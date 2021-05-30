package com.example.hrms.core.concretes;

import MernisServices.UCNKPSPublicSoap;
import com.example.hrms.core.abstracts.UserCheckService;
import com.example.hrms.entities.concretes.Candidates;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;

@Service
public class MernisService implements UserCheckService {

    @Override
    public boolean CheckIfRealPerson(Candidates candidates) {

        UCNKPSPublicSoap candidate = new UCNKPSPublicSoap();
        try {
            return candidate.TCKimlikNoDogrula(Long.parseLong(candidates.getNationaltyNo()), candidates.getName(),
                    candidates.getLastName(), candidates.getBirthDate().getYear());
        }catch (NumberFormatException | RemoteException e){
            System.out.println(e);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
