import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { SharedModule } from '../shared/shared.module';
import { EstoqueRoutingModule } from './estoque-routing.module';
import { PedidovendaComponent } from './pedidovenda/pedidovenda.component';
import { ProdutoComponent } from './produto/produto.component';
import { ProdutoService } from './produto/produto.service';

@NgModule({
    declarations: [
        ProdutoComponent,
        PedidovendaComponent,
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        CommonModule,
        EstoqueRoutingModule,
        SharedModule,
        ReactiveFormsModule,
    ],
    providers: [
        ProdutoService
    ],
    exports: [
        ProdutoComponent,
        PedidovendaComponent
    ]
})
export class EstoqueModule { }