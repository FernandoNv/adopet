package br.com.adopet.domain.tutor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
    @Query("""
        select t.ativo from Tutor t where t.id = :id
    """)
    boolean findAtivoById(Long id);

    Page<Tutor> findAllByAtivoTrue(Pageable paginacao);
}
