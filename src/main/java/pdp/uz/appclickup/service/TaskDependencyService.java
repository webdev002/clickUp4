package pdp.uz.appclickup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.appclickup.entity.TaskDependency;
import pdp.uz.appclickup.entity.enums.DependencyType;
import pdp.uz.appclickup.payload.ApiResponse;
import pdp.uz.appclickup.payload.TaskDependencyDTO;
import pdp.uz.appclickup.repository.TaskDependencyRepository;
import pdp.uz.appclickup.repository.TaskRepository;

@Service
public class TaskDependencyService {
    @Autowired
    TaskDependencyRepository taskDependencyRepository;

    @Autowired
    TaskRepository taskRepository;


    public ApiResponse addTaskDependency(TaskDependencyDTO taskDependencyDTO) {
        TaskDependency taskDependency = new TaskDependency();
        taskDependency.setTask(taskRepository.getById(taskDependencyDTO.getTask()));
        taskDependency.setTaskDependency(taskDependencyRepository.getById(taskDependencyDTO.getTaskDependency()));
        taskDependency.setDependencyType(DependencyType.WAITING);
        return new ApiResponse("TaskDependency saqlandi",true);
    }

    public ApiResponse editTaskDependency(Integer id, TaskDependencyDTO taskDependencyDTO) {
        boolean exists = taskDependencyRepository.existsByIdAndTask_Id(id, taskDependencyDTO.getTask());
        if (exists){
            return new ApiResponse("bunday idlik taskDependency mavjud",false);
        }
        TaskDependency taskDependency = taskDependencyRepository.getById(id);
        taskDependency.setTask(taskRepository.getById(taskDependencyDTO.getTask()));
        taskDependency.setTaskDependency(taskDependencyRepository.getById(taskDependencyDTO.getTaskDependency()));
        taskDependency.setDependencyType(DependencyType.WAITING);
        return new ApiResponse("TaskDependency tahrirlandi",true);
    }

    public ApiResponse deleteTaskDependency(Integer id) {
        taskDependencyRepository.deleteById(id);
        return new ApiResponse("TaskDependency o'chirildi",true);
    }
}
