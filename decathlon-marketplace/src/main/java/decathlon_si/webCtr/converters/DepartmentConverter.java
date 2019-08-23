package decathlon_si.webCtr.converters;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean(name = "acteConverter")
@RequestScoped
public class DepartmentConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

//	@EJB
//	private DemandeServicesLocal demandeServicesLocal;
//
//	@Override
//	public Object getAsObject(FacesContext context, UIComponent component, String value) {
//		return demandeServicesLocal.readActeByName(value);
//	}
//
//	@Override
//	public String getAsString(FacesContext context, UIComponent component, Object value) {
//		ActeMedical acteMedical = (ActeMedical) value;
//		return acteMedical.getTypeActe();
//	}

}
