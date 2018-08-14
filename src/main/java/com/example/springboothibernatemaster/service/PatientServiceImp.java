package com.example.springboothibernatemaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboothibernatemaster.entity.Patient;
import com.example.springboothibernatemaster.repository.PatientRepositoryImp;

@Service
public class PatientServiceImp implements PatientService{

	@Autowired
	PatientRepositoryImp patientRepositoryImp;
	
	@Override
	public int insetPatient(Patient patient){
		return patientRepositoryImp.insetPatient(patient);
	}
	
	@Override
	public Patient updatePatient(Patient patient){
		return patientRepositoryImp.updatePatient(patient);
	}
	
	@Override
	public boolean deletePatient(int id){
		return patientRepositoryImp.deletePatient(id);
		
	}
	
	@Override
	public List<Patient> selectAllPatient(){
		return patientRepositoryImp.selectAllPatient();
	}
	
	@Override
	public List<Patient> searchPatientById(int id){
		return patientRepositoryImp.searchPatientById(id);
		
	}
	
	@Override
	public List<Patient> selectPatientByCriteria(Patient patient){
		return patientRepositoryImp.selectPatientByCriteria(patient);
	}
}
