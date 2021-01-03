 package services;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import query.FacultadQuery;
import clases.Facultad;
import connection.PSQLConnection;




public class FacultadService {
private static FacultadService  facultadservice=null;
private  FacultadQuery  facultadquery;


public static FacultadService getFacultadService(){
      if (facultadservice==null) {
		  facultadservice = new FacultadService();
   	}
		return facultadservice;
	}
public FacultadService() {
       super();
// TODO Auto-generated constructor stub
}


public void InsertFacultad(Facultad facultad) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.facultad_insert(?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setString(1,facultad.getNombdecano());
      MyCall.setString(2,facultad.getNombfacultad());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdateFacultad(Facultad facultad) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.facultad_update(?,?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,facultad.getIdfacultad());
      MyCall.setString(2,facultad.getNombdecano());
      MyCall.setString(3,facultad.getNombfacultad());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void DeleteFacultad(Facultad facultad) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.facultad_delete(?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,facultad.getIdfacultad());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void InsertFacultadQuery(Facultad facultad) throws SQLException,ClassNotFoundException
{    
      
       String query =facultadquery.Insert_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(query);	
      MyCall.setString(1,facultad.getNombdecano());
      MyCall.setString(2,facultad.getNombfacultad());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdateFacultadQuery(Facultad facultad) throws SQLException,ClassNotFoundException
{    
      
      String call=facultadquery.Update_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,facultad.getIdfacultad());
      MyCall.setString(2,facultad.getNombdecano());
      MyCall.setString(3,facultad.getNombfacultad());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }
public void DeleteFacultadQuery(Facultad facultad) throws SQLException,ClassNotFoundException
{    
      
      String call=facultadquery.Delete_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,facultad.getIdfacultad());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public Facultad FindFacultadByPKQuery(Facultad facultad) throws SQLException,ClassNotFoundException
{    
      
      String call=facultadquery.PK1;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,facultad.getIdfacultad());
      facultad =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            facultad = new Facultad(rs.getInt("idfacultad"),rs.getString("nombdecano"),rs.getString("nombfacultad"));
  }
      PSQLConnection.getConn().close();
    return facultad;
 }


public Facultad FindFacultadByPK1(Facultad facultad) throws SQLException,ClassNotFoundException
{    
      
      String call=facultadquery.PK1;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,facultad.getIdfacultad());
      facultad =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            facultad = new Facultad(rs.getInt("idfacultad"),rs.getString("nombdecano"),rs.getString("nombfacultad"));
  }
      PSQLConnection.getConn().close();
    return facultad;
 }


public Facultad FindFacultadByfacultad_nombfacultad_key(Facultad facultad) throws SQLException,ClassNotFoundException
{    
      
      String call=facultadquery.facultad_nombfacultad_key;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setString(1,facultad.getNombfacultad());
      facultad =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            facultad = new Facultad(rs.getInt("idfacultad"),rs.getString("nombdecano"),rs.getString("nombfacultad"));
  }
      PSQLConnection.getConn().close();
    return facultad;
 }




public LinkedList<Facultad> FacultadSelectAllQuery() throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Facultad> facultadList = new LinkedList<Facultad>();
     String call=facultadquery.Select_All_Query;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
       rs=MyCall.executeQuery();
       while(rs.next())
     {
      Facultad  facultad = new Facultad(rs.getInt("idfacultad"),rs.getString("nombdecano"),rs.getString("nombfacultad"));
      facultadList.add(facultad);
  }
      PSQLConnection.getConn().close();
      return facultadList;
 }


public LinkedList<Facultad> FacultadSelectAllQueryBynombdecano(Facultad facultad) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Facultad> facultadList = new LinkedList<Facultad>();
     String call=facultadquery.selectbynombdecano;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setString(1,facultad.getNombdecano());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  facultad = new Facultad(rs.getInt("idfacultad"),rs.getString("nombdecano"),rs.getString("nombfacultad"));
      facultadList.add(facultad);
  }
      PSQLConnection.getConn().close();
      return facultadList;
 }


}
