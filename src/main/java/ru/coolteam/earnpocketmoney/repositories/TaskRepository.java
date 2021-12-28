package ru.coolteam.earnpocketmoney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD
import ru.coolteam.earnpocketmoney.model.Child;
import ru.coolteam.earnpocketmoney.model.Task;
||||||| merged common ancestors
import ru.coolteam.earnpocketmoney.models.Child;
import ru.coolteam.earnpocketmoney.models.Parent;
import ru.coolteam.earnpocketmoney.models.Task;
=======
import ru.coolteam.earnpocketmoney.models.*;
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findTaskByTitle (String login);
  //  List<Task> findAllByChild (Child child);

    List<Task> findTaskByUserCreatingTaskRoleContains (Role role);
    List<Task> findTaskByUserCreatingTask_PeopleGroups (PeopleGroups peopleGroups);
    List<Task> findTaskByUserCreatingTask (User user);
    List<Task> findTaskByUserExecutingTask (User user);

}
