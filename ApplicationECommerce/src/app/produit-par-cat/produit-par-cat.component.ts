import { isPlatformWorkerApp } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Produit } from '../models/Produit.models';
import { GestionAllService } from '../service/gestion-all.service';

@Component({
  selector: 'app-produit-par-cat',
  templateUrl: './produit-par-cat.component.html',
  styleUrls: ['./produit-par-cat.component.css']
})
export class ProduitParCatComponent implements OnInit {

  idCat!:number
  produit!:Produit
  produits!:Produit[]
  produitExist=true

  constructor(private service:GestionAllService, private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.idCat=+this.route.snapshot.params['id'];
    this.selectProdByIdCat()
  }

  selectProdByIdCat() {
    this.service.getProdByIdCat(this.idCat).subscribe(
      response => {
        this.produits=response
        if(this.produits.length==0) {
            console.log("Pas de produit dans cette catégorie")
            this.produitExist=false
        }
      }
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
