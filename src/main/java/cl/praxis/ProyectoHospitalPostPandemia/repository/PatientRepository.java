package cl.praxis.ProyectoHospitalPostPandemia.repository;

import cl.praxis.ProyectoHospitalPostPandemia.model.dto.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {



}
