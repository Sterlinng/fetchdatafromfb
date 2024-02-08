import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http'; // Importez HttpClient

@Component({
  selector: 'app-connexion-user',
  standalone: true,
  imports: [FormsModule, HttpClientModule],
  templateUrl: './connexion-user.component.html',
  styleUrls: ['./connexion-user.component.sass']
})
export class ConnexionUserComponent {
  user = { login: '', password: '' };

  constructor(private http: HttpClient) { } // Injectez HttpClient

  onLogin(): void {
    const url = 'http://localhost:8080/citizen/authenticate';

    this.http.post(url, this.user, { responseType: 'text' }) // Ajoutez responseType: 'text'
      .subscribe({
        next: (token) => {
          console.log('Token JWT reçu:', token);
          localStorage.setItem('token', token); // Stocker le token JWT
        },
        error: (error) => {
          console.error('Erreur lors de la tentative de connexion:', error);
        }
      });
  }
}
