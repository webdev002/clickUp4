package pdp.uz.appclickup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appclickup.entity.User;
import pdp.uz.appclickup.payload.ApiResponse;
import pdp.uz.appclickup.payload.CheckListItemDTO;
import pdp.uz.appclickup.security.CurrentUser;
import pdp.uz.appclickup.service.CheckListItemService;

@RestController
@RequestMapping("/api/checkListItem")
public class CheckListItemController {
    @Autowired
    CheckListItemService checkListItemService;

    @PostMapping
    public HttpEntity<?> addCheckListItem(@RequestBody CheckListItemDTO checkListItemDTO, @CurrentUser User user){
        ApiResponse apiResponse = checkListItemService.addCheckListItem(checkListItemDTO, user);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editCheckListItem(@PathVariable Integer id,@CurrentUser User user,@RequestBody CheckListItemDTO checkListItemDTO){
        ApiResponse apiResponse = checkListItemService.editChecklistItem(id, user, checkListItemDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteCheckListItem(@PathVariable Integer id){
        ApiResponse apiResponse = checkListItemService.deleteCheckListItem(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
