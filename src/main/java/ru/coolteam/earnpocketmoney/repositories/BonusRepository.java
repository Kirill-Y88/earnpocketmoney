package ru.coolteam.earnpocketmoney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD
import ru.coolteam.earnpocketmoney.model.Bonus;
import ru.coolteam.earnpocketmoney.model.Child;
||||||| merged common ancestors
import ru.coolteam.earnpocketmoney.models.Bonus;
import ru.coolteam.earnpocketmoney.models.Child;
=======
import ru.coolteam.earnpocketmoney.models.*;
>>>>>>> 81264a5e1bac1e5f7a5c0ad7026954e91249419b

import java.util.List;
import java.util.Optional;

@Repository
public interface BonusRepository extends JpaRepository<Bonus, Long> {

    Optional <Bonus> findFirstBonusByTitle (String title);
    /*Bonus findFirstByTitle (String title);
    List<Bonus> findAllByChild (Child child);*/

    List<Bonus> findBonusByUserCreatingBonus_PeopleGroups (PeopleGroups peopleGroups);
    List<Bonus> findBonusByUserCreatingBonus (User user);
    List<Bonus> findBonusByUserGettingBonus (User user);



    @Query("SELECT i FROM Bonus i where i.title = :name ")
    Bonus findBonusByName (String name);




}
