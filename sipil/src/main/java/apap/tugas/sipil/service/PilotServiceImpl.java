package apap.tugas.sipil.service;

import apap.tugas.sipil.model.PilotModel;
import apap.tugas.sipil.repository.PilotDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class PilotServiceImpl implements PilotService{

    @Autowired
    PilotDb pilotDb;

    @Override
    public List<PilotModel> getListPilot(){
        return pilotDb.findAll();
    }

    @Override
    public void deletePilot(PilotModel pilot){
        pilotDb.delete(pilot);
    }

    @Override
    public void addPilot(PilotModel pilot){
        pilotDb.save(pilot);
    }

    @Override
    public  PilotModel getPilotByNip(String nip){
        return pilotDb.findByNip(nip);
    }

    public int getRandomNumberUsingNextInt(int max, int min) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    @Override
    public void generateNip(PilotModel pilot){
        String str1 = Integer.toString(pilot.getJenis_kelamin());
        String str2 = pilot.getTempat_lahir().substring(0,2).toUpperCase();
        int panjang = pilot.getNama().length();
        String str3 = pilot.getNama().substring(panjang-1);
        String str4 = Integer.toString(pilot.getTanggal_lahir().getDayOfMonth());
        String str5 = Integer.toString(pilot.getTanggal_lahir().getMonth().getValue());
        int tempVar = pilot.getTanggal_lahir().getYear();
        int ans = Math.floorDiv(tempVar, 10);
        String str6 = Integer.toString(ans);
        int angka1 = getRandomNumberUsingNextInt(90,65);
        int angka2 = getRandomNumberUsingNextInt(90,65);
        String str7 = Character.toString((char)angka1 );
        String str8 = Character.toString((char)angka2 );
        String akhir = str1+str2+str3+str4+str5+str6+str7+str8;
        pilot.setNip(akhir);
    }

    @Override
    public PilotModel updatePilot(PilotModel pilot){
        PilotModel ubahPilot = pilotDb.findById(pilot.getId()).get();
        ubahPilot.setAkademi(pilot.getAkademi());
        ubahPilot.setMaskapai(pilot.getMaskapai());
        ubahPilot.setNama(pilot.getNama());
        ubahPilot.setNik(pilot.getNik());
        ubahPilot.setJenis_kelamin(pilot.getJenis_kelamin());
        ubahPilot.setTanggal_lahir(pilot.getTanggal_lahir());
        ubahPilot.setTempat_lahir(pilot.getTempat_lahir());
        return ubahPilot;
    }


}
