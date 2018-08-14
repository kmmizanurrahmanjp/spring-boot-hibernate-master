package com.example.springboothibernatemaster.repository;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboothibernatemaster.entity.Patient;
import com.example.springboothibernatemaster.util.HibernateSessionUtil;

@Repository
public class PatientRepository {
	
	@Autowired
	HibernateSessionUtil hibernateSessionUtil;
	
	@Autowired
	EntityManagerFactory factory;
	
	public List<Patient> selectAllPatient(){
		List<Patient> patientList;
        Session session = hibernateSessionUtil.getSessionFactory(factory).openSession();
        session.beginTransaction();
        patientList = session.createQuery("from Patient").list();
        session.close();
        return patientList;
    }
    
	public int insetPatient(Patient patient) {
        Session session = hibernateSessionUtil.getSessionFactory(factory).openSession();
        session.beginTransaction();
        int n = (Integer) session.save(patient);
        session.getTransaction().commit();
        session.close();
        return n;
    }
	
	public Patient updatePatient(Patient patient){
        Session session = hibernateSessionUtil.getSessionFactory(factory).openSession();
        session.beginTransaction();
        List<Patient> queryPatient = searchById(patient.getPatientId());
        if(!queryPatient.isEmpty()) {
        	session.update(patient);
            session.getTransaction().commit();
            session.close();
            return patient;
        }
        session.close();
        return null;
    }
	
	public void deletePatient(Patient patient){
        Session session = hibernateSessionUtil.getSessionFactory(factory).openSession();
        session.beginTransaction();
        	session.delete(patient);
            session.getTransaction().commit();
            session.close();
    }
	
	public List<Patient> searchById(int id) {
		Session session = hibernateSessionUtil.getSessionFactory(factory).openSession();
        session.beginTransaction();
        List<Patient> pat = session.createQuery("from Patient where patientId="+id).list();
        session.close();
        return pat;
	}
}
