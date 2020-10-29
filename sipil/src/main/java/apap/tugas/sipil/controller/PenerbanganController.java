package apap.tugas.sipil.controller;

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
public class PenerbanganController {
    @Autowired
    private PenerbanganService penerbanganService;

    @GetMapping("/")
    private String home(){
        return "home";
    }

    @GetMapping("/penerbangan")
    public String viewAll(Model model){
        List<PenerbanganModel> listSemuaPenerbangan = penerbanganService.getListPenerbangan();
        model.addAttribute("listSemuaPenerbangan", listSemuaPenerbangan);
        return "viewall-penerbangan";
    }






}
