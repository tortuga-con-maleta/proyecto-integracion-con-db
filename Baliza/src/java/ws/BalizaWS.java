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
    @WebMethod(operationName = "getVisitas")
    public List<String[]> getVisitas(){
        VisitaController visitaController = new VisitaController();
        List<String[]> mensajes = new ArrayList<>();
        for(Visita visita : visitaController.getVisitas()){
            String[] mensaje = new String[2];
            mensaje[0] = visita.getFecha().toString();
            mensaje[1] = String.valueOf(visita.getIdCliente());
            mensajes.add(mensaje);
        }
        return mensajes;
    }
}