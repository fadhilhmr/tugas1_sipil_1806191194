package apap.tugas.sipil.controller;

import apap.tugas.sipil.model.PilotModel;
import apap.tugas.sipil.service.AkademiService;
import apap.tugas.sipil.service.MaskapaiService;
import apap.tugas.sipil.service.PenerbanganService;
import apap.tugas.sipil.service.PilotService;
import apap.tugas.sipil.model.PenerbanganModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class PilotController {

    @Autowired
    private PilotService pilotService;

    @Autowired
    private MaskapaiService maskapaiService;

    @Autowired
    private AkademiService akademiService;

    @GetMapping("/pilot")
    public String viewAll(Model model){
        List<PilotModel> listSemuaPilot = pilotService.getListPilot();
        model.addAttribute("listSemuaPilot", listSemuaPilot);
        return "viewall-pilot";
    }

    @GetMapping("/pilot/tambah")
    private String addPilotFormPage(Model model){
        model.addAttribute("listAkademi",akademiService.getListAkademi());
        model.addAttribute("listMaskapai",maskapaiService.getListMaskapai());
        model.addAttribute("pilot", new PilotModel());
        return "form-add-pilot";
    }

    @PostMapping("/pilot/tambah")
    public String addPilotSubmit(
            @ModelAttribute PilotModel pilot,
            Model model){
        pilotService.generateNip(pilot);
        pilotService.addPilot(pilot);
        model.addAttribute("nip", pilot.getNip());
        return "add-pilot";
    }

    @GetMapping("/pilot/{nip}")
    private String lihatPilot(
            @PathVariable String nip,
            Model model){

        model.addAttribute("pilot", pilot);
        model.addAttribute("l")

        return "form-add-pilot";
    }


}
