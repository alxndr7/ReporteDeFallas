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
                MFallasDBDef.MUSUARIO.PASSWORD_COL+ " ) VALUES (1,'Administrador TI','administrador','@dm1n15tr4d0r')");
/*
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " (" +
                MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.LOGIN_COL + "," +
                MFallasDBDef.MUSUARIO.PASSWORD_COL+ " ) VALUES (1084,'ENRIQUE','eencalada','eencalada')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " (" +
                MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.LOGIN_COL + "," +
                MFallasDBDef.MUSUARIO.PASSWORD_COL+ " ) VALUES (1187,'JULIO','jbenavides','jbenavides')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " (" +
                MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.LOGIN_COL + "," +
                MFallasDBDef.MUSUARIO.PASSWORD_COL+ " ) VALUES (1828,'LUIS','lsalinas','lsalinas')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " (" +
                MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.LOGIN_COL + "," +
                MFallasDBDef.MUSUARIO.PASSWORD_COL+ " ) VALUES (4624,'ANYELA','aballon','aballon')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " (" +
                MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.LOGIN_COL + "," +
                MFallasDBDef.MUSUARIO.PASSWORD_COL+ " ) VALUES (2318,'EDGAR','ebegazo','ebegazo')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " (" +
                MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.LOGIN_COL + "," +
                MFallasDBDef.MUSUARIO.PASSWORD_COL+ " ) VALUES (4417,'JORGE','jbejarano','jbejarano')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " (" +
                MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.LOGIN_COL + "," +
                MFallasDBDef.MUSUARIO.PASSWORD_COL+ " ) VALUES (4594,'LUIS','lcajamarca','lcajamarca')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " (" +
                MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.LOGIN_COL + "," +
                MFallasDBDef.MUSUARIO.PASSWORD_COL+ " ) VALUES (4413,'MIGUEL','mcalderon','mcalderon')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " (" +
                MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.LOGIN_COL + "," +
                MFallasDBDef.MUSUARIO.PASSWORD_COL+ " ) VALUES (3951,'LUIS','lchavez','lchavez')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " (" +
                MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.LOGIN_COL + "," +
                MFallasDBDef.MUSUARIO.PASSWORD_COL+ " ) VALUES (2079,'CHRISTIAN','lcajamarca','lcajamarca')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " (" +
                MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.LOGIN_COL + "," +
                MFallasDBDef.MUSUARIO.PASSWORD_COL+ " ) VALUES (4266,'FRANKO','fgomez','fgomez')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " (" +
                MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.LOGIN_COL + "," +
                MFallasDBDef.MUSUARIO.PASSWORD_COL+ " ) VALUES (2079,'CHRISTIAN','lcajamarca','lcajamarca')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " (" +
                MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+"," +
                MFallasDBDef.MUSUARIO.LOGIN_COL + "," +
                MFallasDBDef.MUSUARIO.PASSWORD_COL+ " ) VALUES (2079,'CHRISTIAN','lcajamarca','lcajamarca')");
*/


      /*  db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1084,'ENRIQUE','eencalada','eencalada')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1187,'JULIO','jbenavides','jbenavides')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1828,'LUIS','lsalinas','lsalinas')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4624,'ANYELA','aballon','aballon')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (2318,'EDGAR','ebegazo','ebegazo')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4417,'JORGE','jbejarano','jbejarano')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4594,'LUIS','lcajamarca','lcajamarca')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4413,'MIGUEL','mcalderon','mcalderon')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3951,'LUIS','lchavez','lchavez')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (2079,'CHRISTIAN','ccollado','ccollado')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4266,'FRANKO','fgomez','fgomez')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4684,'JOHAN','jmedina','jmedina')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4139,'IRVIN ','iperochena','iperochena')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4359,'EFRAIN','eramos','eramos')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4452,'CARLOS','crodriguez','crodriguez')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4631,'PATRICIO','prodriguez','prodriguez')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4490,'HENRY','htorres','htorres')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3650,'JAVIER','jvicencio','jvicencio')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3309,'EDGAR','eyauri','eyauri')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4596,'MICKELL','mmaldonadof','mmaldonadof')");



        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1084,'ENRIQUE','eencalada','eencalada')");
*/


        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1084,'ENRIQUE','eencaladap','eencaladap')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1187,'JULIO','jbenavidesc','jbenavidesc')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1828,'LUIS','lsalinasc','lsalinasc')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4624,'ANYELA','aballonz','aballonz')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (2318,'EDGAR','ebegazor','ebegazor')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4417,'JORGE','jbejaranot','jbejaranot')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4594,'LUIS','lcajamarcae','lcajamarcae')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4413,'MIGUEL','mcalderonf','mcalderonf')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3951,'LUIS','lchavezv','lchavezv')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (2079,'CHRISTIAN','ccollados','ccollados')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4266,'FRANKO','fgomezk','fgomezk')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4684,'JOHAN','jmedinap','jmedinap')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4139,'IRVIN ','iperochenac','iperochenac')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4359,'EFRAIN','eramosc','eramosc')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4452,'CARLOS','crodriguezs','crodriguezs')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4631,'PATRICIO','prodriguezt','prodriguezt')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4490,'HENRY','htorresi','htorresi')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3650,'JAVIER','jvicencioa','jvicencioa')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3309,'EDGAR','eyaurim','eyaurim')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3813,'REYNALDO','rabalosq','rabalosq')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4478,'DANTE','daceror','daceror')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4727,'MARIO','malegres','malegres')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4492,'EDWUARD','eanticonad','eanticonad')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4424,'ABELINO','abancess','abancess')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4476,'JOSE','jbandas','jbandas')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4481,'OSCAR ','obarriosr','obarriosr')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4405,'JAVIER','jcabrerap','jcabrerap')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4723,'DAVID','dcarrascoq','dcarrascoq')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4645,'WASHINGTON','wccahuanal','wccahuanal')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4873,'JOHNNY','jcentenom','jcentenom')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4724,'IVAN','ichavezm','ichavezm')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4555,'GEREMY','gchavezs','gchavezs')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4507,'DERLIS','dchavezt','dchavezt')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4871,'ESTUARDO','echerop','echerop')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4642,'DARIO','dchevarriad','dchevarriad')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1647,'LUISALBERTO','lchicatam','lchicatam')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3965,'JUAN','jchileq','jchileq')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1833,'PERCY','pchipanab','pchipanab')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4861,'VICTOR','vchipanai','vchipanai')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4371,'MIGUEL','mcohatam','mcohatam')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4755,'OSCAR','ocondorir','ocondorir')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4722,'CHRISTIAN','ccondoriv','ccondoriv')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3913,'JONATHAN','jcordovag','jcordovag')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3764,'TITO','tcortezz','tcortezz')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1058,'RODOLFO','rcubaa','rcubaa')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4357,'JORGE','jcubasv','jcubasv')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4360,'RONY','rcuevac','rcuevac')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4725,'MANUEL','mcuevae','mcuevae')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4486,'JOSUE','jdagaa','jdagaa')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4356,'JUAN','jdelcarpiop','jdelcarpiop')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4644,'FERNANDO','fdelgadoc','fdelgadoc')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3655,'JORGE ','jdelgadon','jdelgadon')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4494,'ELMER','edelgadoq','edelgadoq')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4401,'ANGEL','adelgados','adelgados')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4833,'JHOAN','jdelgados','jdelgados')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4893,'MIGUEL','mdiazd','mdiazd')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4435,'CARLOS','cdiazs','cdiazs')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4274,'CARLOS','cechevarriat','cechevarriat')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4473,'WILFREDO','wescobart','wescobart')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4876,'CESAR','cfernandezr','cfernandezr')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4403,'JUAN','jfernandezg','jfernandezg')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4409,'EDGAR','efernandezd','efernandezd')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4475,'RICHARD','rgonzalesb','rgonzalesb')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4358,'JHON','jguillent','jguillent')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4528,'MARCO','mhuarocv','mhuarocv')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1451,'WALTER','whuayhuasr','whuayhuasr')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4361,'JULIO','jhuertasm','jhuertasm')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4433,'JUAN','jinquillac','jinquillac')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4882,'MELVIN','mjaicov','mjaicov')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4354,'JULIO','jlagunab','jlagunab')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4256,'RICARDO','rlaymem','rlaymem')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4531,'RODOLFO','rlimachea','rlimachea')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4209,'MELQUIADEZ','mlupac','mlupac')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4257,'JONEL','jmacedor','jmacedor')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4647,'RICHART','rmaytah','rmaytah')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1112,'ANTONIO','amessar','amessar')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4493,'FRANKLIN','fmiranop','fmiranop')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4886,'JESUS','jmolinaz','jmolinaz')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4294,'ROGERS','rmontoyag','rmontoyag')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4562,'GIANCARLO','gmoralesc','gmoralesc')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4843,'WILLY','wmuñozc','wmuñozc')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4399,'CARLOS','cnavarretev','cnavarretev')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4677,'FORTUNATO ','fninaraquim','fninaraquim')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (2322,'WASHINGTON','wnoac','wnoac')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4130,'ALEX','aochoac','aochoac')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4421,'JONATHAN','jojedat','jojedat')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4480,'WILMER','wpacherresg','wpacherresg')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4483,'EDWIN','epajaresa','epajaresa')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4721,'JUAN','jpancorboh','jpancorboh')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4500,'JORGE','jparedesc','jparedesc')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4427,'JOE','jpaskualm','jpaskualm')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4479,'MARCO','mpaucara','mpaucara')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4830,'EDWIN','epelincop','epelincop')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4665,'ANDY','aperaltav','aperaltav')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4836,'JHON','jperezg','jperezg')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1072,'PEDRO','ppintoh','ppintoh')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4726,'ARTURO','apintor','apintor')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4437,'LUIS','lportab','lportab')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4482,'CHARLIE','cportillap','cportillap')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4364,'LUIS','lportugalp','lportugalp')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4484,'CARLOS ','cpostigoa','cpostigoa')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4869,'YOSIMAR','ypumat','ypumat')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4654,'ALBERTO','aquispec','aquispec')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4657,'DARWIN','dquispel','dquispel')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4650,'ENRIQUE','equispem','equispem')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3824,'RENSO','rquispesivanaa','rquispesivanaa')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4363,'MIGUEL ','mrodriguezc','mrodriguezc')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3733,'DENNYS ','drodriguezs','drodriguezs')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4731,'HOLGER','hsalasm','hsalasm')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3929,'PERCY','psalazarq','psalazarq')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4474,'EDWIN','esalazars','esalazars')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4881,'JUAN','jsalazars','jsalazars')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4872,'CESAR','csammillany','csammillany')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4297,'YVAN','ysanchezh','ysanchezh')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1214,'MOISES','msanchezq','msanchezq')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4901,'RUDY','rsonccom','rsonccom')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3713,'JHOEL','jsoncoc','jsoncoc')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4666,'ARTURO','asotelop','asotelop')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4362,'ALVARO ','asotomayorp','asotomayorp')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3766,'RIVELINO','rticonac','rticonac')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4565,'YGNACIO','ytisnadoq','ytisnadoq')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4904,'JORGE','jtorresg','jtorresg')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4566,'ELSON','ettitoc','ettitoc')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4489,'ABNER ','aurdayb','aurdayb')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4530,'NOE','nvalderramah','nvalderramah')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4874,'ERICK','evaldiviac','evaldiviac')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3808,'JULIO','jvaldiviao','jvaldiviao')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3720,'CELSO','cvargasr','cvargasr')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1272,'CESAR','cvergarayf','cvergarayf')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1191,'MARCO','mvilchezp','mvilchezp')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1758,'ADRIEL','awilsonv','awilsonv')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (1680,'PERCY','pyanapac','pyanapac')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4529,'EDGARD','eyanquih','eyanquih')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4275,'JORGE','jzegarrac','jzegarrac')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (3932,'OSMAR ','ozegarrah','ozegarrah')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4695,'HIPOLITO','hzentenoc','hzentenoc')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4902,'JONATHAN','jzunigac','jzunigac')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4651,'EMILIO','egarciap','egarciap')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MUSUARIO.TABLE_NAME + " ( "+ MFallasDBDef.MUSUARIO.ID_USUARIO_COL+"," +  MFallasDBDef.MUSUARIO.NOMBRE_USUARIO_COL+","+  MFallasDBDef.MUSUARIO.LOGIN_COL + ","+ MFallasDBDef.MUSUARIO.PASSWORD_COL+ ") VALUES (4596,'MICKELL','mmaldonadof','mmaldonadof')");





         /*db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (1,'REPORTE sync 1','2018-04-02','11:10',0,1084,2,'TRANSALTISA')");
       db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (2,'REPORTE sync 2','2018-04-02','11:15',1,1084,'TRANSALTISA')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (3,'REPORTE 3','16-03-2018','16:14',1,1187,'2','TRANSALTISA')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (4,'REPORTE 4','16-03-2018','16:14',1,1187,'0','TRANSALTISA')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (5,'REPORTE 5','16-03-2018','16:14',1,1187,'2','TRANSALTISA')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (6,'REPORTE 6','16-03-2018','16:14',1,1187,'2','TRANSALTISA')");

        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (7,'REPORTE 7','16-03-2018','16:14',1,1187,'2','TRANSALTISA')");

        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (8,'REPORTE 8','16-03-2018','16:14',1,1187,'2','TRANSALTISA')");

        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (9,'REPORTE 9','16-03-2018','16:14',1,1187,'2','TRANSALTISA')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (10,'REPORTE 10','16-03-2018','16:14',1,1187,'2','TRANSALTISA')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (11,'REPORTE 11','16-03-2018','16:14',1,1187,'2','TRANSALTISA')");

        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (12,'REPORTE 12','16-03-2018','16:14',1,1187,'2','TRANSALTISA')");

        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (13,'REPORTE 13','16-03-2018','16:14',1,1187,'2','TRANSALTISA')");

        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (14,'REPORTE 14','16-03-2018','16:14',1,1187,'2','TRANSALTISA')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (15,'REPORTE 15','16-03-2018','16:14',1,1187,'2','TRANSALTISA')");
        db.execSQL("INSERT INTO " + MFallasDBDef.MFALLAS.TABLE_NAME + " (" +
                MFallasDBDef.MFALLAS.ID_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.TITULO_COL+"," +
                MFallasDBDef.MFALLAS.FECHA_FALLA_COL+"," +
                MFallasDBDef.MFALLAS.HORA_FALLA_COL + "," +
                MFallasDBDef.MFALLAS.ESTADO_COL+ "," +
                MFallasDBDef.MFALLAS.ID_USUARIO_COL+ "," +
                MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL+ "," +
                MFallasDBDef.MFALLAS.EMPRESA_COL+ " ) VALUES (16,'REPORTE 16','16-03-2018','16:14',1,1187,'2','TRANSALTISA')");

        Log.d("ONCREATE","ONCREATE HELPER");*/
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

    public void insertReporte(MFalla falla){
        //Con este método insertamos las notas nuevas que el usuario vaya creando

        // 1. Obtenemos una reference de la BD con permisos de escritura
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. Creamos un obejto de tipo ContentValues para agregar los pares
        // de Claves de Columna y Valor
        ContentValues values = new ContentValues();
        values.put(MFallasDBDef.MFALLAS.TITULO_COL, falla.getTitulo());
        values.put(MFallasDBDef.MFALLAS.FECHA_FALLA_COL, falla.getFecha_falla());
        values.put(MFallasDBDef.MFALLAS.HORA_FALLA_COL, falla.getHora_falla());
        values.put(MFallasDBDef.MFALLAS.RUTA_COL, falla.getRuta());
        values.put(MFallasDBDef.MFALLAS.EMPRESA_COL, falla.getEmpresa());
        values.put(MFallasDBDef.MFALLAS.FLOTA_COL, falla.getFlota());
        values.put(MFallasDBDef.MFALLAS.CONVOY_COL, falla.getConvoy());
        values.put(MFallasDBDef.MFALLAS.PLACA_TRACTO_COL, falla.getPlaca_tracto());
        values.put(MFallasDBDef.MFALLAS.PLACA_CARRETA_COL, falla.getPlaca_carreta());
        values.put(MFallasDBDef.MFALLAS.KILOMETRAJE_COL, falla.getKilometraje());
        values.put(MFallasDBDef.MFALLAS.UBICACION_COL, falla.getUbicacion());
        values.put(MFallasDBDef.MFALLAS.DESCRIPCION_FALLA_COL, falla.getDescripcion_falla());
        values.put(MFallasDBDef.MFALLAS.ID_USUARIO_COL, falla.getId_usuario());
        values.put(MFallasDBDef.MFALLAS.ESTADO_COL, falla.getEstado());
        values.put(MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL, falla.getEstado_envio());

        // 3. Insertamos los datos en la tabla "notes"
        db.insert(MFallasDBDef.MFALLAS.TABLE_NAME, null, values);

        // 4. Cerramos la conexión comn la BD
        db.close();
    }

    //Obtener uan Nota dado un ID
    public MFalla getReportePorId(int id){
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
                MFallasDBDef.MFALLAS.RUTA_COL,
                MFallasDBDef.MFALLAS.EMPRESA_COL,
                MFallasDBDef.MFALLAS.FLOTA_COL,
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
            falla.setRuta(cursor.getString(4));
            falla.setEmpresa(cursor.getString(5));
            falla.setFlota(cursor.getString(6));
            falla.setConvoy(cursor.getString(7));
            falla.setPlaca_tracto(cursor.getString(8));
            falla.setPlaca_carreta(cursor.getString(9));
            falla.setKilometraje(cursor.getString(10));
            falla.setUbicacion(cursor.getString(11));
            falla.setDescripcion_falla(cursor.getString(12));
            falla.setId_usuario(cursor.getString(13));
            falla.setEstado(cursor.getString(14));
        }

        // 5. Devolvemos le objeto Inscampo
        return falla;
    }

    // Obtener todas las notas
    public List<MFalla> getAllReportes(String id_usuario) {
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
            query = "SELECT  * FROM " + MFallasDBDef.MFALLAS.TABLE_NAME + " WHERE "+ MFallasDBDef.MFALLAS.ID_USUARIO_COL + " = " + id_usuario + " AND " + MFallasDBDef.MFALLAS.ESTADO_COL + " = 1" + " AND " + MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL + " = 0";
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
                falla.setRuta(cursor.getString(4));
                falla.setEmpresa(cursor.getString(5));
                falla.setFlota(cursor.getString(6));
                falla.setConvoy(cursor.getString(7));
                falla.setPlaca_tracto(cursor.getString(8));
                falla.setPlaca_carreta(cursor.getString(9));
                falla.setKilometraje(cursor.getString(10));
                falla.setUbicacion(cursor.getString(11));
                falla.setDescripcion_falla(cursor.getString(12));
                falla.setId_usuario(cursor.getString(13));
                falla.setEstado(cursor.getString(14));
                falla.setEstado_envio(cursor.getString(15));
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

    public List<MFalla> getAllReportesEnv(String id_usuario) {
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
            query = "SELECT  * FROM " + MFallasDBDef.MFALLAS.TABLE_NAME + " WHERE "+ MFallasDBDef.MFALLAS.ID_USUARIO_COL + " = " + id_usuario + " AND " + MFallasDBDef.MFALLAS.ESTADO_COL + " = 1" + " AND " + MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL + " IN(1,2)";
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
                falla.setRuta(cursor.getString(4));
                falla.setEmpresa(cursor.getString(5));
                falla.setFlota(cursor.getString(6));
                falla.setConvoy(cursor.getString(7));
                falla.setPlaca_tracto(cursor.getString(8));
                falla.setPlaca_carreta(cursor.getString(9));
                falla.setKilometraje(cursor.getString(10));
                falla.setUbicacion(cursor.getString(11));
                falla.setDescripcion_falla(cursor.getString(12));
                falla.setId_usuario(cursor.getString(13));
                falla.setEstado(cursor.getString(14));
                falla.setEstado_envio(cursor.getString(15));
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


    public List<MFalla> getAllReportesPorEnviar() {
        //Instanciamos un Array para llenarlo con todos los objetos Notes que saquemos de la BD
        List<MFalla> listFallas = new ArrayList<MFalla>();
        String query;
        query = "SELECT  * FROM " + MFallasDBDef.MFALLAS.TABLE_NAME + " WHERE " + MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL + " = 1";

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
                falla.setRuta(cursor.getString(4));
                falla.setEmpresa(cursor.getString(5));
                falla.setFlota(cursor.getString(6));
                falla.setConvoy(cursor.getString(7));
                falla.setPlaca_tracto(cursor.getString(8));
                falla.setPlaca_carreta(cursor.getString(9));
                falla.setKilometraje(cursor.getString(10));
                falla.setUbicacion(cursor.getString(11));
                falla.setDescripcion_falla(cursor.getString(12));
                falla.setId_usuario(cursor.getString(13));
                falla.setEstado(cursor.getString(14));
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

    public Integer getCountReportesPorEnviar() {
        //Instanciamos un Array para llenarlo con todos los objetos Notes que saquemos de la BD
        Integer countRepPorEnv = 0;
        String query;
        query = "SELECT  count(*) FROM " + MFallasDBDef.MFALLAS.TABLE_NAME + " WHERE " + MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL + " = 1 AND " + MFallasDBDef.MFALLAS.ESTADO_COL + " = 1";

        // 2. Obtenemos una reference de la BD con permisos de escritura y ejecutamos el query
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);


        // 3. Iteramos entre cada uno de olos registros y agregarlos al array de Notas
        MFalla falla = null;
        if (cursor.moveToFirst()) {
            do {
                falla = new MFalla();
                countRepPorEnv = Integer.parseInt(cursor.getString(0));

            } while (cursor.moveToNext());

            Log.i("MyActivity", " 4 helper " );
        }

        //Cerramos el cursor
        cursor.close();

        // Devolvemos las notas encontradas o un array vacio en caso de que no se encuentre nada
        return countRepPorEnv;
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
        values.put(MFallasDBDef.MFALLAS.RUTA_COL, falla.getRuta());
        values.put(MFallasDBDef.MFALLAS.EMPRESA_COL, falla.getEmpresa());
        values.put(MFallasDBDef.MFALLAS.FLOTA_COL, falla.getFlota());
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

    public int setEstadoEnviado(MFalla falla) {

        // 1. Obtenemos una reference de la BD con permisos de escritura
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. Creamos el objeto ContentValues con las claves "columna"/valor
        // que se desean actualizar
        ContentValues values = new ContentValues();

        values.put(MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL, "2");

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


    public int updateEstadoEnvioReporte(MFalla falla) {

        // 1. Obtenemos una reference de la BD con permisos de escritura
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. Creamos el objeto ContentValues con las claves "columna"/valor
        // que se desean actualizar
        ContentValues values = new ContentValues();

        values.put(MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL, "1");

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

    public int updateEstadoReporteEnviado(MFalla falla) {

        // 1. Obtenemos una reference de la BD con permisos de escritura
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. Creamos el objeto ContentValues con las claves "columna"/valor
        // que se desean actualizar
        ContentValues values = new ContentValues();

        values.put(MFallasDBDef.MFALLAS.ESTADO_ENVIO_COL, "2");

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
