package info.yeasin.roomdbmvvm.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import info.yeasin.roomdbmvvm.dao.ProductDao;
import info.yeasin.roomdbmvvm.view.ui.note.Product;
import info.yeasin.roomdbmvvm.dao.ProductDatabase;

import java.util.List;

public class ProductRepository {
    private ProductDao productDao;
    private LiveData<List<Product>>allNotes;


    public ProductRepository(Application application){
        ProductDatabase database = ProductDatabase.getInstance(application);
        productDao = database.productDao();
        allNotes = productDao.getAllNotes();
    }


    public void insert(Product product){
        new InsertNoteAsyncTask(productDao).execute(product);

    }
    public  void delete(Product product){
        new DeleteNoteAsyncTask(productDao).execute(product);

    }
    public  void update(Product product){
        new UpdateNoteAsyncTask(productDao).execute(product);

    }
    public void deleteAllNotes(){
        new DeleteAllNoteAsyncTask(productDao).execute();

    }
    public LiveData<List<Product>> getAllNotes(){
        return allNotes;

    }
    private static  class  InsertNoteAsyncTask extends AsyncTask<Product,Void,Void >{
        private ProductDao productDao;
        private InsertNoteAsyncTask(ProductDao productDao){
            this.productDao = productDao;

        }

        @Override
        protected Void doInBackground(Product... products) {
          productDao.insert(products[0]);
            return null;
        }
    }


    private static  class  UpdateNoteAsyncTask extends AsyncTask<Product,Void,Void >{
        private ProductDao productDao;
        private UpdateNoteAsyncTask(ProductDao productDao){
            this.productDao = productDao;

        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.insert(products[0]);
            return null;
        }
    }


    private static  class DeleteNoteAsyncTask extends AsyncTask<Product,Void,Void >{
        private ProductDao productDao;
        private DeleteNoteAsyncTask(ProductDao productDao){
            this.productDao = productDao;

        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.delete(products[0]);
            return null;
        }
    }
    private static  class DeleteAllNoteAsyncTask extends AsyncTask<Product,Void,Void >{
        private ProductDao productDao;
        private DeleteAllNoteAsyncTask(ProductDao productDao){
            this.productDao = productDao;

        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.deleteAllNotes();
            return null;
        }
    }
}

