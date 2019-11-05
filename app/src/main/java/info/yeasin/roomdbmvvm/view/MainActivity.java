package info.yeasin.roomdbmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.roomdbmvvm.R;
import info.yeasin.roomdbmvvm.view.ui.note.Product;
import info.yeasin.roomdbmvvm.view.ui.note.ProductAdapter;
import info.yeasin.roomdbmvvm.view.ui.note.ProductViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView  = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ProductAdapter productAdapter = new ProductAdapter();
        recyclerView.setAdapter(productAdapter);

        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        productViewModel.deleteAll();

        productViewModel.getAllProduct().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                productAdapter.setProducts(products);
                Toast.makeText(MainActivity.this, "OnChange", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
