package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    void delete(int id);
//    Role getCurrentRole(int id);
    Role update(Role role);
    List<Role> getAllRole();
//    Role findByRoleName(String role);
}
