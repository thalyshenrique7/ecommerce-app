import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  private readonly PATH = "/api/empresa";

  constructor(
    private httpClient: HttpClient
  ) { }

  menuSelecionado: number;

  salvar(nome: string, cnpj: string): Observable<any> {
    return this.httpClient.post(`${this.PATH}/salvar`, { nome: nome, cnpj: cnpj });
  }
}
