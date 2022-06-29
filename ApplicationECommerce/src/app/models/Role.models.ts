export class Role {

    idRole!:number
    libRole!:string
    description!:string

    constructor(idRole:number, libRole:string, description:string) {
        this.idRole=idRole
        this.libRole=libRole
        this.description=description
    }
}