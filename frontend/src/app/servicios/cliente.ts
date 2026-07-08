import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Cliente } from '../modelos/cliente'; 

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  
  // Tu ruta base declarada en @RequestMapping
  private apiUrl = 'http://localhost:8080/api/clientes'; 

  constructor(private http: HttpClient) {}

  // Apunta exactamente a: @GetMapping("/perfil/{idUsuario}")
  obtenerPerfil(idUsuario: number): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.apiUrl}/perfil/${idUsuario}`);
  }

  // Apunta exactamente a: @PutMapping("/perfil/{idUsuario}")
  actualizarPerfil(idUsuario: number, cliente: Cliente): Observable<Cliente> {
    return this.http.put<Cliente>(`${this.apiUrl}/perfil/${idUsuario}`, cliente);
  }
}