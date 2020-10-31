package apap.tugas.sipil.service;

import apap.tugas.sipil.model.MaskapaiModel;
import apap.tugas.sipil.model.PilotModel;
import apap.tugas.sipil.repository.MaskapaiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class MaskapaiServiceImpl implements MaskapaiService{

    @Autowired
    MaskapaiDb maskapaiDb;

    @Override
    public List<MaskapaiModel> getListMaskapai(){
        return maskapaiDb.findAll();
    }

    @Override
    public MaskapaiModel getMaskapaiByKode(String kode){
        return maskapaiDb.findByKode(kode).get();
    }

    @Override
    public List<PilotModel> getSortedList(String kode){
        MaskapaiModel maskapai = maskapaiDb.findByKode(kode).get();
        List<PilotModel> temp = maskapai.getListPilot();
        if(temp.size() == 1){
            return temp;
        }
        else if(temp.size() == 2){
            if(temp.get(1).getListPilotPenerbangan().size() > temp.get(0).getListPilotPenerbangan().size()){
                PilotModel baru0 = temp.get(0);
                PilotModel baru1 = temp.get(1);
                temp.clear();
                temp.add(baru1);
                temp.add(baru0);
                return temp;
            }
            return temp;
        }
        else if(temp.size() == 3){
            if(temp.get(1).getListPilotPenerbangan().size() > temp.get(0).getListPilotPenerbangan().size()){
                if(temp.get(2).getListPilotPenerbangan().size() > temp.get(1).getListPilotPenerbangan().size()){
                    PilotModel baru0 = temp.get(0);
                    PilotModel baru1 = temp.get(1);
                    PilotModel baru2 = temp.get(2);
                    temp.clear();
                    temp.add(baru2);
                    temp.add(baru1);
                    temp.add(baru0);
                    return temp;
                }
                else if(temp.get(2).getListPilotPenerbangan().size() > temp.get(0).getListPilotPenerbangan().size()){
                    PilotModel baru0 = temp.get(0);
                    PilotModel baru1 = temp.get(1);
                    PilotModel baru2 = temp.get(2);
                    temp.clear();
                    temp.add(baru1);
                    temp.add(baru2);
                    temp.add(baru0);
                    return temp;
                }
                else{
                    PilotModel baru0 = temp.get(0);
                    PilotModel baru1 = temp.get(1);
                    PilotModel baru2 = temp.get(2);
                    temp.clear();
                    temp.add(baru1);
                    temp.add(baru0);
                    temp.add(baru2);
                    return temp;
                }
            }
            else if(temp.get(1).getListPilotPenerbangan().size() < temp.get(0).getListPilotPenerbangan().size()){
                if(temp.get(2).getListPilotPenerbangan().size() > temp.get(0).getListPilotPenerbangan().size()){
                    PilotModel baru0 = temp.get(0);
                    PilotModel baru1 = temp.get(1);
                    PilotModel baru2 = temp.get(2);
                    temp.clear();
                    temp.add(baru2);
                    temp.add(baru0);
                    temp.add(baru1);
                    return temp;
                }
                else if(temp.get(0).getListPilotPenerbangan().size() > temp.get(2).getListPilotPenerbangan().size()){
                    if(temp.get(2).getListPilotPenerbangan().size()>temp.get(1).getListPilotPenerbangan().size()){
                        PilotModel baru0 = temp.get(0);
                        PilotModel baru1 = temp.get(1);
                        PilotModel baru2 = temp.get(2);
                        temp.clear();
                        temp.add(baru0);
                        temp.add(baru2);
                        temp.add(baru1);
                        return temp;
                    }
                    else{
                        PilotModel baru0 = temp.get(0);
                        PilotModel baru1 = temp.get(1);
                        PilotModel baru2 = temp.get(2);
                        temp.clear();
                        temp.add(baru0);
                        temp.add(baru1);
                        temp.add(baru2);
                        return temp;
                    }
                }
            }
        }
        return temp;
    }

    @Override
    public List<PilotModel> getTopThree(String kode){
        MaskapaiModel maskapai = maskapaiDb.findByKode(kode).get();
        List<PilotModel> temp = maskapai.getListPilot();
        int panjang = temp.size();
        List<PilotModel> top = new ArrayList<PilotModel>();
        PilotModel[] arr= new PilotModel[panjang];
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (arr[j].getListPilotPenerbangan().size() > arr[j+1].getListPilotPenerbangan().size())
                {
                    PilotModel tempPilot = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tempPilot;
                }
            }
        }
        top.add(arr[n-1]);
        top.add(arr[n-2]);
        top.add(arr[-3]);
        return top;
    }
}