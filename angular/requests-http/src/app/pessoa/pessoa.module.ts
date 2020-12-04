import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { PessoaRoutingModule } from './pessoa-routing.module';
import { PessoaListaComponent } from './pessoa-lista/pessoa-lista.component';
import { PessoaFormComponent } from './pessoa-form/pessoa-form.component';

@NgModule({
  imports: [
    CommonModule,
    PessoaRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [PessoaListaComponent, PessoaFormComponent]
})
export class PessoaModule { }
