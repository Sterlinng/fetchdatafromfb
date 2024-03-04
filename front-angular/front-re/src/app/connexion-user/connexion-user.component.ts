import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common'; // Importez CommonModule

@Component({
  selector: 'app-connexion-user',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule],
  templateUrl: './connexion-user.component.html',
  styleUrls: ['./connexion-user.component.sass']
})
export class ConnexionUserComponent implements OnInit {
  user = { login: '', password: '' };
  isLoggedIn = false; // Ajout d'une variable pour suivre l'état de connexion

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.checkLoginStatus();
  }

  checkLoginStatus(): void {
    this.isLoggedIn = !!localStorage.getItem('token'); // Vérifie si le token existe
  }

  onLogin(): void {
    console.log('Tentative de connexion pour l\'utilisateur:', this.user.login);
    const url = 'http://localhost:8080/citizen/authenticate';

    this.http.post(url, this.user, { responseType: 'text' })
      .subscribe({
        next: (token) => {
          console.log('Token JWT reçu:', token);
          localStorage.setItem('token', token);
          console.log('Connexion réussie et token stocké');
          this.isLoggedIn = true; // Mise à jour de l'état de connexion
        },
        error: (error) => {
          console.error('Erreur lors de la tentative de connexion:', error);
        }
      });
  }

  onLogout(): void {
    console.log('Déconnexion de l\'utilisateur:', this.user.login);
    localStorage.removeItem('token');
    console.log('Token JWT supprimé');
    this.router.navigate(['/connexion-user']); // Assurez-vous que cette route est correcte
    console.log('Redirection vers la page de connexion');
    this.isLoggedIn = false; // Mise à jour de l'état de connexion
  }
}
