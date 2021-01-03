 package clases;
 /** 
 * * @Author  
 * * @Software 
 * * @Company  
 */



 public class Disciplina {

private Integer coddisciplina;
private String nombredisciplin;
private String jefedisciplin;
private Integer canthorastotales;
private boolean cancelado;


public Disciplina(){
super();

}


public Disciplina(Integer coddisciplina,String nombredisciplin,String jefedisciplin,Integer canthorastotales,boolean cancelado) {

super();
this.coddisciplina=coddisciplina;
this.nombredisciplin=nombredisciplin;
this.jefedisciplin=jefedisciplin;
this.canthorastotales=canthorastotales;
this.cancelado=cancelado;
}


public Integer getCoddisciplina() {
return coddisciplina;
}


public String getNombredisciplin() {
return nombredisciplin;
}


public String getJefedisciplin() {
return jefedisciplin;
}


public Integer getCanthorastotales() {
return canthorastotales;
}


public boolean getCancelado() {
return cancelado;
}


public void setCoddisciplina( Integer coddisciplina) {
this.coddisciplina=coddisciplina;
}


public void setNombredisciplin( String nombredisciplin) {
this.nombredisciplin=nombredisciplin;
}


public void setJefedisciplin( String jefedisciplin) {
this.jefedisciplin=jefedisciplin;
}


public void setCanthorastotales( Integer canthorastotales) {
this.canthorastotales=canthorastotales;
}


public void setCancelado( boolean cancelado) {
this.cancelado=cancelado;
}




}
