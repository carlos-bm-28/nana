import { Component, OnInit, inject, PLATFORM_ID } from '@angular/core';
import { CommonModule, isPlatformBrowser } from '@angular/common';

@Component({
  selector: 'app-nana-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './nana-dashboard.html',
  styleUrl: './nana-dashboard.css'
})
export class DashboardNana implements OnInit {

  private platformId = inject(PLATFORM_ID);

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

}