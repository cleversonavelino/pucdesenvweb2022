import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Autenticacao } from './model/login.model';
import { LoginService } from './service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  hide: any;
  email: any;
  invalid: any;

  loginForm = new FormGroup({
    login: new FormControl('',Validators.required),
    senha: new FormControl('',Validators.required),
  });

  constructor(private loginService: LoginService,
    private router: Router) { }

  ngOnInit(): void {
  }

  logar() {
  
    if (this.loginForm.valid) {
      console.log(this.loginForm.get('login')?.value);
      console.log(this.loginForm.get('senha')?.value);

      let autenticacao = new Autenticacao();
      autenticacao.login = this.loginForm.get('login')?.value;
      autenticacao.senha = this.loginForm.get('senha')?.value;
      
      this.loginService.login(autenticacao).subscribe(retorno => {
        localStorage.setItem('token',retorno.token);  
        
        //redireciono para tela principal
        console.log("logou")
        this.router.navigate(['/api/home']);
      });
      
    } else {
      console.log("erro");
    }

    
  }

  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }
}
