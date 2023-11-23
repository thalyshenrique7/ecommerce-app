import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private readonly PATH = "/api/login";

  constructor(
    private http: HttpClient
  ) { }

  acessar(email: string, senha: string): Observable<any> {
    return this.http.post(`${this.PATH}`, { email: email, senha: senha });
  }
}
