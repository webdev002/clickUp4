package pdp.uz.appclickup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appclickup.payload.ApiResponse;
import pdp.uz.appclickup.payload.CheckListDTO;
import pdp.uz.appclickup.service.CheckListService;

@RestController
@RequestMapping("/api/checkList")
public class CheckListController {
    @Autowired
    CheckListService checkListService;

    @PostMapping
    public HttpEntity<?> addCheckList(@RequestBody CheckListDTO checkListDTO){
        ApiResponse apiResponse = checkListService.addCheckList(checkListDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editCheckList(@PathVariable Integer id, @RequestBody CheckListDTO checkListDTO){
        ApiResponse apiResponse = checkListService.editCheckList(id, checkListDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteCheckList(@PathVariable Integer id){
        ApiResponse apiResponse = checkListService.deleteCheckList(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

}
