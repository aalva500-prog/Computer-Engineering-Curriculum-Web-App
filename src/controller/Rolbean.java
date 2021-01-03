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

import services.RolService;
import clases.Rol;



public class Rolbean implements Serializable{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Rol rol= new Rol();
   private LinkedList<Rol> rollist = new LinkedList<Rol>();
   private  Map<Rol,Boolean> selectid= new HashMap<Rol, Boolean>();
   private  Boolean update= true;


   public Rol getRol() {
    return rol;
    }


   public  LinkedList<Rol> getRolList() {
    return rollist;
    }


   public  Boolean  getUpdate() {
    return update;
    }




   public void setRol(Rol  rol) {
    this.rol=rol;
    }


   public void setRollist(LinkedList<Rol>  rollist) {
    this.rollist=rollist;
    }


   public void setUpdate(Boolean update) {
    this.update=update;
    }




  public LinkedList<Rol> getAllRol() {
	 try {
			if(update)
				{
					rollist =RolService.getRolService().RolSelectAllQuery();
					update=false;
				}
			} catch (Throwable e){ 
				e.printStackTrace();
		  }		return rollist;
  }



  public String updateRol() {
		String result = "rollist";
		try {

			RolService.getRolService().UpdateRol(rol);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


  public List<SelectItem> getRolItems() { 
    List<SelectItem> items = new ArrayList<SelectItem>();
   try {
       LinkedList<Rol> listaselect=RolService.getRolService().RolSelectAllQuery();
     for(Rol rol:listaselect){
      items.add(new SelectItem(rol.getCodrol(),rol.getTiporol().toString())); 
     }
  	 } catch (Throwable e) {
		// TODO Auto-generated catch block 
		e.printStackTrace();
	}
   return items;
 }


   public Map<Rol,Boolean> getselectid() {
    return selectid;
    }


   public void setselectid(Map<Rol,Boolean> selectid) {
    this.selectid=selectid;
    }


  public String addRol() {
		String result = "rollist";
		try {

			RolService.getRolService().InsertRol(rol);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


  	public String deleteRol() {
		String result = "rollist";

		try {
			RolService.getRolService().DeleteRol(rol);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
 		}
		return result;
	}



public String  delete() {
			String result = "rollist";
			try {
				Iterator<Entry<Rol, Boolean>> a =selectid.entrySet().iterator();
				while (a.hasNext()) {
					Map.Entry<clases.Rol, java.lang.Boolean> entry =  a.next();
					if (entry.getValue()==true) {
						RolService.getRolService().DeleteRol(entry.getKey());
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
