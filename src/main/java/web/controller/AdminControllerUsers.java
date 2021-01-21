package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/admin/users")
public class AdminControllerUsers {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final List<Role> roleList;

    @Autowired
    public AdminControllerUsers(UserService userService, PasswordEncoder passwordEncoder, RoleService roleService) {

        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleList = roleService.getAllRole();
    }


    @GetMapping()
    public String getAllUsers(Model model, Principal principal) {
        //Получим список пользователей и передадим в представление
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("userinfo", principal);
        return "admin/index";
    }

    @GetMapping("/{id}")
    public String getCurrentUser(@PathVariable("id") int id, Model model, Principal principal) {
        //Получим одного пользователя по id и передадим на представление
        model.addAttribute("user", userService.getCurrentUser(id));
        model.addAttribute("userinfo", principal);
        return "admin/info_user";
    }

    @GetMapping("/new-user")
    public String createUserForm(@ModelAttribute("user") User user, Model model, Principal principal) {
        //Вернет html форму для создания нового пользователя
        model.addAttribute("userinfo", principal);
        return "admin/create_user";
    }

    @GetMapping("/{id}/edit")
    public String editUser (Model model,@PathVariable("id") int id, Principal principal){
        //Вернет html форму для редактирования страницы пользователя
        model.addAttribute("user", userService.getCurrentUser(id));
        model.addAttribute("roles", roleList);
        model.addAttribute("userinfo", principal);
        return "admin/edit_user";
    }

    @PostMapping()
    public String createUser (@ModelAttribute("user") @Valid User user,
                              BindingResult bindingResult,
                              @RequestParam(name = "login") String login,
                              @RequestParam(name = "password") String password){
        if(bindingResult.hasErrors())
            return "admin/create_user";

        Set<Role> roles = new HashSet<>();
        roles.add(userService.findByRoleName("ROLE_USER"));

        user.setLogin(login);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(roles);

        userService.addNewUser(user);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String update (@ModelAttribute("user") @Valid User user,
                          BindingResult bindingResult,
                          @PathVariable("id") int id,
                          @RequestParam(name = "login") String login,
                          @RequestParam(name = "password") String password,
                          @RequestParam(name = "addrole") String[] role){
        //Обновляет пользователя
        if(bindingResult.hasErrors())
            return "admin/edit_user";

        Set<Role> roles = new HashSet<>();
//        Set<Role> roles = user.getRoles();
        for (String variable : role) {
            // некоторые операторы
            // ...
            roles.add(userService.findByRoleName(variable));
        }
//        roles.add(userService.findByRoleName(role));
//        roles.add(userService.findByRoleName("ROLE_USER"));

        user.setLogin(login);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(roles);

        userService.update(user);
        return "redirect:/admin";
    }


    @DeleteMapping("/{id}")
    public String delete ( @PathVariable("id") int id){
        //Удаляет пользователя
        userService.delete(id);
        return "redirect:/admin";
    }


}
