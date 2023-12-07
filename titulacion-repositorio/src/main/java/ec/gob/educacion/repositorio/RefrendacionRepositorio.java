package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitRefrendacion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefrendacionRepositorio extends JpaRepository<TitRefrendacion, Long> {
	
	List<TitRefrendacion> findByCodigo(Long codigo);

	TitRefrendacion findByRefCodigo(Long refCodigo);

}
