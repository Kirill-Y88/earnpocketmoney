package ru.coolteam.earnpocketmoney.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coolteam.earnpocketmoney.dtos.ParentDto;
import ru.coolteam.earnpocketmoney.models.Parent;
import ru.coolteam.earnpocketmoney.services.ParentService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/parents")
public class ParentController {
    private final ParentService parentService;

    @GetMapping()
    public List<ParentDto> getAllParents() {
        return parentService.findAll().stream().map(ParentDto::new).collect(Collectors.toList());
    }

    @GetMapping("/dto")
    public List<ParentDto> getAllParentsDto() {
        return parentService.findAll().stream().map(ParentDto::new).collect(Collectors.toList());
    }

    @GetMapping("/getLogin")
    public Optional<ParentDto> getParentDtoByLogin(@RequestParam String login){
        return parentService.findByLogin(login).map(ParentDto::new);
    }

    @GetMapping("/create")
    public Optional<ParentDto> create (@RequestParam String login,
                                      @RequestParam String password){
        Parent parent = parentService.createParent(login, password);
        return Optional.of(new ParentDto(parent));
    }

    @DeleteMapping("/delete")
    public boolean delete (@RequestParam String login,
                           @RequestParam String password){
        parentService.delete(login,password);
        return true;
    }

    @GetMapping("/updatePassword")
    public Optional<ParentDto> updatePassword (@RequestParam String login,
                                              @RequestParam String lastPass,
                                              @RequestParam String futurePass){
        return Optional.of(new ParentDto(parentService.updatePasswordParent(login, lastPass, futurePass)));
    }


}
