package ec.gob.educacion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TIT_PARTICIPACION_EST")
public class TitParticipacionEst {
  @Id
  @Column(name = "PES_CODIGO", nullable = false)
  private Long pesCodigo;

  @Size(max = 100)
  @Column(name = "PES_NOMBRE", length = 100)
  private String pesNombre;

  @JsonIgnore
  @OneToMany(mappedBy = "pesCodigo")
  private Set<TitRefrendacion> titRefrendacions = new LinkedHashSet<>();

  public Long getPesCodigo() {
    return pesCodigo;
  }

  public void setPesCodigo(Long id) {
    this.pesCodigo = id;
  }

  public String getPesNombre() {
    return pesNombre;
  }

  public void setPesNombre(String pesNombre) {
    this.pesNombre = pesNombre;
  }

  public Set<TitRefrendacion> getTitRefrendacions() {
    return titRefrendacions;
  }

  public void setTitRefrendacions(Set<TitRefrendacion> titRefrendacions) {
    this.titRefrendacions = titRefrendacions;
  }

}
