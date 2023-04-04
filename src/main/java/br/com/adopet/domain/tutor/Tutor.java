package br.com.adopet.domain.tutor;

import br.com.adopet.domain.usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Tutor")
@Table(name = "tutores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Tutor {
    @Id
    @SequenceGenerator(name="tutor_seq", sequenceName="tutor_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="tutor_seq")
    private Long id;
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private String foto;
    private String nome;
    private String telefone;
    private String cidade;
    private String sobre;
    private boolean ativo;

    public Tutor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void deletar() {
        ativo = false;

        usuario.deletar();
    }
}
