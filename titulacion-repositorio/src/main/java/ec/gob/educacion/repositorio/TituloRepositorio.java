package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitTitulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TituloRepositorio extends JpaRepository<TitTitulo, Long> {
	
	TitTitulo findByCodTitulo(Long codTitulo);

}
