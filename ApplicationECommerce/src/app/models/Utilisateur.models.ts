export class Utilisateur {

    id!:number
    nom!:string
    prenom!:string
    login!:string
    password!:string

    constructor(id:number, nom:string, prenom:string, login:string, password:string) {
        this.id=id
        this.nom=nom
        this.prenom=prenom
        this.login=login
        this.password=password
    }
}