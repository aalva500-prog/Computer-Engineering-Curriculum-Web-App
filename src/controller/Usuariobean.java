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

import services.UsuarioService;
import clases.Facultad;
import clases.Rol;
import clases.Usuario;



public class Usuariobean implements Serializable{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Usuario usuario= new Usuario();
   private LinkedList<Usuario> usuariolist = new LinkedList<Usuario>();
   private  Map<Usuario,Boolean> selectid= new HashMap<Usuario, Boolean>();
   private  Boolean update= true;
   private Facultad facultad= new Facultad();
   private Rol rol= new Rol();


   public Usuario getUsuario() {
    return usuario;
    }


   public  LinkedList<Usuario> getUsuarioList() {
    return usuariolist;
    }


   public  Boolean  getUpdate() {
    return update;
    }


   public Facultad getFacultad() {
    return facultad;
    }
   public Rol getRol() {
    return rol;
    }


   public void setUsuario(Usuario  usuario) {
    this.usuario=usuario;
    }


   public void setUsuariolist(LinkedList<Usuario>  usuariolist) {
    this.usuariolist=usuariolist;
    }


   public void setUpdate(Boolean update) {
    this.update=update;
    }


   public void setFacultad(Facultad  facultad) {
    this.facultad=facultad;
    }
   public void setRol(Rol  rol) {
    this.rol=rol;
    }


  public LinkedList<Usuario> getAllUsuario() {
	 try {
			if(update)
				{
					usuariolist =UsuarioService.getUsuarioService().UsuarioSelectAllQuery();
					update=false;
				}
			} catch (Throwable e){ 
				e.printStackTrace();
		  }		return usuariolist;
  }



  public String updateUsuario() {
		String result = "usuariolist";
		try {

			UsuarioService.getUsuarioService().UpdateUsuario(usuario);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


  public List<SelectItem> getUsuarioItems() { 
    List<SelectItem> items = new ArrayList<SelectItem>();
   try {
       LinkedList<Usuario> listaselect=UsuarioService.getUsuarioService().UsuarioSelectAllQuery();
     for(Usuario usuario:listaselect){
      items.add(new SelectItem(usuario.getIdusuario(),usuario.getIdusuario().toString())); 
     }
  	 } catch (Throwable e) {
		// TODO Auto-generated catch block 
		e.printStackTrace();
	}
   return items;
 }


   public Map<Usuario,Boolean> getselectid() {
    return selectid;
    }


   public void setselectid(Map<Usuario,Boolean> selectid) {
    this.selectid=selectid;
    }


  public String addUsuario() {
		String result = "usuariolist";
		try {

			UsuarioService.getUsuarioService().InsertUsuario(usuario);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}


  	public String deleteUsuario() {
		String result = "usuariolist";

		try {
			UsuarioService.getUsuarioService().DeleteUsuario(usuario);
			update=true;
		} catch (Throwable e) {
			e.printStackTrace();
			result = "failure";
 		}
		return result;
	}



public String  delete() {
			String result = "usuariolist";
			try {
				Iterator<Entry<Usuario, Boolean>> a =selectid.entrySet().iterator();
				while (a.hasNext()) {
					Map.Entry<clases.Usuario, java.lang.Boolean> entry =  a.next();
					if (entry.getValue()==true) {
						UsuarioService.getUsuarioService().DeleteUsuario(entry.getKey());
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
