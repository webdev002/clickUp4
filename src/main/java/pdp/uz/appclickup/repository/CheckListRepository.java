package pdp.uz.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appclickup.entity.CheckList;

public interface CheckListRepository extends JpaRepository<CheckList,Integer> {
    boolean existsByNameAndIdNot(String name, Integer id);
}
