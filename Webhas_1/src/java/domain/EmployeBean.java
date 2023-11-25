
import entities.Employe;
import entities.Service;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import ma.projet.service.EmployeeService;
import ma.projet.service.ServiceService;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.ChartSeries;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LACHGAR
 */
@ManagedBean(name = "employeBean")
@ViewScoped
public class EmployeBean {

    private Employe employe;

    private Service service;
    private List<Employe> employes;
    private List<Employe> employesBetweenDates;
    private EmployeeService employeService;
    private ServiceService serviceService;
    private static ChartModel barModel;
    private Date date1;
    private Date date2;

    public EmployeBean() {
        employe = new Employe();
        employeService = new EmployeeService();
        serviceService = new ServiceService();

    }

    public List<Employe> getEmployes() {
        if (employes == null) {
            employes = employeService.getAll();
        }
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public EmployeeService getEmployeeService() {
        return employeService;
    }

    public void setEmployeeService(EmployeeService employeService) {
        this.employeService = employeService;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public String onCreateAction() {
        employeService.create(employe);
        employe = new Employe();
        return null;
    }

    public String onDeleteAction() {

        employeService.delete(employeService.getById((int) employe.getId()));
        return null;
    }

    public List<Employe> serviceLoad() {
        for (Employe m : employeService.getAll()) {
            if (m.getService().equals(service)) {
                employes.add(m);
            }
        }
        return employes;

    }

    public void load() {
        System.out.println(service.getNom());
        service = serviceService.getById((int) service.getId());
        getEmployes();
    }

    public void onEdit(RowEditEvent event) {
        employe = (Employe) event.getObject();
        Service service = serviceService.getById((int) this.employe.getService().getId());
        employe.setService(service);
        employe.getService().setNom(service.getNom());
        employeService.update(employe);
    }

    public void onCancel(RowEditEvent event) {
    }

    public ChartModel getBarModel() {
        return barModel;
    }

    public ChartModel initBarModel() {
        CartesianChartModel model = new CartesianChartModel();
        ChartSeries employes = new ChartSeries();
        employes.setLabel("employes");
        model.setAnimate(true);
        for (Object[] m : employeService.nbemployee()) {
            employes.set(m[1], Integer.parseInt(m[0].toString()));
        }
        model.addSeries(employes);

        return model;
    }


    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Employe> getEmployesBetweenDates() {
        return employesBetweenDates;
    }

    public void setEmployesBetweenDates(List<Employe> employesBetweenDates) {
        this.employesBetweenDates = employesBetweenDates;
    }

}
