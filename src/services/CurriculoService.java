 package services;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import query.CurriculoQuery;
import clases.Curriculo;
import connection.PSQLConnection;




public class CurriculoService {
private static CurriculoService  curriculoservice=null;
private  CurriculoQuery  curriculoquery;


public static CurriculoService getCurriculoService(){
      if (curriculoservice==null) {
		  curriculoservice = new CurriculoService();
   	}
		return curriculoservice;
	}
public CurriculoService() {
       super();
// TODO Auto-generated constructor stub
}


public void InsertCurriculo(Curriculo curriculo) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.curriculo_insert(?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setString(1,curriculo.getTipocurriculo());
      MyCall.setBoolean(2,curriculo.getCancelado());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdateCurriculo(Curriculo curriculo) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.curriculo_update(?,?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,curriculo.getCodcurriculo());
      MyCall.setString(2,curriculo.getTipocurriculo());
      MyCall.setBoolean(3,curriculo.getCancelado());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void DeleteCurriculo(Curriculo curriculo) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.curriculo_delete(?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,curriculo.getCodcurriculo());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void InsertCurriculoQuery(Curriculo curriculo) throws SQLException,ClassNotFoundException
{    
      
       String query =curriculoquery.Insert_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(query);	
      MyCall.setString(1,curriculo.getTipocurriculo());
      MyCall.setBoolean(2,curriculo.getCancelado());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdateCurriculoQuery(Curriculo curriculo) throws SQLException,ClassNotFoundException
{    
      
      String call=curriculoquery.Update_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,curriculo.getCodcurriculo());
      MyCall.setString(2,curriculo.getTipocurriculo());
      MyCall.setBoolean(3,curriculo.getCancelado());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }
public void DeleteCurriculoQuery(Curriculo curriculo) throws SQLException,ClassNotFoundException
{    
      
      String call=curriculoquery.Delete_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,curriculo.getCodcurriculo());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public Curriculo FindCurriculoByPKQuery(Curriculo curriculo) throws SQLException,ClassNotFoundException
{    
      
      String call=curriculoquery.PK9;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,curriculo.getCodcurriculo());
      curriculo =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            curriculo = new Curriculo(rs.getInt("codcurriculo"),rs.getString("tipocurriculo"),rs.getBoolean("cancelado"));
  }
      PSQLConnection.getConn().close();
    return curriculo;
 }


public Curriculo FindCurriculoByPK9(Curriculo curriculo) throws SQLException,ClassNotFoundException
{    
      
      String call=curriculoquery.PK9;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,curriculo.getCodcurriculo());
      curriculo =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            curriculo = new Curriculo(rs.getInt("codcurriculo"),rs.getString("tipocurriculo"),rs.getBoolean("cancelado"));
  }
      PSQLConnection.getConn().close();
    return curriculo;
 }




public LinkedList<Curriculo> CurriculoSelectAllQuery() throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Curriculo> curriculoList = new LinkedList<Curriculo>();
     String call=curriculoquery.Select_All_Query;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
       rs=MyCall.executeQuery();
       while(rs.next())
     {
      Curriculo  curriculo = new Curriculo(rs.getInt("codcurriculo"),rs.getString("tipocurriculo"),rs.getBoolean("cancelado"));
      curriculoList.add(curriculo);
  }
      PSQLConnection.getConn().close();
      return curriculoList;
 }


public LinkedList<Curriculo> CurriculoSelectAllQueryBytipocurriculo(Curriculo curriculo) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Curriculo> curriculoList = new LinkedList<Curriculo>();
     String call=curriculoquery.selectbytipocurriculo;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setString(1,curriculo.getTipocurriculo());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  curriculo = new Curriculo(rs.getInt("codcurriculo"),rs.getString("tipocurriculo"),rs.getBoolean("cancelado"));
      curriculoList.add(curriculo);
  }
      PSQLConnection.getConn().close();
      return curriculoList;
 }


public LinkedList<Curriculo> CurriculoSelectAllQueryBycancelado(Curriculo curriculo) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Curriculo> curriculoList = new LinkedList<Curriculo>();
     String call=curriculoquery.selectbycancelado;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setBoolean(1,curriculo.getCancelado());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  curriculo = new Curriculo(rs.getInt("codcurriculo"),rs.getString("tipocurriculo"),rs.getBoolean("cancelado"));
      curriculoList.add(curriculo);
  }
      PSQLConnection.getConn().close();
      return curriculoList;
 }


}
