
package ma.projet.test;
import entities.Employe;
import entities.Service;
import ma.projet.service.EmployeeService;
import ma.projet.service.ServiceService;

import java.util.Date;
import java.util.List;

public class TestEmploye {

    public static void main(String[] args) {
        // Initialiser les services
        EmployeeService employeService = new EmployeeService();
        ServiceService serviceService = new ServiceService();

        // Créer un nouveau service
        Service nouveauService = new Service(1, "IT");
        serviceService.create(nouveauService);
            Service deuxService = new Service(1, "Rh");
        serviceService.create(deuxService);
        Service chefService = null;
        Service troisService = new Service(1, "Rh",chefService);
        serviceService.create(troisService);
        // Créer un nouvel employé
        Employe nouvelEmploye = new Employe("Hatti", "hasna", new Date(), "john_doe.jpg", nouveauService);
        employeService.create(nouvelEmploye);
        Employe deuxEmploye = new Employe("dafali", "fati", new Date(), "john_doe.jpg", deuxService);
        employeService.create(deuxEmploye);
        // Récupérer et afficher les informations
        System.out.println("Employés:");
        List<Employe> employes = employeService.getAll();
        for (Employe e : employes) {
            System.out.println(e.getNom() + " " + e.getPrenom());
        }

        System.out.println("\nServices:");
        List<Service> services = serviceService.getAll();
        for (Service s : services) {
            System.out.println(s.getNom());
            for (Employe e : s.getEmployes()) {
                System.out.println("\t" + e.getNom());
            }
        }

        // Mettre à jour et supprimer des données...
        // Par exemple, employeService.update(employeModifie), serviceService.delete(serviceASupprimer), etc.
    }
}
