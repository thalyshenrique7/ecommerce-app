import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgSelectModule } from '@ng-select/ng-select';
import { SharedModule } from '../shared/shared.module';
import { AdminRoutingModule } from './admin-routing.module';
import { EmpresaComponent } from './empresa/empresa.component';
import { EmpresaService } from './empresa/empresa.service';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login/login.service';
import { TerceiroComponent } from './terceiro/terceiro.component';
import { TerceiroService } from './terceiro/terceiro.service';
import { UsuarioComponent } from './usuario/usuario.component';

@NgModule({
    declarations: [
        UsuarioComponent,
        LoginComponent,
        EmpresaComponent,
        TerceiroComponent,
    ],
    imports: [
        HttpClientModule,
        CommonModule,
        ReactiveFormsModule,
        AdminRoutingModule,
        SharedModule,
        NgSelectModule,
        FormsModule,
    ],
    providers: [
        LoginService,
        EmpresaService,
        TerceiroService,
    ],
    exports: [
        UsuarioComponent,
        LoginComponent,
        EmpresaComponent,
        TerceiroComponent,
    ]
})
export class AdminModule { }