package proiect.employeeManagement;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class registerLogin {

    private final UserRepository userRepository;
    public registerLogin(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register") // creeare cont
    public String register(@RequestBody userDto userDto){
        String username = userDto.getUsername();
        String password = userDto.getPassword();
        String confirmPassword = userDto.getConfirmPassword();
       if(username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
           return "Completati toate campurile";
       }
       if(!password.equals(confirmPassword)){
           return "Parolele trebuie sa fie la fel";
       }
       if(userRepository.findByUsername(username).isPresent()){
           return "Utililizatorul este deja inregistrat";
       }
       userRepository.save(new User(userDto.getUsername(), userDto.getPassword()));
       return "Inregistrat cu succes";
    }
    @PostMapping("/login")//logare
    public String login(@RequestBody loginDto loginDto) {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get(); // Get the User object
            if (user.getPassword().equals(password)) {
                return "Login realizat cu succes";
            } else {
                return "Nume sau parola sunt gresite";
            }
        } else {
            return "Utilizator inexistent";
        }
    }

    public static class userDto{
        private String username;
        private String password;
        private String confirmPassword;

        public String getUsername() {
            return username;
        }
        public String setUsername(String username) {
            return this.username = username;
        }
        public String getPassword() {
            return password;
        }
        public String setPassword(String password) {
            return this.password = password;
        }
        public String getConfirmPassword() {
            return confirmPassword;
        }
        public String setConfirmPassword(String confirmPassword) {
            return this.confirmPassword = confirmPassword;
        }
    }
    public static class loginDto{
        private String username;
        private String password;
        public String getUsername() {
            return username;
        }
        public String setUsername(String username) {
            return this.username = username;
        }
        public String getPassword() {
            return password;
        }
        public String setPassword(String password) {
            return this.password = password;
        }

    }
}
