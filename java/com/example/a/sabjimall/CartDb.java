package com.example.a.sabjimall;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a.sabjimall.Adapter.FruitAdapter;
import com.example.a.sabjimall.models.Fruit;
import com.example.a.sabjimall.models.Fruits;

import java.util.ArrayList;
import java.util.List;

public class CartDb extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "CartItem2";

    // Contacts table name
    private static final String TABLE_CART = "carts";
    private static final String TAG = "DatabaseHandler";
    // Contacts Table Columns names

    private static final String KEY_ID = "id";
     private static final String KEY_PNAME = "pname";
    private static final String KEY_PRICE= "price";
    private static final String KEY_PQNT = "pqnt";
    private static final String KEY_PHOTO = "photo";
    private static final String KEY_ADDQNT = "photo";


    public CartDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Create tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_CONTACTS = "CREATE TABLE " + TABLE_CART + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_PNAME + " TEXT,"
                + KEY_PRICE + " TEXT,"
                + KEY_PQNT + " TEXT,"
                + KEY_ADDQNT + " TEXT" + ")";

        db.execSQL(CREATE_TABLE_CONTACTS);


    }


    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    //Insert values to the table contacts
    public void addIntoCart(Fruit fruit){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_PNAME,fruit.getPname());
        values.put(KEY_PRICE, fruit.getPrice());
        values.put(KEY_PQNT, fruit.getPqnt());
        values.put(KEY_ADDQNT,  fruit.getAddqnt());


        db.insert(TABLE_CART, null, values);
        db.close();
    }



  /*  public List<String> getAllData() {
        //select _id,Name,Card,Code
        SQLiteDatabase db = this.getWritableDatabase();
      List<String> list=new ArrayList<>();
        String[] columns = {KEY_PNAME, KEY_PRICE,KEY_PQNT, KEY_ADDQNT};
        Cursor cursor = db.query(TABLE_CART, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int index1 = cursor.getColumnIndex(KEY_PNAME);
            int index2 = cursor.getColumnIndex(KEY_PRICE);
            int index3 = cursor.getColumnIndex(KEY_PQNT);
            int index4 = cursor.getColumnIndex(KEY_ADDQNT);


            String cid = cursor.getString(index1);
            String name = cursor.getString(index2);
            String card = cursor.getString(index3);
            String code = cursor.getString(index4);

            list.add(cid);
            list.add(name);
            list.add(card);
            list.add(code);

            //buffer.append(cid + " " + name + " " + card + " " + code + "\n");
        }
        return list;

    }
*/

    /**
     *Getting All Contacts
     **/

   public List<Fruit> getAllContacts() {
        List<Fruit> fruitsList = new ArrayList<Fruit>();
        // Select All Query
        // String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor = db.rawQuery(selectQuery, null);
        Cursor cursor =db.query(true, TABLE_CART, new String[] { KEY_ID,
                        KEY_PNAME,KEY_PRICE,KEY_PQNT,KEY_ADDQNT}, null, null,
                null, null, null, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Fruit fruits = new Fruit();
                fruits.setI(Integer.parseInt(cursor.getString(0)));

                fruits.setPname(cursor.getString(1));
                fruits.setPrice(cursor.getString(2));
                fruits.setPqnt(cursor.getString(3));
                fruits.setAddqnt(cursor.getString(4));


                fruitsList.add(fruits);
            } while (cursor.moveToNext());
        }

        // return contact list
        return fruitsList;
    }

  /*  public List<Contact> getAllContact(int id) {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        // String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor = db.rawQuery(selectQuery, null);
        Cursor cursor =db.query(true, TABLE_CONTACTS, new String[] {KEY_I,KEY_ID,
                        KEY_PID,KEY_POTO}, KEY_ID + "=" + id, null,
                null, null, null, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setI(Integer.parseInt(cursor.getString(0)));
                contact.setID(Integer.parseInt(cursor.getString(1)));
                contact.setPID(cursor.getString(2));
                // contact.setFName(cursor.getString(3));
                contact.setImage(cursor.getBlob(3));

                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

*/
    public void deleteProduct(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CART, KEY_PNAME + " = ?",
                new String[] { name });
        db.close();
    }
/*
    public int getCount() {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        // String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor = db.rawQuery(selectQuery, null);
        Cursor cursor =db.query(true, TABLE_CONTACTS, new String[] {KEY_I,KEY_ID,
                        KEY_PID,KEY_POTO}, null, null,
                null, null, null, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setI(Integer.parseInt(cursor.getString(0)));
                contact.setID(Integer.parseInt(cursor.getString(1)));
                contact.setPID(cursor.getString(2));
                // contact.setFName(cursor.getString(3));
                contact.setImage(cursor.getBlob(3));

                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        int cnt;
        cnt=cursor.getCount();
        // return contact list
        return cnt;
    }*/
}
