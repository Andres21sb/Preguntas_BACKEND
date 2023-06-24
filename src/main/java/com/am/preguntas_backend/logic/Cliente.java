/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.am.preguntas_backend.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Darkh
 */
public class Cliente {

    private String nombre;
    private String id;
    private String clave;
    private List<Pregunta> preguntas;

    public Cliente(String nombre, String id, String clave) {
        preguntas = new ArrayList<>(); // Inicializar la lista vacía
        this.nombre = nombre;
        this.id = id;
        this.clave = clave;
    }

    public Cliente() {
        preguntas = new ArrayList<>(); // Inicializar la lista vacía
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Cliente{"
                + "nombre='" + nombre + '\''
                + ", id='" + id + '\''
                + ", clave='" + clave + '\''
                + '}';
    }

    public boolean iniciarSesion(String id, String clave) {
        return this.id.equals(id) && this.clave.equals(clave);
    }

    public Boolean verificaPregunta(String enunciado, String respuesta) {
        Pregunta aEliminar = null;
        Boolean output = false;
        for (Pregunta pregunta : preguntas) {
            if (enunciado.equals(pregunta.getEnunciado())) {
                output = pregunta.isRespuestaCorrecta(respuesta);
                aEliminar = pregunta;
            }
        }
        
        List<Pregunta> copia = this.getPreguntas();
        copia.remove(aEliminar);
        this.setPreguntas(copia);
        int dummy = 0;
        return output;
    }

    
    public List<Pregunta> filter(String text){
        List<Pregunta> output = new ArrayList<>();
        if(text.equals("")){
         output = preguntas;   
        }else{
        for(Pregunta pregunta: preguntas){
            if(pregunta.getEnunciado().contains(text)){
                output.add(pregunta);
            }
        }
        }
        return output;
    }

}
