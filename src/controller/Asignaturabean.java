 package controller;
 /** 
 * * @Author 
 * * @Software 
 * * @Company 
  */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.model.SelectItem;

import services.AsignaturaService;
import clases.Asignatura;
import clases.Curriculo;
import clases.Disciplina;
import clases.Evaluacion;
import clases.Plandeestudio;



public class Asignaturabean implements Serializable{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Asignatura asignaturapre= new Asignatura();
	private LinkedList<Asignatura> asignaturalist = new LinkedList<Asignatura>();
	private Map<Asignatura, Boolean> selectid= new HashMap<Asignatura, Boolean>();
	private Boolean update= true;
	private Asignatura asignatura = new Asignatura();
	private Curriculo curriculo = new Curriculo();
	private Disciplina disciplina = new Disciplina();
	private Evaluacion evaluacion = new Evaluacion();
	private Plandeestudio plandeestudio = new Plandeestudio();


	public Asignatura getAsignaturapre() {
    return asignaturapre;
    }


   public  LinkedList<Asignatura> getAsignaturaList() {
    return asignaturalist;
    }


   public  Boolean  getUpdate() {
    return update;
    }


   public Asignatura getAsignatura() {
    return asignatura;
    }
   public Curriculo getCurriculo() {
    return curriculo;
    }
   public Disciplina getDisciplina() {
    return disciplina;
    }
   public Evaluacion getEvaluacion() {
    return evaluacion;
    }
   public Plandeestudio getPlandeestudio() {
    return plandeestudio;
    }


   public void setAsignaturapre(Asignatura  asignatura) {
    this.asignaturapre=asignatura;
    }


   public void setAsignaturalist(LinkedList<Asignatura>  asignaturalist) {
    this.asignaturalist=asignaturalist;
    }


   public void setUpdate(Boolean update) {
    this.update=update;
    }


   public void setAsignatura(Asignatura  asignatura) {
    this.asignatura=asignatura;
    }
   public void setCurriculo(Curriculo  curriculo) {
    this.curriculo=curriculo;
    }
   public void setDisciplina(Disciplina  disciplina) {
    this.disciplina=disciplina;
    }
   public void setEvaluacion(Evaluacion  evaluacion) {
    this.evaluacion=evaluacion;
    }
   public void setPlandeestudio(Plandeestudio  plandeestudio) {
    this.plandeestudio=plandeestudio;
    }


  public LinkedList<Asignatura> getAllAsignatura() {
	 try {
			if(update)
				{
					asignaturalist =AsignaturaService.getAsignaturaService().AsignaturaSelectAllQuery();
					update=false;
				}
			} catch (Throwable e){ 
				e.printStackTrace();
		  }		return asignaturalist;
  }



  public String updateAsignatura() {
		String result = "asignaturalist";
		try {

			AsignaturaService.getAsignaturaService().UpdateAsignatura(asignatura);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


  public List<SelectItem> getAsignaturaItems() { 
    List<SelectItem> items = new ArrayList<SelectItem>();
   try {
       LinkedList<Asignatura> listaselect=AsignaturaService.getAsignaturaService().AsignaturaSelectAllQuery();
     for(Asignatura asignatura:listaselect){
      items.add(new SelectItem(asignatura.getCodasig(),asignatura.getNombreasig().toString())); 
     }
  	 } catch (Throwable e) {
		// TODO Auto-generated catch block 
		e.printStackTrace();
	}
   return items;
 }


   public Map<Asignatura,Boolean> getselectid() {
    return selectid;
    }


   public void setselectid(Map<Asignatura,Boolean> selectid) {
    this.selectid=selectid;
    }


  public String addAsignatura() {
		String result = "asignaturalist";
		try {

			AsignaturaService.getAsignaturaService().InsertAsignatura(asignatura);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


  	public String deleteAsignatura() {
		String result = "asignaturalist";

		try {
			AsignaturaService.getAsignaturaService().DeleteAsignatura(asignatura);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
 		}
		return result;
	}



public String  delete() {
			String result = "asignaturalist";
			try {
				Iterator<Entry<Asignatura, Boolean>> a =selectid.entrySet().iterator();
				while (a.hasNext()) {
					Map.Entry<clases.Asignatura, java.lang.Boolean> entry =  a.next();
					if (entry.getValue()==true) {
						AsignaturaService.getAsignaturaService().DeleteAsignatura(entry.getKey());
					}
				}
			} catch (Throwable e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
			selectid.clear(); // If necessary. 
	        return result;
		// Now do your thing with checkedItems.
		}



}
