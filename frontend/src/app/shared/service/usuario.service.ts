import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class UsuarioService {

    private readonly PATH = "/api/usuario";

    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })
    };

    constructor(private http: HttpClient) { }

    buscarUsuario(id: number): Observable<any> {
        return this.http.get(`${this.PATH}/buscar/${id}`);
    }

    salvarUsuario(usuario: any): Observable<any> {
        return this.http.post(`${this.PATH}/salvar`, usuario);
    }

    excluirUsuario(id: number): Observable<any> {
        return this.http.delete(`${this.PATH}/excluir/${id}`);
    }

    atualizarUsuario(id: number, novoUsuario: any): Observable<any> {
        return this.http.put(`${this.PATH}/atualizar/${id}`, novoUsuario);
    }
}
