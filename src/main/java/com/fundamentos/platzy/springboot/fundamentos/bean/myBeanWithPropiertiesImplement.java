package com.fundamentos.platzy.springboot.fundamentos.bean;

public class myBeanWithPropiertiesImplement implements MyBeanWithProperties{
    private String nombre;
    private String apellido;

    public myBeanWithPropiertiesImplement(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String fuction() {
        return nombre +"-"+apellido;
    }
}
