package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Set;

@Controller
@RequestMapping("/admin/roles")
public class AdminControllerRoles {
    private final RoleService roleService;

    @Autowired
    public AdminControllerRoles(RoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping()
    public String getAllRoles(Model model, Principal principal) {
        //Получим список пользователей и передадим в представление
        model.addAttribute("roles", roleService.getAllRole());
        model.addAttribute("userinfo", principal);
        return "admin/all_roles";
    }

    @GetMapping("/{id}")
    public String getRole(@PathVariable("id") Long id, Model model, Principal principal) {
        //Получим одного пользователя по id и передадим на представление
        model.addAttribute("role", roleService.getCurrentRole(id));
        model.addAttribute("userinfo", principal);
        return "admin/info_role";
    }

    @GetMapping("/new-role")
    public String createRoleForm(@ModelAttribute("role") Role role, Model model, Principal principal) {
        //Вернет html форму для создания нового пользователя
        model.addAttribute("userinfo", principal);
        return "admin/create_role";
    }

    @GetMapping("/{id}/edit")
    public String editRole (Model model,@PathVariable("id") Long id, Principal principal){
        //Вернет html форму для редактирования страницы пользователя
        model.addAttribute("role", roleService.getCurrentRole(id));
        model.addAttribute("userinfo", principal);
        return "admin/edit_role";
    }

    @PostMapping()
    public String createUser (@ModelAttribute("role") @Valid Role role,
                              BindingResult bindingResult,
                              @RequestParam(name = "rolename") String rolename){
        if(bindingResult.hasErrors())
            return "admin/create_role";

        role.setName(rolename);
        roleService.createRole(role);

        return "redirect:/admin/roles";
    }

    @PatchMapping("/{id}")
    public String update (@ModelAttribute("role") @Valid Role role,
                          BindingResult bindingResult,
                          @PathVariable("id") int id,
                          @RequestParam(name = "rolename") String rolename){
        //Обновляет роль
        if(bindingResult.hasErrors())
            return "admin/edit_role";

        role.setName(rolename);
        roleService.update(role);

        return "redirect:/admin/roles";
    }


    @DeleteMapping("/{id}")
    public String delete ( @PathVariable("id") Long id){
        //Удаляет пользователя
        roleService.delete(id);
        return "redirect:/admin/roles";
    }


}
