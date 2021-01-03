 package services;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import query.CarreraQuery;
import clases.Carrera;
import connection.PSQLConnection;




public class CarreraService {
private static CarreraService  carreraservice=null;
private  CarreraQuery  carreraquery;


public static CarreraService getCarreraService(){
      if (carreraservice==null) {
		  carreraservice = new CarreraService();
   	}
		return carreraservice;
	}
public CarreraService() {
       super();
// TODO Auto-generated constructor stub
}


public void InsertCarrera(Carrera carrera) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.carrera_insert(?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setString(1,carrera.getNombcarrera());
      MyCall.setInt(2,carrera.getIdfacultad());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdateCarrera(Carrera carrera) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.carrera_update(?,?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,carrera.getCodcarrera());
      MyCall.setString(2,carrera.getNombcarrera());
      MyCall.setInt(3,carrera.getIdfacultad());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void DeleteCarrera(Carrera carrera) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.carrera_delete(?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,carrera.getCodcarrera());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void InsertCarreraQuery(Carrera carrera) throws SQLException,ClassNotFoundException
{    
      
       String query =carreraquery.Insert_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(query);	
      MyCall.setString(1,carrera.getNombcarrera());
      MyCall.setInt(2,carrera.getIdfacultad());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdateCarreraQuery(Carrera carrera) throws SQLException,ClassNotFoundException
{    
      
      String call=carreraquery.Update_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,carrera.getCodcarrera());
      MyCall.setString(2,carrera.getNombcarrera());
      MyCall.setInt(3,carrera.getIdfacultad());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }
public void DeleteCarreraQuery(Carrera carrera) throws SQLException,ClassNotFoundException
{    
      
      String call=carreraquery.Delete_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,carrera.getCodcarrera());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public Carrera FindCarreraByPKQuery(Carrera carrera) throws SQLException,ClassNotFoundException
{    
      
      String call=carreraquery.PK2;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,carrera.getCodcarrera());
      carrera =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            carrera = new Carrera(rs.getInt("codcarrera"),rs.getString("nombcarrera"),rs.getInt("idfacultad"));
  }
      PSQLConnection.getConn().close();
    return carrera;
 }


public Carrera FindCarreraByPK2(Carrera carrera) throws SQLException,ClassNotFoundException
{    
      
      String call=carreraquery.PK2;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,carrera.getCodcarrera());
      carrera =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            carrera = new Carrera(rs.getInt("codcarrera"),rs.getString("nombcarrera"),rs.getInt("idfacultad"));
  }
      PSQLConnection.getConn().close();
    return carrera;
 }


public Carrera FindCarreraBycarrera_nombcarrera_key(Carrera carrera) throws SQLException,ClassNotFoundException
{    
      
      String call=carreraquery.carrera_nombcarrera_key;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setString(1,carrera.getNombcarrera());
      carrera =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            carrera = new Carrera(rs.getInt("codcarrera"),rs.getString("nombcarrera"),rs.getInt("idfacultad"));
  }
      PSQLConnection.getConn().close();
    return carrera;
 }




public LinkedList<Carrera> CarreraSelectAllQuery() throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Carrera> carreraList = new LinkedList<Carrera>();
     String call=carreraquery.Select_All_Query;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
       rs=MyCall.executeQuery();
       while(rs.next())
     {
      Carrera  carrera = new Carrera(rs.getInt("codcarrera"),rs.getString("nombcarrera"),rs.getInt("idfacultad"));
      carreraList.add(carrera);
  }
      PSQLConnection.getConn().close();
      return carreraList;
 }


public LinkedList<Carrera> CarreraSelectAllQueryByidfacultad(Carrera carrera) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Carrera> carreraList = new LinkedList<Carrera>();
     String call=carreraquery.selectbyidfacultad;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setInt(1,carrera.getIdfacultad());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  carrera = new Carrera(rs.getInt("codcarrera"),rs.getString("nombcarrera"),rs.getInt("idfacultad"));
      carreraList.add(carrera);
  }
      PSQLConnection.getConn().close();
      return carreraList;
 }


}
