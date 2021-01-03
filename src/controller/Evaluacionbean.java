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

import services.EvaluacionService;
import clases.Evaluacion;



public class Evaluacionbean implements Serializable{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Evaluacion evaluacion= new Evaluacion();
   private LinkedList<Evaluacion> evaluacionlist = new LinkedList<Evaluacion>();
   private  Map<Evaluacion,Boolean> selectid= new HashMap<Evaluacion, Boolean>();
   private  Boolean update= true;


   public Evaluacion getEvaluacion() {
    return evaluacion;
    }


   public  LinkedList<Evaluacion> getEvaluacionList() {
    return evaluacionlist;
    }


   public  Boolean  getUpdate() {
    return update;
    }




   public void setEvaluacion(Evaluacion  evaluacion) {
    this.evaluacion=evaluacion;
    }


   public void setEvaluacionlist(LinkedList<Evaluacion>  evaluacionlist) {
    this.evaluacionlist=evaluacionlist;
    }


   public void setUpdate(Boolean update) {
    this.update=update;
    }




  public LinkedList<Evaluacion> getAllEvaluacion() {
	 try {
			if(update)
				{
					evaluacionlist =EvaluacionService.getEvaluacionService().EvaluacionSelectAllQuery();
					update=false;
				}
			} catch (Throwable e){ 
				e.printStackTrace();
		  }		return evaluacionlist;
  }



  public String updateEvaluacion() {
		String result = "evaluacionlist";
		try {

			EvaluacionService.getEvaluacionService().UpdateEvaluacion(evaluacion);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


  public List<SelectItem> getEvaluacionItems() { 
    List<SelectItem> items = new ArrayList<SelectItem>();
   try {
       LinkedList<Evaluacion> listaselect=EvaluacionService.getEvaluacionService().EvaluacionSelectAllQuery();
     for(Evaluacion evaluacion:listaselect){
      items.add(new SelectItem(evaluacion.getCodevaluacion(),evaluacion.getTipoevaluacion().toString())); 
     }
  	 } catch (Throwable e) {
		// TODO Auto-generated catch block 
		e.printStackTrace();
	}
   return items;
 }


   public Map<Evaluacion,Boolean> getselectid() {
    return selectid;
    }


   public void setselectid(Map<Evaluacion,Boolean> selectid) {
    this.selectid=selectid;
    }


  public String addEvaluacion() {
		String result = "evaluacionlist";
		try {

			EvaluacionService.getEvaluacionService().InsertEvaluacion(evaluacion);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


  	public String deleteEvaluacion() {
		String result = "evaluacionlist";

		try {
			EvaluacionService.getEvaluacionService().DeleteEvaluacion(evaluacion);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
 		}
		return result;
	}



public String  delete() {
			String result = "evaluacionlist";
			try {
				Iterator<Entry<Evaluacion, Boolean>> a =selectid.entrySet().iterator();
				while (a.hasNext()) {
					Map.Entry<clases.Evaluacion, java.lang.Boolean> entry =  a.next();
					if (entry.getValue()==true) {
						EvaluacionService.getEvaluacionService().DeleteEvaluacion(entry.getKey());
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
