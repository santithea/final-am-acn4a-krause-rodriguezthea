
package com.example.parcial_1_am_acn4a_krause_rodriguezthea;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductoViewHolder> implements OnVerMasClickListener{

    private List<Producto> listaProductos;
    private OnVerMasClickListener verMasClickListener;

    public ProductosAdapter(List<Producto> listaProductos, OnVerMasClickListener verMasClickListener) {
        this.listaProductos = listaProductos;
        this.verMasClickListener = verMasClickListener;
    }
    public void setOnVerMasClickListener(OnVerMasClickListener vermas) {
        this.verMasClickListener = vermas;
    }


    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.xml.item_producto, parent, false);
        return new ProductoViewHolder(view, verMasClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = listaProductos.get(position);
        holder.textViewNombre.setText(producto.getNombre());
        holder.textViewDescripcion.setText(producto.getDescripcion());

        // Cargar la imagen con Picasso
        Picasso.get().load(producto.getUrlImagen()).into(holder.imageViewProducto);
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    @Override
    public void onVerMasClick(int position) {

    }


    // ViewHolder para un producto individual
    static class ProductoViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNombre;
        private TextView textViewDescripcion;
        private ImageView imageViewProducto;
        private Button buttonVerMas;

        public ProductoViewHolder(@NonNull View itemView, final OnVerMasClickListener listener) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
            textViewDescripcion = itemView.findViewById(R.id.textViewDescripcion);
            imageViewProducto = itemView.findViewById(R.id.imageViewProducto);
            buttonVerMas = itemView.findViewById(R.id.buttonVerMas);

            buttonVerMas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onVerMasClick(position);
                        }
                    }
                }
            });
        }
    }
}