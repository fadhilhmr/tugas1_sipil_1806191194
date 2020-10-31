package apap.tugas.sipil.service;

import apap.tugas.sipil.model.MaskapaiModel;
import apap.tugas.sipil.model.PilotModel;

import java.util.List;

public interface MaskapaiService {
    List<MaskapaiModel> getListMaskapai();

    List<PilotModel> getTopThree(String Kode);

    List<PilotModel> getSortedList(String Kode);

    MaskapaiModel getMaskapaiByKode(String kode);

}
