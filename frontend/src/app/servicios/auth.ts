import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Auth {
  private apiUrl = 'http://localhost:8080/api/auth';

  constructor(private http: HttpClient) { }

  // Cambiado credentials a 'any' para que acepte 'contrasena' sin problemas de tipos
 login(credentials:any):Observable<any>{

    return this.http.post<any>(`${this.apiUrl}/login`,credentials).pipe(

        tap(res=>{

    if(res){

        localStorage.setItem("usuario_id",res.idUsuario);

        localStorage.setItem("usuario_nombre",res.nombre);

        localStorage.setItem("usuario_apellido",res.apellido);

        localStorage.setItem("usuario_correo",res.correo);

        localStorage.setItem("usuario_telefono",res.telefono);

        localStorage.setItem("usuario_rol",res.tipoUsuario);

    }

})

    );

}

  registro(usuario: any): Observable<any> {

    return this.http.post<any>(
      'http://localhost:8080/api/clientes/registrar',
      usuario
    );

  }

  getRol(): string | null {
    return localStorage.getItem('usuario_rol');
  }

  logout(): void {
    localStorage.clear();
  }
}
