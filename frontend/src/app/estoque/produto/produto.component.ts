import { Component } from '@angular/core';
import { ProdutoService } from './produto.service';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})
export class ProdutoComponent {

  constructor(
    private produtoService: ProdutoService,
  ) {

  }

}
