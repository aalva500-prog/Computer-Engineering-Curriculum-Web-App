 package query;


 /** 
 * * @Author 
 * * @Software 
 * * @Company 
  */
   public class EvaluacionQuery {

    public static String Insert_Query="insert into evaluacion(tipoevaluacion,cancelado)  values(?,?);  ";

    public static String Update_Query="update evaluacion set tipoevaluacion= ?,cancelado= ?   where codevaluacion= ?;";

    public static String Delete_Query="delete from evaluacion where codevaluacion= ?;";

    public static String Select_All_Query="Select * from evaluacion order by evaluacion.codevaluacion";

    public static String PK10="select * from evaluacion where codevaluacion= ?;";

    public static String selectbytipoevaluacion="Select * from evaluacion where tipoevaluacion=?";

    public static String selectbycancelado="Select * from evaluacion where cancelado=?";



}
