package ru.coolteam.earnpocketmoney.controllers;

import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
||||||| merged common ancestors
=======
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
import org.springframework.web.bind.annotation.*;
import ru.coolteam.earnpocketmoney.dtos.TaskDto;
<<<<<<< HEAD
import ru.coolteam.earnpocketmoney.model.Child;
import ru.coolteam.earnpocketmoney.model.Parent;
import ru.coolteam.earnpocketmoney.model.Task;
import ru.coolteam.earnpocketmoney.services.ChildService;
import ru.coolteam.earnpocketmoney.services.ParentService;
||||||| merged common ancestors
import ru.coolteam.earnpocketmoney.models.Child;
import ru.coolteam.earnpocketmoney.models.Parent;
import ru.coolteam.earnpocketmoney.models.Task;
import ru.coolteam.earnpocketmoney.services.ChildService;
import ru.coolteam.earnpocketmoney.services.ParentService;
=======
import ru.coolteam.earnpocketmoney.models.Task;
import ru.coolteam.earnpocketmoney.models.User;
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
import ru.coolteam.earnpocketmoney.services.TaskService;
import ru.coolteam.earnpocketmoney.services.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

<<<<<<< HEAD
@Controller
||||||| merged common ancestors
@RestController
=======
//@RestController
@Controller
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
@RequiredArgsConstructor
@RequestMapping("/api/v2/tasks")
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;

<<<<<<< HEAD
    // Вывести весь список задач
    @GetMapping("/all")
    public String getAllTasks(Model model) {
        List<TaskDto> tasklist = taskService.findAll()
                .stream().
                map(TaskDto::new)
                .collect(Collectors.toList());

        model.addAttribute("tasks", tasklist);
        return "tasklist";
    }

    // Найти задачу по ID
    @GetMapping("/{id}")
    public String showTaskInfo (@PathVariable(name = "id") Long id, Model model) {
        Optional<Task> task = taskService.findById(id);
        if (task.isPresent()) {
            model.addAttribute("task", task.get());
        }
        return "task_info";
||||||| merged common ancestors
    @GetMapping()
    public List<TaskDto> getAllTasks() {
        return taskService.findAll().stream().map(TaskDto::new).collect(Collectors.toList());
=======
    //rest version
    /*@GetMapping()
    public List<TaskDto> getAllTasks() {
        List<TaskDto> taskDtoList = taskService.findAll().stream().map(TaskDto::new).collect(Collectors.toList());
        return taskDtoList;
    }*/

//    @GetMapping()
//    public String getAllTasks(Model model) {
//        List<TaskDto> taskDtoList = taskService.findAll().stream().map(TaskDto::new).collect(Collectors.toList());
//        model.addAttribute("tasks", taskDtoList);
//        return "tasklist";
//    }

    // Вывести весь список задач
    @GetMapping("/all")
    public String getAllTasks(Model model) {
        List<TaskDto> taskDtoList = taskService.findAll()
                .stream()
                .map(TaskDto::new)
                .collect(Collectors.toList());

        model.addAttribute("tasks", taskDtoList);
        return "index";
    }


//    @GetMapping("/{id}")
//    public String showTaskInfo (@PathVariable(name = "id") Long id, Model model) {
//        Optional<Task> task = taskService.findById(id);
//        if (task.isPresent()) {
//            model.addAttribute("task", task.get());
//        }
//        return "task_info";
//    }

    // Найти задачу по ID
    @GetMapping("/{id}")
    public String showTaskInfo (@PathVariable(name = "id") Long id, Model model) {
        Optional<Task> task = taskService.findById(id);
        if (task.isPresent()) {
            model.addAttribute("task", task.get());
        }
        return "task_info";
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
    }

<<<<<<< HEAD
    //Поиск по Заголовку Задачи
||||||| merged common ancestors
=======
    // Поиск по Заголовку Задачи
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
    @GetMapping("/getTitle")
    public TaskDto getTaskDtoByTitle(@RequestParam String title){
        TaskDto taskDto = new TaskDto(taskService.findByTitle(title).get()) ;
        return taskDto;
    }

    // Обновление времени создания Задачи
    @GetMapping("/updateTime")
<<<<<<< HEAD
    public Optional<TaskDto> updatedTime (@RequestParam String title){
        return Optional.of(new TaskDto(taskService.updatedTime(title, LocalDateTime.now())));
||||||| merged common ancestors
    public Optional<TaskDto> updatedTime (@RequestParam String title
                                          ){
        return Optional.of(new TaskDto(taskService.updatedTime(title, LocalDateTime.now())));
=======
    public TaskDto updatedTime (@RequestParam String title){
        TaskDto taskDto = new TaskDto(taskService.updatedTime(title, LocalDateTime.now()));
        return taskDto;
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
    }

<<<<<<< HEAD
    // TODO не забудь добавить description в модели и далее по коду, или удали этот столбец из таблицы в БД
    @GetMapping("/create")
    public Optional<TaskDto> create(@RequestParam(name = "title") String title,
                                    @RequestParam(name = "taskText") String taskText,
                                    @RequestParam(name = "idParent") Integer idParent,
                                    @RequestParam(name = "idChild") Integer idChild,
                                    @RequestParam(name = "cost") Integer cost) {
        Parent parent = parentService.findById(idParent).get();
        Child child;
        if(idChild == null || idChild == 0)
            {child = null;
            }else{child  = childService.findById(idChild).get();}
||||||| merged common ancestors

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
=======
    @GetMapping("/groupTasks")
    public List<TaskDto> getgroupsTaskDtos (@RequestParam String groupName){
        List<TaskDto> taskDtoList = taskService.getAllTasksByPeopleGroups(groupName)
                .stream()
                .map(TaskDto::new)
                .collect(Collectors.toList());
        return taskDtoList;
    }

    @GetMapping("/userCreatingTask")
    public List<TaskDto> getTasksByUserCreatingTask (@RequestParam String login){
        List<TaskDto> taskDtoList = taskService.getAllTasksByUserCreatingTask(login)
                .stream()
                .map(TaskDto::new)
                .collect(Collectors.toList());
        return taskDtoList;
    }

    @GetMapping("/userExecutingTask")
    public List<TaskDto> getTasksByUserExecutingTask (@RequestParam String login){
        List<TaskDto> taskDtoList = taskService.getAllTasksByUserExecutingTask(login)
                .stream()
                .map(TaskDto::new)
                .collect(Collectors.toList());
        return taskDtoList;
    }

    @PreAuthorize("hasRole('ROLE_PARENT')")
    @GetMapping("/create")
    public TaskDto create (@RequestParam String title,
                           @RequestParam String taskText,
                           @RequestParam String userCreatingTaskLogin,
                           @RequestParam String userExecutingTaskLogin,
                           @RequestParam Long wages){
        User userCreatingTask = userService.findByLogin(userCreatingTaskLogin);
        User userExecutingTask = userService.findByLogin(userExecutingTaskLogin);
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b

<<<<<<< HEAD
        return Optional.of(new TaskDto(taskService.createTask(title, taskText, parent, child, cost)));
||||||| merged common ancestors
        return Optional.of(new TaskDto(taskService.createTask(title, parent, child, cost)));
=======
        return new TaskDto(taskService.createTask(title, taskText, userCreatingTask, userExecutingTask, wages));
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
    }

<<<<<<< HEAD
    // Удаление задачи (из базы)
    //TODO подумать над функционалом пометки - задача удалена.
||||||| merged common ancestors
=======
    @PreAuthorize("hasRole('ROLE_PARENT')")
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
    @DeleteMapping("/delete")
    public boolean delete (@RequestParam String title){
        taskService.delete(title);
        return true;
    }
<<<<<<< HEAD

||||||| merged common ancestors



=======
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
}
