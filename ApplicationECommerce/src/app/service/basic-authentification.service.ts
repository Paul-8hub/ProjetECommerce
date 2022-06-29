import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Authentification } from '../models/Authentification.models';

@Injectable({
  providedIn: 'root'
})

export class BasicAuthentificationService {

  constructor(private http:HttpClient) { }

  authentification(username:string, password:string) {
    /*let basicchaine='Basic '+window.btoa(username+':'+password)
    let headers = new HttpHeaders({
      Authorization: basicchaine
    })*/

    return this.http.post<any>('http://localhost:9094/authenticate', {username,password});
  }
}