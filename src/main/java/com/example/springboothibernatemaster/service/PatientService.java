package com.example.springboothibernatemaster.service;

import java.util.List;

import com.example.springboothibernatemaster.entity.Patient;

public interface PatientService {

	public int insetPatient(Patient patient);
	public Patient updatePatient(Patient patient);
	public boolean deletePatient(int id);
	
	public List<Patient> selectAllPatient();
	public List<Patient> searchPatientById(int id);
	public List<Patient> selectPatientByCriteria(Patient patient);
}
