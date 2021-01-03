 package services;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import query.UsuarioQuery;
import clases.Usuario;
import connection.PSQLConnection;




public class UsuarioService {
private static UsuarioService  usuarioservice=null;
private  UsuarioQuery  usuarioquery;


public static UsuarioService getUsuarioService(){
      if (usuarioservice==null) {
		  usuarioservice = new UsuarioService();
   	}
		return usuarioservice;
	}
public UsuarioService() {
       super();
// TODO Auto-generated constructor stub
}


public void InsertUsuario(Usuario usuario) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.usuario_insert(?,?,?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setString(1,usuario.getNombreus());
      MyCall.setString(2,usuario.getPassword());
      MyCall.setInt(3,usuario.getIdfacultad());
      MyCall.setInt(4,usuario.getCodrol());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdateUsuario(Usuario usuario) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.usuario_update(?,?,?,?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setString(1,usuario.getNombreus());
      MyCall.setString(2,usuario.getPassword());
      MyCall.setInt(3,usuario.getIdfacultad());
      MyCall.setInt(4,usuario.getCodrol());
      MyCall.setInt(5,usuario.getIdusuario());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void DeleteUsuario(Usuario usuario) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.usuario_delete(?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,usuario.getIdusuario());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void InsertUsuarioQuery(Usuario usuario) throws SQLException,ClassNotFoundException
{    
      
       String query =usuarioquery.Insert_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(query);	
      MyCall.setString(1,usuario.getNombreus());
      MyCall.setString(2,usuario.getPassword());
      MyCall.setInt(3,usuario.getIdfacultad());
      MyCall.setInt(4,usuario.getCodrol());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdateUsuarioQuery(Usuario usuario) throws SQLException,ClassNotFoundException
{    
      
      String call=usuarioquery.Update_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setString(1,usuario.getNombreus());
      MyCall.setString(2,usuario.getPassword());
      MyCall.setInt(3,usuario.getIdfacultad());
      MyCall.setInt(4,usuario.getCodrol());
      MyCall.setInt(5,usuario.getIdusuario());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }
public void DeleteUsuarioQuery(Usuario usuario) throws SQLException,ClassNotFoundException
{    
      
      String call=usuarioquery.Delete_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,usuario.getIdusuario());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public Usuario FindUsuarioByPKQuery(Usuario usuario) throws SQLException,ClassNotFoundException
{    
      
      String call=usuarioquery.usuario_idusuario_key;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,usuario.getIdusuario());
      usuario =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            usuario = new Usuario(rs.getString("nombreus"),rs.getString("password"),rs.getInt("idfacultad"),rs.getInt("codrol"),rs.getInt("idusuario"));
  }
      PSQLConnection.getConn().close();
    return usuario;
 }


public Usuario FindUsuarioByPK4(Usuario usuario) throws SQLException,ClassNotFoundException
{    
      
      String call=usuarioquery.PK4;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setString(1,usuario.getNombreus());
      usuario =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            usuario = new Usuario(rs.getString("nombreus"),rs.getString("password"),rs.getInt("idfacultad"),rs.getInt("codrol"),rs.getInt("idusuario"));
  }
      PSQLConnection.getConn().close();
    return usuario;
 }


public Usuario FindUsuarioByusuario_idusuario_key(Usuario usuario) throws SQLException,ClassNotFoundException
{    
      
      String call=usuarioquery.usuario_idusuario_key;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,usuario.getIdusuario());
      usuario =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            usuario = new Usuario(rs.getString("nombreus"),rs.getString("password"),rs.getInt("idfacultad"),rs.getInt("codrol"),rs.getInt("idusuario"));
  }
      PSQLConnection.getConn().close();
    return usuario;
 }




public LinkedList<Usuario> UsuarioSelectAllQuery() throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Usuario> usuarioList = new LinkedList<Usuario>();
     String call=usuarioquery.Select_All_Query;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
       rs=MyCall.executeQuery();
       while(rs.next())
     {
      Usuario  usuario = new Usuario(rs.getString("nombreus"),rs.getString("password"),rs.getInt("idfacultad"),rs.getInt("codrol"),rs.getInt("idusuario"));
      usuarioList.add(usuario);
  }
      PSQLConnection.getConn().close();
      return usuarioList;
 }


public LinkedList<Usuario> UsuarioSelectAllQueryBypassword(Usuario usuario) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Usuario> usuarioList = new LinkedList<Usuario>();
     String call=usuarioquery.selectbypassword;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setString(1,usuario.getPassword());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  usuario = new Usuario(rs.getString("nombreus"),rs.getString("password"),rs.getInt("idfacultad"),rs.getInt("codrol"),rs.getInt("idusuario"));
      usuarioList.add(usuario);
  }
      PSQLConnection.getConn().close();
      return usuarioList;
 }


public LinkedList<Usuario> UsuarioSelectAllQueryByidfacultad(Usuario usuario) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Usuario> usuarioList = new LinkedList<Usuario>();
     String call=usuarioquery.selectbyidfacultad;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setInt(1,usuario.getIdfacultad());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  usuario = new Usuario(rs.getString("nombreus"),rs.getString("password"),rs.getInt("idfacultad"),rs.getInt("codrol"),rs.getInt("idusuario"));
      usuarioList.add(usuario);
  }
      PSQLConnection.getConn().close();
      return usuarioList;
 }


public LinkedList<Usuario> UsuarioSelectAllQueryBycodrol(Usuario usuario) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Usuario> usuarioList = new LinkedList<Usuario>();
     String call=usuarioquery.selectbycodrol;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setInt(1,usuario.getCodrol());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  usuario = new Usuario(rs.getString("nombreus"),rs.getString("password"),rs.getInt("idfacultad"),rs.getInt("codrol"),rs.getInt("idusuario"));
      usuarioList.add(usuario);
  }
      PSQLConnection.getConn().close();
      return usuarioList;
 }


}
