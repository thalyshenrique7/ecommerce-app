import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MenuService } from 'src/app/service/menu.service';
import { Produto } from './produto.model';
import { ProdutoService } from './produto.service';

export interface ProdutoForm {

    nome: FormControl<string>;
    ncm: FormControl<string>;
    codigoBarras: FormControl<string>;
    precoCusto: FormControl<number>;
    precoVenda: FormControl<number>;
}

@Component({
    selector: 'app-produto',
    templateUrl: './produto.component.html',
    styleUrls: ['./produto.component.css']
})
export class ProdutoComponent implements OnInit {

    produtos: Produto[];
    form: FormGroup<ProdutoForm>;

    constructor(
        private produtoService: ProdutoService,
        private fb: FormBuilder,
        private router: Router,
        public menuService: MenuService
    ) {

    }

    ngOnInit(): void {

        this.menuService.menuSelecionado = 2;

        this.form = this.fb.group<ProdutoForm>({
            nome: this.fb.control('', Validators.required),
            ncm: this.fb.control('', Validators.required),
            codigoBarras: this.fb.control('', Validators.required),
            precoCusto: this.fb.control(null, Validators.required),
            precoVenda: this.fb.control(null, Validators.required),
        })
    }

    enviar() {
        debugger
        var dados = this.getDadosProduto();

        alert(dados["nome"].value)
    }


    getDadosProduto() {
        this.form.controls;
    }

    getProdutos() {
        this.produtoService.getProdutos().subscribe(dados => {
            this.produtos = dados;
        },
            (erro) => {
                console.log('Ocorreu um erro', erro)
            }
        )
    }

}
