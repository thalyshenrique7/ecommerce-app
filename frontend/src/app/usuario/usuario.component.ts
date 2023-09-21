import { Component, OnInit } from '@angular/core';
import { UsuarioService } from './service/usuario.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  usuario: any;

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.buscarUsuario
  }

  buscarUsuario(id: number) {
    this.usuarioService.buscarUsuario(id).subscribe((response) => {

      this.usuario = response;
    })
  }

}
