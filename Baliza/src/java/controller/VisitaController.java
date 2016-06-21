package controller;


import baliza.Visita;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import util.DbConnect;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pablo de la Sotta
 */
public class VisitaController {
    private Visita visita;
    private List<Visita> visitas;

    public VisitaController() {
        this.visita = new Visita();
        this.visitas = new ArrayList<Visita>();
        List<Visita> result = (List<Visita>) DbConnect.buscarPorQuery("Visita.findAll", null);
        this.visitas = result;
        
    }

    public void guardarPersonaEnDb() {
        // Insertar nuevo objeto en db //
        DbConnect.insertar(visita);
        // Limpio variable local para crear nueva persona //
        visita=new Visita();
    }

    public Visita getVisita() {
        return visita;
    }

    public void setVisita(Visita visita) {
        this.visita = visita;
    }

    public List<Visita> getVisitas() {
        return visitas;
    }

    public void setVisitas(List<Visita> visitas) {
        this.visitas = visitas;
    }
    
    public List<Visita> getVisitasPorIdCliente(int idCliente){
        ArrayList<Visita> visitasCliente = new ArrayList();
        for(Visita visita : this.getVisitas()){
            if(visita.getIdCliente() == idCliente){
                visitasCliente.add(visita);
            }
        }
        return visitasCliente;
    }
    
    
}
