package app.guillen.com.paginasamarillasapp.models;

import java.io.Serializable;

/**
 * Created by guillen on 18/09/17.
 */

public class Empresa implements Serializable{

    private int id;
    private String rubro;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private String url;
    private Integer logo;
    private String info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLogo() {
        return logo;
    }

    public void setLogo(Integer logo) {
        this.logo = logo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Empresa(int id, String rubro, String nombre, String direccion, String telefono, String correo, String url, Integer logo, String info) {
        this.id = id;
        this.rubro = rubro;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.url = url;
        this.logo = logo;
        this.info = info;
    }

    public Empresa(String nombre, String rubro, Integer logo) {
        this.nombre = nombre;
        this.rubro = rubro;
        this.logo = logo;
    }

}
