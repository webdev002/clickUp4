package pdp.uz.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appclickup.entity.TaskHistory;
import pdp.uz.appclickup.payload.TaskHistoryDTO;

public interface TaskHistoryRepository extends JpaRepository<TaskHistory,Integer> {
    boolean existsByIdAndTaskId(Integer id, Integer task_id);
}
