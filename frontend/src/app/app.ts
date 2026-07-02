import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router'; // <-- Importamos el módulo de rutas
import { Login } from './pages/login/login';
import { Registro } from './pages/registro/registro';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Login, Registro], // <-- Lo agregamos a los imports
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class AppComponent { // <-- Asegúrate de que se llame AppComponent
  title = 'frontend';
}
