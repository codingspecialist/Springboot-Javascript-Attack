package shop.mtcoding.secureapp.dto;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.secureapp.model.board.Board;
import shop.mtcoding.secureapp.model.user.User;

public class BoardRequest {
    @Getter @Setter
    public static class WriteDto {
        private String title;
        private String content;

        public Board toEntity(User loginUser){
            return Board.builder().title(title).content(content).user(loginUser).build();
        }
    }
}
