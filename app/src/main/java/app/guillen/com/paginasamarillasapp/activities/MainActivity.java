package app.guillen.com.paginasamarillasapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import app.guillen.com.paginasamarillasapp.R;
import app.guillen.com.paginasamarillasapp.adapters.AdaptadorEmpresa;
import app.guillen.com.paginasamarillasapp.models.Empresa;
import app.guillen.com.paginasamarillasapp.repositories.RepositorioEmpresas;

public class MainActivity extends AppCompatActivity {

    SearchView buscador;
    ListView list;
    AdaptadorEmpresa empresaAd;
    ArrayList<Empresa> listaEmpresa;
    private int id;
    private String rubro, nombre, direccion,  telefono, correo, url, info;
    private Integer logo;
    RepositorioEmpresas repositorioEmpresas = RepositorioEmpresas.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        buscador = (android.widget.SearchView) findViewById(R.id.buscadorInp);
        repositorioEmpresas.iniciarEmpresas();
        listaEmpresa = repositorioEmpresas.getEmpresas();
        empresaAd = new AdaptadorEmpresa(this, listaEmpresa);
        list.setAdapter(empresaAd);

        final List<Empresa> empresas = repositorioEmpresas.getEmpresas();
//
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,long id1) {
                final List<Empresa> empresas = repositorioEmpresas.getEmpresas();
                Empresa empresa1 = listaEmpresa.get(position);
                boolean nombrekey = false;
                String empresa11 = empresa1.getNombre();
                for( Empresa empresa : empresas){
                    if(empresa11.equals(empresa.getNombre())){
                        nombrekey = true;
                    }
                    if(nombrekey){
                        rubro     = empresa.getRubro().toString();
                        nombre    = empresa.getNombre().toString();
                        direccion = empresa.getDireccion().toString();
                        telefono  = empresa.getTelefono().toString();
                        correo    = empresa.getCorreo().toString();
                        url       = empresa.getUrl().toString();
                        info      = empresa.getInfo().toString();
                        logo      = empresa.getLogo();
                        id        = empresa.getId();
                        break;
                    }
                }


                Intent intent = new Intent(MainActivity.this, EmpresadActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("rubro", rubro);
                intent.putExtra("nombre", nombre);
                intent.putExtra("direccion", direccion);
                intent.putExtra("telefono", telefono);
                intent.putExtra("correo", correo);
                intent.putExtra("url", url);
                intent.putExtra("info", info);
                intent.putExtra("logo", logo);
                startActivity(intent);
            }
        });


        //

        buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                empresaAd.getFilter().filter(query);
                return false;
            }
        });

    }
}
