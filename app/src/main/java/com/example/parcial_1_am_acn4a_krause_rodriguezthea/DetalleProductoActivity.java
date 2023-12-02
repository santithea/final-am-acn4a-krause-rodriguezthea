package com.example.parcial_1_am_acn4a_krause_rodriguezthea;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetalleProductoActivity extends AppCompatActivity {
    public static final String EXTRA_NOMBRE_PRODUCTO = "extra_nombre_producto";
    public static final String EXTRA_DESCRIPCION_PRODUCTO = "extra_descripcion_producto";
    public static final String EXTRA_FOTO_PRODUCTO = "extra_foto_producto";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        // Recupera el nombre del producto del intent
        String nombreProducto = getIntent().getStringExtra(EXTRA_NOMBRE_PRODUCTO);
        String descripcionProducto = getIntent().getStringExtra(EXTRA_DESCRIPCION_PRODUCTO);
        String fotoProducto = getIntent().getStringExtra(EXTRA_FOTO_PRODUCTO);

        ImageView imagenProductoImageView = findViewById(R.id.imagenProductoImageView);
        Picasso.get().load(fotoProducto).into(imagenProductoImageView);

        // Ejemplo: Mostrar el nombre del producto en un TextView
        TextView nombreProductoTextView = findViewById(R.id.tituloProductoTextView);
        nombreProductoTextView.setText(nombreProducto);

        TextView descripcionProductoTextView = findViewById(R.id.descripcionProductoTextView);
        descripcionProductoTextView.setText(descripcionProducto);


    }
}