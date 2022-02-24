package uz.gm.gmuz.repsitry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.gm.gmuz.model.Car;

import java.util.List;

@Repository
public interface CarRepositary extends JpaRepository<Car,Integer> {


    boolean existsByIdIn(List<Integer> ids);

    List<Car> findAllByIdIn(List<Integer> ids);

    @Query(value = "select *from car join auto_shop_cars uc on car.id = uc.cars_id\n" +
            "where  uc.auto_shop_id =:autoShopId",nativeQuery = true)
    List<Car>  getCarByAndAutoShopNative(Integer autoShopId);
}
