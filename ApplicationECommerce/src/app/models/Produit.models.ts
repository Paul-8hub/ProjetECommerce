import { Categorie } from "./Categorie.models"

export class Produit {

    idProduit!:number
    libProduit!:string
    img!:string
    quantite!:number
    categorie!:Categorie

    constructor(idProduit:number, libProduit:string, img:string, quantite:number, categorie:Categorie) {
        this.idProduit=idProduit;
        this.libProduit=libProduit;
        this.img=img;
        this.quantite=quantite;
        this.categorie=categorie
    }
}