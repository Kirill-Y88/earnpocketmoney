package ru.coolteam.earnpocketmoney.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
@NoArgsConstructor
public class Task{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

<<<<<<< HEAD:src/main/java/ru/coolteam/earnpocketmoney/model/Task.java
    @Column(name = "task_text")
    private String taskText;

||||||| merged common ancestors:src/main/java/ru/coolteam/earnpocketmoney/models/Task.java
=======
    @Column(name="task_text")
    private String taskText;

>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b:src/main/java/ru/coolteam/earnpocketmoney/models/Task.java
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "id_user_creating_task")
    private User userCreatingTask;

    @ManyToOne
    @JoinColumn(name = "id_user_executing_task")
    private User userExecutingTask;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;

    //обозвал зарплату
    @Column(name = "wages")
    private Long wages;

    public void incrementWages() {
        this.wages++;
    }

    public void decrementWages() {
        this.wages--;
    }

}
