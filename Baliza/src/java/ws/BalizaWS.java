/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import controller.VisitaController;
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
    @WebMethod(operationName = "getVisitas")
    public String getVisitas() {
        VisitaController visitaController = new VisitaController();
        visitaController.getVisitas();
        System.out.println(visitaController.getVisitas().toString());
        return "Hello " + " !";
    }
}
