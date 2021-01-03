 package clases;
import java.sql.SQLException;
import services.FacultadService;
 /** 
 * * @Author  
 * * @Software 
 * * @Company  
 */



 public class Carrera {

private Integer codcarrera;
private String nombcarrera;
private Integer idfacultad;


public Carrera(){
super();

}


public Carrera(Integer codcarrera,String nombcarrera,Integer idfacultad) {

super();
this.codcarrera=codcarrera;
this.nombcarrera=nombcarrera;
this.idfacultad=idfacultad;
}


public Integer getCodcarrera() {
return codcarrera;
}


public String getNombcarrera() {
return nombcarrera;
}


public Integer getIdfacultad() {
return idfacultad;
}


public void setCodcarrera( Integer codcarrera) {
this.codcarrera=codcarrera;
}


public void setNombcarrera( String nombcarrera) {
this.nombcarrera=nombcarrera;
}


public void setIdfacultad( Integer idfacultad) {
this.idfacultad=idfacultad;
}




public Facultad getFacultad() throws SQLException, ClassNotFoundException
  {
    Facultad facultad= new Facultad(); 
    facultad.setIdfacultad(idfacultad);
    return FacultadService.getFacultadService().FindFacultadByPKQuery(facultad);

   }


}
