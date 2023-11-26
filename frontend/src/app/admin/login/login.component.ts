import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';
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
    private authService: AuthService,
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
        token => {
          this.authService.setToken(token);
          this.authService.checkIsAutenticado(true);
          this.router.navigate(['/dashboard']);
        },
        (error) => {
          alert('Ocorreu um erro ao tentar realizar o login.');
        }
      )
    }
  }

}
