import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteComponent } from './cliente/cliente.component';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import { UsuarioComponent } from './usuario/usuario.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  {
    path: '',
    redirectTo: '/api/home',
    pathMatch: 'full',
  },
  {
    path: 'api',
    component: MenuComponent,
    children: [
      { path: 'home', component: UsuarioComponent },
      { path: 'usuario', component: UsuarioComponent },
      { path: 'cliente', component: ClienteComponent },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
