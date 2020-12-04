import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { tap, map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { PessoasService } from './pessoa.service';
import { Pessoa } from './pessoa.model';

declare var $: any;

@Component({
  selector: 'app-pessoa',
  templateUrl: './pessoa.component.html',
  styleUrls: ['./pessoa.component.css']
})
export class PessoaComponent implements OnInit {

  showSpinner = false;
  responsePessoas: Pessoa;
  queryField = new FormControl();
  results$;
  texto = '';

   mudaTermo() {
     this.texto = this.queryField.value;
  }

  constructor(
      private pessoaService: PessoasService,
      private http: HttpClient) {
  }

  ngOnInit(): void {

      this.showSpinner = true;
      this.pessoaService.getPessoas().subscribe(
          res => this.responsePessoas = res
      );
      if (this.results$ == null) {
          setTimeout(() => {
              this.showSpinner = false;
          }, 1000);
      }
  }

onSearchNome() {
    let value = this.queryField.value.toUpperCase();
    if (value && (value = value.trim()) !== '') {
    this.showSpinner = true;
    this.results$ = this.http
        .get(this.pessoaService.PessoaURLfindNome + value)
        .pipe(
            tap((res: string) => res),
            map((res: string) => res)
        );
        this.showSpinner = false;
        this.showNotificatioSearch();
    }
};

onSearchCpf() {
  let value = this.queryField.value;
  if (value && (value = value.trim()) !== '') {
  this.showSpinner = true;
  this.results$ = this.http
      .get(this.pessoaService.PessoaURLfindCpf + value)
      .pipe(
          tap((res: string) => res),
          map((res: string) => res)
      );
      this.showSpinner = false;
      this.showNotificatioSearch();
  }
};

  showNotificatioSearch() {
      const type = ['', 'info', 'success', 'warning', 'danger'];

      const color = Math.floor((Math.random() * 4) + 1);

      $.notify({
          icon: 'notifications',
          message: 'Busca Finlizada !<b></b>'
      }, {
          type: type[color],
          timer: 4000,
          placement: {},
          template: '<div data-notify="container" class="col-xl-4 col-lg-4 col-11 col-sm-4 col-md-4 alert alert-{0} alert-with-icon" role="alert">' +
              '<button mat-button  type="button" aria-hidden="true" class="close mat-button" data-notify="dismiss">  <i class="material-icons">close</i></button>' +
              '<i class="material-icons" data-notify="icon">notifications</i> ' +
              '<span data-notify="title">{1}</span> ' +
              '<span data-notify="message">{2}</span>' +
              '<div class="progress" data-notify="progressbar">' +
              '<div class="progress-bar progress-bar-{0}" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>' +
              '</div>' +
              '<a href="{3}" target="{4}" data-notify="url"></a>' +
              '</div>'
      });
  }
}
