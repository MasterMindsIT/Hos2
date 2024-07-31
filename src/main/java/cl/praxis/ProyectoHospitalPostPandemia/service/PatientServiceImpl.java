package cl.praxis.ProyectoHospitalPostPandemia.service;
import cl.praxis.ProyectoHospitalPostPandemia.model.dto.Patient;
import cl.praxis.ProyectoHospitalPostPandemia.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientServiceImpl implements IPatient{

   PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findOne(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient update(Patient p) {
        Patient patient = findOne(p.getId());
        patient.setName(p.getName());
        patient.setLastName(p.getLastName());
        patient.setConcurrence(p.getConcurrence());

        return patientRepository.save(p);
    }

    @Override
    public  void delete(Long id) {
        patientRepository.delete(findOne(id));
    }




}
