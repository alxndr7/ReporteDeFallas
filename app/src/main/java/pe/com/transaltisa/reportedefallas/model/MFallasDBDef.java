package pe.com.transaltisa.reportedefallas.model;

/**
 * Created by ExpoCode Tech http://expocodetech.com
 */
public class MFallasDBDef {
    //Nombre del esquema de Base de Datos
    public static final String DATABASE_NAME = "trn_fallas";
    //Version de la Base de Datos (Este parámetro es importante  )
    public static final int DATABASE_VERSION = 1;

    public static class MFALLAS {
        //Nombre de la tabla
        public static final String TABLE_NAME = "MFALLAS";
        //Nombre de las Columnas que contiene la tabla
        public static final String ID_FALLA_COL = "id_falla_col";
        public static final String TITULO_COL = "titulo";
        public static final String FECHA_FALLA_COL = "fecha_falla";
        public static final String HORA_FALLA_COL = "hora_falla";
        public static final String EMPRESA_COL = "empresa";
        public static final String CONVOY_COL= "convoy";
        public static final String PLACA_TRACTO_COL= "placa_tracto";
        public static final String PLACA_CARRETA_COL= "placa_carreta";
        public static final String KILOMETRAJE_COL= "kilometraje";
        public static final String UBICACION_COL= "ubicacion";
        public static final String DESCRIPCION_FALLA_COL= "descripcion_falla";
    }

    public static class MUSUARIO {
        //Nombre de la tabla
        public static final String TABLE_NAME = "MUSUARIO";
        //Nombre de las Columnas que contiene la tabla
        public static final String ID_USUARIO_COL = "id_usuario";
        public static final String NOMBRE_USUARIO_COL = "nombre_usuario";
        public static final String LOGIN_COL = "login";
        public static final String PASSWORD_COL = "password";
    }

    //Setencia SQL que permite crear la tabla
    public static final String MFALLAS_TABLE_CREATE =
            "CREATE TABLE " + MFALLAS.TABLE_NAME + " (" +
                    MFALLAS.ID_FALLA_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    MFALLAS.TITULO_COL + " TEXT, " +
                    MFALLAS.FECHA_FALLA_COL + " TEXT, " +
                    MFALLAS.HORA_FALLA_COL + " TEXT, " +
                    MFALLAS.EMPRESA_COL + " TEXT, " +
                    MFALLAS.CONVOY_COL + " TEXT, " +
                    MFALLAS.PLACA_TRACTO_COL + " TEXT, " +
                    MFALLAS.PLACA_CARRETA_COL + " TEXT, " +
                    MFALLAS.KILOMETRAJE_COL + " TEXT, " +
                    MFALLAS.UBICACION_COL + " TEXT, " +
                    MFALLAS.DESCRIPCION_FALLA_COL + " TEXT);";

    public static final String MUSUARIO_TABLE_CREATE =
            "CREATE TABLE " + MUSUARIO.TABLE_NAME + " (" +
                    MUSUARIO.ID_USUARIO_COL+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    MUSUARIO.NOMBRE_USUARIO_COL + " TEXT, " +
                    MUSUARIO.LOGIN_COL + " TEXT, " +
                    MUSUARIO.PASSWORD_COL + " TEXT);";

    //Setencia SQL que permite eliminar la tabla
    public static final String MFALLAS_TABLE_DROP = "DROP TABLE IF EXISTS " + MFALLAS.TABLE_NAME;
    public static final String MUSUARIO_TABLE_DROP = "DROP TABLE IF EXISTS " + MUSUARIO.TABLE_NAME;
}
