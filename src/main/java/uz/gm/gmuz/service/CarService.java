package uz.gm.gmuz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.gm.gmuz.Dto.ApiResponse;
import uz.gm.gmuz.model.Car;
import uz.gm.gmuz.repsitry.CarRepositary;

@Service
public class CarService {
    public CarService(CarRepositary carRepositary) {
        this.carRepositary = carRepositary;
    }
    @Autowired
    private final CarRepositary carRepositary;

    public ApiResponse addCar(Car car){
        carRepositary.save(car);
        return new ApiResponse("Successfully added",true);
    }
}
