import { Produit } from "./Produit.models"

export class Categorie {

    idCategorie!:number
    nomCategorie!:string
    description!:string
    produit!:Produit

    constructor(idCategorie:number, nomCategorie:string, description:string) {
        this.idCategorie=idCategorie;
        this.nomCategorie=nomCategorie;
        this.description=description;
    }
}