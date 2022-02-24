package uz.gm.gmuz.repsitry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.gm.gmuz.model.Gm;
@Repository
public interface GmRepository extends JpaRepository<Gm,Integer> {
    boolean existsByCorpName(String corpName);


}
