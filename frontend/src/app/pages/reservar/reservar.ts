import { Component } from '@angular/core';

import { Navbar } from '../../shared/components/navbar/navbar';
import { Footer } from '../../shared/components/footer/footer';

@Component({
  selector: 'app-reservar',
  imports: [
    Navbar, 
    Footer
  ],
  templateUrl: './reservar.html',
  styleUrl: './reservar.css',
})
export class Reservar {

}
