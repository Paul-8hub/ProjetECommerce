import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-choix',
  templateUrl: './choix.component.html',
  styleUrls: ['./choix.component.css']
})
export class ChoixComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  onProduit() {
    this.router.navigateByUrl('gestionProduit');
  }

  onCategorie() {
    this.router.navigateByUrl('gestionCategorie');
  }

  onCommande() {
    this.router.navigateByUrl('gestionCommande')
  }

  deconnexion() {
    sessionStorage.removeItem("token")
    this.router.navigateByUrl('')
  }

}
