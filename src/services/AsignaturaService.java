 package services;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import query.AsignaturaQuery;
import clases.Asignatura;
import connection.PSQLConnection;




public class AsignaturaService {
private static AsignaturaService  asignaturaservice=null;
private  AsignaturaQuery  asignaturaquery;


public static AsignaturaService getAsignaturaService(){
      if (asignaturaservice==null) {
		  asignaturaservice = new AsignaturaService();
   	}
		return asignaturaservice;
	}
public AsignaturaService() {
       super();
// TODO Auto-generated constructor stub
}


public void InsertAsignatura(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.asignatura_insert(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setString(1,asignatura.getNombreasig());
      MyCall.setString(2,asignatura.getJefeasig());
      MyCall.setInt(3,asignatura.getCanthoras());
      MyCall.setInt(4,asignatura.getAnno());
      MyCall.setInt(5,asignatura.getPeriodo());
      MyCall.setString(6,asignatura.getPlanmetodologico());
      MyCall.setString(7,asignatura.getProgramanalitico());
      MyCall.setString(8,asignatura.getSecactividad());
      MyCall.setInt(9,asignatura.getCodevaluacion());
      MyCall.setInt(10,asignatura.getCodplanest());
      MyCall.setInt(11,asignatura.getCodasigpre());
      MyCall.setInt(12,asignatura.getCoddisciplina());
      MyCall.setInt(13,asignatura.getCodcurriculo());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdateAsignatura(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.asignatura_update(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,asignatura.getCodasig());
      MyCall.setString(2,asignatura.getNombreasig());
      MyCall.setString(3,asignatura.getJefeasig());
      MyCall.setInt(4,asignatura.getCanthoras());
      MyCall.setInt(5,asignatura.getAnno());
      MyCall.setInt(6,asignatura.getPeriodo());
      MyCall.setString(7,asignatura.getPlanmetodologico());
      MyCall.setString(8,asignatura.getProgramanalitico());
      MyCall.setString(9,asignatura.getSecactividad());
      MyCall.setInt(10,asignatura.getCodevaluacion());
      MyCall.setInt(11,asignatura.getCodplanest());
      MyCall.setInt(12,asignatura.getCodasigpre());
      MyCall.setInt(13,asignatura.getCoddisciplina());
      MyCall.setInt(14,asignatura.getCodcurriculo());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void DeleteAsignatura(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.asignatura_delete(?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,asignatura.getCodasig());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void InsertAsignaturaQuery(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
      
       String query =asignaturaquery.Insert_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(query);	
      MyCall.setString(1,asignatura.getNombreasig());
      MyCall.setString(2,asignatura.getJefeasig());
      MyCall.setInt(3,asignatura.getCanthoras());
      MyCall.setInt(4,asignatura.getAnno());
      MyCall.setInt(5,asignatura.getPeriodo());
      MyCall.setString(6,asignatura.getPlanmetodologico());
      MyCall.setString(7,asignatura.getProgramanalitico());
      MyCall.setString(8,asignatura.getSecactividad());
      MyCall.setInt(9,asignatura.getCodevaluacion());
      MyCall.setInt(10,asignatura.getCodplanest());
      MyCall.setInt(11,asignatura.getCodasigpre());
      MyCall.setInt(12,asignatura.getCoddisciplina());
      MyCall.setInt(13,asignatura.getCodcurriculo());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdateAsignaturaQuery(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
      
      String call=asignaturaquery.Update_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,asignatura.getCodasig());
      MyCall.setString(2,asignatura.getNombreasig());
      MyCall.setString(3,asignatura.getJefeasig());
      MyCall.setInt(4,asignatura.getCanthoras());
      MyCall.setInt(5,asignatura.getAnno());
      MyCall.setInt(6,asignatura.getPeriodo());
      MyCall.setString(7,asignatura.getPlanmetodologico());
      MyCall.setString(8,asignatura.getProgramanalitico());
      MyCall.setString(9,asignatura.getSecactividad());
      MyCall.setInt(10,asignatura.getCodevaluacion());
      MyCall.setInt(11,asignatura.getCodplanest());
      MyCall.setInt(12,asignatura.getCodasigpre());
      MyCall.setInt(13,asignatura.getCoddisciplina());
      MyCall.setInt(14,asignatura.getCodcurriculo());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }



public void DeleteAsignaturaQuery(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
      
      String call=asignaturaquery.Delete_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,asignatura.getCodasig());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public Asignatura FindAsignaturaByPKQuery(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
      
      String call=asignaturaquery.PK5;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,asignatura.getCodasig());
      asignatura =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            asignatura = new Asignatura(rs.getInt("codasig"),rs.getString("nombreasig"),rs.getString("jefeasig"),rs.getInt("canthoras"),rs.getInt("anno"),rs.getInt("periodo"),rs.getString("planmetodologico"),rs.getString("programanalitico"),rs.getString("secactividad"),rs.getInt("codevaluacion"),rs.getInt("codplanest"),rs.getInt("codasigpre"),rs.getInt("coddisciplina"),rs.getInt("codcurriculo"));
  }
      PSQLConnection.getConn().close();
    return asignatura;
 }


public Asignatura FindAsignaturaByPK5(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
      
      String call=asignaturaquery.PK5;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,asignatura.getCodasig());
      asignatura =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            asignatura = new Asignatura(rs.getInt("codasig"),rs.getString("nombreasig"),rs.getString("jefeasig"),rs.getInt("canthoras"),rs.getInt("anno"),rs.getInt("periodo"),rs.getString("planmetodologico"),rs.getString("programanalitico"),rs.getString("secactividad"),rs.getInt("codevaluacion"),rs.getInt("codplanest"),rs.getInt("codasigpre"),rs.getInt("coddisciplina"),rs.getInt("codcurriculo"));
  }
      PSQLConnection.getConn().close();
    return asignatura;
 }


public Asignatura FindAsignaturaByasignatura_nombreasig_key(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
      
      String call=asignaturaquery.asignatura_nombreasig_key;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setString(1,asignatura.getNombreasig());
      asignatura =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            asignatura = new Asignatura(rs.getInt("codasig"),rs.getString("nombreasig"),rs.getString("jefeasig"),rs.getInt("canthoras"),rs.getInt("anno"),rs.getInt("periodo"),rs.getString("planmetodologico"),rs.getString("programanalitico"),rs.getString("secactividad"),rs.getInt("codevaluacion"),rs.getInt("codplanest"),rs.getInt("codasigpre"),rs.getInt("coddisciplina"),rs.getInt("codcurriculo"));
  }
      PSQLConnection.getConn().close();
    return asignatura;
 }




public LinkedList<Asignatura> AsignaturaSelectAllQuery() throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Asignatura> asignaturaList = new LinkedList<Asignatura>();
     String call=asignaturaquery.Select_All_Query;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
       rs=MyCall.executeQuery();
       while(rs.next())
     {
      Asignatura  asignatura = new Asignatura(rs.getInt("codasig"),rs.getString("nombreasig"),rs.getString("jefeasig"),rs.getInt("canthoras"),rs.getInt("anno"),rs.getInt("periodo"),rs.getString("planmetodologico"),rs.getString("programanalitico"),rs.getString("secactividad"),rs.getInt("codevaluacion"),rs.getInt("codplanest"),rs.getInt("codasigpre"),rs.getInt("coddisciplina"),rs.getInt("codcurriculo"));
      asignaturaList.add(asignatura);
  }
      PSQLConnection.getConn().close();
      return asignaturaList;
 }


public LinkedList<Asignatura> AsignaturaSelectAllQueryByjefeasig(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Asignatura> asignaturaList = new LinkedList<Asignatura>();
     String call=asignaturaquery.selectbyjefeasig;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setString(1,asignatura.getJefeasig());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  asignatura = new Asignatura(rs.getInt("codasig"),rs.getString("nombreasig"),rs.getString("jefeasig"),rs.getInt("canthoras"),rs.getInt("anno"),rs.getInt("periodo"),rs.getString("planmetodologico"),rs.getString("programanalitico"),rs.getString("secactividad"),rs.getInt("codevaluacion"),rs.getInt("codplanest"),rs.getInt("codasigpre"),rs.getInt("coddisciplina"),rs.getInt("codcurriculo"));
      asignaturaList.add(asignatura);
  }
      PSQLConnection.getConn().close();
      return asignaturaList;
 }


public LinkedList<Asignatura> AsignaturaSelectAllQueryBycanthoras(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Asignatura> asignaturaList = new LinkedList<Asignatura>();
     String call=asignaturaquery.selectbycanthoras;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setInt(1,asignatura.getCanthoras());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  asignatura = new Asignatura(rs.getInt("codasig"),rs.getString("nombreasig"),rs.getString("jefeasig"),rs.getInt("canthoras"),rs.getInt("anno"),rs.getInt("periodo"),rs.getString("planmetodologico"),rs.getString("programanalitico"),rs.getString("secactividad"),rs.getInt("codevaluacion"),rs.getInt("codplanest"),rs.getInt("codasigpre"),rs.getInt("coddisciplina"),rs.getInt("codcurriculo"));
      asignaturaList.add(asignatura);
  }
      PSQLConnection.getConn().close();
      return asignaturaList;
 }


public LinkedList<Asignatura> AsignaturaSelectAllQueryByanno(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Asignatura> asignaturaList = new LinkedList<Asignatura>();
     String call=asignaturaquery.selectbyanno;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setInt(1,asignatura.getAnno());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  asignatura = new Asignatura(rs.getInt("codasig"),rs.getString("nombreasig"),rs.getString("jefeasig"),rs.getInt("canthoras"),rs.getInt("anno"),rs.getInt("periodo"),rs.getString("planmetodologico"),rs.getString("programanalitico"),rs.getString("secactividad"),rs.getInt("codevaluacion"),rs.getInt("codplanest"),rs.getInt("codasigpre"),rs.getInt("coddisciplina"),rs.getInt("codcurriculo"));
      asignaturaList.add(asignatura);
  }
      PSQLConnection.getConn().close();
      return asignaturaList;
 }


public LinkedList<Asignatura> AsignaturaSelectAllQueryByperiodo(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Asignatura> asignaturaList = new LinkedList<Asignatura>();
     String call=asignaturaquery.selectbyperiodo;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setInt(1,asignatura.getPeriodo());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  asignatura = new Asignatura(rs.getInt("codasig"),rs.getString("nombreasig"),rs.getString("jefeasig"),rs.getInt("canthoras"),rs.getInt("anno"),rs.getInt("periodo"),rs.getString("planmetodologico"),rs.getString("programanalitico"),rs.getString("secactividad"),rs.getInt("codevaluacion"),rs.getInt("codplanest"),rs.getInt("codasigpre"),rs.getInt("coddisciplina"),rs.getInt("codcurriculo"));
      asignaturaList.add(asignatura);
  }
      PSQLConnection.getConn().close();
      return asignaturaList;
 }


public LinkedList<Asignatura> AsignaturaSelectAllQueryByplanmetodologico(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Asignatura> asignaturaList = new LinkedList<Asignatura>();
     String call=asignaturaquery.selectbyplanmetodologico;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setString(1,asignatura.getPlanmetodologico());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  asignatura = new Asignatura(rs.getInt("codasig"),rs.getString("nombreasig"),rs.getString("jefeasig"),rs.getInt("canthoras"),rs.getInt("anno"),rs.getInt("periodo"),rs.getString("planmetodologico"),rs.getString("programanalitico"),rs.getString("secactividad"),rs.getInt("codevaluacion"),rs.getInt("codplanest"),rs.getInt("codasigpre"),rs.getInt("coddisciplina"),rs.getInt("codcurriculo"));
      asignaturaList.add(asignatura);
  }
      PSQLConnection.getConn().close();
      return asignaturaList;
 }


public LinkedList<Asignatura> AsignaturaSelectAllQueryByprogramanalitico(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Asignatura> asignaturaList = new LinkedList<Asignatura>();
     String call=asignaturaquery.selectbyprogramanalitico;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setString(1,asignatura.getProgramanalitico());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  asignatura = new Asignatura(rs.getInt("codasig"),rs.getString("nombreasig"),rs.getString("jefeasig"),rs.getInt("canthoras"),rs.getInt("anno"),rs.getInt("periodo"),rs.getString("planmetodologico"),rs.getString("programanalitico"),rs.getString("secactividad"),rs.getInt("codevaluacion"),rs.getInt("codplanest"),rs.getInt("codasigpre"),rs.getInt("coddisciplina"),rs.getInt("codcurriculo"));
      asignaturaList.add(asignatura);
  }
      PSQLConnection.getConn().close();
      return asignaturaList;
 }


public LinkedList<Asignatura> AsignaturaSelectAllQueryBysecactividad(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Asignatura> asignaturaList = new LinkedList<Asignatura>();
     String call=asignaturaquery.selectbysecactividad;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setString(1,asignatura.getSecactividad());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  asignatura = new Asignatura(rs.getInt("codasig"),rs.getString("nombreasig"),rs.getString("jefeasig"),rs.getInt("canthoras"),rs.getInt("anno"),rs.getInt("periodo"),rs.getString("planmetodologico"),rs.getString("programanalitico"),rs.getString("secactividad"),rs.getInt("codevaluacion"),rs.getInt("codplanest"),rs.getInt("codasigpre"),rs.getInt("coddisciplina"),rs.getInt("codcurriculo"));
      asignaturaList.add(asignatura);
  }
      PSQLConnection.getConn().close();
      return asignaturaList;
 }


public LinkedList<Asignatura> AsignaturaSelectAllQueryBycodevaluacion(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Asignatura> asignaturaList = new LinkedList<Asignatura>();
     String call=asignaturaquery.selectbycodevaluacion;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setInt(1,asignatura.getCodevaluacion());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  asignatura = new Asignatura(rs.getInt("codasig"),rs.getString("nombreasig"),rs.getString("jefeasig"),rs.getInt("canthoras"),rs.getInt("anno"),rs.getInt("periodo"),rs.getString("planmetodologico"),rs.getString("programanalitico"),rs.getString("secactividad"),rs.getInt("codevaluacion"),rs.getInt("codplanest"),rs.getInt("codasigpre"),rs.getInt("coddisciplina"),rs.getInt("codcurriculo"));
      asignaturaList.add(asignatura);
  }
      PSQLConnection.getConn().close();
      return asignaturaList;
 }


public LinkedList<Asignatura> AsignaturaSelectAllQueryBycodplanest(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Asignatura> asignaturaList = new LinkedList<Asignatura>();
     String call=asignaturaquery.selectbycodplanest;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setInt(1,asignatura.getCodplanest());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  asignatura = new Asignatura(rs.getInt("codasig"),rs.getString("nombreasig"),rs.getString("jefeasig"),rs.getInt("canthoras"),rs.getInt("anno"),rs.getInt("periodo"),rs.getString("planmetodologico"),rs.getString("programanalitico"),rs.getString("secactividad"),rs.getInt("codevaluacion"),rs.getInt("codplanest"),rs.getInt("codasigpre"),rs.getInt("coddisciplina"),rs.getInt("codcurriculo"));
      asignaturaList.add(asignatura);
  }
      PSQLConnection.getConn().close();
      return asignaturaList;
 }


public LinkedList<Asignatura> AsignaturaSelectAllQueryBycodasigpre(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Asignatura> asignaturaList = new LinkedList<Asignatura>();
     String call=asignaturaquery.selectbycodasigpre;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setInt(1,asignatura.getCodasigpre());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  asignatura = new Asignatura(rs.getInt("codasig"),rs.getString("nombreasig"),rs.getString("jefeasig"),rs.getInt("canthoras"),rs.getInt("anno"),rs.getInt("periodo"),rs.getString("planmetodologico"),rs.getString("programanalitico"),rs.getString("secactividad"),rs.getInt("codevaluacion"),rs.getInt("codplanest"),rs.getInt("codasigpre"),rs.getInt("coddisciplina"),rs.getInt("codcurriculo"));
      asignaturaList.add(asignatura);
  }
      PSQLConnection.getConn().close();
      return asignaturaList;
 }


public LinkedList<Asignatura> AsignaturaSelectAllQueryBycoddisciplina(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Asignatura> asignaturaList = new LinkedList<Asignatura>();
     String call=asignaturaquery.selectbycoddisciplina;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setInt(1,asignatura.getCoddisciplina());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  asignatura = new Asignatura(rs.getInt("codasig"),rs.getString("nombreasig"),rs.getString("jefeasig"),rs.getInt("canthoras"),rs.getInt("anno"),rs.getInt("periodo"),rs.getString("planmetodologico"),rs.getString("programanalitico"),rs.getString("secactividad"),rs.getInt("codevaluacion"),rs.getInt("codplanest"),rs.getInt("codasigpre"),rs.getInt("coddisciplina"),rs.getInt("codcurriculo"));
      asignaturaList.add(asignatura);
  }
      PSQLConnection.getConn().close();
      return asignaturaList;
 }


public LinkedList<Asignatura> AsignaturaSelectAllQueryBycodcurriculo(Asignatura asignatura) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Asignatura> asignaturaList = new LinkedList<Asignatura>();
     String call=asignaturaquery.selectbycodcurriculo;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setInt(1,asignatura.getCodcurriculo());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  asignatura = new Asignatura(rs.getInt("codasig"),rs.getString("nombreasig"),rs.getString("jefeasig"),rs.getInt("canthoras"),rs.getInt("anno"),rs.getInt("periodo"),rs.getString("planmetodologico"),rs.getString("programanalitico"),rs.getString("secactividad"),rs.getInt("codevaluacion"),rs.getInt("codplanest"),rs.getInt("codasigpre"),rs.getInt("coddisciplina"),rs.getInt("codcurriculo"));
      asignaturaList.add(asignatura);
  }
      PSQLConnection.getConn().close();
      return asignaturaList;
 }


}
