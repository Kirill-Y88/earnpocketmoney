package ru.coolteam.earnpocketmoney.model;


import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    @JoinColumn(name = "id_parent")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "id_child")
    private Child child;

    @Column(name = "price")
    private Integer price;

    @Column(name = "received_at")
    private LocalDateTime receivedAt;

    public Bonus(Long id, String title, Parent parent, Child child, Integer price, LocalDateTime receivedAt) {
        this.id = id;
        this.title = title;
        this.parent = parent;
        this.child = child;
        this.price = price;
        this.receivedAt = receivedAt;
    }
}
