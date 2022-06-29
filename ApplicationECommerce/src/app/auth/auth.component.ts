import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Role } from '../models/Role.models';
import { Utilisateur } from '../models/Utilisateur.models';
import { BasicAuthentificationService } from '../service/basic-authentification.service';
import { GestionAllService } from '../service/gestion-all.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit {

  username!:string
  password!:string
  validUser!:boolean

  idRole!:number
  roles!:Role[]
  utilisateur!:Utilisateur
  ajoutUser=false

  constructor(private authService:BasicAuthentificationService, private service:GestionAllService, private router:Router) { }

  ngOnInit(): void {
    this.selectAllRole()
    this.utilisateur = new Utilisateur(0,"","","","")
  }

  Authentification() {
    this.authService.authentification(this.username,this.password)
    .subscribe(
      response => {
          console.log(response.jwt)
          sessionStorage.setItem('token','Bearer '+response.jwt)
          this.router.navigateByUrl('choix')
          this.validUser=true
      },
      error => {
        console.log("ko")
        this.validUser=false
      }
    )
  }

  ajouterUnUtilisateur() {
    console.log(this.utilisateur.nom)
    console.log(this.utilisateur.prenom)
    console.log(this.utilisateur.login)
    console.log(this.utilisateur.password)
    console.log(this.idRole)
    this.service.ajouterUtilisateur(this.idRole, this.utilisateur).subscribe()
    this.ajoutUser=true
  }

  selectAllRole() {
    this.service.getAllRole().subscribe(
      response => this.roles=response
    )
  }
}