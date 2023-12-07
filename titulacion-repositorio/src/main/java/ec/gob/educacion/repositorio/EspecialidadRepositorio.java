package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitEspecialidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepositorio extends JpaRepository<TitEspecialidad, Long> {
	
	List<TitEspecialidad> findByCodTitulo(Long codTitulo);
	
	TitEspecialidad findByCodEspecialidad(Long codEspecialidad);

}
