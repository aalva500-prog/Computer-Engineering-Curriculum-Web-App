 package services;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import query.PlandeestudioQuery;
import clases.Plandeestudio;
import connection.PSQLConnection;




public class PlandeestudioService {
private static PlandeestudioService  plandeestudioservice=null;
private  PlandeestudioQuery  plandeestudioquery;


public static PlandeestudioService getPlandeestudioService(){
      if (plandeestudioservice==null) {
		  plandeestudioservice = new PlandeestudioService();
   	}
		return plandeestudioservice;
	}
public PlandeestudioService() {
       super();
// TODO Auto-generated constructor stub
}


public void InsertPlandeestudio(Plandeestudio plandeestudio) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.plandeestudio_insert(?,?,?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setString(1,plandeestudio.getNombreplan());
      MyCall.setInt(2,plandeestudio.getCantperiodos());
      MyCall.setInt(3,plandeestudio.getCantannos());
      MyCall.setInt(4,plandeestudio.getCodcarrera());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdatePlandeestudio(Plandeestudio plandeestudio) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.plandeestudio_update(?,?,?,?,?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,plandeestudio.getCodplanest());
      MyCall.setString(2,plandeestudio.getNombreplan());
      MyCall.setInt(3,plandeestudio.getCantperiodos());
      MyCall.setInt(4,plandeestudio.getCantannos());
      MyCall.setInt(5,plandeestudio.getCodcarrera());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void DeletePlandeestudio(Plandeestudio plandeestudio) throws SQLException,ClassNotFoundException
{    
      
      String call="{call public.plandeestudio_delete(?)}";
      CallableStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,plandeestudio.getCodplanest());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void InsertPlandeestudioQuery(Plandeestudio plandeestudio) throws SQLException,ClassNotFoundException
{    
      
       String query =plandeestudioquery.Insert_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(query);	
      MyCall.setString(1,plandeestudio.getNombreplan());
      MyCall.setInt(2,plandeestudio.getCantperiodos());
      MyCall.setInt(3,plandeestudio.getCantannos());
      MyCall.setInt(4,plandeestudio.getCodcarrera());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public void UpdatePlandeestudioQuery(Plandeestudio plandeestudio) throws SQLException,ClassNotFoundException
{    
      
      String call=plandeestudioquery.Update_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,plandeestudio.getCodplanest());
      MyCall.setString(2,plandeestudio.getNombreplan());
      MyCall.setInt(3,plandeestudio.getCantperiodos());
      MyCall.setInt(4,plandeestudio.getCantannos());
      MyCall.setInt(5,plandeestudio.getCodcarrera());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }
public void DeletePlandeestudioQuery(Plandeestudio plandeestudio) throws SQLException,ClassNotFoundException
{    
      
      String call=plandeestudioquery.Delete_Query;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      MyCall.setInt(1,plandeestudio.getCodplanest());
      MyCall.execute();
      PSQLConnection.getConn().close();
 }


public Plandeestudio FindPlandeestudioByPKQuery(Plandeestudio plandeestudio) throws SQLException,ClassNotFoundException
{    
      
      String call=plandeestudioquery.PK3;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,plandeestudio.getCodplanest());
      plandeestudio =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            plandeestudio = new Plandeestudio(rs.getInt("codplanest"),rs.getString("nombreplan"),rs.getInt("cantperiodos"),rs.getInt("cantannos"),rs.getInt("codcarrera"));
  }
      PSQLConnection.getConn().close();
    return plandeestudio;
 }


public Plandeestudio FindPlandeestudioByPK3(Plandeestudio plandeestudio) throws SQLException,ClassNotFoundException
{    
      
      String call=plandeestudioquery.PK3;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setInt(1,plandeestudio.getCodplanest());
      plandeestudio =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            plandeestudio = new Plandeestudio(rs.getInt("codplanest"),rs.getString("nombreplan"),rs.getInt("cantperiodos"),rs.getInt("cantannos"),rs.getInt("codcarrera"));
  }
      PSQLConnection.getConn().close();
    return plandeestudio;
 }


public Plandeestudio FindPlandeestudioByplandeestudio_nombreplan_key(Plandeestudio plandeestudio) throws SQLException,ClassNotFoundException
{    
      
      String call=plandeestudioquery.plandeestudio_nombreplan_key;
      PreparedStatement MyCall;
      MyCall =PSQLConnection.getConn().prepareCall(call);	
      ResultSet rs=null;
      MyCall.setString(1,plandeestudio.getNombreplan());
      plandeestudio =null;
      rs=MyCall.executeQuery();
      while(rs.next())
     {
            plandeestudio = new Plandeestudio(rs.getInt("codplanest"),rs.getString("nombreplan"),rs.getInt("cantperiodos"),rs.getInt("cantannos"),rs.getInt("codcarrera"));
  }
      PSQLConnection.getConn().close();
    return plandeestudio;
 }




public LinkedList<Plandeestudio> PlandeestudioSelectAllQuery() throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Plandeestudio> plandeestudioList = new LinkedList<Plandeestudio>();
     String call=plandeestudioquery.Select_All_Query;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
       rs=MyCall.executeQuery();
       while(rs.next())
     {
      Plandeestudio  plandeestudio = new Plandeestudio(rs.getInt("codplanest"),rs.getString("nombreplan"),rs.getInt("cantperiodos"),rs.getInt("cantannos"),rs.getInt("codcarrera"));
      plandeestudioList.add(plandeestudio);
  }
      PSQLConnection.getConn().close();
      return plandeestudioList;
 }


public LinkedList<Plandeestudio> PlandeestudioSelectAllQueryBycantperiodos(Plandeestudio plandeestudio) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Plandeestudio> plandeestudioList = new LinkedList<Plandeestudio>();
     String call=plandeestudioquery.selectbycantperiodos;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setInt(1,plandeestudio.getCantperiodos());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  plandeestudio = new Plandeestudio(rs.getInt("codplanest"),rs.getString("nombreplan"),rs.getInt("cantperiodos"),rs.getInt("cantannos"),rs.getInt("codcarrera"));
      plandeestudioList.add(plandeestudio);
  }
      PSQLConnection.getConn().close();
      return plandeestudioList;
 }


public LinkedList<Plandeestudio> PlandeestudioSelectAllQueryBycantannos(Plandeestudio plandeestudio) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Plandeestudio> plandeestudioList = new LinkedList<Plandeestudio>();
     String call=plandeestudioquery.selectbycantannos;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setInt(1,plandeestudio.getCantannos());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  plandeestudio = new Plandeestudio(rs.getInt("codplanest"),rs.getString("nombreplan"),rs.getInt("cantperiodos"),rs.getInt("cantannos"),rs.getInt("codcarrera"));
      plandeestudioList.add(plandeestudio);
  }
      PSQLConnection.getConn().close();
      return plandeestudioList;
 }


public LinkedList<Plandeestudio> PlandeestudioSelectAllQueryBycodcarrera(Plandeestudio plandeestudio) throws SQLException,ClassNotFoundException
{    
     
     LinkedList<Plandeestudio> plandeestudioList = new LinkedList<Plandeestudio>();
     String call=plandeestudioquery.selectbycodcarrera;
     PreparedStatement MyCall;
     MyCall =PSQLConnection.getConn().prepareCall(call);	
     ResultSet rs=null;
      MyCall.setInt(1,plandeestudio.getCodcarrera());
      rs=MyCall.executeQuery();
      while(rs.next())
     {
                  plandeestudio = new Plandeestudio(rs.getInt("codplanest"),rs.getString("nombreplan"),rs.getInt("cantperiodos"),rs.getInt("cantannos"),rs.getInt("codcarrera"));
      plandeestudioList.add(plandeestudio);
  }
      PSQLConnection.getConn().close();
      return plandeestudioList;
 }


}
