package bsu.bsit3fg1.inksight_v4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

    public class SQLiteDBHelper extends SQLiteOpenHelper {


        private static String DATABASE_NAME = "MyDatabase.db";
        private static int VERSION = 2;
        Context context;

        public SQLiteDBHelper(Context context) {
            super(context, DATABASE_NAME, null, VERSION);
            this.context = context;
            SQLiteDatabase db = this.getWritableDatabase();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            final String CREATE_USER_TABLE = "CREATE TABLE `"+DB_Contract.User.USER_TABLE+"` (" +
                    "`"+DB_Contract.User.ID+"` INTEGER PRIMARY KEY," +
                    "`"+DB_Contract.User.COMPLETE_NAME+"` TEXT NOT NULL," +
                    "`"+DB_Contract.User.USERNAME+"` TEXT NOT NULL," +
                    "`"+DB_Contract.User.PASSWORD+"` TEXT NOT NULL," +
                    "`"+DB_Contract.User.BIRTHDAY+"` DATE," +
                    "`"+DB_Contract.User.ADDRESS+"` TEXT," +
                    " UNIQUE (`"+DB_Contract.User.ID+"`) ON CONFLICT ABORT);";

            final String CREATE_POST_TABLE = "CREATE TABLE `"+DB_Contract.Post.POST_TABLE+"` (" +
                    "`"+DB_Contract.Post.ID+"` INTEGER PRIMARY KEY," +
                    "`"+DB_Contract.Post.USER_ID+"` INTEGER NOT NULL," +
                    "`"+DB_Contract.Post.TEXT+"` TEXT NOT NULL," +
                    "`"+DB_Contract.Post.DATE+"` DATE," +
                    " FOREIGN KEY (`"+DB_Contract.Post.USER_ID+"`) REFERENCES " +
                    " `"+DB_Contract.User.USER_TABLE+"`(`"+DB_Contract.User.ID+"`)," +
                    " UNIQUE (`"+DB_Contract.Post.ID+"`) ON CONFLICT ABORT);";

            try {
                db.execSQL(CREATE_USER_TABLE);
                Toast.makeText(context, "Table User Created.", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                db.execSQL(CREATE_POST_TABLE);
                Toast.makeText(context, "Table Post Created.", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            final String DROP_USER_TABLE = "DROP TABLE IF EXISTS "+DB_Contract.User.USER_TABLE;
            final String DROP_POST_TABLE = "DROP TABLE IF EXISTS "+DB_Contract.Post.POST_TABLE;
            db.execSQL(DROP_USER_TABLE);
            db.execSQL(DROP_POST_TABLE);
            onCreate(db);
        }

        public boolean insertUser(String name, String username, String password,
                                  String birthday, String address){
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(DB_Contract.User.COMPLETE_NAME,name);
            values.put(DB_Contract.User.USERNAME,username);
            values.put(DB_Contract.User.PASSWORD,password);
            values.put(DB_Contract.User.BIRTHDAY,birthday);
            values.put(DB_Contract.User.ADDRESS,address);

            long result = db.insert(DB_Contract.User.USER_TABLE,null,values);
            if(result==-1){
                return false;
            }else{
                return true;
            }
        }

        public Cursor selectAllUser(){
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor result = db.query(DB_Contract.User.USER_TABLE,null,null,null,
                    null,null,null);
            return result;
        }

        public Cursor selectUserByIDandName(String ID, String name){
            SQLiteDatabase db = this.getReadableDatabase();
            //Column
            String[] columns = {
                    DB_Contract.User.ID,
                    DB_Contract.User.COMPLETE_NAME,
                    DB_Contract.User.USERNAME,
                    DB_Contract.User.PASSWORD,
                    DB_Contract.User.BIRTHDAY,
                    DB_Contract.User.ADDRESS,
            };

            //Filters Selection and SelectionARgs: WHERE `ID` = 1 AND `name` LIKE `%anna%`
            String selection = DB_Contract.User.ID + " = ? OR "+
                    DB_Contract.User.COMPLETE_NAME +" LIKE ? ";
            String[] selectionArgs = {ID,"'%"+name+"%'"};

            //Sort
            String orderBy = DB_Contract.User.ID + " DESC";

            Cursor result = db.query(DB_Contract.User.USER_TABLE,columns,selection,selectionArgs,
                    null,null,orderBy);
            return result;
        }

        public boolean updateUser(String ID, String name, String username, String password,
                                  String birthday, String address){
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(DB_Contract.User.COMPLETE_NAME,name);
            values.put(DB_Contract.User.USERNAME,username);
            values.put(DB_Contract.User.PASSWORD,password);
            values.put(DB_Contract.User.BIRTHDAY,birthday);
            values.put(DB_Contract.User.ADDRESS,address);

            String selection = DB_Contract.User.ID + " = ?";
            String[] selectionArgs = {ID};

            int affected = db.update(DB_Contract.User.USER_TABLE,values,selection,selectionArgs);
            if(affected>0){
                return true;
            }else{
                return false;
            }

        }

        public boolean deleteUser(String ID){
            SQLiteDatabase db = this.getWritableDatabase();

            String selection = DB_Contract.User.ID + " = ?";
            String[] selectionArgs = {ID};

            int affected = db.delete(DB_Contract.User.USER_TABLE,selection,selectionArgs);
            if(affected>0){
                return true;
            }else{
                return false;
            }
        }

        public ArrayList<String> fetchDataFromDatabase() {
            ArrayList<String> allData = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM " + DB_Contract.User.USER_TABLE, null);

            if (cursor.moveToFirst()) {
                do {
                    // Extract data from the cursor and add it to the list
                    String data = "ID: " + cursor.getString(0) +
                            ", Name: " + cursor.getString(1) +
                            ", Username: " + cursor.getString(2) +
                            ", Password: " + cursor.getString(3) +
                            ", Birthday: " + cursor.getString(4) +
                            ", Address: " + cursor.getString(5);
                    allData.add(data);
                } while (cursor.moveToNext());
            }

            cursor.close();
            return allData;
        }

        public Cursor selectUserByID(String id) {
            SQLiteDatabase db = this.getReadableDatabase();
            String[] columns = {
                    DB_Contract.User.ID,
                    DB_Contract.User.COMPLETE_NAME,
                    DB_Contract.User.USERNAME,
                    DB_Contract.User.PASSWORD,
                    DB_Contract.User.BIRTHDAY,
                    DB_Contract.User.ADDRESS
            };
            String selection = DB_Contract.User.ID + " = ?";
            String[] selectionArgs = {id}; // Change ID to id
            return db.query(DB_Contract.User.USER_TABLE, columns, selection, selectionArgs, null, null, null);

        }


        public boolean restoreUser(String selectedID) {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(DB_Contract.User.ID, selectedID);

            long result = db.insertWithOnConflict(DB_Contract.User.USER_TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);
            return result != -1;
        }

        public Cursor getAllArchivedUsers() {
            SQLiteDatabase db = this.getReadableDatabase();
            String[] columns = null; // Retrieve all columns
            String selection = DB_Contract.User.ARCHIVED + " = ?";
            String[] selectionArgs = {"1"}; // Assuming "ARCHIVED" is a column indicating whether a user is archived (1) or not (0)
            return db.query(DB_Contract.User.USER_TABLE, columns, selection, selectionArgs, null, null, null);
        }

    }