import { Component, OnInit } from '@angular/core';
import { Produto } from './produto.model';
import { ProdutoService } from './produto.service';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})
export class ProdutoComponent implements OnInit {

  produtos: Produto[];

  constructor(
    private produtoService: ProdutoService,
  ) {

  }

  ngOnInit(): void {

    this.getProdutos();
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
