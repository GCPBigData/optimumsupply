import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CompanyComponent } from './company/company.component';
import { EditCompanyComponent } from './company/edit-company/edit-company.component';
import { CreateCompanyComponent } from './company/create-company/create-company.component';

import { AdminComponent } from './admin';
import { LoginComponent } from './login';

import { AuthGuard } from './_helpers';
import { Role } from './_models';
import {UserProfileComponent} from './user-profile/user-profile.component';
import {HomeComponent} from './home';
import { PessoaListComponent } from './pessoa/pessoa-list';

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
  /*company*/
  {
    path: 'company',
    component: CompanyComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'edit-company/:id',
    component: EditCompanyComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'create-company',
    component: CreateCompanyComponent,
    canActivate: [AuthGuard]
  },


    /*pessoa*/
    {
      path: 'pessoa-list',
      component: PessoaListComponent,
      canActivate: [AuthGuard]
    },
    {
      path: 'edit-pessoa/:id',
      component: EditCompanyComponent,
      canActivate: [AuthGuard]
    },
    {
      path: 'create-pessoa',
      component: CreateCompanyComponent,
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
