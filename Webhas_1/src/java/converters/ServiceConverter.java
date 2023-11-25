package converters;

import entities.Service;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import ma.projet.service.ServiceService;

@FacesConverter("serviceConverter")
public class ServiceConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                ServiceService serviceService = context.getApplication().evaluateExpressionGet(context, "#{serviceService}", ServiceService.class);
                return serviceService.getById(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid service."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Service) {
            Service service = (Service) value;
            return service.getId() != 0 ? String.valueOf(service.getId()) : null;
        } else {
            return null;
        }
    }
}
