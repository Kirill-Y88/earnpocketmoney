package ru.coolteam.earnpocketmoney.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "children")
@Data
@NoArgsConstructor
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column
    private String login;

    @Column
    private String password;

    @Column(name = "wallet")
    private Integer wallet;

    @OneToMany(mappedBy = "child")
    List<Task> tasks;

}
