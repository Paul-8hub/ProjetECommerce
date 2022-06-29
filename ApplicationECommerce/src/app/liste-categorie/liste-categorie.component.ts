import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Categorie } from '../models/Categorie.models';
import { Produit } from '../models/Produit.models';
import { GestionAllService } from '../service/gestion-all.service';

@Component({
  selector: 'app-liste-categorie',
  templateUrl: './liste-categorie.component.html',
  styleUrls: ['./liste-categorie.component.css']
})
export class ListeCategorieComponent implements OnInit {

  categories!:Categorie[]
  categorie!:Categorie
  c!:Categorie

  constructor(private service:GestionAllService, private router:Router) { }

  ngOnInit(): void {
    this.c = new Categorie(0,"","")
    this.selectAll()
  }

  selectAll() {
    this.service.getAllCategorie().subscribe(
      response => this.categories=response
    )
  }

  ajouterCategorie() {
    this.service.ajouterCategorie(this.c).subscribe(
      response => {
        this.selectAll()
      }
    )
  }

  // ---------------------- Suppression ----------------------
  onSuppression(idCategorie:number) {
    this.service.supprimerCategorie(idCategorie).subscribe(
      response => {this.selectAll()}
    )
  }

  // ---------------------- Redirections ----------------------
  onRedirectionAffichageProd(idCat:number) {
    this.router.navigateByUrl("afficherProdByCat/"+idCat)
  }

  onRedirectionModification(id:number) {
    this.router.navigateByUrl("modifierCategorie/"+id)
  }

  retour() {
    this.router.navigateByUrl('choix')
  }

  deconnexion() {
    sessionStorage.removeItem("token")
    this.router.navigateByUrl('')
  }

}
