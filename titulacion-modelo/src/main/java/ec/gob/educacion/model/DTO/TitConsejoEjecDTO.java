package ec.gob.educacion.model.DTO;

public class TitConsejoEjecDTO {
  private Long autCodigo;
  private Long carCodigo;
  private Long codigo;
  private String autCedula;
  private String autNombre;
  private Long codInstitucion;
  private Long codIncAnioLectivo;

  public Long getAutCodigo() {
    return autCodigo;
  }

  public void setAutCodigo(Long id) {
    this.autCodigo = id;
  }

  public Long getCarCodigo() {
    return carCodigo;
  }

  public void setCarCodigo(Long carCodigo) {
    this.carCodigo = carCodigo;
  }

  public Long getCodigo() {
    return codigo;
  }

  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }

  public String getAutCedula() {
    return autCedula;
  }

  public void setAutCedula(String autCedula) {
    this.autCedula = autCedula;
  }

  public String getAutNombre() {
    return autNombre;
  }

  public void setAutNombre(String autNombre) {
    this.autNombre = autNombre;
  }

  public Long getCodInstitucion() {
    return codInstitucion;
  }

  public void setCodInstitucion(Long codInstitucion) {
    this.codInstitucion = codInstitucion;
  }

  public Long getCodIncAnioLectivo() {
    return codIncAnioLectivo;
  }

  public void setCodIncAnioLectivo(Long codIncAnioLectivo) {
    this.codIncAnioLectivo = codIncAnioLectivo;
  }

}
