import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  private readonly PATH = "/api/produto";

  constructor(
    private http: HttpClient
  ) { }

  buscar(id: number): Observable<any> {
    return this.http.get(`${this.PATH}/buscar/${id}`);
  }

  salvar(produto: any): Observable<any> {
    return this.http.post(`${this.PATH}/salvar`, produto);
  }

  excluir(id: number): Observable<any> {
    return this.http.delete(`${this.PATH}/excluir/${id}`);
  }

  atualizar(id: number, novoProduto: any): Observable<any> {
    return this.http.put(`${this.PATH}/atualizar/${id}`, novoProduto);
  }

  getProdutos(): Observable<any> {
    return this.http.get(`${this.PATH}`);
  }

}
