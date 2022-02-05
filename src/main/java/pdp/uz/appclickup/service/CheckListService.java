package pdp.uz.appclickup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.appclickup.entity.CheckList;
import pdp.uz.appclickup.payload.ApiResponse;
import pdp.uz.appclickup.payload.CheckListDTO;
import pdp.uz.appclickup.repository.CheckListRepository;
import pdp.uz.appclickup.repository.TaskRepository;

@Service
public class CheckListService {
    @Autowired
    CheckListRepository checkListRepository;
    @Autowired
    TaskRepository taskRepository;

    public ApiResponse addCheckList(CheckListDTO checkListDTO) {
        CheckList checkList = new CheckList(checkListDTO.getName(), taskRepository.getById(checkListDTO.getTask()));
        checkListRepository.save(checkList);
        return new ApiResponse("CheckList saqlandi",true);
    }

    public ApiResponse editCheckList(Integer id, CheckListDTO checkListDTO) {
        boolean exists = checkListRepository.existsByNameAndIdNot(checkListDTO.getName(), id);
        if (exists){
            return new ApiResponse("Bunday idlik checkList mavjud",false);
        }
        CheckList checkList = checkListRepository.getById(id);
        checkList.setName(checkListDTO.getName());
        checkList.setTask(taskRepository.getById(checkListDTO.getTask()));
        checkListRepository.save(checkList);
        return new ApiResponse("CheckList tahrirlandi",true);
    }

    public ApiResponse deleteCheckList(Integer id) {
        checkListRepository.deleteById(id);
        return new ApiResponse("CheckList o'chirildi",true);
    }
}
