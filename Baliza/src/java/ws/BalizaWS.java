/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import baliza.Visita;
import controller.VisitaController;
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
    @WebMethod(operationName = "operation")
    public Boolean operation(@WebParam(name = "nombreZona") final String nombreZona) {
        //TODO write your implementation code here:
        return null;
    }
    
    
}
