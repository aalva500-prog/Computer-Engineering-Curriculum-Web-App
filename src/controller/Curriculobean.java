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

import services.CurriculoService;
import clases.Curriculo;



public class Curriculobean implements Serializable{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Curriculo curriculo= new Curriculo();
   private LinkedList<Curriculo> curriculolist = new LinkedList<Curriculo>();
   private  Map<Curriculo,Boolean> selectid= new HashMap<Curriculo, Boolean>();
   private  Boolean update= true;


   public Curriculo getCurriculo() {
    return curriculo;
    }


   public  LinkedList<Curriculo> getCurriculoList() {
    return curriculolist;
    }


   public  Boolean  getUpdate() {
    return update;
    }




   public void setCurriculo(Curriculo  curriculo) {
    this.curriculo=curriculo;
    }


   public void setCurriculolist(LinkedList<Curriculo>  curriculolist) {
    this.curriculolist=curriculolist;
    }


   public void setUpdate(Boolean update) {
    this.update=update;
    }




  public LinkedList<Curriculo> getAllCurriculo() {
	 try {
			if(update)
				{
					curriculolist =CurriculoService.getCurriculoService().CurriculoSelectAllQuery();
					update=false;
				}
			} catch (Throwable e){ 
				e.printStackTrace();
		  }		return curriculolist;
  }



  public String updateCurriculo() {
		String result = "curriculolist";
		try {

			CurriculoService.getCurriculoService().UpdateCurriculo(curriculo);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


  public List<SelectItem> getCurriculoItems() { 
    List<SelectItem> items = new ArrayList<SelectItem>();
   try {
       LinkedList<Curriculo> listaselect=CurriculoService.getCurriculoService().CurriculoSelectAllQuery();
     for(Curriculo curriculo:listaselect){
      items.add(new SelectItem(curriculo.getCodcurriculo(),curriculo.getTipocurriculo().toString())); 
     }
  	 } catch (Throwable e) {
		// TODO Auto-generated catch block 
		e.printStackTrace();
	}
   return items;
 }


   public Map<Curriculo,Boolean> getselectid() {
    return selectid;
    }


   public void setselectid(Map<Curriculo,Boolean> selectid) {
    this.selectid=selectid;
    }


  public String addCurriculo() {
		String result = "curriculolist";
		try {

			CurriculoService.getCurriculoService().InsertCurriculo(curriculo);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


  	public String deleteCurriculo() {
		String result = "curriculolist";

		try {
			CurriculoService.getCurriculoService().DeleteCurriculo(curriculo);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
 		}
		return result;
	}



public String  delete() {
			String result = "curriculolist";
			try {
				Iterator<Entry<Curriculo, Boolean>> a =selectid.entrySet().iterator();
				while (a.hasNext()) {
					Map.Entry<clases.Curriculo, java.lang.Boolean> entry =  a.next();
					if (entry.getValue()==true) {
						CurriculoService.getCurriculoService().DeleteCurriculo(entry.getKey());
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
