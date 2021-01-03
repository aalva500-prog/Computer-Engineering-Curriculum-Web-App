 package clases;
 /** 
 * * @Author  
 * * @Software 
 * * @Company  
 */



 public class Curriculo {

private Integer codcurriculo;
private String tipocurriculo;
private boolean cancelado;


public Curriculo(){
super();

}


public Curriculo(Integer codcurriculo,String tipocurriculo,boolean cancelado) {

super();
this.codcurriculo=codcurriculo;
this.tipocurriculo=tipocurriculo;
this.cancelado=cancelado;
}


public Integer getCodcurriculo() {
return codcurriculo;
}


public String getTipocurriculo() {
return tipocurriculo;
}


public boolean getCancelado() {
return cancelado;
}


public void setCodcurriculo( Integer codcurriculo) {
this.codcurriculo=codcurriculo;
}


public void setTipocurriculo( String tipocurriculo) {
this.tipocurriculo=tipocurriculo;
}


public void setCancelado( boolean cancelado) {
this.cancelado=cancelado;
}

}
