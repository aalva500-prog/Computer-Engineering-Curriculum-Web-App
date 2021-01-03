 package services;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import query.EvaluacionQuery;
import clases.Evaluacion;
import connection.PSQLConnection;




public class EvaluacionService {
private static EvaluacionService  evaluacionservice=null;
private  EvaluacionQuery  evaluacionquery;


public static EvaluacionService getEvaluacionService(){
      if (evaluacionservice==null) {
		  evaluacionservice = new EvaluacionService();
   	}
		return evaluacionservice;
	}
public EvaluacionService() {
       super();
// TODO Auto-generated constructor stub
}


public void InsertEvaluacion(Evaluacion evaluacion) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.evaluacion_insert(?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setString(1,evaluacion.getTipoevaluacion());
      MyCall.setBoolean(2,evaluacion.getCancelado());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdateEvaluacion(Evaluacion evaluacion) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.evaluacion_update(?,?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,evaluacion.getCodevaluacion());
      MyCall.setString(2,evaluacion.getTipoevaluacion());
      MyCall.setBoolean(3,evaluacion.getCancelado());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void DeleteEvaluacion(Evaluacion evaluacion) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.evaluacion_delete(?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,evaluacion.getCodevaluacion());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void InsertEvaluacionQuery(Evaluacion evaluacion) throws SQLException,ClassNotFoundException
{    
      
       String query =evaluacionquery.Insert_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(query);	
      MyCall.setString(1,evaluacion.getTipoevaluacion());
      MyCall.setBoolean(2,evaluacion.getCancelado());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdateEvaluacionQuery(Evaluacion evaluacion) throws SQLException,ClassNotFoundException
{    
      
      String call=evaluacionquery.Update_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,evaluacion.getCodevaluacion());
      MyCall.setString(2,evaluacion.getTipoevaluacion());
      MyCall.setBoolean(3,evaluacion.getCancelado());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }
public void DeleteEvaluacionQuery(Evaluacion evaluacion) throws SQLException,ClassNotFoundException
{    
      
      String call=evaluacionquery.Delete_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,evaluacion.getCodevaluacion());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public Evaluacion FindEvaluacionByPKQuery(Evaluacion evaluacion) throws SQLException,ClassNotFoundException
{    
      
      String call=evaluacionquery.PK10;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,evaluacion.getCodevaluacion());
      evaluacion =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            evaluacion = new Evaluacion(rs.getInt("codevaluacion"),rs.getString("tipoevaluacion"),rs.getBoolean("cancelado"));
  }
      PSQLConnection.getConn().close();
    return evaluacion;
 }


public Evaluacion FindEvaluacionByPK10(Evaluacion evaluacion) throws SQLException,ClassNotFoundException
{    
      
      String call=evaluacionquery.PK10;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,evaluacion.getCodevaluacion());
      evaluacion =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            evaluacion = new Evaluacion(rs.getInt("codevaluacion"),rs.getString("tipoevaluacion"),rs.getBoolean("cancelado"));
  }
      PSQLConnection.getConn().close();
    return evaluacion;
 }




public LinkedList<Evaluacion> EvaluacionSelectAllQuery() throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Evaluacion> evaluacionList = new LinkedList<Evaluacion>();
     String call=evaluacionquery.Select_All_Query;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
       rs=MyCall.executeQuery();
       while(rs.next())
     {
      Evaluacion  evaluacion = new Evaluacion(rs.getInt("codevaluacion"),rs.getString("tipoevaluacion"),rs.getBoolean("cancelado"));
      evaluacionList.add(evaluacion);
  }
      PSQLConnection.getConn().close();
      return evaluacionList;
 }


public LinkedList<Evaluacion> EvaluacionSelectAllQueryBytipoevaluacion(Evaluacion evaluacion) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Evaluacion> evaluacionList = new LinkedList<Evaluacion>();
     String call=evaluacionquery.selectbytipoevaluacion;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setString(1,evaluacion.getTipoevaluacion());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  evaluacion = new Evaluacion(rs.getInt("codevaluacion"),rs.getString("tipoevaluacion"),rs.getBoolean("cancelado"));
      evaluacionList.add(evaluacion);
  }
      PSQLConnection.getConn().close();
      return evaluacionList;
 }


public LinkedList<Evaluacion> EvaluacionSelectAllQueryBycancelado(Evaluacion evaluacion) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Evaluacion> evaluacionList = new LinkedList<Evaluacion>();
     String call=evaluacionquery.selectbycancelado;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setBoolean(1,evaluacion.getCancelado());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  evaluacion = new Evaluacion(rs.getInt("codevaluacion"),rs.getString("tipoevaluacion"),rs.getBoolean("cancelado"));
      evaluacionList.add(evaluacion);
  }
      PSQLConnection.getConn().close();
      return evaluacionList;
 }


}
