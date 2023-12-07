package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitEstadoCal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCalRepositorio extends JpaRepository<TitEstadoCal, Long> {
	
	TitEstadoCal findByCodEstado(Long codEstado);
}
