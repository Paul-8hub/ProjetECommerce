import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Produit } from '../models/Produit.models';
import { GestionAllService } from '../service/gestion-all.service';

@Component({
  selector: 'app-liste-produit-client',
  templateUrl: './liste-produit-client.component.html',
  styleUrls: ['./liste-produit-client.component.css']
})
export class ListeProduitClientComponent implements OnInit {

  p!:Produit
  produits!:Produit[]

  constructor(private service:GestionAllService, private router:Router) { }

  ngOnInit(): void {
    this.selectAll()
  }

  selectAll() {
    this.service.getAllProduitClient().subscribe(
      response => this.produits=response
    )
  }

  connexion() {
    this.router.navigateByUrl('authentification')
  }

}
