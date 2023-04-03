ALTER TABLE tutores add column usuario_id BIGSERIAL;
ALTER TABLE tutores add constraint fk_tutores_usuarios_id foreign key(usuario_id) references usuarios(id);