package com.example.springboothibernatemaster.repository;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboothibernatemaster.entity.Patient;
import com.example.springboothibernatemaster.util.HibernateSessionUtil;

@Repository
public class PatientRepositoryImp implements PatientRepository{
	
	@Autowired
	HibernateSessionUtil hibernateSessionUtil;
	
	@Autowired
	EntityManagerFactory factory;
	
	@Override
	public int insetPatient(Patient patient) {
        Session session = hibernateSessionUtil.getSessionFactory(factory).openSession();
        session.beginTransaction();
        int n = (Integer) session.save(patient);
        session.getTransaction().commit();
        session.close();
        return n;
    }
	
	@Override
	public Patient updatePatient(Patient patient){
        Session session = hibernateSessionUtil.getSessionFactory(factory).openSession();
        session.beginTransaction();
        List<Patient> queryPatient = searchPatientById(patient.getPatientId());
        if(!queryPatient.isEmpty()) {
        	session.update(patient);
            session.getTransaction().commit();
            session.close();
            return patient;
        }
        session.close();
        return null;
    }
	
	@Override
	public boolean deletePatient(int id){
        Session session = hibernateSessionUtil.getSessionFactory(factory).openSession();
        session.beginTransaction();
        List<Patient> queryPatient = searchPatientById(id);
        if(!queryPatient.isEmpty()) {
        	session.createQuery("Delete Patient where id = "+id).executeUpdate();
            session.getTransaction().commit();
            session.close();
            return true;
        }
        return false;	
    }
	
	@Override
	public List<Patient> selectAllPatient(){
		List<Patient> patientList;
        Session session = hibernateSessionUtil.getSessionFactory(factory).openSession();
        session.beginTransaction();
        patientList = session.createQuery("from Patient").list();
        session.close();
        return patientList;
    }
	
	@Override
	public List<Patient> searchPatientById(int id) {
		Session session = hibernateSessionUtil.getSessionFactory(factory).openSession();
        session.beginTransaction();
        List<Patient> patients = session.createQuery("from Patient where patientId="+id).list();
        session.close();
        return patients;
	}
	
	@Override
	public List<Patient> selectPatientByCriteria(Patient patient){
		List<Patient> patientList;
		String patientNo = "";
		if(patient.getPatientId() != 0){
			patientNo = String.valueOf(patient.getPatientId());
		}
		System.out.println(patientNo);
		Session session = hibernateSessionUtil.getSessionFactory(factory).openSession();
		session.beginTransaction();
		patientList = session.createQuery(
				"from Patient where patientId like '%"+patientNo+"%'"
				+ " and patientName like '%"+patient.getPatientName()+"%'"
				+ " and patientPhone like '%"+patient.getPatientPhone()+"%'"
				).list();
		session.close();
		return patientList;
	}
	
}
