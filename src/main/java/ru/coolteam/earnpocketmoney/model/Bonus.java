package ru.coolteam.earnpocketmoney.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bonuses")
@Data
@NoArgsConstructor
public class Bonus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "bonus_text")
    private String bonusText;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "id_user_creating_bonus")
    private User userCreatingBonus;

<<<<<<< HEAD:src/main/java/ru/coolteam/earnpocketmoney/model/Bonus.java
    public Bonus(Long id, String title, Parent parent, Child child, Integer price, LocalDateTime receivedAt) {
        this.id = id;
        this.title = title;
        this.parent = parent;
        this.child = child;
        this.price = price;
        this.receivedAt = receivedAt;
    }
||||||| merged common ancestors:src/main/java/ru/coolteam/earnpocketmoney/models/Bonus.java
    public Bonus(Integer id, String title, Parent parent, Child child, Integer price, LocalDateTime receivedAt) {
        this.id = id;
        this.title = title;
        this.parent = parent;
        this.child = child;
        this.price = price;
        this.receivedAt = receivedAt;
    }


=======
    @ManyToOne
    @JoinColumn(name = "id_user_getting_bonus")
    private User userGettingBonus;

    @Column(name = "price")
    private Long price;

    @Column(name = "getting_status")
    private Boolean gettingStatus;
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b:src/main/java/ru/coolteam/earnpocketmoney/models/Bonus.java
}
