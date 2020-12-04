import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin';
import { LoginComponent } from './login';

import { AuthGuard } from './_helpers';
import { Role } from './_models';
import {UserProfileComponent} from './user-profile/user-profile.component';
import {HomeComponent} from './home';
import { PessoaComponent } from './pessoa';
import { CreatePessoaComponent } from './pessoa/create-pessoa/create-pessoa.component';

const routes: Routes = [
  {
    path: '',
    component: UserProfileComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'login',
    component: LoginComponent },
  {
    path: 'admin',
    component: AdminComponent,
    canActivate: [AuthGuard],
    data: { roles: [Role.Admin] }
  },
  {
    path: 'user',
    component: UserProfileComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'home',
    component: HomeComponent,
    canActivate: [AuthGuard]
  },
  /*pessoa*/
  {
    path: 'pessoa',
    component: PessoaComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'create-pessoa',
    component: CreatePessoaComponent,
    canActivate: [AuthGuard]
  },

   /*full*/
  { path: '**',
    redirectTo: ''
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
