package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitCargo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepositorio extends JpaRepository<TitCargo, Long> {
	
	List<TitCargo> findByCarEstado(Integer carEstado);
	
	TitCargo findByCarCodigo(Long carCodigo);

}
