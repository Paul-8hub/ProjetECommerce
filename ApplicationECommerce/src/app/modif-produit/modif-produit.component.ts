import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from '../models/Categorie.models';
import { Produit } from '../models/Produit.models';
import { GestionAllService } from '../service/gestion-all.service';

@Component({
  selector: 'app-modif-produit',
  templateUrl: './modif-produit.component.html',
  styleUrls: ['./modif-produit.component.css']
})
export class ModifProduitComponent implements OnInit {

  categorie!:Categorie
  categories!:Categorie[]
  produit!:Produit

  selectedFile!:File
  id!:number
  idCat!:number

  constructor(private service:GestionAllService, private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.id=+this.route.snapshot.params['id'];
    this.produit = new Produit(0,"","",0, new Categorie(0,"",""))
    this.selectById(this.id)
    this.selectAllCat()
  }

  selectAllCat() {
    this.service.getAllCategorie().subscribe(
      response => this.categories=response
    )
  }
  
  selectById(id:number) {
    this.service.getProdById(id).subscribe(
      response => {
        this.produit=response
        this.idCat=this.produit.categorie.idCategorie
      }
    )
  }

  selectEvent(event:any): void {
    this.selectedFile = event.target.files[0]
  }

  modifProduit() {
    let formData = new FormData()
    formData.append("libProduit",this.produit.libProduit)
    formData.append("quantite",this.produit.quantite.toString())
    formData.append("idCat",this.idCat.toString())

    if(this.selectedFile==undefined) {
      console.log("Pas de fichier entré, affichage de l'image précédente :")
      console.log(this.produit.img)
      // Appel de la méthode sans fichier
      this.service.modifierProduitssF(formData,this.id).subscribe(
        response => this.router.navigateByUrl('gestionProduit')
      )
    }
    else {
      formData.append("file",this.selectedFile)
      console.log("Fichier présent :")
      console.log(this.selectedFile)
      this.service.modifierProduit(formData,this.id).subscribe(
        response => this.router.navigateByUrl('gestionProduit')
      )
    }
  }

  retour() {
    this.router.navigateByUrl('gestionProduit')
  }
  
  deconnexion() {
    sessionStorage.removeItem("token")
    this.router.navigateByUrl('')
  }
}