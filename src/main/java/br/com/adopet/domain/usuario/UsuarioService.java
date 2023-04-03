package br.com.adopet.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository _usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository _usuarioRepository) {
        this._usuarioRepository = _usuarioRepository;
    }
}
