import { Routes } from '@angular/router';
import { InscriptionUserComponent } from './inscription-user/inscription-user.component';
import { InscriptionCorpComponent } from './inscription-corp/inscription-corp.component';

export const routes: Routes = [
    { path: 'inscription-user', component: InscriptionUserComponent },
    { path: 'inscription-corp', component: InscriptionCorpComponent }
];
