 package controller;
 /** 
 * * @Author 
 * * @Software 
 * * @Company 
  */
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import services.CarreraService;
import clases.Carrera;
import clases.Facultad;



public class Carrerabean implements Serializable{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Carrera carrera= new Carrera();
   private LinkedList<Carrera> carreralist = new LinkedList<Carrera>();
   private  Map<Carrera,Boolean> selectid= new HashMap<Carrera, Boolean>();
   private  Boolean update= true;
   private Facultad facultad= new Facultad();


   public Carrera getCarrera() {
    return carrera;
    }


   public  LinkedList<Carrera> getCarreraList() {
    return carreralist;
    }


   public  Boolean  getUpdate() {
    return update;
    }


   public Facultad getFacultad() {
    return facultad;
    }


   public void setCarrera(Carrera  carrera) {
    this.carrera=carrera;
    }


   public void setCarreralist(LinkedList<Carrera>  carreralist) {
    this.carreralist=carreralist;
    }


   public void setUpdate(Boolean update) {
    this.update=update;
    }


   public void setFacultad(Facultad  facultad) {
    this.facultad=facultad;
    }


  public LinkedList<Carrera> getAllCarrera() {
	 try {
			if(update)
				{
					carreralist =CarreraService.getCarreraService().CarreraSelectAllQuery();
					update=false;
				}
			} catch (Throwable e){ 
				e.printStackTrace();
		  }		return carreralist;
  }

public String carreraUpdate()
{
	String result="modificarcarrera";
	FacesContext context = FacesContext.getCurrentInstance();  
	Map requestMap = context.getExternalContext().getRequestParameterMap(); 
	String value = (String)requestMap.get("idcarreraupdate"); 
	carrera.setCodcarrera(Integer.valueOf(value));
	try {
		carrera=CarreraService.getCarreraService().FindCarreraByPK2(carrera);
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
}

  public String updateCarrera() {
		String result = "carreralist";
		try {

			CarreraService.getCarreraService().UpdateCarrera(carrera);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


  public List<SelectItem> getCarreraItems() { 
    List<SelectItem> items = new ArrayList<SelectItem>();
   try {
       LinkedList<Carrera> listaselect=CarreraService.getCarreraService().CarreraSelectAllQuery();
     for(Carrera carrera:listaselect){
      items.add(new SelectItem(carrera.getCodcarrera(),carrera.getNombcarrera().toString())); 
     }
  	 } catch (Throwable e) {
		// TODO Auto-generated catch block 
		e.printStackTrace();
	}
   return items;
 }


   public Map<Carrera,Boolean> getselectid() {
    return selectid;
    }


   public void setselectid(Map<Carrera,Boolean> selectid) {
    this.selectid=selectid;
    }


  public String addCarrera() {
		String result = "carreralist";
		try {

			CarreraService.getCarreraService().InsertCarrera(carrera);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


  	public String deleteCarrera() {
		String result = "carreralist";

		try {
			CarreraService.getCarreraService().DeleteCarrera(carrera);
			update=true;
			System.out.println("Elimino"+carrera.getNombcarrera());
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
 		}
		return result;
	}



public String  delete() {
			String result = "carreralist";
			try {
				Iterator<Entry<Carrera, Boolean>> a =selectid.entrySet().iterator();
				while (a.hasNext()) {
					Map.Entry<clases.Carrera, java.lang.Boolean> entry =  a.next();
					if (entry.getValue()==true) {
						CarreraService.getCarreraService().DeleteCarrera(entry.getKey());
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
