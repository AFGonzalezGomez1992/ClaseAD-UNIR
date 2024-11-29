package database;

public interface DBScheme {

    // elemento interconecta cosas que no tienen que ver entre si
    // metodos son no definidos -> abs
    public final static String HOST = "127.0.0.1";
    String PORT ="3306";
    String DATABASE = "repaso";
    String TAB_USER ="usuarios";
    String COL_NAME = "nombre";
    String COL_ID = "id";
    String COL_PASS = "password";
    String COL_MAIL = "correo";

}
