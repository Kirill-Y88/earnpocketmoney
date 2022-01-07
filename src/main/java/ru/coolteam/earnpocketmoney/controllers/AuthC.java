package ru.coolteam.earnpocketmoney.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.coolteam.earnpocketmoney.authorization.AuthRequest;
import ru.coolteam.earnpocketmoney.authorization.AuthResponse;
import ru.coolteam.earnpocketmoney.authorization.jwt.JwtProvider;
import ru.coolteam.earnpocketmoney.models.User;
import ru.coolteam.earnpocketmoney.repositories.RoleRepository;
import ru.coolteam.earnpocketmoney.services.UserService;


@RestController
@RequiredArgsConstructor
public class AuthC {

    private final UserService userService;
    private final JwtProvider jwtProvider;
    private final RoleRepository roleRepository;

    @PostMapping("/auth2")
    public AuthResponse auth(AuthRequest request) {
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(user.getLogin());
        return new AuthResponse(token);
    }

}
