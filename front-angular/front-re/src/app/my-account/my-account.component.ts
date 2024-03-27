import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';


@Component({
  selector: 'app-my-account',
  standalone: true,
  imports: [HttpClientModule, FormsModule, CommonModule],
  templateUrl: './my-account.component.html',
  styleUrl: './my-account.component.sass'
})

export class MyAccountComponent implements OnInit {
  citizen: any = {};
  isEditing: boolean = false;

  constructor(private http: HttpClient, private router: Router) { }
  

  ngOnInit(): void {
    const userId = localStorage.getItem('userId');
    if (userId) {
      this.http.get(`http://localhost:8080/citizen/getCitizenById/${userId}`).subscribe((citizen: any) => {
        this.citizen = citizen;
      });
    }
  }

  enableEditing(): void {
    this.isEditing = true;
  }

  updateCitizen(): void {
    const userId = localStorage.getItem('userId');
    if (userId && this.isEditing) {
      this.http.put(`http://localhost:8080/citizen/updateCitizen/${userId}`, this.citizen)
        .subscribe({
          next: (updatedCitizen: any) => {
            this.citizen = updatedCitizen;
            this.isEditing = false;
          },
          error: (error) => {
            console.error('Error updating citizen:', error);
            // Gérez les erreurs ici
          }
        });
    }
  }

  deleteAccount(): void {
    const userId = localStorage.getItem('userId');
    if (userId) {
      this.http.delete(`http://localhost:8080/citizen/deleteCitizen/${userId}`)
        .subscribe({
          next: () => {
            console.log("Compte supprimé avec succès");
            localStorage.removeItem('userId');
            this.router.navigate(['/']);
          },
          error: (error) => {
            console.error('Erreur lors de la suppression du compte:', error);
          }
        });
    }
  }

  onLogout(): void {
    localStorage.removeItem('token');
    console.log('Token JWT supprimé');
    this.router.navigate(['/connexion-user']);
  }
}
