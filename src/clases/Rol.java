 package clases;
 /** 
 * * @Author  
 * * @Software 
 * * @Company  
 */



 public class Rol {

private Integer codrol;
private String tiporol;
private boolean cancelado;


public Rol(){
super();

}


public Rol(Integer codrol,String tiporol,boolean cancelado) {

super();
this.codrol=codrol;
this.tiporol=tiporol;
this.cancelado=cancelado;
}


public Integer getCodrol() {
return codrol;
}


public String getTiporol() {
return tiporol;
}


public boolean getCancelado() {
return cancelado;
}


public void setCodrol( Integer codrol) {
this.codrol=codrol;
}


public void setTiporol( String tiporol) {
this.tiporol=tiporol;
}


public void setCancelado( boolean cancelado) {
this.cancelado=cancelado;
}

}
