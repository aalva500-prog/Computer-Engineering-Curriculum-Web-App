 package query;


 /** 
 * * @Author 
 * * @Software 
 * * @Company 
  */
   public class FacultadQuery {

    public static String Insert_Query="insert into facultad(nombdecano,nombfacultad)  values(?,?);  ";

    public static String Update_Query="update facultad set nombdecano= ?,nombfacultad= ?   where idfacultad= ?;";

    public static String Delete_Query="delete from facultad where idfacultad= ?;";

    public static String Select_All_Query="Select * from facultad order by facultad.idfacultad";

    public static String PK1="select * from facultad where idfacultad= ?;";

    public static String facultad_nombfacultad_key="select * from facultad where nombfacultad= ?;";

    public static String selectbynombdecano="Select * from facultad where nombdecano=?";



}
