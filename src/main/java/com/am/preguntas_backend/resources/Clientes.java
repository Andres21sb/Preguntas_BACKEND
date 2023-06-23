/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.am.preguntas_backend.resources;

import com.am.preguntas_backend.logic.Cliente;
import com.am.preguntas_backend.logic.Service;
import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author Darkh
 */
@Path("/clientes")
@PermitAll
public class Clientes {

    @Context
    HttpServletRequest request;

    @POST
    @Path("/login")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Cliente showClient(Cliente candidate) {
        try {
            System.out.println("Entro");
            Cliente cliente = Service.instance().iniciarSesion(candidate.getId(), candidate.getClave());
            request.getSession(true).setAttribute("user", cliente);
            return cliente;
        } catch (Exception ex) {
            //Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            throw new NotFoundException();
        }
    }

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Cliente> getClientes() {
        try {
            System.out.println("Entro");
            return Service.instance().getClientes();
        } catch (Exception ex) {
            throw new NotFoundException();
        }
    }

    @DELETE
    @Path("/logout")
    public Response logout() {
        // Invalidar la sesión del usuario
        request.getSession().invalidate();
        // Opcionalmente, puedes realizar otras acciones de limpieza o respuesta
        // Por ejemplo, puedes devolver una respuesta exitosa o un mensaje de éxito
        return Response.ok().build();
    }

}
