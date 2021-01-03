 package services;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import query.RolQuery;
import clases.Rol;
import connection.PSQLConnection;




public class RolService {
private static RolService  rolservice=null;
private  RolQuery  rolquery;


public static RolService getRolService(){
      if (rolservice==null) {
		  rolservice = new RolService();
   	}
		return rolservice;
	}
public RolService() {
       super();
// TODO Auto-generated constructor stub
}


public void InsertRol(Rol rol) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.rol_insert(?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setString(1,rol.getTiporol());
      MyCall.setBoolean(2,rol.getCancelado());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdateRol(Rol rol) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.rol_update(?,?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,rol.getCodrol());
      MyCall.setString(2,rol.getTiporol());
      MyCall.setBoolean(3,rol.getCancelado());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void DeleteRol(Rol rol) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.rol_delete(?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,rol.getCodrol());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void InsertRolQuery(Rol rol) throws SQLException,ClassNotFoundException
{    
      
       String query =rolquery.Insert_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(query);	
      MyCall.setString(1,rol.getTiporol());
      MyCall.setBoolean(2,rol.getCancelado());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdateRolQuery(Rol rol) throws SQLException,ClassNotFoundException
{    
      
      String call=rolquery.Update_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,rol.getCodrol());
      MyCall.setString(2,rol.getTiporol());
      MyCall.setBoolean(3,rol.getCancelado());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }
public void DeleteRolQuery(Rol rol) throws SQLException,ClassNotFoundException
{    
      
      String call=rolquery.Delete_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,rol.getCodrol());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public Rol FindRolByPKQuery(Rol rol) throws SQLException,ClassNotFoundException
{    
      
      String call=rolquery.PK7;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,rol.getCodrol());
      rol =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            rol = new Rol(rs.getInt("codrol"),rs.getString("tiporol"),rs.getBoolean("cancelado"));
  }
      PSQLConnection.getConn().close();
    return rol;
 }


public Rol FindRolByPK7(Rol rol) throws SQLException,ClassNotFoundException
{    
      
      String call=rolquery.PK7;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,rol.getCodrol());
      rol =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            rol = new Rol(rs.getInt("codrol"),rs.getString("tiporol"),rs.getBoolean("cancelado"));
  }
      PSQLConnection.getConn().close();
    return rol;
 }


public Rol FindRolByrol_tiporol_key(Rol rol) throws SQLException,ClassNotFoundException
{    
      
      String call=rolquery.rol_tiporol_key;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setString(1,rol.getTiporol());
      rol =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            rol = new Rol(rs.getInt("codrol"),rs.getString("tiporol"),rs.getBoolean("cancelado"));
  }
      PSQLConnection.getConn().close();
    return rol;
 }




public LinkedList<Rol> RolSelectAllQuery() throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Rol> rolList = new LinkedList<Rol>();
     String call=rolquery.Select_All_Query;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
       rs=MyCall.executeQuery();
       while(rs.next())
     {
      Rol  rol = new Rol(rs.getInt("codrol"),rs.getString("tiporol"),rs.getBoolean("cancelado"));
      rolList.add(rol);
  }
      PSQLConnection.getConn().close();
      return rolList;
 }


public LinkedList<Rol> RolSelectAllQueryBycancelado(Rol rol) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Rol> rolList = new LinkedList<Rol>();
     String call=rolquery.selectbycancelado;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setBoolean(1,rol.getCancelado());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  rol = new Rol(rs.getInt("codrol"),rs.getString("tiporol"),rs.getBoolean("cancelado"));
      rolList.add(rol);
  }
      PSQLConnection.getConn().close();
      return rolList;
 }


}
