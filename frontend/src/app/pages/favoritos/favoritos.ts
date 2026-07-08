import { Component } from '@angular/core';

import { Navbar } from '../../shared/components/navbar/navbar';
import { Footer } from '../../shared/components/footer/footer';

@Component({
  selector: 'app-favoritos',
  imports: [
    Navbar,
    Footer
  ],
  templateUrl: './favoritos.html',
  styleUrl: './favoritos.css',
})
export class Favoritos {

}
