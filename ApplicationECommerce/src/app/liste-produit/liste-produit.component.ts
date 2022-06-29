import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Categorie } from '../models/Categorie.models';
import { Produit } from '../models/Produit.models';
import { GestionAllService } from '../service/gestion-all.service';

@Component({
  selector: 'app-liste-produit',
  templateUrl: './liste-produit.component.html',
  styleUrls: ['./liste-produit.component.css']
})
export class ListeProduitComponent implements OnInit {

  p!:Produit
  produits!:Produit[]

  c!:Categorie
  categories!:Categorie[]

  selectedFile!:File
  idCat!:number

  constructor(private service:GestionAllService, private router:Router) { }

  ngOnInit(): void {
    this.p = new Produit(0,"","",0, new Categorie(0,"",""))
    this.selectAll()
    this.selectAllCat()
    //this.idCat=1 // Permet de laisser le select sur short par défaut
  }

  selectAll() {
    this.service.getAllProduit().subscribe(
      response => this.produits=response
    )
  }

  selectAllCat() {
    this.service.getAllCategorie().subscribe(
      response => this.categories=response
    )
  }

  // ---------------------- Ajout produit ----------------------
  selectEvent(event:any): void {
    this.selectedFile = event.target.files[0]
  }

  ajouterProduit() {
    console.log(this.p.libProduit)
    console.log(this.p.quantite)
    console.log(this.idCat)
    console.log(this.selectedFile.name)
    let formData = new FormData()
    formData.append("libProduit",this.p.libProduit)
    formData.append("file",this.selectedFile)
    formData.append("quantite",this.p.quantite.toString())
    formData.append("idCat",this.idCat.toString())

    this.service.ajouterProduit(formData).subscribe(
      response => this.selectAll()
    )
  }

  // ---------------------- Suppression ----------------------
  onSuppression(idProduit:number) {
    this.service.supprimerProduit(idProduit).subscribe(
      response => this.selectAll()
    )
  }
 
  // ---------------------- Redirections ----------------------
  onRedirectionModification(id:number) {
    this.router.navigateByUrl('modifierProduit/'+id)
  }

  retour() { 
    this.router.navigateByUrl('choix')
  }

  deconnexion() {
    sessionStorage.removeItem("token")
    this.router.navigateByUrl('')
  }


}
