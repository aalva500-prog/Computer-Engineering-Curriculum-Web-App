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

import services.PlandeestudioService;
import clases.Carrera;
import clases.Plandeestudio;



public class Plandeestudiobean implements Serializable{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Plandeestudio plandeestudio= new Plandeestudio();
   private LinkedList<Plandeestudio> plandeestudiolist = new LinkedList<Plandeestudio>();
   private  Map<Plandeestudio,Boolean> selectid= new HashMap<Plandeestudio, Boolean>();
   private  Boolean update= true;
   private Carrera carrera= new Carrera();


   public Plandeestudio getPlandeestudio() {
    return plandeestudio;
    }


   public  LinkedList<Plandeestudio> getPlandeestudioList() {
    return plandeestudiolist;
    }


   public  Boolean  getUpdate() {
    return update;
    }


   public Carrera getCarrera() {
    return carrera;
    }


   public void setPlandeestudio(Plandeestudio  plandeestudio) {
    this.plandeestudio=plandeestudio;
    }


   public void setPlandeestudiolist(LinkedList<Plandeestudio>  plandeestudiolist) {
    this.plandeestudiolist=plandeestudiolist;
    }


   public void setUpdate(Boolean update) {
    this.update=update;
    }


   public void setCarrera(Carrera  carrera) {
    this.carrera=carrera;
    }


  public LinkedList<Plandeestudio> getAllPlandeestudio() {
	 try {
			if(update)
				{
					plandeestudiolist =PlandeestudioService.getPlandeestudioService().PlandeestudioSelectAllQuery();
					update=false;
				}
			} catch (Throwable e){ 
				e.printStackTrace();
		  }		return plandeestudiolist;
  }



  public String updatePlandeestudio() {
		String result = "plandeestudiolist";
		try {

			PlandeestudioService.getPlandeestudioService().UpdatePlandeestudio(plandeestudio);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


  public List<SelectItem> getPlandeestudioItems() { 
    List<SelectItem> items = new ArrayList<SelectItem>();
   try {
       LinkedList<Plandeestudio> listaselect=PlandeestudioService.getPlandeestudioService().PlandeestudioSelectAllQuery();
     for(Plandeestudio plandeestudio:listaselect){
      items.add(new SelectItem(plandeestudio.getCodplanest(),plandeestudio.getNombreplan().toString())); 
     }
  	 } catch (Throwable e) {
		// TODO Auto-generated catch block 
		e.printStackTrace();
	}
   return items;
 }


   public Map<Plandeestudio,Boolean> getselectid() {
    return selectid;
    }


   public void setselectid(Map<Plandeestudio,Boolean> selectid) {
    this.selectid=selectid;
    }


  public String addPlandeestudio() {
		String result = "plandeestudiolist";
		try {

			PlandeestudioService.getPlandeestudioService().InsertPlandeestudio(plandeestudio);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


  	public String deletePlandeestudio() {
		String result = "plandeestudiolist";

		try {
			PlandeestudioService.getPlandeestudioService().DeletePlandeestudio(plandeestudio);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
 		}
		return result;
	}



public String  delete() {
			String result = "plandeestudiolist";
			try {
				Iterator<Entry<Plandeestudio, Boolean>> a =selectid.entrySet().iterator();
				while (a.hasNext()) {
					Map.Entry<clases.Plandeestudio, java.lang.Boolean> entry =  a.next();
					if (entry.getValue()==true) {
						PlandeestudioService.getPlandeestudioService().DeletePlandeestudio(entry.getKey());
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
