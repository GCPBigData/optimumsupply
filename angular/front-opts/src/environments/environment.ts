export const environment = {
  production: true,

  /*PESSOA*/
  baseUrl : 'http://localhost:9191/pessoa/v1/',
  pessoaURListAll : 'http://localhost:9191/pessoa/v1/listarTodos',
  pessoaURLfindNome : 'http://localhost:9191/pessoa/v1/buscarNome/',
  pessoaURLfindCpf : 'http://localhost:9191/pessoa/v1/buscarCpf/',
  pessoaURLfindCep : 'http://localhost:9191/pessoa/v1/buscarCep/',
  pessoaURLInsert: 'http://localhost:9191/pessoa/v1/salvar',
  pessoaURLfindId: 'http://localhost:9191/pessoa/v1/findbyid/',

    /*LOGIN*/
    walletURlPost: 'http://191.13.134.55:8080/users/login/',
    apiUrl: 'http://191.13.134.55:8080/users/login/',

    /*COMPANY*/
  
  companyURListAll: 'http://191.13.134.55:8080/company/allResult/',
  companyURLfindName: 'http://191.13.134.55:8080/company/findbyname/',
  companyURLfindId: 'http://191.13.134.55:8080/company/findbyid/',
  companyURLInsert: 'http://191.13.134.55:8080/company/insert',
  companyURLPut: 'http://191.13.134.55:8080/company/edit/',
  companyURLPutStatus: 'http://191.13.134.55:8080/company/edit/',
  companyURListAllSector: 'http://191.13.134.55:8080/company/allResultSector/'
};
