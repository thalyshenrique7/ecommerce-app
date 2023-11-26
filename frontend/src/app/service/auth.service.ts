import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private usuarioAutenticado: boolean = false;
  private usuario: any;
  private token: any;

  constructor(
    private http: HttpClient,

  ) { }

  checkToken() {
    return Promise.resolve(true);
  }

  checkIsAutenticado(status: boolean) {
    localStorage.setItem('usuarioAutenticado', JSON.stringify(status));
  }

  isAutenticado(): Promise<boolean> {
    this.usuarioAutenticado = localStorage.getItem('usuarioAutenticado') === 'true';
    return Promise.resolve(this.usuarioAutenticado);
  }

  setToken(token: string) {
    localStorage.setItem('token', token);
    this.token = token;
  }

  get getToken() {
    this.token = localStorage.getItem('token');
    return this.token;
  }

  limparDadosUsuario() {

    this.checkIsAutenticado(false);

    this.usuario = null;

    localStorage.clear();
    sessionStorage.clear();

  }
}
