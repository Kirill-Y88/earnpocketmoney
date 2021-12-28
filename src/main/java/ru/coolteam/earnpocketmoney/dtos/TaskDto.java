package ru.coolteam.earnpocketmoney.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
import ru.coolteam.earnpocketmoney.model.Task;
||||||| merged common ancestors
import ru.coolteam.earnpocketmoney.models.Task;
=======
import ru.coolteam.earnpocketmoney.models.Status;
import ru.coolteam.earnpocketmoney.models.Task;
import ru.coolteam.earnpocketmoney.models.User;
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TaskDto {
    private Long id;
    private String title;
    private String taskText;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserDto userCreatingTask;
    private UserDto userExecutingTask;
    private StatusDto status;
    private Long wages;
//    private Integer cost;

    public TaskDto(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.taskText = task.getTaskText();
        this.createdAt = task.getCreatedAt();
        this.updatedAt = task.getUpdatedAt();
<<<<<<< HEAD
        this.parentDto = new ParentDto(task.getParent());

||||||| merged common ancestors
        this.parentDto = new ParentDto(task.getParent());
=======
        /*this.parentDto = new ParentDto(task.getParent());
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
        if(task.getChild()!=null) {
            this.childDto = new ChildDto(task.getChild());
        }else {
            this.childDto = new ChildDto();
        }
        this.cost = task.getCost();*/
        this.userCreatingTask = new UserDto(task.getUserCreatingTask());
        if(task.getUserExecutingTask()!=null){
        this.userExecutingTask = new UserDto(task.getUserExecutingTask());
        }else {
            this.userExecutingTask = new UserDto();
        }
        this.status = new StatusDto(task.getStatus());
        this.wages = task.getWages();


    }
}
