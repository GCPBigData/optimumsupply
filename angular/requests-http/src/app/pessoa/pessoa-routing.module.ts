import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PessoaListaComponent } from './pessoa-lista/pessoa-lista.component';
import { PessoaFormComponent } from './pessoa-form/pessoa-form.component';
import { PessoaResolverGuard } from './guards/pessoa-resolver.guard';

const routes: Routes = [
  { path: '', component: PessoaListaComponent },
  {
    path: 'novo',
    component: PessoaFormComponent,
    resolve: {
      pessoa: PessoaResolverGuard
    }
  },
  {
    path: 'editar/:id',
    component: PessoaFormComponent,
    resolve: {
      pessoa: PessoaResolverGuard
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PessoaRoutingModule {}
