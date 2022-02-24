package uz.gm.gmuz.Dto;

import lombok.Data;

import java.util.List;

@Data
public class AutoShopDto {

    private String name;
    private String street;
    private String houseNumber;
    private String districtName;
    private Integer gmId;
    private List<Integer> carsId;
}
