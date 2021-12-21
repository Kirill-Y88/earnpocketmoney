package ru.coolteam.earnpocketmoney.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.coolteam.earnpocketmoney.dtos.TaskDto;
import ru.coolteam.earnpocketmoney.model.Child;
import ru.coolteam.earnpocketmoney.model.Parent;
import ru.coolteam.earnpocketmoney.model.Task;
import ru.coolteam.earnpocketmoney.services.ChildService;
import ru.coolteam.earnpocketmoney.services.ParentService;
import ru.coolteam.earnpocketmoney.services.TaskService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v2/tasks")
public class TaskController {
    private final TaskService taskService;
    private final ParentService parentService;
    private final ChildService childService;

    @GetMapping("/all")
    public String getAllTasks(Model model) {
        List<TaskDto> tasks = taskService.findAll()
                .stream().
                map(TaskDto::new)
                .collect(Collectors.toList());

        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/{id}")
    public String showTaskInfo (@PathVariable(name = "id") Long id, Model model) {
        Optional<Task> task = taskService.findById(id);
        if (task.isPresent()) {
            model.addAttribute("task", task.get());
        }
        return "task_info";
    }

    @GetMapping("/getTitle")
    public Optional<TaskDto> getTaskDtoByTitle(@RequestParam String title){
        return taskService.findByTitle(title).map(TaskDto::new);
    }

    @GetMapping("/updateTime")
    public Optional<TaskDto> updatedTime (@RequestParam String title){
        return Optional.of(new TaskDto(taskService.updatedTime(title, LocalDateTime.now())));
    }


    @GetMapping("/create")      //todo не забудь добавить description в модели и далее по коду, или удали этот столбец из таблицы в БД
    public Optional<TaskDto> create(@RequestParam(name = "title") String title,
                                           @RequestParam(name = "idParent") Integer idParent,
                                           @RequestParam(name = "idChild") Integer idChild,
                                           @RequestParam(name = "cost") Integer cost) {
        Parent parent = parentService.findById(idParent).get();
        Child child;
        if(idChild == null || idChild == 0)
            {child = null;
            }else{child  = childService.findById(idChild).get();}

        return Optional.of(new TaskDto(taskService.createTask(title, parent, child, cost)));
    }

    @DeleteMapping("/delete")
    public boolean delete (@RequestParam String title){
        taskService.delete(title);
        return true;
    }

}
