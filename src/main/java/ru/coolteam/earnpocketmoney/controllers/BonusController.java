package ru.coolteam.earnpocketmoney.controllers;

import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
import org.springframework.stereotype.Controller;
||||||| merged common ancestors
=======
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
import org.springframework.web.bind.annotation.*;
import ru.coolteam.earnpocketmoney.dtos.BonusDto;
<<<<<<< HEAD
import ru.coolteam.earnpocketmoney.model.Bonus;
import ru.coolteam.earnpocketmoney.model.Child;
import ru.coolteam.earnpocketmoney.model.Parent;
||||||| merged common ancestors
import ru.coolteam.earnpocketmoney.models.Bonus;
import ru.coolteam.earnpocketmoney.models.Child;
import ru.coolteam.earnpocketmoney.models.Parent;
=======
import ru.coolteam.earnpocketmoney.models.Bonus;
import ru.coolteam.earnpocketmoney.models.User;
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
import ru.coolteam.earnpocketmoney.services.BonusService;
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
@RequestMapping("/api/v2/bonuses")
public class BonusController {
    private final BonusService bonusService;
<<<<<<< HEAD
    private final ParentService parentService;
    private final ChildService childService;

    // Вывести весь список Детей со всеми Бонусами ??? я правильно понял??
    @GetMapping("/all/children")
||||||| merged common ancestors
    private final ParentService parentService;
    private final ChildService childService;



    @GetMapping()
=======
    private final UserService userService;


    @GetMapping()
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
    public List<BonusDto> getAllChildren() {
        return  bonusService.findAll().stream().map(BonusDto::new).collect(Collectors.toList());
    }

    // Найти Бонус по ID
    @GetMapping("/getId")
    public Optional<BonusDto> getBonusDtoById(@RequestParam Long id){
        return bonusService.findById(id).map(BonusDto::new);
    }

    // Найти Бонус по Заголовку
    @GetMapping("/getTitle")
    public Optional<BonusDto> getBonusDtoByTitle(@RequestParam String title){
        return bonusService.findByName(title).map(BonusDto::new);
    }

<<<<<<< HEAD
    // Создать Бонус
||||||| merged common ancestors
=======
    @PreAuthorize("hasRole('ROLE_PARENT')")
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
    @GetMapping("/create")
    public Optional<BonusDto> create (@RequestParam String title,
                                      @RequestParam String userCreatingBonusLogin,  // TODO надо обдумать с какого места отправить родителя в запрос
                                      @RequestParam Long price){
        User userCreatingBonus = userService.findByLogin(userCreatingBonusLogin);
        Bonus bonus = bonusService.createBonus(title, userCreatingBonus, price);
        return Optional.of(new BonusDto(bonus));
    }

<<<<<<< HEAD
    // Удалить Бонус
||||||| merged common ancestors
=======
    @PreAuthorize("hasRole('ROLE_PARENT')")
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
    @DeleteMapping("/delete")
    public boolean delete (@RequestParam String title){
        bonusService.delete(title);
        return true;
    }

    // Обновление Бонуса Родителем
    @GetMapping("/updateFromParent")
    public Optional<BonusDto> updateBonusFromParent (@RequestParam String title,
                                           @RequestParam String userCreatingBonusLogin,  // TODO надо обдумать с какого места отправить родителя в запрос
                                           @RequestParam Long price){
        User userCreatingBonus = userService.findByLogin(userCreatingBonusLogin);
        return Optional.of(new BonusDto(bonusService.updateBonusFromParent(title,userCreatingBonus,price)));
    }

    //Обновление Бонуса Ребенком
    @GetMapping("/updateFromChild")
    public Optional<BonusDto> updateBonusFromChild (@RequestParam String title,
                                                     @RequestParam String userGettingBonusLogin)  // TODO надо обдумать с какого места отправить родителя в запрос
    {
        User userGettingBonus = userService.findByLogin(userGettingBonusLogin);
        return Optional.of(new BonusDto(bonusService.updateBonusFromChildren(title,userGettingBonus,LocalDateTime.now())));
    }
}
