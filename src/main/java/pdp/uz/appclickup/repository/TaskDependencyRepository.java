package pdp.uz.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appclickup.entity.TaskDependency;

public interface TaskDependencyRepository extends JpaRepository<TaskDependency,Integer> {
    boolean existsByIdAndTask_Id(Integer id, Integer task_id);
}
