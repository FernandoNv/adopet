DROP SEQUENCE IF EXISTS usuarios_id_seq CASCADE;
DROP SEQUENCE IF EXISTS tutores_id_seq CASCADE;

create sequence if not exists usuarios_seq
    increment 1
    minvalue 1
    maxvalue 9999999999
    start 1
    cache 1;

create sequence if not exists tutor_seq
    increment 1
    minvalue 1
    maxvalue 9999999999
    start 1
    cache 1;