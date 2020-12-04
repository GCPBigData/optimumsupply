export const environment = {
  production: true,
  /*BROKERAGES   φ = '1,61803398874988'; */
  brokeragesURLInsert: 'http://191.13.134.55:8080/brokerages/',
  brokeragesURLListarTodos: 'http://191.13.134.55:8080/brokerages/ListaTodos/',
  brokeragesURLpainel: 'http://191.13.134.55:8080/brokerages/painel',
  brokeragesURLfindName: 'http://191.13.134.55:8080/brokerages/findbyname/',
  brokeragesURLfindId: 'http://191.13.134.55:8080/brokerages/findbyid',
  brokeragesURLfindAccount: 'http://191.13.134.55:8080/brokerages/findaccountsbyuser/',
  brokeragesURLPut: 'http://191.13.134.55:8080/brokerages/editar/',
  brokeragesURLPutUpdate: 'http://191.13.134.55:8080//brokerages/update/',
  brokeragesURLDelete: 'http://191.13.134.55:8080/brokerages/delete/',
  brokeragesURLStatus: 'http://191.13.134.55:8080/brokerages/status/check/',
  
  /*LOGIN*/
  walletURlPost: 'http://191.13.134.55:8080/users/login/',
  apiUrl: 'http://191.13.134.55:8080/users/login/',

    /*PESSOA*/
    baseUrl : 'http://localhost:9191/pessoa/v1/',
    pessoaURListAll : 'http://localhost:9191/pessoa/v1/ListaTodos',
    pessoaURLfindNome : 'http://localhost:9191/pessoa/v1/findbynome/',
    pessoaURLfindCpf : 'http://localhost:9191/pessoa/v1/findbycpf/',
    pessoaURLfindCep : 'http://localhost:9191/pessoa/v1/findbycep/',
    pessoaURLInsert: 'http://localhost:9191/pessoa/v1/salvar',
    pessoaURLUpdate: 'http://localhost:9191/pessoa/v1/atualizar',
    pessoaURLfindId: 'http://localhost:9191/pessoa/v1/findbyid/'
  
};
