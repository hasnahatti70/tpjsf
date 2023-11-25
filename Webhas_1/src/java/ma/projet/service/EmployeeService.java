/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import entities.Employe;
import java.util.Date;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;


public class EmployeeService extends AbstractFacad<Employe>{

   

    @Override
    protected Class<Employe> getEntityClass() {
    return Employe.class;
    }
    public List<Object[]> nbemployee(){
        List<Object[]> employees = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        employees  = session.createQuery("select count(e.nom), e.nom from Employe e group by e.nom").list();
        session.getTransaction().commit();
        return employees;
    }
    
    
    
}

    

