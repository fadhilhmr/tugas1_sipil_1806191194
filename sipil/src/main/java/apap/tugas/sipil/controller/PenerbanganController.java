package apap.tugas.sipil.controller;

import apap.tugas.sipil.model.PilotModel;
import apap.tugas.sipil.model.PilotPenerbanganModel;
import apap.tugas.sipil.repository.PenerbanganDb;
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

    @GetMapping("/penerbangan/detail/{id}")
    private String detailPenerbangan(
            @PathVariable(value= "id") Long id,
            Model model){
        PenerbanganModel penerbangan = penerbanganService.getPenerbanganById(id);
        List<PilotPenerbanganModel> listBertugas = penerbangan.getListPilotPenerbangan();

        model.addAttribute("penerbangan", penerbangan);
        model.addAttribute("listBertugas", listBertugas);
        model.addAttribute("adaTugas", !listBertugas.isEmpty());


        return "view-penerbangan";
    }

    @GetMapping("/penerbangan/tambah")
    private String addPenerbanganFormPage(Model model){
        model.addAttribute("penerbangan", new PenerbanganModel());
        return "form-add-penerbangan";
    }

    @PostMapping("/penerbangan/tambah")
    public String addPenerbanganSubmit(
            @ModelAttribute PenerbanganModel penerbangan,
            Model model){
        penerbanganService.addPenerbangan(penerbangan);
        model.addAttribute("kode", penerbangan.getKode());
        return "add-penerbangan";
    }

    @GetMapping("/penerbangan/hapus/{id}")
    public String deletePenerbangan(
            @PathVariable(value= "id") Long id,
            Model model
    ){
        try {
            if (id == null) {
                return "error-null-input";
            }
            PenerbanganModel penerbangan = penerbanganService.getPenerbanganById(id);
            penerbanganService.deletePenerbangan(penerbangan);
            return "delete-penerbangan";
        }
        catch (NumberFormatException e){
            return "error-input";
        }
        catch (NoSuchElementException e){
            return "error-input";
        }
    }

    @GetMapping("/penerbangan/ubah/{id}")
    public String changePenerbanganFormPage(
            @PathVariable Long id,
            Model model
    ){
        PenerbanganModel penerbangan = penerbanganService.getPenerbanganById(id);
        model.addAttribute("penerbangan", penerbangan);
        return "form-update-penerbangan";

    }
    @PostMapping("/penerbangan/ubah")
    public String changePenerbanganFormSubmit(
            @ModelAttribute PenerbanganModel penerbangan,
            Model model
    ){
        PenerbanganModel penerbanganBaru = penerbanganService.updatePenerbangan(penerbangan);
        penerbanganService.addPenerbangan(penerbanganBaru);
        model.addAttribute("penerbanganBaru",penerbanganBaru);
        model.addAttribute("kode",penerbanganBaru.getKode());
        return "update-penerbangan";
    }








}
