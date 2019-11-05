package info.yeasin.roomdbmvvm.view.ui.note;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdbmvvm.R;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.NoteHolder> {
    private List<Product> products = new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Product currentProduct = products.get(position);
        holder.textViewTitle.setText(currentProduct.getName());
        holder.textViewDescription.setText(""+ currentProduct.getPriority());

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(List<Product> products){
        this.products = products;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            ;
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_priority);
        }
    }
}
