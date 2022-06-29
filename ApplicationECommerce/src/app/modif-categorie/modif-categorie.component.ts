import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from '../models/Categorie.models';
import { Produit } from '../models/Produit.models';
import { GestionAllService } from '../service/gestion-all.service';

@Component({
  selector: 'app-modif-categorie',
  templateUrl: './modif-categorie.component.html',
  styleUrls: ['./modif-categorie.component.css']
})
export class ModifCategorieComponent implements OnInit {

  categorie!:Categorie

  p!:Produit
  libProduit!:string
  selectedFile!:File
  quantite!:string
  idCat!:string

  constructor(private service:GestionAllService, private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.categorie= new Categorie(0,"","")
    this.selectById()
  }

  selectById() {
    const id=+this.route.snapshot.params['id'];
    this.service.getCatById(id).subscribe(
      response => this.categorie=response
    )
  }

  modifCategorie() {
    this.service.modifierCategorie(this.categorie).subscribe(
      response => this.router.navigateByUrl('gestionCategorie')
    )
  }

  retour() {
    this.router.navigateByUrl('gestionCategorie')
  }

  deconnexion() {
    sessionStorage.removeItem("token")
    this.router.navigateByUrl('')
  }
}
