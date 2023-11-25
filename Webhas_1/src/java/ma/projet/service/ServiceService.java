/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import entities.Service;
import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;


public class ServiceService extends AbstractFacad<Service>{

   

    @Override
    protected Class<Service> getEntityClass() {
        return Service.class;
    }
}