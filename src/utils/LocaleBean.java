package utils;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.context.FacesContext;

public class LocaleBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Locale locale = new Locale("es");

	private String language;
	
	public String changeLocale() {
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		return null;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Locale getLocale() {
		return locale;
	}
	
}
