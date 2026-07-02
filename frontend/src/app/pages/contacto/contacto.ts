import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Navbar } from '../../shared/components/navbar/navbar';
import { Footer } from '../../shared/components/footer/footer';

@Component({
  selector: 'app-contacto',
  standalone: true,
  imports: [
    CommonModule,
    Navbar,
    Footer
  ],
  templateUrl: './contacto.html',
  styleUrl: './contacto.css',
})
export class Contacto {

}