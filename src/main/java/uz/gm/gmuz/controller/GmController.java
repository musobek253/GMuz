package uz.gm.gmuz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.gm.gmuz.Dto.ApiResponse;
import uz.gm.gmuz.Dto.GmDTO;
import uz.gm.gmuz.model.Gm;
import uz.gm.gmuz.repsitry.GmRepository;
import uz.gm.gmuz.service.GmService;

import java.util.List;

@RestController
@RequestMapping("/gm")
public class GmController {
    private final GmRepository gmRepository;
    private final GmService gmService;
    @Autowired
    public GmController(GmRepository gmRepository, GmService gmService) {
        this.gmRepository = gmRepository;
        this.gmService = gmService;
    }
    @PostMapping("/add")
    public ApiResponse addGm(@RequestBody GmDTO gmDTO){
        return gmService.addGm(gmDTO);
    }
    @GetMapping("/all")
    public List<Gm> getAllGm(){
        return gmRepository.findAll();
    }

}
