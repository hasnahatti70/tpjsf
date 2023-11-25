/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import entities.Service;
import ma.projet.service.ServiceService;

/**
 *
 * @author hasna
 */
public class TestService {
    public static void main(String[] args) {
        ServiceService ss = new ServiceService();
        //création des Services
        ss.create(new Service(1, "RH"));
        ss.create(new Service(2, "BusinessAnalyst"));
        ss.create(new Service(3, "Comptabl"));
        Service chefService = null;
         ss.create(new Service(1, "Rh",chefService));
        //La liste des salles
        for (Service s : ss.getAll()) {
            System.out.println("" + s.getId());
        }
}
}