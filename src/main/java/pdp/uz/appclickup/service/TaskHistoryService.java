package pdp.uz.appclickup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.appclickup.entity.TaskHistory;
import pdp.uz.appclickup.payload.ApiResponse;
import pdp.uz.appclickup.payload.TaskHistoryDTO;
import pdp.uz.appclickup.repository.TaskHistoryRepository;
import pdp.uz.appclickup.repository.TaskRepository;

import java.util.Date;

@Service
public class TaskHistoryService {
    @Autowired
    TaskHistoryRepository taskHistoryRepository;
    @Autowired
    TaskRepository taskRepository;

    public ApiResponse addTaskHistory(TaskHistoryDTO taskHistoryDTO) {
        TaskHistory taskHistory = new TaskHistory();
        taskHistory.setTask(taskRepository.getById(taskHistoryDTO.getTask()));
        taskHistory.setBefore(taskHistoryDTO.getBefore());
        taskHistory.setAfter(taskHistoryDTO.getAfter());
        taskHistory.setDate(new Date());
        taskHistoryRepository.save(taskHistory);
        return new ApiResponse("TaskHistory saqlandi",true);
    }

    public ApiResponse editTaskHistory(Integer id, TaskHistoryDTO taskHistoryDTO) {
        boolean exists = taskHistoryRepository.existsByIdAndTaskId(id, taskHistoryDTO.getTask());
        if (exists){
            return new ApiResponse("Bunday idlik taskHistory mavjud",false);
        }
        TaskHistory taskHistory = taskHistoryRepository.getById(id);
        taskHistory.setTask(taskRepository.getById(taskHistoryDTO.getTask()));
        taskHistory.setBefore(taskHistoryDTO.getBefore());
        taskHistory.setAfter(taskHistoryDTO.getAfter());
        taskHistory.setDate(new Date());
        taskHistoryRepository.save(taskHistory);
        return new ApiResponse("TaskHistory tahrirlandi",true);
    }

    public ApiResponse deleteTaskHistory(Integer id) {
        taskHistoryRepository.deleteById(id);
        return new ApiResponse("TaskHistory o'chirildi",true);
    }
}
