package app.guillen.com.paginasamarillasapp.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.guillen.com.paginasamarillasapp.R;

public class EmpresadActivity extends AppCompatActivity {

    private TextView idText;
    private TextView rubroText;
    private TextView nombreText;
    private TextView direccionText;
    private TextView telefonoText;
    private String correoText;
    private String urlText;
    private TextView infoText;
    private ImageView logo;

    String nombre, rubro, direccion, telefono, correo, url, info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresad);

        rubroText = (TextView) findViewById(R.id.etRubro);
        nombreText = (TextView) findViewById(R.id.etNombre);
        direccionText = (TextView) findViewById(R.id.etDireccion);
        telefonoText = (TextView) findViewById(R.id.etTelefono);
        infoText = (TextView) findViewById(R.id.etInfo);
        logo = (ImageView)findViewById(R.id.imgLogoE);
        urlText = this.getIntent().getExtras().get("url").toString();
        correoText = this.getIntent().getExtras().get("correo").toString();


        if (this.getIntent().getExtras() != null) {

            if (this.getIntent().getExtras().get("rubro") != null) {
                String rubro = this.getIntent().getExtras().getString("rubro");
                rubroText.setText(rubro);
            }

            if (this.getIntent().getExtras().get("nombre") != null) {
                String nombre = this.getIntent().getExtras().getString("nombre");
                nombreText.setText(String.valueOf(nombre));
            }

            if (this.getIntent().getExtras().get("direccion") != null) {
                String direccion = this.getIntent().getExtras().getString("direccion");
                direccionText.setText(String.valueOf(direccion));
            }

            if (this.getIntent().getExtras().get("telefono") != null) {
                String telefono = this.getIntent().getExtras().getString("telefono");
                telefonoText.setText(String.valueOf(telefono));
            }

            if (this.getIntent().getExtras().get("info") != null) {
                String info = this.getIntent().getExtras().getString("info");
                infoText.setText(String.valueOf(info));
            }

            if (this.getIntent().getExtras().get("logo") != null) {
                Integer logos = this.getIntent().getExtras().getInt("logo");
                logo.setImageResource(logos);
            }

        }

    }

    public void callNumber(View view){
        telefono = telefonoText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+telefono));
        startActivity(intent);
    }

    public void gotoWeb(View view){
        //url = urlText.getText().toString();
        //Intent intent = new Intent(Intent.ACTION_VIEW);
        //intent.setData(Uri.parse("http://www.google.com"));
        //startActivity(intent);
        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("www.google.com")));
    }

    public void share(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, "Elija una aplicacion"));
    }

    public void sendMessage(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, correoText);
        startActivity(Intent.createChooser(intent, "Elija una aplicacion"));
    }

    public void sendSMS(View view){
        telefono = telefonoText.getText().toString();
        Uri sms_uri = Uri.parse("smsto:+" + telefono);
        Intent intent = new Intent(Intent.ACTION_SENDTO, sms_uri);
        startActivity(intent);
    }
}
