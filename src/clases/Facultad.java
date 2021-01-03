 package clases;
 /** 
 * * @Author  
 * * @Software 
 * * @Company  
 */



 public class Facultad {

private Integer idfacultad;
private String nombdecano;
private String nombfacultad;


public Facultad(){
super();

}


public Facultad(Integer idfacultad,String nombdecano,String nombfacultad) {

super();
this.idfacultad=idfacultad;
this.nombdecano=nombdecano;
this.nombfacultad=nombfacultad;
}


public Integer getIdfacultad() {
return idfacultad;
}


public String getNombdecano() {
return nombdecano;
}


public String getNombfacultad() {
return nombfacultad;
}


public void setIdfacultad( Integer idfacultad) {
this.idfacultad=idfacultad;
}


public void setNombdecano( String nombdecano) {
this.nombdecano=nombdecano;
}


public void setNombfacultad( String nombfacultad) {
this.nombfacultad=nombfacultad;
}

}
