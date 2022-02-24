package uz.gm.gmuz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.gm.gmuz.Dto.ApiResponse;
import uz.gm.gmuz.Dto.AutoShopDto;
import uz.gm.gmuz.model.AutoShop;
import uz.gm.gmuz.repsitry.AutoShopRepositary;
import uz.gm.gmuz.service.AutoShopService;

import java.util.List;

@RestController
@RequestMapping("/autoShop")
public class AutoShopController {
    private final AutoShopRepositary autoShopRepositary;
    private final AutoShopService autoShopService;
    @Autowired
    public AutoShopController(AutoShopRepositary autoShopRepositary, AutoShopService autoShopService) {
        this.autoShopRepositary = autoShopRepositary;
        this.autoShopService = autoShopService;
    }
    @PostMapping("/add")
    public ApiResponse addAutoShop(@RequestBody AutoShopDto autoShopDto){
        return autoShopService.addAutoShop(autoShopDto);
    }

    @GetMapping("/all")
    public List<AutoShop> getAllAutoShop(){
        return autoShopRepositary.findAll();
    }

    @GetMapping("/GmId/{gm_id}")
    public List<AutoShop> getBYgmId(@PathVariable Integer gm_id){
        return  autoShopRepositary.getAutoShopByGmId(gm_id);
    }
}
