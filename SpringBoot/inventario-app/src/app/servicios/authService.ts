import { Injectable } from '@angular/core';
import { Usuario } from '../usuario';
import {HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private usuarioActual: Usuario | null = null;

  constructor(private http: HttpClient) { }

  login(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>('http://localhost:8080/api/usuarios/login', usuario);
  }
  
  registrar(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>('http://localhost:8080/api/usuarios/registrar', usuario);
  }

  setUsuario(usuario: Usuario) {
    this.usuarioActual = usuario;
  }

  getUsuario(): Usuario | null {
    return this.usuarioActual;
  }

  esAdmin(): boolean {
    return this.usuarioActual?.rol === 'ADMIN';
  }
}
