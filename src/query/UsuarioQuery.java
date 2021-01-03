 package query;


 /** 
 * * @Author 
 * * @Software 
 * * @Company 
  */
   public class UsuarioQuery {

    public static String Insert_Query="insert into usuario(nombreus,password,idfacultad,codrol)  values(?,?,?,?);  ";

    public static String Update_Query="update usuario set nombreus= ?,password= ?,idfacultad= ?,codrol= ?   where idusuario= ?;";

    public static String Delete_Query="delete from usuario where idusuario= ?;";

    public static String Select_All_Query="Select * from usuario order by usuario.idusuario";

    public static String PK4="select * from usuario where nombreus= ?;";

    public static String usuario_idusuario_key="select * from usuario where idusuario= ?;";

    public static String selectbypassword="Select * from usuario where password=?";

    public static String selectbyidfacultad="Select * from usuario where idfacultad=?";

    public static String selectbycodrol="Select * from usuario where codrol=?";



}
