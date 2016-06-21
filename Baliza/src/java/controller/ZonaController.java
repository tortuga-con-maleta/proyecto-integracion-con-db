/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import baliza.Zona;
import java.util.List;
import util.DbConnect;

/**
 *
 * @author Pablo de la Sotta
 */
public class ZonaController {
    private Zona zona;
    private List<Zona> zonas;
    
    public ZonaController(){
        
    }
    
    public boolean insertZona(){
        try{
            DbConnect dbConnect = new DbConnect();
            dbConnect.insertar(this.zona);
            return true;
        }catch(Exception ex){
            System.out.println("Error en insertZona");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public List<Zona> getZonas() {
        return zonas;
    }

    public void setZonas(List<Zona> zonas) {
        this.zonas = zonas;
    }
    
}
