package apap.tugas.sipil.service;

import apap.tugas.sipil.model.PenerbanganModel;
import apap.tugas.sipil.model.PilotModel;
import apap.tugas.sipil.repository.PenerbanganDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PenerbanganServiceImpl implements PenerbanganService{

    @Autowired
    PenerbanganDb penerbanganDb;

    @Override
    public List<PenerbanganModel> getListPenerbangan(){
        return penerbanganDb.findAll();
    }

    @Override
    public void deletePenerbangan(PenerbanganModel penerbangan){
        penerbanganDb.delete(penerbangan);
    }

    @Override
    public void addPenerbangan(PenerbanganModel penerbangan){
        penerbanganDb.save(penerbangan);
    }

    @Override
    public PenerbanganModel getPenerbanganById(Long id){
        return penerbanganDb.findById(id).get();
    }

    @Override
    public PenerbanganModel updatePenerbangan(PenerbanganModel penerbangan){
        PenerbanganModel ubahPenerbangan=penerbanganDb.findById(penerbangan.getId()).get();
        ubahPenerbangan.setKode(penerbangan.getKode());
        ubahPenerbangan.setKota_asal(penerbangan.getKota_asal());;
        ubahPenerbangan.setKota_tujuan(penerbangan.getKota_tujuan());
        ubahPenerbangan.setWaktu(penerbangan.getWaktu());
        return ubahPenerbangan;
    }



}
