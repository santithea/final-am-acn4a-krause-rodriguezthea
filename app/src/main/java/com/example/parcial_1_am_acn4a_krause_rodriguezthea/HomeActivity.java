package com.example.parcial_1_am_acn4a_krause_rodriguezthea;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements OnVerMasClickListener {

    private RecyclerView recyclerViewProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerViewProductos = findViewById(R.id.recyclerViewProductos);
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(this));
        List<Producto> listaProductos = obtenerListaDeProductos();

        // Crear el adaptador antes del código de configuración del click listener
        ProductosAdapter productosAdapter = new ProductosAdapter(listaProductos, this);

        // Configurar el click listener después de crear el adaptador
        productosAdapter.setOnVerMasClickListener(new OnVerMasClickListener() {
            @Override
            public void onVerMasClick(int position) {
                Producto producto = listaProductos.get(position);
                Toast.makeText(HomeActivity.this, "Ver más de " + producto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this, DetalleProductoActivity.class);
                intent.putExtra(DetalleProductoActivity.EXTRA_NOMBRE_PRODUCTO, producto.getNombre());
                intent.putExtra(DetalleProductoActivity.EXTRA_DESCRIPCION_PRODUCTO, producto.getDescripcion());
                intent.putExtra(DetalleProductoActivity.EXTRA_FOTO_PRODUCTO, producto.getUrlImagen());
                startActivity(intent);
            }
        });

        recyclerViewProductos.setAdapter(productosAdapter);
    }

    private List<Producto> obtenerListaDeProductos() {
        List<Producto> listaProductos = new ArrayList<>();

        listaProductos.add(new Producto("Air Jordan 1 Low", "Zapatillas Jordan para Hombre", "https://nikearprod.vtexassets.com/arquivos/ids/679745/553558_174_A_PREM.jpg?v=638224543210770000"));
        listaProductos.add(new Producto("Air Jordan 1 Mid SE Craft", "Zapatillas Jordan para Hombre", "https://nikearprod.vtexassets.com/arquivos/ids/530374-1200-1200?v=638161363745530000&width=1200&height=1200&aspect=true"));
        listaProductos.add(new Producto("Air Jordan 1 Zoom CMFT 2", "Zapatillas Jordan para Hombre", "https://nikearprod.vtexassets.com/arquivos/ids/659859-1200-1200?v=638221826927100000&width=1200&height=1200&aspect=true"));
        listaProductos.add(new Producto("Air Jordan 2 Retro Low", "Zapatillas Jordan para Hombre", "https://nikearprod.vtexassets.com/arquivos/ids/533533-1200-1200?v=638161410875770000&width=1200&height=1200&aspect=true"));

        return listaProductos;
    }


    public void onVerMasClick(int position) {

    }
}

