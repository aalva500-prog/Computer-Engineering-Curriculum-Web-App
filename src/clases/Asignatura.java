 package clases;
import java.sql.SQLException;
import services.AsignaturaService;
import services.CurriculoService;
import services.DisciplinaService;
import services.EvaluacionService;
import services.PlandeestudioService;
 /** 
 * * @Author  
 * * @Software 
 * * @Company  
 */



 public class Asignatura {

private Integer codasig;
private String nombreasig;
private String jefeasig;
private Integer canthoras;
private Integer anno;
private Integer periodo;
private String planmetodologico;
private String programanalitico;
private String secactividad;
private Integer codevaluacion;
private Integer codplanest;
private Integer codasigpre;
private Integer coddisciplina;
private Integer codcurriculo;


public Asignatura(){
super();

}


public Asignatura(Integer codasig,String nombreasig,String jefeasig,Integer canthoras,Integer anno,Integer periodo,String planmetodologico,String programanalitico,String secactividad,Integer codevaluacion,Integer codplanest,Integer codasigpre,Integer coddisciplina,Integer codcurriculo) {

super();
this.codasig=codasig;
this.nombreasig=nombreasig;
this.jefeasig=jefeasig;
this.canthoras=canthoras;
this.anno=anno;
this.periodo=periodo;
this.planmetodologico=planmetodologico;
this.programanalitico=programanalitico;
this.secactividad=secactividad;
this.codevaluacion=codevaluacion;
this.codplanest=codplanest;
this.codasigpre=codasigpre;
this.coddisciplina=coddisciplina;
this.codcurriculo=codcurriculo;
}


public Integer getCodasig() {
return codasig;
}


public String getNombreasig() {
return nombreasig;
}


public String getJefeasig() {
return jefeasig;
}


public Integer getCanthoras() {
return canthoras;
}


public Integer getAnno() {
return anno;
}


public Integer getPeriodo() {
return periodo;
}


public String getPlanmetodologico() {
return planmetodologico;
}


public String getProgramanalitico() {
return programanalitico;
}


public String getSecactividad() {
return secactividad;
}


public Integer getCodevaluacion() {
return codevaluacion;
}


public Integer getCodplanest() {
return codplanest;
}


public Integer getCodasigpre() {
return codasigpre;
}


public Integer getCoddisciplina() {
return coddisciplina;
}


public Integer getCodcurriculo() {
return codcurriculo;
}


public void setCodasig( Integer codasig) {
this.codasig=codasig;
}


public void setNombreasig( String nombreasig) {
this.nombreasig=nombreasig;
}


public void setJefeasig( String jefeasig) {
this.jefeasig=jefeasig;
}


public void setCanthoras( Integer canthoras) {
this.canthoras=canthoras;
}


public void setAnno( Integer anno) {
this.anno=anno;
}


public void setPeriodo( Integer periodo) {
this.periodo=periodo;
}


public void setPlanmetodologico( String planmetodologico) {
this.planmetodologico=planmetodologico;
}


public void setProgramanalitico( String programanalitico) {
this.programanalitico=programanalitico;
}


public void setSecactividad( String secactividad) {
this.secactividad=secactividad;
}


public void setCodevaluacion( Integer codevaluacion) {
this.codevaluacion=codevaluacion;
}


public void setCodplanest( Integer codplanest) {
this.codplanest=codplanest;
}


public void setCodasigpre( Integer codasigpre) {
this.codasigpre=codasigpre;
}


public void setCoddisciplina( Integer coddisciplina) {
this.coddisciplina=coddisciplina;
}


public void setCodcurriculo( Integer codcurriculo) {
this.codcurriculo=codcurriculo;
}




public Asignatura getAsignatura() throws SQLException, ClassNotFoundException
  {
    Asignatura asignatura= new Asignatura(); 
    asignatura.setCodasig(codasigpre);
    return AsignaturaService.getAsignaturaService().FindAsignaturaByPKQuery(asignatura);

   }


public Curriculo getCurriculo() throws SQLException, ClassNotFoundException
  {
    Curriculo curriculo= new Curriculo(); 
    curriculo.setCodcurriculo(codcurriculo);
    return CurriculoService.getCurriculoService().FindCurriculoByPKQuery(curriculo);

   }


public Disciplina getDisciplina() throws SQLException, ClassNotFoundException
  {
    Disciplina disciplina= new Disciplina(); 
    disciplina.setCoddisciplina(coddisciplina);
    return DisciplinaService.getDisciplinaService().FindDisciplinaByPKQuery(disciplina);

   }


public Evaluacion getEvaluacion() throws SQLException, ClassNotFoundException
  {
    Evaluacion evaluacion= new Evaluacion(); 
    evaluacion.setCodevaluacion(codevaluacion);
    return EvaluacionService.getEvaluacionService().FindEvaluacionByPKQuery(evaluacion);

   }


public Plandeestudio getPlandeestudio() throws SQLException, ClassNotFoundException
  {
    Plandeestudio plandeestudio= new Plandeestudio(); 
    plandeestudio.setCodplanest(codplanest);
    return PlandeestudioService.getPlandeestudioService().FindPlandeestudioByPKQuery(plandeestudio);

   }


}
