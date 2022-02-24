package uz.gm.gmuz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.gm.gmuz.Dto.ApiResponse;
import uz.gm.gmuz.Dto.GmDTO;
import uz.gm.gmuz.model.Address;
import uz.gm.gmuz.model.Gm;
import uz.gm.gmuz.repsitry.AddressRepository;
import uz.gm.gmuz.repsitry.GmRepository;

@Service
public class GmService {
    private  final GmRepository gmRepository;
    private final AddressRepository addressRepository;
    @Autowired
    public GmService(GmRepository gmRepository, AddressRepository addressRepository) {
        this.gmRepository = gmRepository;
        this.addressRepository = addressRepository;
    }

    public ApiResponse addGm(GmDTO gmDTO){
        if (gmRepository.existsByCorpName(gmDTO.getCorpName()))
            return new ApiResponse("Already exist CorpName",false);
        if (addressRepository.existsByStreetAndHouseNumber(gmDTO.getStreet(),gmDTO.getHouseNumber()))
            return new ApiResponse("Already exist Address",false);
        Address address = new Address();
        address.setStreet(gmDTO.getStreet());
        address.setHouseNumber(gmDTO.getHouseNumber());
        address.setDistrictName(gmDTO.getDistrictName());
        Address address1 = addressRepository.save(address);
        Gm gm = new Gm();
        gm.setAddress(address1);
        gm.setCorpName(gmDTO.getCorpName());
        gm.setDirectorName(gmDTO.getDirectorName());
        gmRepository.save(gm);
        return  new ApiResponse("Successfully added",true);
    }
}
