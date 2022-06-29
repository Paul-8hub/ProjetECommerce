import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Commande } from '../models/Commande.models';
import { GestionAllService } from '../service/gestion-all.service';

@Component({
  selector: 'app-liste-commande',
  templateUrl: './liste-commande.component.html',
  styleUrls: ['./liste-commande.component.css']
})
export class ListeCommandeComponent implements OnInit {

  commande!:Commande
  commandes!:Commande[]

  constructor(private service:GestionAllService, private router:Router) { }

  ngOnInit(): void {
    this.selectAllCommande()
  }

  selectAllCommande() {
    this.service.getAllCommande().subscribe(
      response => {
        this.commandes=response
      }
    )
  }

  retour() {
    this.router.navigateByUrl('choix')
  }

  deconnexion() {
    sessionStorage.removeItem("token")
    this.router.navigateByUrl('')
  }
  

}
