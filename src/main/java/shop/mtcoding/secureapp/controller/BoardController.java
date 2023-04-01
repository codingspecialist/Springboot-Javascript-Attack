package shop.mtcoding.secureapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.secureapp.dto.BoardRequest;
import shop.mtcoding.secureapp.model.board.BoardRepository;
import shop.mtcoding.secureapp.model.user.User;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardRepository boardRepository;
    private final HttpSession session;

    @CrossOrigin
    @GetMapping("/board/writeForm")
    public String writeForm(){
        return "board/writeForm";
    }


    @GetMapping({"/","/board"})
    public String boardList(Model model, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        model.addAttribute("boardList", boardRepository.findAll());
        return "board/list";
    }

    @PostMapping("/board")
    public String write(BoardRequest.WriteDto writeDto){
        User loginUser = (User) session.getAttribute("loginUser");
        if(loginUser == null){
            throw new RuntimeException("인증이 되지 않았습니다");
        }
        boardRepository.save(writeDto.toEntity(loginUser));
        return "redirect:/";
    }
}
