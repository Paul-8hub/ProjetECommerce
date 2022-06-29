export class Commande {

    idCommande!:number
    dateCommande!:string
    idUtilisateur!:number

    constructor(idCommande:number, dateCommande:string, idUtilisateur:number) {
        this.idCommande=idCommande
        this.dateCommande=dateCommande
        this.idUtilisateur=idUtilisateur
    }
}