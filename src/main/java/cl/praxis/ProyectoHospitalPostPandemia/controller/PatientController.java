package cl.praxis.ProyectoHospitalPostPandemia.controller;
import cl.praxis.ProyectoHospitalPostPandemia.model.dto.Patient;
import cl.praxis.ProyectoHospitalPostPandemia.service.IPatient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patients")
public class PatientController {


    //@Autowired
    private IPatient service;

        public PatientController(IPatient service) {
        this.service = service;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("patients", service.findAll());
        return "patientList";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") Long id, Model model){
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
        Patient result = service.update(patient);

        return "redirect:/patients";
    }

    @GetMapping("/new")
    public String newPatient(){
        return "newPatient";
    }

    @PostMapping("/new")
    public String createPatient(@ModelAttribute Patient patient){
         service.create(patient);

        return "redirect:/patients";
    }
    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") Long id){
        service.delete(id);

        return "redirect:/patients";
    }


}
