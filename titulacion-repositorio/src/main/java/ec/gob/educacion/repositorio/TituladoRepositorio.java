package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitTitulado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TituladoRepositorio extends JpaRepository<TitTitulado, Long> {
	
	TitTitulado findByCodTitulado(Long codTitulado);

}
