package br.com.adopet.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("""
        SELECT count(u) > 0 FROM Usuario u where u.email=:email
    """)
    boolean existsByEmail(String email);
}
