package com.example.springboothibernatemaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboothibernatemaster.entity.Patient;
import com.example.springboothibernatemaster.repository.PatientRepository;
import com.mysql.jdbc.BlobFromLocator;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;
	
	public List<Patient> selectAllPatient(){
		return patientRepository.selectAllPatient();
	}
	
	public Patient insetPatient(Patient patient){
		int chackPatient = patientRepository.insetPatient(patient);
		if(chackPatient == patient.getPatientId()){
			return patient;
		}else{
			return null;
		}
	}
	
	public Patient updatePatient(Patient patient){
		Patient chackPatient = patientRepository.updatePatient(patient);
		if(chackPatient == null){
			return null;
		}else{
			return patient;
		}
	}
	
	public void deletePatient(Patient patient){
		patientRepository.deletePatient(patient);
		
	}
}
