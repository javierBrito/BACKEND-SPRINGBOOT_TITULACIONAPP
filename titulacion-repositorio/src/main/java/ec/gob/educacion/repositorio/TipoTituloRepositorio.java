package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitTipoTitulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTituloRepositorio extends JpaRepository<TitTipoTitulo, Long> {
	
	TitTipoTitulo findByCodTipoTitulo(Long codTipoTitulo);

}
