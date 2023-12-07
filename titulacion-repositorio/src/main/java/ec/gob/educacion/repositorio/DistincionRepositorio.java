package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitDistincion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistincionRepositorio extends JpaRepository<TitDistincion, Long> {
	
	TitDistincion findByCodDistincion(Long codDistincion);

}
