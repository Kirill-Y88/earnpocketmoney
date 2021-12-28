package ru.coolteam.earnpocketmoney.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
import ru.coolteam.earnpocketmoney.model.Bonus;
||||||| merged common ancestors
import ru.coolteam.earnpocketmoney.models.Bonus;
=======
import org.hibernate.annotations.CreationTimestamp;
import ru.coolteam.earnpocketmoney.models.Bonus;
import ru.coolteam.earnpocketmoney.models.User;
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BonusDto {

<<<<<<< HEAD
    private Long id;
||||||| merged common ancestors
=======
    private Integer id;
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
    private String title;
    private String bonusText;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserDto userCreatingBonus;
    private UserDto userGettingBonus;
    private Long price;
    private Boolean gettingStatus;

    public BonusDto(Bonus bonus) {
        this.id = bonus.getId();
        this.title = bonus.getTitle();
<<<<<<< HEAD
        this.parentDto = new ParentDto(bonus.getParent());

        if(bonus.getChild()!=null) {
            this.childDto = new ChildDto(bonus.getChild());
||||||| merged common ancestors
        this.parentDto = new ParentDto(bonus.getParent());
        if(bonus.getChild()!=null) {
            this.childDto = new ChildDto(bonus.getChild());
=======
        this.bonusText = bonus.getBonusText();
        this.createdAt = bonus.getCreatedAt();
        this.updatedAt = bonus.getUpdatedAt();
        this.userCreatingBonus = new UserDto(bonus.getUserCreatingBonus());
        if(bonus.getUserGettingBonus()!=null){
        this.userGettingBonus = new UserDto(bonus.getUserGettingBonus());
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b
        }else {
            this.userGettingBonus = new UserDto();
        }

        this.price = bonus.getPrice();
        this.gettingStatus = bonus.getGettingStatus();
    }
}
