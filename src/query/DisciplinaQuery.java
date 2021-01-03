 package query;


 /** 
 * * @Author 
 * * @Software 
 * * @Company 
  */
   public class DisciplinaQuery {

    public static String Insert_Query="insert into disciplina(nombredisciplin,jefedisciplin,canthorastotales,cancelado)  values(?,?,?,?);  ";

    public static String Update_Query="update disciplina set nombredisciplin= ?,jefedisciplin= ?,canthorastotales= ?,cancelado= ?   where coddisciplina= ?;";

    public static String Delete_Query="delete from disciplina where coddisciplina= ?;";

    public static String Select_All_Query="Select * from disciplina order by disciplina.coddisciplina";

    public static String PK6="select * from disciplina where coddisciplina= ?;";

    public static String disciplina_nombredisciplin_key="select * from disciplina where nombredisciplin= ?;";

    public static String selectbyjefedisciplin="Select * from disciplina where jefedisciplin=?";

    public static String selectbycanthorastotales="Select * from disciplina where canthorastotales=?";

    public static String selectbycancelado="Select * from disciplina where cancelado=?";



}
