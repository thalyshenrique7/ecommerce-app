import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/shared/model/usuario.model';
import { UsuarioService } from 'src/app/shared/service/usuario.service';

@Component({
    selector: 'app-usuarios',
    templateUrl: './usuarios.component.html',
    styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

    usuario: Usuario;
    displayedColumns = ['id', 'nome', 'cpf', 'rg', 'permissao', 'ativo'];

    constructor(
        public usuarioService: UsuarioService
    ) { }

    ngOnInit(): void {
        this.getUsuario();
    }

    getUsuario() {
        this.usuarioService.buscarUsuario(2).subscribe(data => {
            this.usuario = data;
            console.log('Usuario logado', this.usuario);
        });
    }

}
