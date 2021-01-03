 package services;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import query.DisciplinaQuery;
import clases.Disciplina;
import connection.PSQLConnection;




public class DisciplinaService {
private static DisciplinaService  disciplinaservice=null;
private  DisciplinaQuery  disciplinaquery;


public static DisciplinaService getDisciplinaService(){
      if (disciplinaservice==null) {
		  disciplinaservice = new DisciplinaService();
   	}
		return disciplinaservice;
	}
public DisciplinaService() {
       super();
// TODO Auto-generated constructor stub
}


public void InsertDisciplina(Disciplina disciplina) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.disciplina_insert(?,?,?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setString(1,disciplina.getNombredisciplin());
      MyCall.setString(2,disciplina.getJefedisciplin());
      MyCall.setInt(3,disciplina.getCanthorastotales());
      MyCall.setBoolean(4,disciplina.getCancelado());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdateDisciplina(Disciplina disciplina) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.disciplina_update(?,?,?,?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,disciplina.getCoddisciplina());
      MyCall.setString(2,disciplina.getNombredisciplin());
      MyCall.setString(3,disciplina.getJefedisciplin());
      MyCall.setInt(4,disciplina.getCanthorastotales());
      MyCall.setBoolean(5,disciplina.getCancelado());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void DeleteDisciplina(Disciplina disciplina) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.disciplina_delete(?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,disciplina.getCoddisciplina());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void InsertDisciplinaQuery(Disciplina disciplina) throws SQLException,ClassNotFoundException
{    
      
       String query =disciplinaquery.Insert_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(query);	
      MyCall.setString(1,disciplina.getNombredisciplin());
      MyCall.setString(2,disciplina.getJefedisciplin());
      MyCall.setInt(3,disciplina.getCanthorastotales());
      MyCall.setBoolean(4,disciplina.getCancelado());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdateDisciplinaQuery(Disciplina disciplina) throws SQLException,ClassNotFoundException
{    
      
      String call=disciplinaquery.Update_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,disciplina.getCoddisciplina());
      MyCall.setString(2,disciplina.getNombredisciplin());
      MyCall.setString(3,disciplina.getJefedisciplin());
      MyCall.setInt(4,disciplina.getCanthorastotales());
      MyCall.setBoolean(5,disciplina.getCancelado());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }
public void DeleteDisciplinaQuery(Disciplina disciplina) throws SQLException,ClassNotFoundException
{    
      
      String call=disciplinaquery.Delete_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,disciplina.getCoddisciplina());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public Disciplina FindDisciplinaByPKQuery(Disciplina disciplina) throws SQLException,ClassNotFoundException
{    
      
      String call=disciplinaquery.PK6;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,disciplina.getCoddisciplina());
      disciplina =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            disciplina = new Disciplina(rs.getInt("coddisciplina"),rs.getString("nombredisciplin"),rs.getString("jefedisciplin"),rs.getInt("canthorastotales"),rs.getBoolean("cancelado"));
  }
      PSQLConnection.getConn().close();
    return disciplina;
 }


public Disciplina FindDisciplinaByPK6(Disciplina disciplina) throws SQLException,ClassNotFoundException
{    
      
      String call=disciplinaquery.PK6;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,disciplina.getCoddisciplina());
      disciplina =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            disciplina = new Disciplina(rs.getInt("coddisciplina"),rs.getString("nombredisciplin"),rs.getString("jefedisciplin"),rs.getInt("canthorastotales"),rs.getBoolean("cancelado"));
  }
      PSQLConnection.getConn().close();
    return disciplina;
 }


public Disciplina FindDisciplinaBydisciplina_nombredisciplin_key(Disciplina disciplina) throws SQLException,ClassNotFoundException
{    
      
      String call=disciplinaquery.disciplina_nombredisciplin_key;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setString(1,disciplina.getNombredisciplin());
      disciplina =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            disciplina = new Disciplina(rs.getInt("coddisciplina"),rs.getString("nombredisciplin"),rs.getString("jefedisciplin"),rs.getInt("canthorastotales"),rs.getBoolean("cancelado"));
  }
      PSQLConnection.getConn().close();
    return disciplina;
 }




public LinkedList<Disciplina> DisciplinaSelectAllQuery() throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Disciplina> disciplinaList = new LinkedList<Disciplina>();
     String call=disciplinaquery.Select_All_Query;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
       rs=MyCall.executeQuery();
       while(rs.next())
     {
      Disciplina  disciplina = new Disciplina(rs.getInt("coddisciplina"),rs.getString("nombredisciplin"),rs.getString("jefedisciplin"),rs.getInt("canthorastotales"),rs.getBoolean("cancelado"));
      disciplinaList.add(disciplina);
  }
      PSQLConnection.getConn().close();
      return disciplinaList;
 }


public LinkedList<Disciplina> DisciplinaSelectAllQueryByjefedisciplin(Disciplina disciplina) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Disciplina> disciplinaList = new LinkedList<Disciplina>();
     String call=disciplinaquery.selectbyjefedisciplin;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setString(1,disciplina.getJefedisciplin());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  disciplina = new Disciplina(rs.getInt("coddisciplina"),rs.getString("nombredisciplin"),rs.getString("jefedisciplin"),rs.getInt("canthorastotales"),rs.getBoolean("cancelado"));
      disciplinaList.add(disciplina);
  }
      PSQLConnection.getConn().close();
      return disciplinaList;
 }


public LinkedList<Disciplina> DisciplinaSelectAllQueryBycanthorastotales(Disciplina disciplina) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Disciplina> disciplinaList = new LinkedList<Disciplina>();
     String call=disciplinaquery.selectbycanthorastotales;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setInt(1,disciplina.getCanthorastotales());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  disciplina = new Disciplina(rs.getInt("coddisciplina"),rs.getString("nombredisciplin"),rs.getString("jefedisciplin"),rs.getInt("canthorastotales"),rs.getBoolean("cancelado"));
      disciplinaList.add(disciplina);
  }
      PSQLConnection.getConn().close();
      return disciplinaList;
 }


public LinkedList<Disciplina> DisciplinaSelectAllQueryBycancelado(Disciplina disciplina) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Disciplina> disciplinaList = new LinkedList<Disciplina>();
     String call=disciplinaquery.selectbycancelado;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setBoolean(1,disciplina.getCancelado());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  disciplina = new Disciplina(rs.getInt("coddisciplina"),rs.getString("nombredisciplin"),rs.getString("jefedisciplin"),rs.getInt("canthorastotales"),rs.getBoolean("cancelado"));
      disciplinaList.add(disciplina);
  }
      PSQLConnection.getConn().close();
      return disciplinaList;
 }


}
