package info.yeasin.roomdbmvvm.dao;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import info.yeasin.roomdbmvvm.view.ui.note.Product;

@Database(entities =  {Product.class},version = 1)
public abstract class ProductDatabase extends RoomDatabase {
    private static ProductDatabase instance;

    public abstract ProductDao productDao();

    public static synchronized ProductDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), ProductDatabase.class,"product_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };


}
