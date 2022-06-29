import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Categorie } from '../models/Categorie.models';
import { Commande } from '../models/Commande.models';
import { Produit } from '../models/Produit.models';
import { Role } from '../models/Role.models';
import { Utilisateur } from '../models/Utilisateur.models';

@Injectable({
  providedIn: 'root'
})
export class GestionAllService {
  
  constructor(private http:HttpClient) { }

  //--------------------------- Gestion produits ---------------------------
  getAllProduit() {
    return this.http.get<Produit[]>('http://localhost:9094/admin/produit');
  }

  getAllProduitClient() {
    return this.http.get<Produit[]>('http://localhost:9094/client/produit');
  }

  getProdById(idProduit:number) {
    return this.http.get<Produit>('http://localhost:9094/admin/produit/'+idProduit);
  }

  getProdByIdCat(idCat:number) {
    return this.http.get<Produit[]>('http://localhost:9094/admin/produitParCat/'+idCat);
  }

  ajouterProduit(data:FormData) {
    return this.http.post<Produit>('http://localhost:9094/admin/produit', data);
  }
  
  modifierProduit(data:FormData, id:number) {
    return this.http.put<Produit>('http://localhost:9094/admin/produit/'+id, data);
  }

	// Modification d'un produit dans le cas où il n'y a pas de fichier sélectionné
  modifierProduitssF(data:FormData, id:number) {
    return this.http.put<Produit>('http://localhost:9094/admin/produitssF/'+id, data);
  }

  supprimerProduit(idProduit:number) {
    return this.http.delete('http://localhost:9094/admin/produit/'+idProduit);
  }


  //--------------------------- Gestion catégories ---------------------------
  getAllCategorie() {
    return this.http.get<Categorie[]>('http://localhost:9094/admin/categorie');
  }

  getCatById(idCategorie:number) {
    return this.http.get<Categorie>('http://localhost:9094/admin/categorie/'+idCategorie);
  }

  ajouterCategorie(c:Categorie) {
    return this.http.post<Categorie>('http://localhost:9094/admin/categorie', c);
  }
  
  modifierCategorie(c:Categorie) {
    return this.http.put<Categorie>('http://localhost:9094/admin/categorie', c);
  }

  supprimerCategorie(idCategorie:number) {
    return this.http.delete('http://localhost:9094/admin/categorie/'+idCategorie);
  }

  //--------------------------- Gestion commandes ---------------------------
  getAllCommande() {
    return this.http.get<Commande[]>('http://localhost:9094/admin/commande');
  }

  supprimerCommande(idCommande:number) {
    return this.http.delete('http://localhost:9094/admin/commande/'+idCommande);
  }

  //---------------------------------- Role -----------------------------------
  getAllRole() {
    return this.http.get<Role[]>('http://localhost:9094/role');
  }

  //------------------------------- Utilisateur -------------------------------
  ajouterUtilisateur(idRole:number, u:Utilisateur) {
    return this.http.post('http://localhost:9094/utilisateur/'+idRole, u);
  }

}