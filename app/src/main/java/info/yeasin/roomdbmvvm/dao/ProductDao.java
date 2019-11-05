package info.yeasin.roomdbmvvm.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import info.yeasin.roomdbmvvm.view.ui.note.Product;

import java.util.List;

@Dao
public interface ProductDao {
    @Insert
    void insert(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);

    @Query("DELETE FROM product_table")
    void  deleteAllNotes();

    @Query("SELECT * FROM product_table ORDER BY priority DESC")
    LiveData<List<Product>> getAllNotes();

}
