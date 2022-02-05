package pdp.uz.appclickup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appclickup.entity.TaskDependency;
import pdp.uz.appclickup.payload.ApiResponse;
import pdp.uz.appclickup.payload.TaskDependencyDTO;
import pdp.uz.appclickup.repository.TaskDependencyRepository;
import pdp.uz.appclickup.service.TaskDependencyService;

@RestController
@RequestMapping("/api/taskDependency")
public class TaskDependencyController {
    @Autowired
    TaskDependencyService taskDependencyService;
    @PostMapping
    public HttpEntity<?> addTaskDependency(@RequestBody TaskDependencyDTO taskDependencyDTO){
        ApiResponse apiResponse = taskDependencyService.addTaskDependency(taskDependencyDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editTaskDependency(@PathVariable Integer id,@RequestBody TaskDependencyDTO taskDependencyDTO){
        ApiResponse apiResponse = taskDependencyService.editTaskDependency(id, taskDependencyDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteTaskDependency(@PathVariable Integer id){
        ApiResponse apiResponse = taskDependencyService.deleteTaskDependency(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
