package apap.tugas.sipil.service;

import apap.tugas.sipil.model.PilotModel;
import java.util.List;

public interface PilotService {
    List<PilotModel> getListPilot();

    void addPilot(PilotModel pilot);

    void generateNip(PilotModel pilot);

    PilotModel getPilotByNip(String nip);

    PilotModel updatePilot(PilotModel pilot);

    void deletePilot(PilotModel pilot);

    List<PilotModel> getListPilotById_akademi(Long id);

    List<PilotModel> getGetListPilotByKode_maskapai(String kode);

    List<PilotModel> getGetListPilotByKode_maskapaiAndId_akademi(String kode, Long id);


}
