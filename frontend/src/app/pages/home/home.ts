import { Component } from '@angular/core';

import { Navbar } from '../../shared/components/navbar/navbar';
import { Hero } from '../../shared/components/hero/hero';
import { Beneficios } from '../../shared/components/beneficios/beneficios';
import { CuidadorasDestacadas } from '../../shared/components/cuidadoras-destacadas/cuidadoras-destacadas';
import { Testimonios } from '../../shared/components/testimonios/testimonios';
import { Footer } from '../../shared/components/footer/footer';


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    Navbar,
    Hero,
    Beneficios,
    CuidadorasDestacadas,
    Testimonios,
    Footer,
  ],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {}