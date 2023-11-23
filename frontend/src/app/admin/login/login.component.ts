import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from './login.service';

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
    private router: Router,
    private loginService: LoginService,
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

    const email = this.getInformacoesLogin().email;
    const senha = this.getInformacoesLogin().senha;

    if (this.form.valid) {
      this.loginService.acessar(email.value, senha.value).subscribe(
        dados => {
          this.router.navigate(['/dashboard']);
        },
        (error) => {
          alert('Ocorreu um erro ao tentar realizar o login.');
        }
      )
    }
  }

}
