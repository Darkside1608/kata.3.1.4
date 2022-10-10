package preproject.kata314.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class LoginController {

  @GetMapping("/admin")
  public String getAdminPage() {
    return "adminPage";
  }
  @GetMapping("/user")
  public  String getUserPage() {
    return "userPage";
  }

}
