import { Component, OnInit } from '@angular/core';
import { PessoaService } from 'src/app/services/pessoa.service';

@Component({
  selector: 'app-pessoa-list',
  templateUrl: './pessoa-list.component.html',
  styleUrls: ['./pessoa-list.component.css']
})
export class PessoaListComponent implements OnInit {

  pessoas: any;
  currentPessoa = null;
  currentIndex = -1;
  nome = '';

  constructor(private pessoaService: PessoaService) { }

  ngOnInit(): void {
    this.retrievePessoas();
  }

  retrievePessoas(): void {
    this.pessoaService.getAll()
      .subscribe(
        data => {
          this.pessoas = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList(): void {
    this.retrievePessoas();
    this.currentPessoa = null;
    this.currentIndex = -1;
  }

  setActivePessoa(pessoa, index): void {
    this.currentPessoa = pessoa;
    this.currentIndex = index;
  }

  removeAllPessoas(): void {
    this.pessoaService.deleteAll()
      .subscribe(
        response => {
          console.log(response);
          this.refreshList();
        },
        error => {
          console.log(error);
        });
  }

  searchNome(): void {
    this.pessoaService.findByNome(this.nome)
      .subscribe(
        data => {
          this.pessoas = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
}
