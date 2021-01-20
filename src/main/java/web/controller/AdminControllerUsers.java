package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.repository.RoleRepository;
import web.service.RoleService;
import web.service.UserService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin/users")
public class AdminControllerUsers {
    private final UserService userService;

    @Autowired
    public AdminControllerUsers(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String getAllUsers(Model model) {
        //Получим список пользователей и передадим в представление
        model.addAttribute("users", userService.getAllUsers());
        return "admin/index";
    }

    @GetMapping("/{id}")
    public String getCurrentUser(@PathVariable("id") int id, Model model) {
        //Получим одного пользователя по id и передадим на представление
        model.addAttribute("user", userService.getCurrentUser(id));
        return "admin/info_user";
    }

    @GetMapping("/new-user")
    public String createUserForm(@ModelAttribute("user") User user) {
        //Вернет html форму для создания нового пользователя
        return "admin/create_user";
    }

    @GetMapping("/{id}/edit")
    public String editUser (Model model,@PathVariable("id") int id){
        //Вернет html форму для редактирования страницы пользователя
        model.addAttribute("user", userService.getCurrentUser(id));
        return "admin/edit_user";
    }

    /**
     * Ошибка позднее разобраться
     * @param user
     * @param bindingResult
     * @param login
     * @param password
     * @return
     */
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
        user.setPassword(password);
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
                          @RequestParam(name = "role") String role){
        //Обновляет пользователя
        if(bindingResult.hasErrors())
            return "admin/edit_user";

        Set<Role> roles = new HashSet<>();
//        roles.add(roleRepository.getOne(1L));
        roles.add(userService.findByRoleName(role));

        user.setLogin(login);
        user.setPassword(password);
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
