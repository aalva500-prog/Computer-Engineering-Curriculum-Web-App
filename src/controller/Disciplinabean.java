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

import services.DisciplinaService;
import clases.Disciplina;



public class Disciplinabean implements Serializable{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Disciplina disciplina= new Disciplina();
   private LinkedList<Disciplina> disciplinalist = new LinkedList<Disciplina>();
   private  Map<Disciplina,Boolean> selectid= new HashMap<Disciplina, Boolean>();
   private  Boolean update= true;


   public Disciplina getDisciplina() {
    return disciplina;
    }


   public  LinkedList<Disciplina> getDisciplinaList() {
    return disciplinalist;
    }


   public  Boolean  getUpdate() {
    return update;
    }




   public void setDisciplina(Disciplina  disciplina) {
    this.disciplina=disciplina;
    }


   public void setDisciplinalist(LinkedList<Disciplina>  disciplinalist) {
    this.disciplinalist=disciplinalist;
    }


   public void setUpdate(Boolean update) {
    this.update=update;
    }




  public LinkedList<Disciplina> getAllDisciplina() {
	 try {
			if(update)
				{
					disciplinalist =DisciplinaService.getDisciplinaService().DisciplinaSelectAllQuery();
					update=false;
				}
			} catch (Throwable e){ 
				e.printStackTrace();
		  }		return disciplinalist;
  }



  public String updateDisciplina() {
		String result = "disciplinalist";
		try {

			DisciplinaService.getDisciplinaService().UpdateDisciplina(disciplina);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


  public List<SelectItem> getDisciplinaItems() { 
    List<SelectItem> items = new ArrayList<SelectItem>();
   try {
       LinkedList<Disciplina> listaselect=DisciplinaService.getDisciplinaService().DisciplinaSelectAllQuery();
     for(Disciplina disciplina:listaselect){
      items.add(new SelectItem(disciplina.getCoddisciplina(),disciplina.getNombredisciplin().toString())); 
     }
  	 } catch (Throwable e) {
		// TODO Auto-generated catch block 
		e.printStackTrace();
	}
   return items;
 }


   public Map<Disciplina,Boolean> getselectid() {
    return selectid;
    }


   public void setselectid(Map<Disciplina,Boolean> selectid) {
    this.selectid=selectid;
    }


  public String addDisciplina() {
		String result = "disciplinalist";
		try {

			DisciplinaService.getDisciplinaService().InsertDisciplina(disciplina);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


  	public String deleteDisciplina() {
		String result = "disciplinalist";

		try {
			DisciplinaService.getDisciplinaService().DeleteDisciplina(disciplina);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
 		}
		return result;
	}



public String  delete() {
			String result = "disciplinalist";
			try {
				Iterator<Entry<Disciplina, Boolean>> a =selectid.entrySet().iterator();
				while (a.hasNext()) {
					Map.Entry<clases.Disciplina, java.lang.Boolean> entry =  a.next();
					if (entry.getValue()==true) {
						DisciplinaService.getDisciplinaService().DeleteDisciplina(entry.getKey());
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
