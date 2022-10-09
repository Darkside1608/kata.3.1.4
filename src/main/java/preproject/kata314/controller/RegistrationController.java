package preproject.kata314.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import preproject.kata314.model.User;
import preproject.kata314.service.UserService;

@RestController
public class RegistrationController {

  private UserService userService;


  public RegistrationController(UserService userService) {
    this.userService = userService;

  }

  @PostMapping("/registration")
  public ResponseEntity<User> registrationUser(@RequestBody User user) {
    userService.saveUser(user);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
