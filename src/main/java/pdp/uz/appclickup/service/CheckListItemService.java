package pdp.uz.appclickup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.appclickup.entity.CheckList;
import pdp.uz.appclickup.entity.CheckListItem;
import pdp.uz.appclickup.entity.User;
import pdp.uz.appclickup.payload.ApiResponse;
import pdp.uz.appclickup.payload.CheckListItemDTO;
import pdp.uz.appclickup.repository.CheckListItemRepository;
import pdp.uz.appclickup.repository.CheckListRepository;

@Service
public class CheckListItemService {
    @Autowired
    CheckListItemRepository checkListItemRepository;
    @Autowired
    CheckListRepository checkListRepository;

    public ApiResponse addCheckListItem(CheckListItemDTO checkListItemDTO, User user) {
        boolean exists = checkListItemRepository.existsByAssignedUserAndName(user, checkListItemDTO.getName());
        if (exists){
            return new ApiResponse("Bu userda bunday namelik checklist mavjud",false);
        }
        CheckListItem checkListItem = new CheckListItem();
        checkListItem.setName(checkListItem.getName());
        checkListItem.setCheckList(checkListRepository.getById(checkListItemDTO.getCheckList()));
        checkListItem.setResolved(checkListItem.getResolved());
        checkListItem.setAssignedUser(user);
        return new ApiResponse("CheckListItem saqlandi",true);
    }

    public ApiResponse editChecklistItem(Integer id, User user, CheckListItemDTO checkListItemDTO) {
        boolean exists = checkListItemRepository.existsByNameAndIdNot(checkListItemDTO.getName(), id);
        if (exists){
            return new ApiResponse("Bunday idlik checkListItem mavjud",false);
        }
        CheckListItem checkListItem = checkListItemRepository.getById(id);
        checkListItem.setName(checkListItem.getName());
        checkListItem.setCheckList(checkListRepository.getById(checkListItemDTO.getCheckList()));
        checkListItem.setResolved(checkListItem.getResolved());
        checkListItem.setAssignedUser(user);
        return new ApiResponse("CheckListItem saqlandi",true);
    }

    public ApiResponse deleteCheckListItem(Integer id) {
        checkListItemRepository.deleteById(id);
        return new ApiResponse("checkListItem o'chirildi",true);
    }
}
