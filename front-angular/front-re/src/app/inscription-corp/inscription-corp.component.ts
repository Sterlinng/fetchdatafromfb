import { Component } from '@angular/core';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Corporation } from './model/corporation.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-inscription-corp',
  standalone: true,
  imports: [FormsModule, HttpClientModule],
  templateUrl: './inscription-corp.component.html',
  styleUrl: ['./inscription-corp.component.sass']
  standalone: true,
})
export class InscriptionCorpComponent {

corporation = new Corporation('', '', '', '', 0, '', '', '', '','');

  constructor(private http: HttpClient) { }

  onSubmit(): void {
    console.log(this.corporation);

    const httpOptions = {
      headers: new HttpHeaders({
        'Access-Control-Allow-Origin': 'http://localhost:8080'
      })
    };

    this.http.post<Corporation>('http://localhost:8080/corporation/createCorporation', this.corporation, httpOptions)
      .subscribe({
        next: (response) => console.log('Corporation créé avec succès !', response),
        error: (error) => console.error('Erreur lors de la création de la Corporation :', error)
      });
  }
}
