package app.guillen.com.paginasamarillasapp.repositories;

import java.util.ArrayList;

import app.guillen.com.paginasamarillasapp.R;
import app.guillen.com.paginasamarillasapp.models.Empresa;

/**
 * Created by guillen on 18/09/17.
 */

public class RepositorioEmpresas {

    private static RepositorioEmpresas _INSTANCE = null;

    private RepositorioEmpresas(){}

    public static RepositorioEmpresas getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new RepositorioEmpresas();
        return _INSTANCE;
    }

    private ArrayList<Empresa> empresas = new ArrayList<>();

    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    private void setEmpresas() {
        Empresa e1 = new
                Empresa(100,
                "Restaurantes",
                "El retiro",
                "Tr93 53-48 Int 84",
                "012242625",
                "informes@elretiro.com",
                "www.elretiro.com",
                R.drawable.img_restaurante,
                "El Sabor Original del Pollo Desde…");
        Empresa e2 = new
                Empresa(101,
                "Textiles",
                "Guicas",
                "Tr93 53-48 Int 84",
                "992834755",
                "informes@guicas.com",
                "www.guicas.com",
                R.drawable.img_telas,
                "La mejor calidad en textiles...");
        Empresa e3 = new
                Empresa(102,
                "Joyeria",
                "Jandy Style",
                "Tr93 53-48 Int 84",
                "987435221",
                "informes@jstyle.com",
                "www.jandystyle.com",
                R.drawable.img_joyas,
                "La mas fina joyeria en diseños exclusivos...");
        Empresa e4 = new
                Empresa(103,
                "Ferreteria",
                "Popeye",
                "Tr93 53-48 Int 84",
                "967344325",
                "informes@popeye.com",
                "www.ferreteriapopeye.com",
                R.drawable.img_ferreteria,
                "Los mejores materiales para tu casa…");
        Empresa e5 = new
                Empresa(103,
                "Jugueria",
                "Santa Fruta",
                "Tr93 53-48 Int 84",
                "914448328",
                "informes@santafruta.com",
                "www.santafruta.com",
                R.drawable.img_jugueria,
                "Jugos con las frutas mas frescas del mercado…");
        Empresa e6 = new
                Empresa(103,
                "Caterin",
                "Luciana",
                "Tr93 53-48 Int 84",
                "992452981",
                "informes@luciana.com",
                "www.lucianacaterin.com",
                R.drawable.img_caterin,
                "Buffets preparados con los mejores ingredientes…");
        Empresa e7 = new
                Empresa(103,
                "Pasteleria",
                "Rosita",
                "Tr93 53-48 Int 84",
                "967344325",
                "informes@popeye.com",
                "www.rosita.com",
                R.drawable.img_pasteleria,
                "Los mejores materiales para tu casa…");
        Empresa e8 = new
                Empresa(103,
                "Transportes",
                "Hernan",
                "Tr93 53-48 Int 84",
                "967344325",
                "informes@popeye.com",
                "www.thernan.com",
                R.drawable.img_transportes,
                "Los mejores materiales para tu casa…");
        Empresa e9 = new
                Empresa(103,
                "Veterinaria",
                "Dos pulgas",
                "Tr93 53-48 Int 84",
                "967344325",
                "informes@popeye.com",
                "www.dospulgas.com",
                R.drawable.img_veterinaria,
                "Los mejores materiales para tu casa…");
        Empresa e10 = new
                Empresa(103,
                "Pizzeria",
                "Pappa Juan",
                "Tr93 53-48 Int 84",
                "967344325",
                "informes@popeye.com",
                "www.pappajuan.com",
                R.drawable.img_pizzeria,
                "Los mejores materiales para tu casa…");
        empresas.add(e1);
        empresas.add(e2);
        empresas.add(e3);
        empresas.add(e4);
        empresas.add(e5);
        empresas.add(e6);
        empresas.add(e7);
        empresas.add(e8);
        empresas.add(e9);
        empresas.add(e10);
    }

    public void iniciarEmpresas(){
        setEmpresas();
    }


}
