 package clases;
 /** 
 * * @Author  
 * * @Software 
 * * @Company  
 */



 public class Evaluacion {

private Integer codevaluacion;
private String tipoevaluacion;
private boolean cancelado;


public Evaluacion(){
super();

}


public Evaluacion(Integer codevaluacion,String tipoevaluacion,boolean cancelado) {

super();
this.codevaluacion=codevaluacion;
this.tipoevaluacion=tipoevaluacion;
this.cancelado=cancelado;
}


public Integer getCodevaluacion() {
return codevaluacion;
}


public String getTipoevaluacion() {
return tipoevaluacion;
}


public boolean getCancelado() {
return cancelado;
}


public void setCodevaluacion( Integer codevaluacion) {
this.codevaluacion=codevaluacion;
}


public void setTipoevaluacion( String tipoevaluacion) {
this.tipoevaluacion=tipoevaluacion;
}


public void setCancelado( boolean cancelado) {
this.cancelado=cancelado;
}

}
