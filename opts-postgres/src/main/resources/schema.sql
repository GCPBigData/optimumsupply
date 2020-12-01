create table test.pessoa
(
    id             serial             not null
        constraint pessoa_pk
            primary key,
    nome           varchar default 100,
    cpf            varchar default 11 not null,
    datanascimento timestamp,
    estado         varchar default 2,
    cidade         varchar,
    cep            bigint,
    telefone       varchar,
    email          varchar,
    skype          varchar,
    status         varchar default 'Ativo'::character varying
);

alter table test.pessoa
    owner to postgres;

create unique index pessoa_cpf_uindex
    on test.pessoa (cpf);

create unique index pessoa_estado_uindex
    on test.pessoa (estado);

