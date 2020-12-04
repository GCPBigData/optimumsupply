import { LocaleData, LocaleOptionsFormat } from "ngx-bootstrap/chronos/locale/locale.class";

export class Pessoa {
  id: number;
  nome: string;
  cpf: string;
  datanascimento: string;
  estado: string;
  cidade: string;
  cep: string;
  telefone: string;
  email: string;
  skype: string;
  datacadastro: string;
  status: string;

}

export interface RequestCreatePessoa{
  nome: string;
  cpf: string;
  datanascimento: string;
  estado: string;
  cidade: string;
  cep: string;
  telefone: string;
  email: string;
  skype: string;
  datacadastro: String;
  status: string;

}