package com.example.springboothibernatemaster.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboothibernatemaster.entity.Patient;
import com.example.springboothibernatemaster.service.PatientService;

@RestController
@RequestMapping(value="/patient")
public class PatientController {

	@Autowired
	PatientService patientService;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public Map<String, Object> selectAllPatient(){
		Map<String, Object> response = new HashMap<String, Object>();
		 List<Patient> pat = patientService.selectAllPatient();
		 if(pat.isEmpty()){
			 response.put("Success", false);
			 response.put("data", pat);
			 response.put("massage", "There are no Patient");
		 }else{
			 response.put("Success", true);
			 response.put("data", pat);
			 response.put("massage", "Select All Patient");
		 }
		 return response;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public Map<String, Object> insetPatient(@RequestBody Patient patient){
		Map<String, Object> response = new HashMap<String, Object>();
		System.out.println(patient.getPatientName());
		 Patient pat = patientService.insetPatient(patient);
		 if(pat == null){
			 response.put("Success", false);
			 response.put("data", pat);
			 response.put("massage", "There are no Patient");
		 }else{
			 response.put("Success", true);
			 response.put("data", pat);
			 response.put("massage", "Select All Patient");
		 }
		 return response;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Map<String, Object> updatePatient(@PathVariable int id, @RequestBody Patient patient){
		Map<String, Object> response = new HashMap<String, Object>();
		patient.setPatientId(id);
		 Patient pat = patientService.updatePatient(patient);
		 if(pat == null){
			 response.put("Success", false);
			 response.put("data", pat);
			 response.put("massage", "There are no Patient");
		 }else{
			 response.put("Success", true);
			 response.put("data", pat);
			 response.put("massage", "Patient Updated");
		 }
		 return response;
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public Map<String, Object> deletePatient(@PathVariable int id){
		Map<String, Object> response = new HashMap<String, Object>();
		Patient patient = new Patient();
		patient.setPatientId(id);
		 patientService.deletePatient(patient);
			 response.put("Success", true);
			 response.put("massage", "Patient Deleted");
		 return response;
	}
	
}
