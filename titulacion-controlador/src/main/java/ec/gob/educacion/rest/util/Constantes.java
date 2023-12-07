package ec.gob.educacion.rest.util;

/**
 * Constantes
 *
 * @author Javier Brito
 * @modify jbrito - 20211211
 * @version $Revision: 1.1 $
 * 
 */
public class Constantes {

	public static final String FORMATO_YY_MM_DD = "yyyy/mm/dd";
	public static final String REGISTRO_ACTIVO_NUM = "1";
	public static final String REGISTRO_INACTIVO_NUM = "0";
	public static final String REGISTRO_INSERT = "INS";
	public static final String REGISTRO_UPDATE = "UPD";

	//Credenciales para Carpeta
	//localhost
	public static final String nombreDirectorio = "D://upload//";
	//Desarrollo y Pre-produccion
	//public static final String UPLOADED_FOLDER = "sellobt";
	
	//Credenciales para FTP
	//localhost
	public static final String URL_FTP = "192.168.0.100";
	public static final String USUARIO_FTP = "jbrito";
	public static final String PASSWORD_FTP = "Dario0030.D";
	//Desarrollo y Pre-produccion
	/*
	public static final String URL_FTP = "10.200.10.16";
	public static final String USUARIO_FTP = "";
	public static final String PASSWORD_FTP = "";
	*/

	//Link para seguridades
	// desarrollo
	//public static final String URL_REST_SEGURIDAD = "http://10.200.10.15/serviciosEducacion-web/resources/ValidarUsuario/Seguridades/";
	//public static final String URL_REST_ROLES = "http://10.200.10.15/serviciosEducacion-web/resources/ValidacionUsuarioLdapSeguridadesJdc/ObtenerRecursosDeRol";
	 
	// pre-produccion
	public static final String URL_REST_SEGURIDAD = "https://pre-academico.educacion.gob.ec/serviciosEducacion-web/resources/ValidarUsuario/Seguridades/";
	public static final String URL_REST_ROLES = "https://pre-academico.educacion.gob.ec/serviciosEducacion-web/resources/ValidacionUsuarioLdapSeguridadesJdc/ObtenerRecursosDeRol";
	public static final Integer REGISTRO_ACTIVO = null;
	public static final String REGISTRO_INACTIVO = null;

	// produccion
	// public static final String URL_REST_SEGURIDAD =
	// "https://academico.educarecuador.gob.ec/serviciosEducacion-web/resources/ValidarUsuario/Seguridades/";
	// public static final String URL_REST_ROLES =
	// "https://academico.educarecuador.gob.ec/serviciosEducacion-web/resources/ValidacionUsuarioLdapSeguridadesJdc/ObtenerRecursosDeRol";

}