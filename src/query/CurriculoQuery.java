 package query;


 /** 
 * * @Author 
 * * @Software 
 * * @Company 
  */
   public class CurriculoQuery {

    public static String Insert_Query="insert into curriculo(tipocurriculo,cancelado)  values(?,?);  ";

    public static String Update_Query="update curriculo set tipocurriculo= ?,cancelado= ?   where codcurriculo= ?;";

    public static String Delete_Query="delete from curriculo where codcurriculo= ?;";

    public static String Select_All_Query="Select * from curriculo order by curriculo.codcurriculo";

    public static String PK9="select * from curriculo where codcurriculo= ?;";

    public static String selectbytipocurriculo="Select * from curriculo where tipocurriculo=?";

    public static String selectbycancelado="Select * from curriculo where cancelado=?";



}
