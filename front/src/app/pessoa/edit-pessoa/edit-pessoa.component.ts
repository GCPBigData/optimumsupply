import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { PessoasService } from '../pessoa.service';
import { Pessoa } from '../pessoa.model';

declare var $: any;

@Component({
  selector: 'app-edit-pessoa',
  templateUrl: './edit-pessoa.component.html',
  styleUrls: ['./edit-pessoa.component.css']
})
export class EditPessoaComponent implements OnInit {

  currentPessoa = null;
  message = '';
  response = Pessoa;
  statusString: string[] = ['INATIVO' , 'ATIVO'];

  constructor(
      private PessoasService: PessoasService,
      private formBuilder: FormBuilder,
      private route: ActivatedRoute,
      private router: Router,
  ) {
  }

  ngOnInit(): void {
      this.message = '';
      this.getPessoax(this.route.snapshot.paramMap.get('id'));
  }

 updatePessoaX() {
      this.PessoasService.update(this.currentPessoa.id, this.currentPessoa)
          .subscribe(
              response => {
                  console.log(response);
                  this.message = 'ATUALIZADO';
              },
              error => {
                  console.log(error);
              });
  }

  getPessoax(id) {
      this.PessoasService.getPessoaid(id)
          .subscribe(
              data => {
                  this.currentPessoa = data;
                  console.log(data);
              },
              error => {
                  console.log(error);
              });
  }

}

