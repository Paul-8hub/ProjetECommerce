import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { AuthComponent } from './auth/auth.component';
import { ListeProduitComponent } from './liste-produit/liste-produit.component';
import { ListeCategorieComponent } from './liste-categorie/liste-categorie.component';
import { HttpInterceptorBasicAuthServiceService } from './service/http-interceptor-basic-auth-service.service';
import { ModifCategorieComponent } from './modif-categorie/modif-categorie.component';
import { ModifProduitComponent } from './modif-produit/modif-produit.component';
import { ListeCommandeComponent } from './liste-commande/liste-commande.component';
import { ProduitParCatComponent } from './produit-par-cat/produit-par-cat.component';
import { ListeProduitClientComponent } from './liste-produit-client/liste-produit-client.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    ListeProduitComponent,
    ListeCategorieComponent,
    ModifCategorieComponent,
    ModifProduitComponent,
    ListeCommandeComponent,
    ProduitParCatComponent,
    ListeProduitClientComponent,
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    {provide:HTTP_INTERCEPTORS,useClass:HttpInterceptorBasicAuthServiceService,multi:true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
