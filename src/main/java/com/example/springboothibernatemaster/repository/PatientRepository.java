package com.example.springboothibernatemaster.repository;

import java.util.List;

import com.example.springboothibernatemaster.entity.Patient;

public interface PatientRepository {

	public int insetPatient(Patient patient);
	public Patient updatePatient(Patient patient);
	public boolean deletePatient(int id);
	
	public List<Patient> selectAllPatient();
	public List<Patient> searchPatientById(int id);
	public List<Patient> selectPatientByCriteria(Patient patient);
}
