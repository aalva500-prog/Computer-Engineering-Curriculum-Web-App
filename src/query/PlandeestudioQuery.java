 package query;


 /** 
 * * @Author 
 * * @Software 
 * * @Company 
  */
   public class PlandeestudioQuery {

    public static String Insert_Query="insert into plandeestudio(nombreplan,cantperiodos,cantannos,codcarrera)  values(?,?,?,?);  ";

    public static String Update_Query="update plandeestudio set nombreplan= ?,cantperiodos= ?,cantannos= ?,codcarrera= ?   where codplanest= ?;";

    public static String Delete_Query="delete from plandeestudio where codplanest= ?;";

    public static String Select_All_Query="Select * from plandeestudio order by plandeestudio.codplanest";

    public static String PK3="select * from plandeestudio where codplanest= ?;";

    public static String plandeestudio_nombreplan_key="select * from plandeestudio where nombreplan= ?;";

    public static String selectbycantperiodos="Select * from plandeestudio where cantperiodos=?";

    public static String selectbycantannos="Select * from plandeestudio where cantannos=?";

    public static String selectbycodcarrera="Select * from plandeestudio where codcarrera=?";



}
