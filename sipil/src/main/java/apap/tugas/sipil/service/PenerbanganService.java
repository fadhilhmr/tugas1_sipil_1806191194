package apap.tugas.sipil.service;

import apap.tugas.sipil.model.PenerbanganModel;
import apap.tugas.sipil.model.PilotModel;

import java.util.List;

public interface PenerbanganService {
    List<PenerbanganModel> getListPenerbangan();

    void addPenerbangan(PenerbanganModel penerbangan);

    PenerbanganModel getPenerbanganById(Long id);

    PenerbanganModel updatePenerbangan(PenerbanganModel penerbangan);

    void deletePenerbangan(PenerbanganModel penerbangan);
}
