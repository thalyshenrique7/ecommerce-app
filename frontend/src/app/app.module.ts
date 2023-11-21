import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { UsuarioComponent } from './admin/usuario/usuario.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProdutoRoutingModule } from './estoque/estoque-routing.module';
import { EstoqueModule } from './estoque/estoque.module';
import { PedidovendaComponent } from './estoque/pedidovenda/pedidovenda.component';

@NgModule({
  declarations: [
    AppComponent,
    UsuarioComponent,
    PedidovendaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    EstoqueModule,
    ProdutoRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
