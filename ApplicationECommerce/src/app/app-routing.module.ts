import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { ChoixComponent } from './choix/choix.component';
import { ListeCategorieComponent } from './liste-categorie/liste-categorie.component';
import { ListeCommandeComponent } from './liste-commande/liste-commande.component';
import { ListeProduitClientComponent } from './liste-produit-client/liste-produit-client.component';
import { ListeProduitComponent } from './liste-produit/liste-produit.component';
import { ModifCategorieComponent } from './modif-categorie/modif-categorie.component';
import { ModifProduitComponent } from './modif-produit/modif-produit.component';
import { ProduitParCatComponent } from './produit-par-cat/produit-par-cat.component';

const routes: Routes = [
  {path:'',component:ListeProduitClientComponent},
  {path:'authentification',component:AuthComponent},
  {path:'choix',component:ChoixComponent},
  {path:'gestionCategorie',component:ListeCategorieComponent},
  {path:'gestionProduit',component:ListeProduitComponent},
  {path:'gestionCommande',component:ListeCommandeComponent},
  {path:'modifierCategorie/:id',component:ModifCategorieComponent},
  {path:'modifierProduit/:id',component:ModifProduitComponent},
  {path:'afficherProdByCat/:id',component:ProduitParCatComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }