package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Person;

@ApplicationScoped
public class PersonManager {
	private List<Person> db = new ArrayList<Person>();
	
	public void addPerson(Person person){
		Person newPerson = new Person();
		newPerson.setName(person.getName());
		newPerson.setYob(person.getYob());
		db.add(newPerson);
	}
	public boolean ifContain(Person p)
	{
		if(db.contains(p)) return true;
		else return false;
	}
	public List<Person> getAllPerson(){
		return db;
	}
	public void removePerson(Person p) {
		db.remove(p);
		
	}
	public void setPerson(int i, Person p) {
		db.set(i,  p);
		
	}
	public Person getPerson(int i)
	{
		return db.get(i);
	}
}
