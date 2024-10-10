package com.example.bioproject.service;

import com.example.bioproject.model.Kiosk;
import com.example.bioproject.repository.KioskRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class KioskService {
    KioskRepository kioskRepository;

    public KioskService(KioskRepository kioskRepository){
        this.kioskRepository = kioskRepository;
    }

    public List<Kiosk> getKioskList(){
        List<Kiosk> kioskList = kioskRepository.getKioskList();
        return kioskList;
    }

    public void createKioskItem(Kiosk newKioskItem){
        kioskRepository.createKioskItem(newKioskItem);
    }

    public void deleteKioskItem(int ID){
        kioskRepository.deleteKiosk(ID);
    }

    public void updateKiosk(int ID, Kiosk updatedKiosk){
        kioskRepository.updateKiosk(ID, updatedKiosk);
    }
}
