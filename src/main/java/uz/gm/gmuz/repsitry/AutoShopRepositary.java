package uz.gm.gmuz.repsitry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.gm.gmuz.model.AutoShop;

import java.util.List;

@Repository
public interface AutoShopRepositary extends JpaRepository<AutoShop,Integer> {

    List<AutoShop> getAutoShopByGmId(Integer gm_id);
}
