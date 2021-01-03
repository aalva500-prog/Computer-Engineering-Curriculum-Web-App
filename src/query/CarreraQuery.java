 package query;


 /** 
 * * @Author 
 * * @Software 
 * * @Company 
  */
   public class CarreraQuery {

    public static String Insert_Query="insert into carrera(nombcarrera,idfacultad)  values(?,?);  ";

    public static String Update_Query="update carrera set nombcarrera= ?,idfacultad= ?   where codcarrera= ?;";

    public static String Delete_Query="delete from carrera where codcarrera= ?;";

    public static String Select_All_Query="Select * from carrera order by carrera.codcarrera";

    public static String PK2="select * from carrera where codcarrera= ?;";

    public static String carrera_nombcarrera_key="select * from carrera where nombcarrera= ?;";

    public static String selectbyidfacultad="Select * from carrera where idfacultad=?";



}
