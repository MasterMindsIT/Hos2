package cl.praxis.ProyectoHospitalPostPandemia.controller;

import cl.praxis.ProyectoHospitalPostPandemia.ProyectoHospitalPostPandemiaApplication;
import cl.praxis.ProyectoHospitalPostPandemia.model.dto.Patient;
import cl.praxis.ProyectoHospitalPostPandemia.service.IPatient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patients")
public class PatientController {
    private static final Logger logger = LoggerFactory.getLogger(ProyectoHospitalPostPandemiaApplication.class);

    //@Autowired
    private IPatient service;

        public PatientController(IPatient service) {
        this.service = service;
    }

    @GetMapping
    public String findAll(Model model){
        logger.info("Ejecutando findAll de PatientController");
        model.addAttribute("patients", service.findAll());
        return "patientList";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") Long id, Model model){
        logger.info("Ejecutando findOne de PatientController");
        model.addAttribute("patient", service.findOne(id));

        return "patientDetail";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id,Model model){
            model.addAttribute("patient", service.findOne(id));
            return "patientEdit";
    }

    @PostMapping
    public String update(@ModelAttribute Patient patient){
        logger.info("Ejecutando update de PatientController");
        Patient result = service.update(patient);

        return "redirect:/patients";
    }

    @GetMapping("/new")
    public String newPatient(){
        logger.info("Ejecutando newPatient de PatientController");
        return "newPatient";
    }

    @PostMapping("/new")
    public String createPatient(@ModelAttribute Patient patient){
        logger.info("Ejecutando createPatient de PatientController");
         service.create(patient);

        return "redirect:/patients";
    }
    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") Long id){
        logger.info("Ejecutando delete de PatientController");
        service.delete(id);

        return "redirect:/patients";
    }


}
