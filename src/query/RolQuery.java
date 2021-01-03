 package query;


 /** 
 * * @Author 
 * * @Software 
 * * @Company 
  */
   public class RolQuery {

    public static String Insert_Query="insert into rol(tiporol,cancelado)  values(?,?);  ";

    public static String Update_Query="update rol set tiporol= ?,cancelado= ?   where codrol= ?;";

    public static String Delete_Query="delete from rol where codrol= ?;";

    public static String Select_All_Query="Select * from rol order by rol.codrol";

    public static String PK7="select * from rol where codrol= ?;";

    public static String rol_tiporol_key="select * from rol where tiporol= ?;";

    public static String selectbycancelado="Select * from rol where cancelado=?";



}
