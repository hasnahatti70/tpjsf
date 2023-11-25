/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import static java.nio.file.Files.list;
import static java.util.Collections.list;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.ChartSeries;
@Entity

/**
 *
 * @author Lachgar
 */
public class Service {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom ;
     @OneToMany(mappedBy = "service")
    private List<Employe>employes;
     @OneToOne
     private Service chefService ;

    public Service getChefService() {
        return chefService;
    }

    public void setChefService(Service chefService) {
        this.chefService = chefService;
    }

    public Service(long id, String nom, Service chefService) {
        this.id = id;
        this.nom = nom;
        this.chefService = chefService;
    }
    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public Service(long id, String nom, List<Employe> employes) {
        this.id = id;
        this.nom = nom;
        this.employes = employes;
    }

    public Service() {
    }

    public Service(String nom, List<Employe> employes) {
        this.nom = nom;
        this.employes = employes;
    }

    public Service(long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public void setChefDeService(Employe chefDeService) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
     
   