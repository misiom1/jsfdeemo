package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Person;
import com.example.jsfdemo.service.PersonManager;

@SessionScoped
@Named("personBean")
public class PersonFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Person person = new Person();
	@Inject
	private PersonManager pm;

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getAllPersons(){
		return pm.getAllPerson();
	}

	// Actions
	public String addPerson(){

		pm.addPerson(person);

		return "showPersons";
	}

	 

	public String saveAction() {
		 
		for (Person p : getAllPersons()){
			p.setEditable(false);
		}
		return null;
 
	}
	public void delPerson(Person p){
		pm.removePerson(p);
	}
	public String editAction(Person p) {
 
		p.setEditable(true);
		return null;
	} 
	public void validateYob(FacesContext context, UIComponent component, Object value){
		String yob = Integer.toString((Integer) value) ;
		String pattern ="[0-9]*";
		if(!yob.matches(pattern))
		{
			FacesMessage message = new FacesMessage ();
			String warning = "Pole imie moze zawierac tylko cyfry!";
			message.setDetail(warning);
			message.setSummary(warning);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
}
