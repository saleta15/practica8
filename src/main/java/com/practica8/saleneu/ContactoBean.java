package com.practica8.saleneu;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ManagedBean
@SessionScoped
public class ContactoBean implements Serializable {
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correo;
    private Integer id;
    private HashMap<Integer,Contacto> contactos = new HashMap<Integer, Contacto>();
    private Contacto contactoSeleccionado;

    public Contacto getContactoSeleccionado() {
        return contactoSeleccionado;
    }

    public void setContactoSeleccionado(Contacto contactoSeleccionado) {
        this.contactoSeleccionado = contactoSeleccionado;
    }

    @PostConstruct
    public void init() {
        Contacto nuevoContacto = new Contacto();
        nuevoContacto.setApellido("sdfsfd");
        nuevoContacto.setNombre("dddfdf");
        nuevoContacto.setCorreo("dfsdf");
        nuevoContacto.setDireccion("dsferfw");
        nuevoContacto.setTelefono("fwegw");
        nuevoContacto.setId(1);
        contactos.put(1,nuevoContacto);
        nuevoContacto = new Contacto();
        nuevoContacto.setApellido("sdfsfd");
        nuevoContacto.setNombre("dddfdf");
        nuevoContacto.setCorreo("dfsdf");
        nuevoContacto.setDireccion("dsferfw");
        nuevoContacto.setTelefono("fwegw");
        nuevoContacto.setId(2);

        contactos.put(2,nuevoContacto);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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


    public List<Contacto> getContactos() {
        return new ArrayList<Contacto>(contactos.values());
    }





    public void setContactos(HashMap<Integer, Contacto> contactos) {
        this.contactos = contactos;
    }

    public void insertarConctacto(){
     Contacto nuevoContacto = new Contacto();
     nuevoContacto.setApellido(this.apellido);
     nuevoContacto.setNombre(this.nombre);
     nuevoContacto.setCorreo(this.correo);
     nuevoContacto.setDireccion(this.direccion);
     nuevoContacto.setTelefono(this.telefono);
     int id= Contacto.getultimoId() + 1;
     nuevoContacto.setId(id);
     Contacto.setultimoId(id);
     this.contactos.put(id,nuevoContacto);
     limpiarFormulario();
    }

    public void cargarContacto(Contacto contacto){
        nombre = contacto.getNombre();
        apellido = contacto.getApellido();
        correo = contacto.getCorreo();
        telefono = contacto.getTelefono();
        direccion = contacto.getDireccion();
        id = contacto.getId();
    }

    public void actualizarContacto(){

        Contacto contacto = new Contacto();
        contacto.setNombre(nombre);
        contacto.setApellido(apellido);
        contacto.setDireccion(direccion);
        contacto.setCorreo(correo);
        contacto.setId(id);
        contacto.setTelefono(telefono);
        contactos.put(id,contacto);

    }

    private void limpiarFormulario(){
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.direccion = "";
        this.telefono = "";
    }

}