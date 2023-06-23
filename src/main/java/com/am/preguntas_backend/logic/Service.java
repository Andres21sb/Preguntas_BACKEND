/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.am.preguntas_backend.logic;

/**
 *
 * @author Darkh
 */
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

        // Creación de preguntas
        Pregunta pregunta1 = new Pregunta("¿Qué es un NullPointerException en Java?", Arrays.asList(
                "Un error al manipular cadenas de texto.",
                "Una excepción lanzada cuando se intenta acceder a un objeto nulo.",
                "Un problema con el manejo de excepciones en tiempo de ejecución."),
                1);

        Pregunta pregunta2 = new Pregunta("¿Qué es un algoritmo de ordenamiento QuickSort?", Arrays.asList(
                "Un algoritmo de búsqueda en profundidad.",
                "Un algoritmo de ordenamiento por inserción.",
                "Un algoritmo de ordenamiento recursivo basado en la técnica 'divide y vencerás'."),
                2);

        Pregunta pregunta3 = new Pregunta("¿Qué es una clase abstracta en programación orientada a objetos?", Arrays.asList(
                "Una clase que no puede tener instancias.",
                "Una clase que solo puede tener métodos estáticos.",
                "Una clase que implementa una interfaz."),
                0);

        preguntas = Arrays.asList(pregunta1, pregunta2, pregunta3);

        // Creación de clientes
        Cliente cliente1 = new Cliente("Juan Pérez", "111", "111");
        Cliente cliente2 = new Cliente("María López", "222", "222");

        // Agregar clientes a la lista de clientes
        clientes = Arrays.asList(cliente1, cliente2);
        
        //agregar preguntas a los clientes
        for(Cliente cliente:clientes){
            cliente.setPreguntas(preguntas);
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
