package com.example.tarea2unidad2;
public class Contacto {
    int id;
    String nombres;
    String direccion;
    String telefono;
    String pedido;

    public Contacto (){

    }
    public Contacto(String nombres, String direccion, String telefono, String pedido) {
        this.id = id;
        this.nombres = nombres;
        this.direccion = direccion;
        this.telefono = telefono;
        this.pedido = pedido;
    }
    public Contacto(int id, String nombres, String direccion, String telefono, String pedido) {
        this.id = id;
        this.nombres = nombres;
        this.direccion = direccion;
        this.telefono = telefono;
        this.pedido = pedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
}
