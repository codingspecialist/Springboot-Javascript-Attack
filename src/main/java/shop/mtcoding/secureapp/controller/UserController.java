package shop.mtcoding.secureapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import shop.mtcoding.secureapp.dto.UserRequest;
import shop.mtcoding.secureapp.model.user.User;
import shop.mtcoding.secureapp.model.user.UserRepository;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserRepository userRepository;
    private final HttpSession session;

    @GetMapping("/loginForm")
    public String loginForm(){
        return "user/loginForm";
    }

    @PostMapping("/login")
    public String login(UserRequest.LoginDto loginDto){
        User loginUser = userRepository.login(loginDto.getUsername(), loginDto.getPassword())
                .orElseThrow(
                        ()-> new RuntimeException("아이디 패스워드가 틀렸습니다")
                );
        session.setAttribute("loginUser", loginUser);
        return "redirect:/board/writeForm";
    }


}
