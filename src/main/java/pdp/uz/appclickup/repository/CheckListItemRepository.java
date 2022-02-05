package pdp.uz.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appclickup.entity.CheckListItem;
import pdp.uz.appclickup.entity.User;

public interface CheckListItemRepository extends JpaRepository<CheckListItem,Integer> {
    boolean existsByAssignedUserAndName(User assignedUser, String name);
    boolean existsByNameAndIdNot(String name, Integer id);
}
