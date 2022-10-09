package preproject.kata314.service;

import java.util.List;
import preproject.kata314.model.Role;

public interface RoleService {

  Role getRole(Long id);

  void addRole(Role role);

  List<Role> getRoles();
}
