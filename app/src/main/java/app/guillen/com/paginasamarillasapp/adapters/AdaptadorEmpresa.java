package app.guillen.com.paginasamarillasapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import app.guillen.com.paginasamarillasapp.R;
import app.guillen.com.paginasamarillasapp.models.Empresa;

import java.util.ArrayList;

/**
 * Created by guillen on 28/09/17.
 */

public class AdaptadorEmpresa extends BaseAdapter implements Filterable {

    Context context;
    ArrayList<Empresa> Empresa;
    LayoutInflater inflater;
    CustomFilter filtro;
    ArrayList<Empresa> filtroList;

    public AdaptadorEmpresa(Context context, ArrayList<Empresa> Empresa){
        this.context = context;
        this.Empresa = Empresa;
        this.filtroList = Empresa;
    }

    @Override
    public int getCount() {
        return Empresa.size();
    }

    @Override
    public Object getItem(int i) {
        return Empresa.get(i);
    }

    @Override
    public long getItemId(int i) {
        return Empresa.indexOf(getItem(i));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView nombre;
        TextView rubro;
        ImageView logo;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view == null){
            view = inflater.inflate(R.layout.activity_detail, viewGroup, false);
        }

        nombre = (TextView)view.findViewById(R.id.etLNombre);
        rubro  = (TextView)view.findViewById(R.id.etLRubro);
        logo   = (ImageView)view.findViewById(R.id.imgLLogo);

        nombre.setText(Empresa.get(i).getNombre());
        rubro.setText(Empresa.get(i).getRubro());
        logo.setImageResource(Empresa.get(i).getLogo());

        return view;
    }

    @Override
    public Filter getFilter() {
        if(filtro == null){
            filtro = new CustomFilter();
        }
        return filtro;
    }


    class CustomFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults resulst = new FilterResults();
            if(charSequence != null && charSequence.length()>0){
                //pasamos a mayusculas
                charSequence= charSequence.toString().toUpperCase();

                ArrayList<Empresa> filtro = new ArrayList<Empresa>();

                for(Integer i=0;i<filtroList.size();i++){
                    if(filtroList.get(i).getNombre().toUpperCase().contains(charSequence)){
                        Empresa empresa = new Empresa(filtroList.get(i).getNombre(),filtroList.get(i).getRubro(), filtroList.get(i).getLogo());

                        filtro.add(empresa);
                    }
                }
                resulst.count= filtro.size();
                resulst.values = filtro;
            }else{
                resulst.count= filtroList.size();
                resulst.values = filtroList;
            }

            return resulst;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            Empresa = (ArrayList<Empresa>) results.values;
            notifyDataSetChanged();

        }
    }
}