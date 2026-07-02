import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';

@Component({
  selector: 'app-hero',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink
  ],
  templateUrl: './hero.html',
  styleUrl: './hero.css',
})


export class Hero implements OnInit {
  constructor(
    @Inject(PLATFORM_ID) private platformId: Object
  ) { }
  usuario: any = null;

  ngOnInit(): void {

    if (isPlatformBrowser(this.platformId)) {

      const usuarioGuardado = localStorage.getItem('usuario');

      if (usuarioGuardado) {

        this.usuario = JSON.parse(usuarioGuardado);

      }

    }

  }

}