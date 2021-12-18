package ru.coolteam.earnpocketmoney.dtos;

import lombok.Data;
import ru.coolteam.earnpocketmoney.models.Parent;
import ru.coolteam.earnpocketmoney.models.Role;

@Data
public class ParentDto {

    private String login;
    private String password;
    private Role role;

    public ParentDto(Parent parent) {
        this.login = parent.getLogin();
        this.password = parent.getPassword();
        this.role = parent.getRole();
    }
}
