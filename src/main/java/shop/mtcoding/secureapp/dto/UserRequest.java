package shop.mtcoding.secureapp.dto;

import lombok.Getter;
import lombok.Setter;

public class UserRequest {
    @Getter @Setter
    public static class LoginDto{
        private String username;
        private String password;
    }
}
