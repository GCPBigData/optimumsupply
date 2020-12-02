    -- DADOS
    -- 1,admin,admin,{bcrypt}$2a$10$62G2DfTMpiQasT4WwbDXUuJly3pZYUVRn/qYbQA7PV5yTSkS6SGTe,"ROLE_ADMIN,ROLE_USER"
   create table caed.login_user
(
    id          integer not null
        constraint user_pk
            primary key,
    name        varchar,
    username    varchar,
    password    varchar,
    authorities varchar
);

alter table caed.login_user
    owner to postgres;

