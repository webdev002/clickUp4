package pdp.uz.appclickup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appclickup.payload.ApiResponse;
import pdp.uz.appclickup.payload.TaskHistoryDTO;
import pdp.uz.appclickup.service.TaskHistoryService;

@RestController
@RequestMapping("/api/taskHistory")
public class TaskHistoryController {
    @Autowired
    TaskHistoryService taskHistoryService;

    @PostMapping
    public HttpEntity<?> addTaskHistory(@RequestBody TaskHistoryDTO taskHistoryDTO){
        ApiResponse apiResponse = taskHistoryService.addTaskHistory(taskHistoryDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editTaskHistory(@RequestBody TaskHistoryDTO taskHistoryDTO,@PathVariable Integer id){
        ApiResponse apiResponse = taskHistoryService.editTaskHistory(id, taskHistoryDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteTaskHistory(@PathVariable Integer id){
        ApiResponse apiResponse = taskHistoryService.deleteTaskHistory(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
