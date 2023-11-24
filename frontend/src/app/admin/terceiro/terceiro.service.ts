import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TerceiroService {

  private readonly PATH = "/api/terceiro";

  constructor(
    private httpClient: HttpClient
  ) { }

  menuSelecionado: number;

  salvar(nome: string): Observable<any> {
    return this.httpClient.post(`${this.PATH}`, { nome: nome });
  }
}
