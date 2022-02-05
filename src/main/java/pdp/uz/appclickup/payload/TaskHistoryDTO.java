package pdp.uz.appclickup.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pdp.uz.appclickup.entity.Task;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskHistoryDTO {
    @NotNull
    private Integer task;

    @NotNull
    private String changeFieldName;

    @NotNull
    private String before;

    @NotNull
    private String after;
}
