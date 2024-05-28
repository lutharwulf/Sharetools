package com.example.sharetools;

//https://www.geeksforgeeks.org/how-to-save-data-to-the-firebase-realtime-database-in-android/


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class DatabaseManager {

    /*private static final String DATABASE_NAME = "Game.db";
    private static final int DATABASE_VERSION = 2;

    public DatabaseManager(Context context ) {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSql = "create table T_Scores ("
                + "    idScore integer primary key autoincrement,"
                + "    name text not null,"
                + "    score integer not null,"
                + "    when_ integer not null"
                + ")";
        db.execSQL( strSql );
        Log.i( "DATABASE", "onCreate invoked" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //String strSql = "alter table T_Scores add column ...";
        String strSql = "drop table T_Scores";
        db.execSQL( strSql );
        this.onCreate( db );
        Log.i( "DATABASE", "onUpgrade invoked" );
    }

    public void insertScore( String name, int score ) {
        name = name.replace( "'", "''" );
        String strSql = "insert into T_Scores (name, score, when_) values ('"
                + name + "', " + score + ", " + new Date().getTime() + ")";
        this.getWritableDatabase().execSQL( strSql );
        Log.i( "DATABASE", "insertScore invoked" );
    }*/

    /*public List<Outils> readTop10() {
        List<Outils> scores = new ArrayList<>();

        // 1ère technique : SQL
        //String strSql = "select * from T_Scores order by score desc limit 10";
        //Cursor cursor = this.getReadableDatabase().rawQuery( strSql, null );

        // 2nd technique "plus objet"
        Cursor cursor = this.getReadableDatabase().query( "T_Scores",
                new String[] { "idScore", "name", "score", "when_" },
                null, null, null, null, "score desc", "10" );
        cursor.moveToFirst();
        while( ! cursor.isAfterLast() ) {
            Outils score = new Outils( cursor.getInt( 0 ), cursor.getString( 1 ),
                    cursor.getInt( 2 ), new Date( cursor.getLong( 3 ) ) );
            scores.add( score );
            cursor.moveToNext();
        }
        cursor.close();

        return scores;
    }*/



    /*
    //Tentative ajout outils dans firebase
    public static void writeNewOutils() {
        database.getReference().child("annonces").child("users").child("0001").child("users_annonces").setValue("nom_outils:marteau");
    }*/




    public static void addDatatoFirebase(String name, String descr) {
        // creating a variable for our Firebase Database.
        FirebaseDatabase database;

        // creating a variable for our Database Reference for Firebase.
        DatabaseReference databaseReference;
        // below 3 lines of code is used to set
        // data in our object class.
        //Outils outils = new Outils(name, descr, Calendar.getInstance().getTime());
        //outils.setNomOutils(name);
        //outils.setDescroutils(descr);
        //employeeInfo.setEmployeeAddress(address);

        // we are use add value event listener method
        // which is called with database reference.
        database = FirebaseDatabase.getInstance("https://ussi26-dev-mobile-default-rtdb.europe-west1.firebasedatabase.app/");

        databaseReference = database.getReference("annonces");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.

                databaseReference.child("users").child("user_test").child("nom_outils").setValue(name);
                databaseReference.child("users").child("user_test").child("descr_outils").setValue(descr);

                //databaseReference.child("users").child("user_test2").setValue(outils);

                // after adding this data we are showing toast message.
                //Toast.makeText(DatabaseManager.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                //Toast.makeText(getContext(), "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }



}
