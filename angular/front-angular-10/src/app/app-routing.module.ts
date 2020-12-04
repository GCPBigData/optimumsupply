import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TutorialDetailsComponent } from './components/tutorial-details/tutorial-details.component';
import { AddTutorialComponent } from './components/add-tutorial/add-tutorial.component';
import { PessoaListComponent } from './components/pessoa-list/pessoa-list.component';
import { PessoaListCpfComponent } from './components/pessoa-list-cpf/pessoa-list-cpf.component';

const routes: Routes = [
  { path: '', redirectTo: 'tutorials', pathMatch: 'full' },
  { path: 'pessoas', component: PessoaListComponent },
  { path: 'pessoascpf', component: PessoaListCpfComponent },
  { path: 'tutorials/:id', component: TutorialDetailsComponent },
  { path: 'add', component: AddTutorialComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
