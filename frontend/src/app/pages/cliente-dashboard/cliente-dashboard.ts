import { Component, OnInit, inject, PLATFORM_ID } from '@angular/core';
import { CommonModule, isPlatformBrowser } from '@angular/common';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-cliente-dashboard',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink
  ],
  templateUrl: './cliente-dashboard.html',
  styleUrl: './cliente-dashboard.css'
})
export class ClienteDashboard implements OnInit {

  private platformId = inject(PLATFORM_ID);

  nombre = '';
  apellido = '';

  constructor(private router: Router) {}

  ngOnInit(): void {

    if (isPlatformBrowser(this.platformId)) {

      this.nombre = localStorage.getItem('usuario_nombre') || '';

      this.apellido = localStorage.getItem('usuario_apellido') || '';

      console.log("Nombre:", this.nombre);
      console.log("Apellido:", this.apellido);

    }

  }

  cerrarSesion(): void {

    localStorage.clear();

    this.router.navigate(['/']);

  }

}