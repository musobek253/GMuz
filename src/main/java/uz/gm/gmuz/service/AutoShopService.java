package uz.gm.gmuz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import uz.gm.gmuz.Dto.ApiResponse;
import uz.gm.gmuz.Dto.AutoShopDto;
import uz.gm.gmuz.model.Address;
import uz.gm.gmuz.model.AutoShop;
import uz.gm.gmuz.repsitry.AddressRepository;
import uz.gm.gmuz.repsitry.AutoShopRepositary;
import uz.gm.gmuz.repsitry.CarRepositary;
import uz.gm.gmuz.repsitry.GmRepository;

@Service
public class AutoShopService {
    private final AddressRepository addressRepository;
    private final GmRepository gmRepository;
    private final AutoShopRepositary autoShopRepositary;
    private final CarRepositary carRepositary;
    @Autowired
    public AutoShopService(AddressRepository addressRepository, GmRepository gmRepository, AutoShopRepositary autoShopRepositary, CarRepositary carRepositary) {
        this.addressRepository = addressRepository;
        this.gmRepository = gmRepository;
        this.autoShopRepositary = autoShopRepositary;
        this.carRepositary = carRepositary;
    }

    public ApiResponse addAutoShop(@RequestBody AutoShopDto autoShopDto){
        if (addressRepository.existsByStreetAndHouseNumber(autoShopDto.getStreet(),autoShopDto.getHouseNumber()))
            return new ApiResponse("Already exist Address",false);
        if (!gmRepository.findById(autoShopDto.getGmId()).isPresent())
            return new ApiResponse("Not found Gm",false);
        if (!carRepositary.existsByIdIn(autoShopDto.getCarsId()))
            return new ApiResponse("Not found cars",false);
        Address address = new Address();
        address.setStreet(autoShopDto.getStreet());
        address.setDistrictName(autoShopDto.getDistrictName());
        address.setHouseNumber(autoShopDto.getHouseNumber());
        Address address1 = addressRepository.save(address);
        AutoShop autoShop = new AutoShop();
        autoShop.setAddress(address1);
        autoShop.setGm(gmRepository.findById(autoShopDto.getGmId()).get());
        autoShop.setName(autoShopDto.getName());
        autoShop.setCars(carRepositary.findAllByIdIn(autoShopDto.getCarsId()));
        autoShopRepositary.save(autoShop);
        return new ApiResponse("successfully add",true);

    }


}
