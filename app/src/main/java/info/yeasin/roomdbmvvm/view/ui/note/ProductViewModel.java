package info.yeasin.roomdbmvvm.view.ui.note;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import info.yeasin.roomdbmvvm.repository.ProductRepository;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {
    private ProductRepository repository;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        repository = new ProductRepository(application);
    }

    public void insert(Product product) {
        repository.insert(product);
    }

    public void update(Product product) {
        repository.update(product);
    }

    public void delete(Product product) {
        repository.delete(product);
    }

    public void deleteAll() {
        repository.deleteAllNotes();
    }

    public LiveData<List<Product>> getAllProduct() {
        return repository.getAllNotes();
    }
}
