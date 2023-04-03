create sequence if not exists usuarios_id_seq
    increment 1
    minvalue 1
    maxvalue 9999999999
    start 1
    cache 1;

create sequence if not exists tutor_id_seq
    increment 1
    minvalue 1
    maxvalue 9999999999
    start 1
    cache 1;