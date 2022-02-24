package uz.gm.gmuz.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
public class GmDTO {

    private String corpName;
    private String directorName;
    private String street;
    private String houseNumber;
    private String districtName;
}
