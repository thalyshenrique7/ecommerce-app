import { Component, OnInit } from '@angular/core';
import { UsuarioService } from './service/usuario.service';
import { Permissao } from './permissao.model';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css'],
})
export class UsuarioComponent implements OnInit {
  usuario: any;
  nome: string = '';
  cpf: string = '';
  rg: string = '';
  permissao?: Permissao;

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.buscarUsuario;
  }

  buscarUsuario(id: number) {
    this.usuarioService.buscarUsuario(id).subscribe((response) => {
      this.usuario = response;
    });
  }
}
