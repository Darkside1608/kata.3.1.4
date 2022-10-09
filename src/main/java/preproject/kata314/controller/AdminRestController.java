package preproject.kata314.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import preproject.kata314.model.Role;
import preproject.kata314.model.User;
import preproject.kata314.service.RoleService;
import preproject.kata314.service.UserService;

@RestController
@RequestMapping("/api")
public class AdminRestController {

  private final UserService userService;
  private final RoleService roleService;

  @Autowired
  public AdminRestController(UserService userService, RoleService roleService) {
    this.userService = userService;
    this.roleService = roleService;
  }

  @GetMapping("/admin")
  public ResponseEntity<List<User>> getAllUsers() {
    final List<User> users = userService.getAllUsers();
    return users != null && !users.isEmpty()
        ? new ResponseEntity<>(users, HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @GetMapping("/admin/{id}")
  public ResponseEntity<User> getUser(@PathVariable("id") long id) {
    final User user = userService.getUser(id);
    return user != null
        ? new ResponseEntity<>(user, HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping("/admin")
  public ResponseEntity<User> newUser(@RequestBody User user) {
    userService.saveUser(user);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PatchMapping("/admin/{id}")
  public ResponseEntity<User> updateUser(@RequestBody User user) {
    userService.updateUser(user);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/admin/{id}")
  public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
    userService.deleteUser(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/roles")
  public ResponseEntity<List<Role>> getAllRoles() {
    return new ResponseEntity<>(roleService.getRoles(), HttpStatus.OK);
  }
}
