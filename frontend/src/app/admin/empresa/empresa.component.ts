import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MenuService } from 'src/app/service/menu.service';
import { Empresa } from './empresa.model';
import { EmpresaService } from './empresa.service';

export interface EmpresaForm {

  nome: FormControl<string>;
  cnpj: FormControl<string>;
}

@Component({
  selector: 'app-empresa',
  templateUrl: './empresa.component.html',
  styleUrls: ['./empresa.component.css']
})
export class EmpresaComponent implements OnInit {

  form: FormGroup<EmpresaForm>;
  empresas: Empresa[];

  constructor(
    private menuService: MenuService,
    private router: Router,
    private empresaService: EmpresaService,
    private fb: FormBuilder,
  ) { }

  ngOnInit(): void {

    this.menuService.menuSelecionado = 3;

    this.form = this.fb.group<EmpresaForm>({
      nome: this.fb.control('', Validators.required),
      cnpj: this.fb.control('', Validators.required),
    })
  }

  getDadosEmpresa() {
    return this.form.controls;
  }

  salvar() {

    const nome = this.getDadosEmpresa().nome;
    const cnpj = this.getDadosEmpresa().cnpj;

    this.empresaService.salvar(nome.value, cnpj.value).subscribe(
      dados => {
        this.router.navigate(['/dashboard']);
      },
      (error) => {
        alert('Ocorreu um erro ao tentar salvar a empresa.');
      }
    )
  }

}
