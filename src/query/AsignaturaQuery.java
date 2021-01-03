 package query;


 /** 
 * * @Author 
 * * @Software 
 * * @Company 
  */
   public class AsignaturaQuery {

    public static String Insert_Query="insert into asignatura(nombreasig,jefeasig,canthoras,anno,periodo,planmetodologico,programanalitico,secactividad,codevaluacion,codplanest,codasigpre,coddisciplina,codcurriculo)  values(?,?,?,?,?,?,?,?,?,?,?,?,?);  ";

    public static String Update_Query="update asignatura set nombreasig= ?,jefeasig= ?,canthoras= ?,anno= ?,periodo= ?,planmetodologico= ?,programanalitico= ?,secactividad= ?,codevaluacion= ?,codplanest= ?,codasigpre= ?,coddisciplina= ?,codcurriculo= ?   where codasig= ?;";

    public static String Delete_Query="delete from asignatura where codasig= ?;";

    public static String Select_All_Query="Select * from asignatura order by asignatura.codasig";

    public static String PK5="select * from asignatura where codasig= ?;";

    public static String asignatura_nombreasig_key="select * from asignatura where nombreasig= ?;";

    public static String selectbyjefeasig="Select * from asignatura where jefeasig=?";

    public static String selectbycanthoras="Select * from asignatura where canthoras=?";

    public static String selectbyanno="Select * from asignatura where anno=?";

    public static String selectbyperiodo="Select * from asignatura where periodo=?";

    public static String selectbyplanmetodologico="Select * from asignatura where planmetodologico=?";

    public static String selectbyprogramanalitico="Select * from asignatura where programanalitico=?";

    public static String selectbysecactividad="Select * from asignatura where secactividad=?";

    public static String selectbycodevaluacion="Select * from asignatura where codevaluacion=?";

    public static String selectbycodplanest="Select * from asignatura where codplanest=?";

    public static String selectbycodasigpre="Select * from asignatura where codasigpre=?";

    public static String selectbycoddisciplina="Select * from asignatura where coddisciplina=?";

    public static String selectbycodcurriculo="Select * from asignatura where codcurriculo=?";



}
