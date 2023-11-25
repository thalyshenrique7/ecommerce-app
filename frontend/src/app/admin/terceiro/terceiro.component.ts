import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MenuService } from 'src/app/service/menu.service';
import { TerceiroService } from './terceiro.service';

export interface TerceiroForm {

  nome: FormControl<string>;
  cpf: FormControl<string>;
}

@Component({
  selector: 'app-terceiro',
  templateUrl: './terceiro.component.html',
  styleUrls: ['./terceiro.component.css']
})
export class TerceiroComponent implements OnInit {

  form: FormGroup<TerceiroForm>;

  constructor(
    private menuService: MenuService,
    private router: Router,
    private terceiroService: TerceiroService,
    private fb: FormBuilder,
  ) { }

  ngOnInit(): void {

    this.menuService.menuSelecionado = 2;

    this.form = this.fb.group<TerceiroForm>({
      nome: this.fb.control('', Validators.required),
      cpf: this.fb.control('', Validators.required),
    })
  }

  getDadosTerceiro() {
    return this.form.controls;
  }

  salvar() {

    const nome = this.getDadosTerceiro().nome;

    this.terceiroService.salvar(nome.value).subscribe(
      dados => {
        this.router.navigate(['/dashboard']);
      },
      (error) => {
        alert('Ocorreu um erro ao tentar salvar o terceiro.')
      }
    )
  }

}
