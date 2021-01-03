 package controller;
import clases.*;
 /** 
 * * @Author 
 * * @Software 
 * * @Company  
 */
public class Controllerbean {
    private Asignatura asignatura= new Asignatura();
    private Carrera carrera= new Carrera();
    private Curriculo curriculo= new Curriculo();
    private Disciplina disciplina= new Disciplina();
    private Evaluacion evaluacion= new Evaluacion();
    private Facultad facultad= new Facultad();
    private Plandeestudio plandeestudio= new Plandeestudio();
    private Rol rol= new Rol();
    private Usuario usuario= new Usuario();
    
    public Asignatura  getAsignatura(){
      return asignatura;
    }
    public void  setAsignatura(Asignatura asignatura){
      this.asignatura=asignatura;
    }
    public Carrera  getCarrera(){
      return carrera;
    }
    public void  setCarrera(Carrera carrera){
      this.carrera=carrera;
    }
    public Curriculo  getCurriculo(){
      return curriculo;
    }
    public void  setCurriculo(Curriculo curriculo){
      this.curriculo=curriculo;
    }
    public Disciplina  getDisciplina(){
      return disciplina;
    }
    public void  setDisciplina(Disciplina disciplina){
      this.disciplina=disciplina;
    }
    public Evaluacion  getEvaluacion(){
      return evaluacion;
    }
    public void  setEvaluacion(Evaluacion evaluacion){
      this.evaluacion=evaluacion;
    }
    public Facultad  getFacultad(){
      return facultad;
    }
    public void  setFacultad(Facultad facultad){
      this.facultad=facultad;
    }
    public Plandeestudio  getPlandeestudio(){
      return plandeestudio;
    }
    public void  setPlandeestudio(Plandeestudio plandeestudio){
      this.plandeestudio=plandeestudio;
    }
    public Rol  getRol(){
      return rol;
    }
    public void  setRol(Rol rol){
      this.rol=rol;
    }
    public Usuario  getUsuario(){
      return usuario;
    }
    public void  setUsuario(Usuario usuario){
      this.usuario=usuario;
    }
 }
