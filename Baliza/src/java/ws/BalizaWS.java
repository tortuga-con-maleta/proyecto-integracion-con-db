/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import baliza.*;
import controller.VisitaController;
import controller.ZonaController;
import estimote.EstimoteApi;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Pablo de la Sotta
 */
@WebService(serviceName = "BalizaWS")
public class BalizaWS {

    /**
     * This is a sample web service operation
     */
    
//    public String[] getVisitas() {
    @WebMethod(operationName = "getFechaVisitas")
    public List<String> getFechaVisitas(){
        VisitaController visitaController = new VisitaController();
        List<String> mensajes = new ArrayList<>();
        for(Visita visita : visitaController.getVisitas()){
            String mensaje = visita.getFecha().toString();
            mensajes.add(mensaje);
        }
        return mensajes;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getVisitasPorIdCliente")
    public List<String> getVisitasPorIdCliente(@WebParam(name = "idCliente") final int idCliente) {
        VisitaController visitaController = new VisitaController();
        List<String> mensaje = new ArrayList<>();
        for(Visita visita: visitaController.getVisitasPorIdCliente(idCliente)){
            mensaje.add(visita.getFecha().toString());
        }
        return mensaje;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertarZona")
    public boolean operation(@WebParam(name = "nombreZona") final String nombreZona) {
        Zona zona = new Zona();
        zona.setNombreZona(nombreZona);
        ZonaController zonaController = new ZonaController();
        zonaController.setZona(zona);
        boolean result = zonaController.insertZona();
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "enviarMensajeCliente")
    public boolean enviarMensajeCliente(@WebParam(name = "idCliente") final int idCliente, @WebParam(name = "mensaje") final String mensaje) {
        boolean result = EstimoteApi.enviarMensajeCliente(idCliente, mensaje);
        return result;
    }
    
    
    
    
}
