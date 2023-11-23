import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AdminRoutingModule } from './admin-routing.module';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login/login.service';
import { UsuarioComponent } from './usuario/usuario.component';

@NgModule({
    declarations: [
        UsuarioComponent,
        LoginComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        CommonModule,
        ReactiveFormsModule,
        AdminRoutingModule,
    ],
    providers: [
        LoginService
    ],
    exports: [
        UsuarioComponent,
        LoginComponent,
    ]
})
export class AdminModule { }