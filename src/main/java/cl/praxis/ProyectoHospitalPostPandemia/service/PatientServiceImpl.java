package cl.praxis.ProyectoHospitalPostPandemia.service;

import cl.praxis.ProyectoHospitalPostPandemia.ProyectoHospitalPostPandemiaApplication;
import cl.praxis.ProyectoHospitalPostPandemia.model.dto.Patient;
import cl.praxis.ProyectoHospitalPostPandemia.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientServiceImpl implements IPatient{

   PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    private static final Logger logger = LoggerFactory.getLogger(ProyectoHospitalPostPandemiaApplication.class);




    @Override
    public List<Patient> findAll() {
        logger.warn("Ejecutando findAll de PatientServiceImpl");
        return patientRepository.findAll();
    }

    @Override
    public Patient findOne(Long id) {
        logger.warn("Ejecutando findOne de PatientServiceImpl");
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient create(Patient patient) {
        logger.warn("Ejecutando create de PatientServiceImpl");
        return patientRepository.save(patient);
    }

    @Override
    public Patient update(Patient p) {
        logger.warn("Ejecutando update de PatientServiceImpl");
        Patient patient = findOne(p.getId());
        patient.setName(p.getName());
        patient.setLastName(p.getLastName());
        patient.setConcurrence(p.getConcurrence());

        return patientRepository.save(p);
    }

    @Override
    public  void delete(Long id) {
        logger.warn("Ejecutando delete de PatientServiceImpl");
        patientRepository.delete(findOne(id));
    }




}
