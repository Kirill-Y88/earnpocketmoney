package ru.coolteam.earnpocketmoney.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.coolteam.earnpocketmoney.dtos.ParentDto;
import ru.coolteam.earnpocketmoney.model.Parent;
import ru.coolteam.earnpocketmoney.services.ParentService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v2/parents")
public class ParentController {
    private final ParentService parentService;

    //TODO оставить без пути т.к. в верху все есть
    //Получить список родителей
    @GetMapping()
    public List<ParentDto> getAllParentsDto() {
        return parentService.findAll()
                .stream()
                .map(ParentDto::new)
                .collect(Collectors.toList());
    }

    //TODO возможно ли сделать POST
    //достать родителя по логину
    @GetMapping("/getLogin")
    public Optional<ParentDto> getParentDtoByLogin(@RequestParam String login){
        return parentService.findByLogin(login).map(ParentDto::new);
    }

    //создать родителя
    @GetMapping("/create")
    public Optional<ParentDto> create (@RequestParam String login,
                                      @RequestParam String password){
        Parent parent = parentService.createParent(login, password);
        return Optional.of(new ParentDto(parent));
    }

    //TODO нужен ли,если да, то что делать с созданными этим родителем задачами и бонусами
    //удалить родителя
    @DeleteMapping("/delete")
    public boolean delete (@RequestParam String login,
                           @RequestParam String password){
        parentService.delete(login,password);
        return true;
    }

    //изменение пароля
    @GetMapping("/updatePassword")
    public Optional<ParentDto> updatePassword (@RequestParam String login,
                                              @RequestParam String lastPass,
                                              @RequestParam String futurePass){
        return Optional.of(new ParentDto(parentService.updatePasswordParent(login, lastPass, futurePass)));
    }
}
