 package clases;
import java.sql.SQLException;
import services.CarreraService;
 /** 
 * * @Author  
 * * @Software 
 * * @Company  
 */



 public class Plandeestudio {

private Integer codplanest;
private String nombreplan;
private Integer cantperiodos;
private Integer cantannos;
private Integer codcarrera;


public Plandeestudio(){
super();

}


public Plandeestudio(Integer codplanest,String nombreplan,Integer cantperiodos,Integer cantannos,Integer codcarrera) {

super();
this.codplanest=codplanest;
this.nombreplan=nombreplan;
this.cantperiodos=cantperiodos;
this.cantannos=cantannos;
this.codcarrera=codcarrera;
}


public Integer getCodplanest() {
return codplanest;
}


public String getNombreplan() {
return nombreplan;
}


public Integer getCantperiodos() {
return cantperiodos;
}


public Integer getCantannos() {
return cantannos;
}


public Integer getCodcarrera() {
return codcarrera;
}


public void setCodplanest( Integer codplanest) {
this.codplanest=codplanest;
}


public void setNombreplan( String nombreplan) {
this.nombreplan=nombreplan;
}


public void setCantperiodos( Integer cantperiodos) {
this.cantperiodos=cantperiodos;
}


public void setCantannos( Integer cantannos) {
this.cantannos=cantannos;
}


public void setCodcarrera( Integer codcarrera) {
this.codcarrera=codcarrera;
}




public Carrera getCarrera() throws SQLException, ClassNotFoundException
  {
    Carrera carrera= new Carrera(); 
    carrera.setCodcarrera(codcarrera);
    return CarreraService.getCarreraService().FindCarreraByPKQuery(carrera);

   }

}
