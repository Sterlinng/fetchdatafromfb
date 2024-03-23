import { Routes } from '@angular/router';
import { InscriptionUserComponent } from './inscription-user/inscription-user.component';
import { InscriptionCorpComponent } from './inscription-corp/inscription-corp.component';
import { ConnexionUserComponent } from './connexion-user/connexion-user.component';
import { HomeComponent } from './home/home.component';

export const routes: Routes = [
    { path: 'inscription-corp', component: InscriptionCorpComponent },
    { path: 'inscription-user', component: InscriptionUserComponent },
    { path: 'connexion-user', component: ConnexionUserComponent },
    { path: 'home', component: HomeComponent },
];


