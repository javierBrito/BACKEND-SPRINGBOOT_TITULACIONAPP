package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitAutoridad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoridadRepositorio extends JpaRepository<TitAutoridad, Long> {
	
	TitAutoridad findByCodAutoridad(Long codAutoridad);

	List<TitAutoridad> findByCodInstitucion(Long codInstitucion);

}
