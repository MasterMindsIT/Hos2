package cl.praxis.ProyectoHospitalPostPandemia.service;

import cl.praxis.ProyectoHospitalPostPandemia.model.dto.Patient;

import java.util.List;

public interface IPatient {
    List<Patient> findAll();
    Patient findOne(Long id);
    Patient create(Patient patient);
    Patient update(Patient patient);
    void delete(Long id);

}
