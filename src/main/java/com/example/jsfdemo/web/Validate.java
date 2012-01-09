package com.example.jsfdemo.web;

import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import com.example.jsfdemo.service.PersonManager;
import com.example.jsfdemo.domain.Person;
@FacesValidator("validateimie")
public class Validate implements Validator
{
	@Inject
	public PersonManager pm;
	boolean nameExists = false;
	public List<Person> getAllPersons(){
		return pm.getAllPerson();
	}
	public void validate(FacesContext context, UIComponent component, Object value)
	{
		String imie = (String)value ;
		if(imie.length()==0){
			FacesMessage message = new FacesMessage ();
			String warning = "Pole imie nie moze byc puste!";
			message.setDetail(warning);
			message.setSummary(warning);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
		String pattern ="[A-Z]*[a-z]*";
		if(!imie.matches(pattern))
		{
			FacesMessage message = new FacesMessage ();
			String warning = "Pole imie moze zawierac tylko male i wielkie litery!";
			message.setDetail(warning);
			message.setSummary(warning);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
		
		
}