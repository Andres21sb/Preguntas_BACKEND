/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.am.preguntas_backend.logic;

/**
 *
 * @author Darkh
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {

    private static Service uniqueInstance;

    public static Service instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Service();
        }
        return uniqueInstance;
    }

    private List<Pregunta> preguntas;
    private List<Cliente> clientes;

    public Service() {
         preguntas = new ArrayList<>();
        clientes = new ArrayList<>();

        List<String> opciones1 = new ArrayList<>();
        List<String> opciones2 = new ArrayList<>();
        List<String> opciones3 = new ArrayList<>();

        // Creación de preguntas
        Pregunta pregunta1 = new Pregunta("¿Qué es un NullPointerException en Java?", 1);
        opciones1.add("Un error al manipular cadenas de texto.");
        opciones1.add("Una excepción lanzada cuando se intenta acceder a un objeto nulo.");
        opciones1.add("Un problema con el manejo de excepciones en tiempo de ejecución.");
        pregunta1.setOpciones(opciones1);
        preguntas.add(pregunta1);
        

        Pregunta pregunta2 = new Pregunta("¿Qué es un algoritmo de ordenamiento QuickSort?", 2);
        opciones2.add("Un algoritmo de búsqueda en profundidad.");
        opciones2.add("Un algoritmo de ordenamiento por inserción.");
        opciones2.add("Un algoritmo de ordenamiento recursivo basado en la técnica 'divide y vencerás'.");
        pregunta2.setOpciones(opciones2);
        preguntas.add(pregunta2);

        opciones3.add("Una clase que no puede tener instancias.");
        opciones3.add("Una clase que solo puede tener métodos estáticos.");
        opciones3.add("Una clase que implementa una interfaz.");

        Pregunta pregunta3 = new Pregunta("¿Qué es una clase abstracta en programación orientada a objetos?", opciones3, 0);
        preguntas.add(pregunta3);

        // Creación de clientes
        Cliente cliente1 = new Cliente("Juan Pérez", "111", "111");
        Cliente cliente2 = new Cliente("María López", "222", "222");

        // Agregar clientes a la lista de clientes
        clientes.add(cliente1);
        clientes.add(cliente2);

        //agregar preguntas a los clientes
        for (Cliente cliente
                : clientes) {
            cliente.setPreguntas(new ArrayList<>(preguntas));
        }
    }

    public List<Pregunta> obtenerPreguntas() {
        return preguntas;
    }

    public boolean validarRespuesta(Pregunta pregunta, int opcionSeleccionada) {
        int respuestaCorrecta = pregunta.getRespuestaCorrecta();
        return opcionSeleccionada == respuestaCorrecta;
    }

    public Cliente iniciarSesion(String id, String clave) {
        for (Cliente cliente : clientes) {
            if (cliente.iniciarSesion(id, clave)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

}
