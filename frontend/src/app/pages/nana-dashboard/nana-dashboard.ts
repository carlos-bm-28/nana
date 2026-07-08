import { Component, OnInit, inject, PLATFORM_ID } from '@angular/core';
import { CommonModule, isPlatformBrowser } from '@angular/common';

import { Router } from '@angular/router'; // 1. Importamos el Router

@Component({
  selector: 'app-nana-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './nana-dashboard.html',
  styleUrl: './nana-dashboard.css'
})
export class DashboardNana implements OnInit {

  private platformId = inject(PLATFORM_ID);
  private router = inject(Router);

  nombre = '';
  apellido = '';
  correo = '';
  telefono = '';

  ngOnInit(): void {

    if (isPlatformBrowser(this.platformId)) {

      this.nombre = localStorage.getItem('usuario_nombre') || '';
      this.apellido = localStorage.getItem('usuario_apellido') || '';
      this.correo = localStorage.getItem('usuario_correo') || '';
      this.telefono = localStorage.getItem('usuario_telefono') || '';

    }

  }

  // 3. Añadimos la función exacta para cerrar sesión
  cerrarSesion(): void {
    if (isPlatformBrowser(this.platformId)) {
      localStorage.clear(); // Borra los datos de sesión guardados
    }
    this.router.navigate(['/']); // Redirige a la página principal o login
  }

  

}