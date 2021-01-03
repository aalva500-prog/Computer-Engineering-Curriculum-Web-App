 package clases;
import java.sql.SQLException;
import services.FacultadService;
import services.RolService;
 /** 
 * * @Author  
 * * @Software 
 * * @Company  
 */



 public class Usuario {

private String nombreus;
private String password;
private Integer idfacultad;
private Integer codrol;
private Integer idusuario;


public Usuario(){
super();

}


public Usuario(String nombreus,String password,Integer idfacultad,Integer codrol,Integer idusuario) {

super();
this.nombreus=nombreus;
this.password=password;
this.idfacultad=idfacultad;
this.codrol=codrol;
this.idusuario=idusuario;
}


public String getNombreus() {
return nombreus;
}


public String getPassword() {
return password;
}


public Integer getIdfacultad() {
return idfacultad;
}


public Integer getCodrol() {
return codrol;
}


public Integer getIdusuario() {
return idusuario;
}


public void setNombreus( String nombreus) {
this.nombreus=nombreus;
}


public void setPassword( String password) {
this.password=password;
}


public void setIdfacultad( Integer idfacultad) {
this.idfacultad=idfacultad;
}


public void setCodrol( Integer codrol) {
this.codrol=codrol;
}


public void setIdusuario( Integer idusuario) {
this.idusuario=idusuario;
}




public Facultad getFacultad() throws SQLException, ClassNotFoundException
  {
    Facultad facultad= new Facultad(); 
    facultad.setIdfacultad(idfacultad);
    return FacultadService.getFacultadService().FindFacultadByPKQuery(facultad);

   }


public Rol getRol() throws SQLException, ClassNotFoundException
  {
    Rol rol= new Rol(); 
    rol.setCodrol(codrol);
    return RolService.getRolService().FindRolByPKQuery(rol);

   }

}
