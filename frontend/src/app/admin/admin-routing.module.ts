import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmpresaComponent } from './empresa/empresa.component';
import { LoginComponent } from './login/login.component';
import { TerceiroComponent } from './terceiro/terceiro.component';

const routes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'empresa', component: EmpresaComponent },
    { path: 'terceiro', component: TerceiroComponent },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class AdminRoutingModule { }