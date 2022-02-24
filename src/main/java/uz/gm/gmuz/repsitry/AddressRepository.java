package uz.gm.gmuz.repsitry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import uz.gm.gmuz.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer>, JpaSpecificationExecutor<Address> {
    boolean existsByStreetAndHouseNumber(String street, String houseNumber);

}
