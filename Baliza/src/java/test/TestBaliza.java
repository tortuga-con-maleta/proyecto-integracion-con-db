/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controller.VisitaController;

/**
 *
 * @author Pablo de la Sotta
 */
public class TestBaliza {
    public static void main(String[] args){
        VisitaController visitaController = new VisitaController();
        visitaController.getVisitas();
        System.out.println("Hola desde main");
    }
}
