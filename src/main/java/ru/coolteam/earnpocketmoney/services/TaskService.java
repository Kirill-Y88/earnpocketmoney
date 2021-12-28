package ru.coolteam.earnpocketmoney.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import ru.coolteam.earnpocketmoney.model.Child;
import ru.coolteam.earnpocketmoney.model.Parent;
import ru.coolteam.earnpocketmoney.model.Task;
||||||| merged common ancestors
import ru.coolteam.earnpocketmoney.models.Child;
import ru.coolteam.earnpocketmoney.models.Parent;
import ru.coolteam.earnpocketmoney.models.Task;
=======
import ru.coolteam.earnpocketmoney.models.*;
import ru.coolteam.earnpocketmoney.repositories.PeopleGroupsRepository;
import ru.coolteam.earnpocketmoney.repositories.StatusRepository;
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
import ru.coolteam.earnpocketmoney.repositories.TaskRepository;
import ru.coolteam.earnpocketmoney.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final PeopleGroupsRepository peopleGroupsRepository;
    private final UserRepository userRepository;
    private final StatusRepository statusRepository;

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public List<Task> getAllTasksByPeopleGroups (String groupName){
        return taskRepository.findTaskByUserCreatingTask_PeopleGroups(peopleGroupsRepository.findByName(groupName));
    }

<<<<<<< HEAD
    public Task createTask(String title, String taskText, Parent parent, Child child, Integer cost) {
||||||| merged common ancestors
    public Task createTask(String title, Parent parent, Child child, Integer cost) {
=======
    public List<Task> getAllTasksByUserCreatingTask (String login){
        return taskRepository.findTaskByUserCreatingTask(userRepository.findByLogin(login));
    }

    public List<Task> getAllTasksByUserExecutingTask (String login){
        return taskRepository.findTaskByUserExecutingTask(userRepository.findByLogin(login));
    }

    public Task createTask (String title,
                            String taskText,
                            User userCreatingTask,
                            User userExecutingTask,
                            Long wages){

>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
        Task task = new Task();
        task.setTitle(title);
<<<<<<< HEAD
        task.setTaskText(taskText);
        task.setParent(parent);
        task.setChild(child);
        task.setCost(cost);
||||||| merged common ancestors
        task.setParent(parent);
        task.setChild(child);
        task.setCost(cost);
=======
        task.setTaskText(taskText);
        task.setUserCreatingTask(userCreatingTask);
        task.setUserExecutingTask(userExecutingTask);
        task.setStatus(statusRepository.getById(1L));
        task.setWages(wages);

>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
        return taskRepository.save(task);
    }


    public Optional<Task> findByTitle (String title) {
        return taskRepository.findTaskByTitle(title);
    }

    public Task updatedTime (String title, LocalDateTime updatedAt){
        Task task = taskRepository.findTaskByTitle(title).get();
        task.setUpdatedAt(updatedAt);
        return taskRepository.save(task);
    }

    public Task updateUserExecutingTasks (String title, User userExecutingTasks){
        Task task = taskRepository.findTaskByTitle(title).get();
        task.setUserExecutingTask(userExecutingTasks);
        return task;
    }

    public boolean delete (String title){
        Task task = taskRepository.findTaskByTitle(title).get();
        taskRepository.delete(task);
        return true;
    }


}
