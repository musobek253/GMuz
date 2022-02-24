package uz.gm.gmuz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.gm.gmuz.Dto.ApiResponse;
import uz.gm.gmuz.model.Car;
import uz.gm.gmuz.repsitry.CarRepositary;
import uz.gm.gmuz.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/Car")
public class CarController {
    private final CarRepositary carRepositary;
    private final CarService carService;
    @Autowired
    public CarController(CarRepositary carRepositary, CarService carService) {
        this.carRepositary = carRepositary;
        this.carService = carService;
    }
    @PostMapping("/add")
    public ApiResponse addCar(@RequestBody Car car){
        return carService.addCar(car);
    }
    @GetMapping("/all")
    public List<Car> getAll(){
        return carRepositary.findAll();
    }
    @GetMapping("/autoshopId/{autoShopId}")
    public List<Car> getByAutoShop(@PathVariable Integer autoShopId){
        return carRepositary.getCarByAndAutoShopNative(autoShopId);
    }
}
