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

import services.FacultadService;
import clases.Facultad;



public class Facultadbean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Facultad facultad= new Facultad();
	private LinkedList<Facultad> facultadlist = new LinkedList<Facultad>();
	private  Map<Facultad,Boolean> selectid= new HashMap<Facultad, Boolean>();
	private  Boolean update= true;


	public Facultad getFacultad() {
		return facultad;
	}


	public  LinkedList<Facultad> getFacultadList() {
		return facultadlist;
	}


	public  Boolean  getUpdate() {
		return update;
	}




	public void setFacultad(Facultad  facultad) {
		this.facultad=facultad;
	}


	public void setFacultadlist(LinkedList<Facultad>  facultadlist) {
		this.facultadlist=facultadlist;
	}


	public void setUpdate(Boolean update) {
		this.update=update;
	}




	public LinkedList<Facultad> getAllFacultad() {
		try {
			if(update)
			{
				facultadlist =FacultadService.getFacultadService().FacultadSelectAllQuery();
				update=false;
			}
		} catch (Throwable e){ 
			e.printStackTrace();
		}		return facultadlist;
	}



	public String updateFacultad() {
		String result = "facultadlist";
		try {

			FacultadService.getFacultadService().UpdateFacultad(facultad);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


	public List<SelectItem> getFacultadItems() { 
		List<SelectItem> items = new ArrayList<SelectItem>();
		try {
			LinkedList<Facultad> listaselect=FacultadService.getFacultadService().FacultadSelectAllQuery();
			for(Facultad facultad:listaselect){
				items.add(new SelectItem(facultad.getIdfacultad(),facultad.getNombfacultad().toString())); 
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return items;
	}


	public Map<Facultad,Boolean> getselectid() {
		return selectid;
	}


	public void setselectid(Map<Facultad,Boolean> selectid) {
		this.selectid=selectid;
	}


	public String addFacultad() {
		String result = "facultadlist";
		try {

			FacultadService.getFacultadService().InsertFacultad(facultad);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


	public String deleteFacultad() {
		String result = "facultadlist";

		try {
			FacultadService.getFacultadService().DeleteFacultad(facultad);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}



	public String  delete() {
		String result = "facultadlist";
		try {
			Iterator<Entry<Facultad, Boolean>> a =selectid.entrySet().iterator();
			while (a.hasNext()) {
				Map.Entry<clases.Facultad, java.lang.Boolean> entry =  a.next();
				if (entry.getValue()==true) {
					FacultadService.getFacultadService().DeleteFacultad(entry.getKey());
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
