import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

export interface LoginForm {

  email: FormControl<string>;
  senha: FormControl<string>;
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  form: FormGroup<LoginForm>;

  constructor(
    private fb: FormBuilder,
    private router: Router
  ) { }

  ngOnInit(): void {

    this.form = this.fb.group<LoginForm>({
      email: this.fb.control('', [Validators.required, Validators.email]),
      senha: this.fb.control('', Validators.required),
    })
  }

  getInformacoesLogin() {
    return this.form.controls;
  }

  acessarTelaLogin() {
    alert("OK");
  }

}
