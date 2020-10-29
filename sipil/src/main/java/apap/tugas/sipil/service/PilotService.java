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

}
