package com.example.pruebamarketmix.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.pruebamarketmix.utils.Constants;

import java.sql.SQLData;
import java.util.List;

public class ManageSQLiteDB {

    private SQLiteDatabase db;
    private SqlOpenHelperConection sqlC;
    private Context contex;

    public ManageSQLiteDB() {
        MakeConecction();
    }

    public ManageSQLiteDB(Context contex) {
        this.contex = contex;
        MakeConecction();
    }

    public Context getContex() {
        return contex;
    }

    public void setContex(Context contex) {
        this.contex = contex;
    }

    private void MakeConecction(){
        sqlC = new SqlOpenHelperConection(contex,"Shoping_DB",null, 1);
        db = sqlC.getWritableDatabase();

    }

    public void closeCoMakeConecction(){
        db.close();
    }
    public void OpenCoMakeConecction(){
       MakeConecction();
    }

   public boolean addTable(String tableName, List<Object> data){
       switch (tableName){
           case Constants.SHOPINGCAR_TABLE:
               return addTableShopingCar(data);
       }
       return false;
   }

    private boolean addTableShopingCar(List<Object> data) {
       boolean response = false;
        ContentValues values = new ContentValues();
        values.put(Constants.SHOPINGCAR_TABLE_FIELD_IDS, (Integer) data.get(0));
        values.put(Constants.SHOPINGCAR_TABLE_FIELD_IDAS, (String) data.get(1));
        db.insert(Constants.SHOPINGCAR_TABLE, Constants.SHOPINGCAR_TABLE_FIELD_IDS, values);
        response = true;
       return response;
    }


}

