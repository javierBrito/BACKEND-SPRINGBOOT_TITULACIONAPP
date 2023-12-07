package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitParametro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametroRepositorio extends JpaRepository<TitParametro, Long> {

	TitParametro findByParCodigo(Long parCodigo);
	
	List<TitParametro> findByParEstado(Integer parEstado);
}
