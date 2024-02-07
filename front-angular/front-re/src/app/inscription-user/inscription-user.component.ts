import { Component } from '@angular/core';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Citizens } from './model/citizen.model';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-inscription-user',
  templateUrl: './inscription-user.component.html',
  imports: [FormsModule, HttpClientModule],
  styleUrls: ['./inscription-user.component.sass'],
  standalone: true,
})
export class InscriptionUserComponent {
  citizen = new Citizens('', '', '', '', '', '', "0", 0, '');

  constructor(private http: HttpClient) { }

  onSubmit(): void {
    console.log(this.citizen); 

    const httpOptions = {
      headers: new HttpHeaders({
        'Access-Control-Allow-Origin': 'http://localhost:8080'
      })
    };

    this.http.post<Citizens>('http://localhost:8080/citizen/createCitizen', this.citizen, httpOptions)
      .subscribe({
        next: (response) => console.log('Utilisateur créé avec succès !', response),
        error: (error) => console.error('Erreur lors de la création de l\'utilisateur :', error)
      });
  }
}
