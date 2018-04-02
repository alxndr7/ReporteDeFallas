package pe.com.transaltisa.reportedefallas.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ExpoCode Tech http://expocodetech.com
 */
public class FallasDBHelper extends SQLiteOpenHelper {

    //Definimos in Contructor para Instanciar el Databse Helper
    public FallasDBHelper(Context context) {
        super(context, MFallasDBDef.DATABASE_NAME, null, MFallasDBDef.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creamos las tablas en la Base de datos
        Log.d("ONCREATE","ONCREATE HELPER 1");

        db.execSQL(MFallasDBDef.MFALLAS_TABLE_CREATE);
        db.execSQL(MFallasDBDef.MUSUARIO_TABLE_CREATE);
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " (" +
                MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.LOGIN_COL + "," +
                MFallasDBDef.MUSUARIO.PASSWORD_COL+ " ) VALUES (1,'Nombre Completo Usuario 1','administrador','@dm1n15tr4d0r')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " (" +
                MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.LOGIN_COL + "," +
                MFallasDBDef.MUSUARIO.PASSWORD_COL+ " ) VALUES (10,'Nombre Completo Usuario 2','user','user')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " (" +
                MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.LOGIN_COL + "," +
                MFallasDBDef.MUSUARIO.PASSWORD_COL+ " ) VALUES (11,'Nombre Completo Usuario 3','user2','user2')");

        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (1,'REPORTE 1','16-03-2018','16:14',1,11,'TRANSALTISA')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (2,'REPORTE 1','16-03-2018','16:14',1,11,'TRANSALTISA')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (3,'REPORTE 1','16-03-2018','16:14',1,10,'TRANSALTISA')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (4,'REPORTE 2','16-03-2018','16:14','TRANSALTISA')");

        Log.d("ONCREATE","ONCREATE HELPER");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    /*    if (oldVersion < 4){
            Log.d("UPGRADE", "OLDVERSION");
            db.execSQL("ALTER TABLE "+ MFallasDBDef.MFALLAS.TABLE_NAME +" ADD "+ MFallasDBDef.MFALLAS.ID_USUARIO_COL +" INTEGER");
            db.execSQL("ALTER TABLE "+ MFallasDBDef.MFALLAS.TABLE_NAME +" ADD "+ MFallasDBDef.MFALLAS.ESTADO_COL +" INTEGER");
        }*/


        //El método onUpgrade se ejecuta cada vez que recompilamos e instalamos la app con un
        //nuevo numero de version de base de datos (DATABASE_VERSION), de tal mamera que en este
        // método lo que hacemos es:
        // 1. Con esta sentencia borramos la tabla "notes"
        db.execSQL(MFallasDBDef.MFALLAS_TABLE_DROP);
        db.execSQL(MFallasDBDef.MUSUARIO_TABLE_DROP);
        // 2. Con esta sentencia llamamos de nuevo al método onCreate para que se cree de nuevo
        //la tabla "notes" la cual seguramente al cambair de versión ha tenido modifciaciones
        // en cuanto a su estructura de columnas
        this.onCreate(db);

    }

    /*
    * OPERACIONES CRUD (Create, Read, Update, Delete)
    * A partir de aqui se definen los metodos para insertar, leer, actualizar y borrar registros de
    * la base de datos (BD)
    * */

    public void insertFallo(MFalla falla){
        //Con este método insertamos las notas nuevas que el usuario vaya creando

        // 1. Obtenemos una reference de la BD con permisos de escritura
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. Creamos un obejto de tipo ContentValues para agregar los pares
        // de Claves de Columna y Valor
        ContentValues values = new ContentValues();
        values.put(MFallasDBDef.MFALLAS.TITULO_COL, falla.getTitulo());
        values.put(MFallasDBDef.MFALLAS.FECHA_FALLA_COL, falla.getFecha_falla());
        values.put(MFallasDBDef.MFALLAS.HORA_FALLA_COL, falla.getHora_falla());
        values.put(MFallasDBDef.MFALLAS.EMPRESA_COL, falla.getEmpresa());
        values.put(MFallasDBDef.MFALLAS.CONVOY_COL, falla.getConvoy());
        values.put(MFallasDBDef.MFALLAS.PLACA_TRACTO_COL, falla.getPlaca_tracto());
        values.put(MFallasDBDef.MFALLAS.PLACA_CARRETA_COL, falla.getPlaca_carreta());
        values.put(MFallasDBDef.MFALLAS.KILOMETRAJE_COL, falla.getKilometraje());
        values.put(MFallasDBDef.MFALLAS.UBICACION_COL, falla.getUbicacion());
        values.put(MFallasDBDef.MFALLAS.DESCRIPCION_FALLA_COL, falla.getDescripcion_falla());
        values.put(MFallasDBDef.MFALLAS.ID_USUARIO_COL, falla.getId_usuario());
        values.put(MFallasDBDef.MFALLAS.ESTADO_COL, falla.getId_usuario());


        // 3. Insertamos los datos en la tabla "notes"
        db.insert(MFallasDBDef.MFALLAS.TABLE_NAME, null, values);

        // 4. Cerramos la conexión comn la BD
        db.close();
    }

    //Obtener uan Nota dado un ID
    public MFalla getFallaPorId(int id){
        // Declaramos un objeto Inscampo para instanciarlo con el resultado del query
        MFalla falla= null;

        // 1. Obtenemos una reference de la BD con permisos de lectura
        SQLiteDatabase db = this.getReadableDatabase();

        //Definimos un array con los nombres de las columnas que deseamos sacar
        String[] COLUMNS = {
                MFallasDBDef.MFALLAS.ID_FALLA_COL,
                MFallasDBDef.MFALLAS.TITULO_COL,
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL,
                MFallasDBDef.MFALLAS.HORA_FALLA_COL,
                MFallasDBDef.MFALLAS.EMPRESA_COL,
                MFallasDBDef.MFALLAS.CONVOY_COL,
                MFallasDBDef.MFALLAS.PLACA_TRACTO_COL,
                MFallasDBDef.MFALLAS.PLACA_CARRETA_COL,
                MFallasDBDef.MFALLAS.KILOMETRAJE_COL,
                MFallasDBDef.MFALLAS.UBICACION_COL,
                MFallasDBDef.MFALLAS.DESCRIPCION_FALLA_COL,
                MFallasDBDef.MFALLAS.ID_USUARIO_COL,
                MFallasDBDef.MFALLAS.ESTADO_COL
        };

        // 2. Contruimos el query
        Cursor cursor =
                db.query(MFallasDBDef.MFALLAS.TABLE_NAME,  //Nomre de la tabla
                        COLUMNS, // b. Nombre de las Columnas
                        " id_falla_col = ?", // c. Columnas de la clausula WHERE
                        new String[] { String.valueOf(id) }, // d. valores de las columnas de la clausula WHERE
                        null, // e. Clausula Group by
                        null, // f. Clausula having
                        null, // g. Clausula order by
                        null); // h. Limte de regsitros

        // 3. Si hemos obtenido algun resultado entonces sacamos el primero de ellos ya que se supone
        //que ha de existir un solo registro para un id
        if (cursor != null) {
            cursor.moveToFirst();
            // 4. Contruimos el objeto Inscampo
            falla = new MFalla();
            falla.setId_falla(Integer.parseInt(cursor.getString(0)));
            falla.setTitulo(cursor.getString(1));
            falla.setFecha_falla(cursor.getString(2));
            falla.setHora_falla(cursor.getString(3));
            falla.setEmpresa(cursor.getString(4));
            falla.setConvoy(cursor.getString(5));
            falla.setPlaca_tracto(cursor.getString(6));
            falla.setPlaca_carreta(cursor.getString(7));
            falla.setKilometraje(cursor.getString(8));
            falla.setUbicacion(cursor.getString(9));
            falla.setDescripcion_falla(cursor.getString(10));
            falla.setId_usuario(cursor.getString(11));
            falla.setEstado(cursor.getString(12));
        }

        // 5. Devolvemos le objeto Inscampo
        return falla;
    }

    // Obtener todas las notas
    public List<MFalla> getAllFallos(String id_usuario) {
        //Instanciamos un Array para llenarlo con todos los objetos Notes que saquemos de la BD
        List<MFalla> listFallas = new ArrayList<MFalla>();
        Log.d("GETFALLOS","ID=" + id_usuario);
        String query;
        String id_admin = "1";
        if(id_usuario.equals(id_admin)){
            // 1. Aramos un String con el query a ejecutar
            query = "SELECT  * FROM " + MFallasDBDef.MFALLAS.TABLE_NAME ;
        }
        else{
            query = "SELECT  * FROM " + MFallasDBDef.MFALLAS.TABLE_NAME + " WHERE "+ MFallasDBDef.MFALLAS.ID_USUARIO_COL + " = " + id_usuario + " AND " + MFallasDBDef.MFALLAS.ESTADO_COL + " = 1";
        }


        // 2. Obtenemos una reference de la BD con permisos de escritura y ejecutamos el query
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. Iteramos entre cada uno de olos registros y agregarlos al array de Notas
        MFalla falla = null;
        if (cursor.moveToFirst()) {

            do {
                falla = new MFalla();
                falla.setId_falla(Integer.parseInt(cursor.getString(0)));
                falla.setTitulo(cursor.getString(1));
                falla.setFecha_falla(cursor.getString(2));
                falla.setHora_falla(cursor.getString(3));
                falla.setEmpresa(cursor.getString(4));
                falla.setConvoy(cursor.getString(5));
                falla.setPlaca_tracto(cursor.getString(6));
                falla.setPlaca_carreta(cursor.getString(7));
                falla.setKilometraje(cursor.getString(8));
                falla.setUbicacion(cursor.getString(9));
                falla.setDescripcion_falla(cursor.getString(10));
                falla.setId_usuario(cursor.getString(11));
                falla.setEstado(cursor.getString(12));
                // Add book to books
                listFallas.add(falla);
                Log.i("MyActivity", " 3 helper " );
            } while (cursor.moveToNext());

            Log.i("MyActivity", " 4 helper " );
        }

        //Cerramos el cursor
        cursor.close();

        // Devolvemos las notas encontradas o un array vacio en caso de que no se encuentre nada
        return listFallas;
    }

    //Actualizar los datos en una nota
    public int updateReporteFalla(MFalla falla) {

        // 1. Obtenemos una reference de la BD con permisos de escritura
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. Creamos el objeto ContentValues con las claves "columna"/valor
        // que se desean actualizar
        ContentValues values = new ContentValues();

        values.put(MFallasDBDef.MFALLAS.TITULO_COL, falla.getTitulo());
        values.put(MFallasDBDef.MFALLAS.FECHA_FALLA_COL, falla.getFecha_falla());
        values.put(MFallasDBDef.MFALLAS.HORA_FALLA_COL, falla.getHora_falla());
        values.put(MFallasDBDef.MFALLAS.EMPRESA_COL, falla.getEmpresa());
        values.put(MFallasDBDef.MFALLAS.CONVOY_COL, falla.getConvoy());
        values.put(MFallasDBDef.MFALLAS.PLACA_TRACTO_COL, falla.getPlaca_tracto());
        values.put(MFallasDBDef.MFALLAS.PLACA_CARRETA_COL, falla.getPlaca_carreta());
        values.put(MFallasDBDef.MFALLAS.KILOMETRAJE_COL, falla.getKilometraje());
        values.put(MFallasDBDef.MFALLAS.UBICACION_COL, falla.getUbicacion());
        values.put(MFallasDBDef.MFALLAS.DESCRIPCION_FALLA_COL, falla.getDescripcion_falla());

        // 3. Actualizamos el registro con el método update el cual devuelve la cantidad
        // de registros actualizados
        int i = db.update(MFallasDBDef.MFALLAS.TABLE_NAME, //table
                values, // column/value
                MFallasDBDef.MFALLAS.ID_FALLA_COL+" = ?", // selections
                new String[] { String.valueOf(falla.getId_falla()) }); //selection args

        // 4. Cerramos la conexión a la BD
        db.close();

        // Devolvemos la cantidad de registros actualizados
        return i;
    }

    // Borrar una Nota
    public void deleteReporteFalla(MFalla falla) {

        // 1. Obtenemos una reference de la BD con permisos de escritura
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. Borramos el registro
        db.delete(MFallasDBDef.MFALLAS.TABLE_NAME,
                MFallasDBDef.MFALLAS.ID_FALLA_COL +" = ?",
                new String[] { String.valueOf(falla.getId_falla()) });

        // 3. Cerramos la conexión a la Bd
        db.close();
    }

    public int updateEstadoReporte(MFalla falla) {

        // 1. Obtenemos una reference de la BD con permisos de escritura
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. Creamos el objeto ContentValues con las claves "columna"/valor
        // que se desean actualizar
        ContentValues values = new ContentValues();

        values.put(MFallasDBDef.MFALLAS.ESTADO_COL, "0");

        // 3. Actualizamos el registro con el método update el cual devuelve la cantidad
        // de registros actualizados
        int i = db.update(MFallasDBDef.MFALLAS.TABLE_NAME, //table
                values, // column/value
                MFallasDBDef.MFALLAS.ID_FALLA_COL+" = ?", // selections
                new String[] { String.valueOf(falla.getId_falla()) }); //selection args

        // 4. Cerramos la conexión a la BD
        db.close();

        // Devolvemos la cantidad de registros actualizados
        return i;
    }


    public Usuario validarLogin(String l, String p){

        // 1. Aramos un String con el query a ejecutar
       /* String query =  "SELECT  * FROM " + InscampoDBDef.MUSUARIO.TABLE_NAME +
                        " WHERE " + InscampoDBDef.MUSUARIO.LOGIN_COL + " = " + l +
                        " AND " + InscampoDBDef.MUSUARIO.PASSWORD_COL + " = " + p;
*/
        // 2. Obtenemos una reference de la BD con permisos de escritura y ejecutamos el query
        SQLiteDatabase db = this.getWritableDatabase();

        String[] COLUMNS = {MFallasDBDef.MUSUARIO.ID_USUARIO_COL,
                MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL,
                MFallasDBDef.MUSUARIO.LOGIN_COL,
                MFallasDBDef.MUSUARIO.PASSWORD_COL};


        // 2. Contruimos el query
        Cursor cursor =
                db.query(MFallasDBDef.MUSUARIO.TABLE_NAME,  //Nomre de la tabla
                        COLUMNS, // b. Nombre de las Columnas
                        "login = ? AND password = ?", // c. Columnas de la clausula WHERE
                        new String[] { l,p }, // d. valores de las columnas de la clausula WHERE
                        null, // e. Clausula Group by
                        null, // f. Clausula having
                        null, // g. Clausula order by
                        null); // h. Limte de regsitros

        // 3. Iteramos entre cada uno de olos registros y agregarlos al array de Notas
        Usuario usu = null;
        if (cursor.moveToFirst()) {
            do {
                usu = new Usuario();
                usu.setId_usuario(Integer.parseInt(cursor.getString(0)));
                usu.setNombre_usuario(cursor.getString(1));
                usu.setLogin(cursor.getString(2));
                usu.setPassword(cursor.getString(3));

            } while (cursor.moveToNext());

        }

        //Cerramos el cursor
        cursor.close();

        // Devolvemos las notas encontradas o un array vacio en caso de que no se encuentre nada
        return usu;
    }

    // Obtener todas las notas
 /*   public List<Usuario> getAllUsuarios() {
        //Instanciamos un Array para llenarlo con todos los objetos Notes que saquemos de la BD
        List<Usuario> usus = new ArrayList<Usuario>();

        // 1. Aramos un String con el query a ejecutar
        String query = "SELECT  * FROM " + InscampoDBDef.MUSUARIO.TABLE_NAME;

        // 2. Obtenemos una reference de la BD con permisos de escritura y ejecutamos el query
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        // 3. Iteramos entre cada uno de olos registros y agregarlos al array de Notas
        Usuario usu = null;
        if (cursor.moveToFirst()) {
            do {
                usu = new Usuario();
                usu.setId_usuario(Integer.parseInt(cursor.getString(0)));
                usu.setNombre_usuario(cursor.getString(1));
                usu.setLogin(cursor.getString(2));
                usu.setPassword(cursor.getString(3));

                // Add book to books
                usus.add(usu);
            } while (cursor.moveToNext());

        }

        //Cerramos el cursor
        cursor.close();

        // Devolvemos las notas encontradas o un array vacio en caso de que no se encuentre nada
        return usus;
    }
*/
   /* public  int limpiarTabla(int id){

        List<Integer> ids = new ArrayList<Integer>();
        int id_tmp;

        // 1. Aramos un String con el query a ejecutar
        String query = "SELECT  id_reg_dat FROM " + InscampoDBDef.INSCAMPO.TABLE_NAME + " WHERE " + InscampoDBDef.INSCAMPO.ID_INSPECTOR_COL + " = " + id;

        // 2. Obtenemos una reference de la BD con permisos de escritura y ejecutamos el query
        SQLiteDatabase db = this.getWritableDatabase();

        // 1. Aramos un String con el query a ejecutar

        Cursor cursor = db.rawQuery(query, null);

        // 3. Iteramos entre cada uno de olos registros y agregarlos al array de Notas

        if (cursor.moveToFirst()) {

            do {
                ids.add(cursor.getInt(0));

            } while (cursor.moveToNext());

        }

        //Cerramos el cursor
        cursor.close();

        int values = db.delete(InscampoDBDef.INSCAMPO.TABLE_NAME, InscampoDBDef.INSCAMPO.ID_INSPECTOR_COL + "=" + id, null);

        //db.execSQL(query);
        db.close();

        return values;
    }*/



}
