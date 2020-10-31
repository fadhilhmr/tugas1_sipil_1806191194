package apap.tugas.sipil.controller;

import apap.tugas.sipil.model.*;
import apap.tugas.sipil.service.AkademiService;
import apap.tugas.sipil.service.MaskapaiService;
import apap.tugas.sipil.service.PenerbanganService;
import apap.tugas.sipil.service.PilotService;
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
            @PathVariable(value= "nip") String nip,
            Model model){

        PilotModel pilot = pilotService.getPilotByNip(nip);
        List<PilotPenerbanganModel> listBertugas = pilot.getListPilotPenerbangan();

        model.addAttribute("pilot", pilot);
        model.addAttribute("listBertugas", listBertugas);
        model.addAttribute("adaTugas", !listBertugas.isEmpty());

        return "view-pilot";
    }

    @GetMapping("/pilot/ubah/{nip}")
    public String changePilotFormPage(
            @PathVariable String nip,
            Model model
    ){
        PilotModel pilot = pilotService.getPilotByNip(nip);
        model.addAttribute("listAkademi",akademiService.getListAkademi());
        model.addAttribute("listMaskapai",maskapaiService.getListMaskapai());
        model.addAttribute("pilot", pilot);
        return "form-update-pilot";

    }
    @PostMapping("/pilot/ubah")
    public String changePilotFormSubmit(
            @ModelAttribute PilotModel pilot,
            Model model
    ){
        PilotModel pilotUpdated = pilotService.updatePilot(pilot);
        pilotService.generateNip(pilotUpdated);
        pilotService.addPilot(pilotUpdated);
        model.addAttribute("pilotUpdated",pilotUpdated);
        return "update-pilot";
    }

    @GetMapping("/pilot/hapus/{nip}")
    public String deletePilot(
            @PathVariable(value= "nip") String nip,
            Model model
    ){
        try {
            if (nip.equals(null)) {
                return "error-null-input";
            }
            PilotModel pilot = pilotService.getPilotByNip(nip);
            pilotService.deletePilot(pilot);
            return "delete-pilot";
            }
        catch (NumberFormatException e){
            return "error-input";
        }
        catch (NoSuchElementException e){
            return "error-input";
        }
    }

    @RequestMapping("cari/pilot/penerbangan-terbanyak")
    public String cariPilotTerbanyak(
            @RequestParam(value="kodeMaskapai", required = false) String kode,
            Model model){
        if(kode == null){
            List<MaskapaiModel> listMaskapai = maskapaiService.getListMaskapai();
            model.addAttribute("adaPilot", false);
            model.addAttribute("listMaskapai",listMaskapai);
            return "cari-pilot-top";
        }
        else{
            MaskapaiModel maskapai = maskapaiService.getMaskapaiByKode(kode);
            if(maskapai.getListPilot().size() > 3){
                List<PilotModel> topPilot = maskapaiService.getTopThree(kode);
                List<MaskapaiModel> listMaskapai = maskapaiService.getListMaskapai();
                model.addAttribute("listMaskapai",listMaskapai);
                model.addAttribute("adaPilot", true);
                model.addAttribute("topPilot", topPilot);
                return "cari-pilot-top";
            }
            else {
                List<PilotModel> topPilot = maskapaiService.getSortedList(kode);
                List<MaskapaiModel> listMaskapai = maskapaiService.getListMaskapai();
                model.addAttribute("listMaskapai",listMaskapai);
                model.addAttribute("adaPilot", true);
                model.addAttribute("topPilot", topPilot);
                return "cari-pilot-top";
            }
        }
    }

    @RequestMapping("/cari/pilot")
    public String cariPilotMaskAkad(
            @RequestParam(value = "kodeMaskapai" , required = false) String kode,
            @RequestParam(value = "idSekolah", required = false) Long id,
            Model model){
        if (kode == null || kode.equals("-1")){
            if((""+id).equals("-1")){
                List<AkademiModel> listAkademi = akademiService.getListAkademi();
                List<MaskapaiModel> listMaskapai = maskapaiService.getListMaskapai();
                model.addAttribute("adaPilot",false);
                model.addAttribute("listAkademi",listAkademi);
                model.addAttribute("listMaskapai",listMaskapai);
                return "cari-pilot";
            }
            else{
                List<AkademiModel> listAkademi = akademiService.getListAkademi();
                List<MaskapaiModel> listMaskapai = maskapaiService.getListMaskapai();
                List<PilotModel> listTemp = pilotService.getListPilotById_akademi(id);
                model.addAttribute("adaPilot",true);
                model.addAttribute("listAkademi",listAkademi);
                model.addAttribute("listMaskapai",listMaskapai);
                model.addAttribute("listTemp", listTemp);
                return "cari-pilot";
            }
        }
        else if((""+id).equals("-1")){
            List<AkademiModel> listAkademi = akademiService.getListAkademi();
            List<MaskapaiModel> listMaskapai = maskapaiService.getListMaskapai();
            List<PilotModel> listTemp = pilotService.getGetListPilotByKode_maskapai(kode);
            model.addAttribute("adaPilot",!listTemp.isEmpty());
            model.addAttribute("listAkademi",listAkademi);
            model.addAttribute("listMaskapai",listMaskapai);
            model.addAttribute("listTemp", listTemp);
            return "cari-pilot";
        }
        else{
            List<AkademiModel> listAkademi = akademiService.getListAkademi();
            List<MaskapaiModel> listMaskapai = maskapaiService.getListMaskapai();
            List<PilotModel> listTemp = pilotService.getGetListPilotByKode_maskapaiAndId_akademi(kode,id);
            model.addAttribute("adaPilot",!listTemp.isEmpty());
            model.addAttribute("listAkademi",listAkademi);
            model.addAttribute("listMaskapai",listMaskapai);
            model.addAttribute("listTemp", listTemp);
            return "cari-pilot";
        }

    }

}
