package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;
import web.repository.UserRepository;
import web.repository.edition.RoleByNameRepository;
import web.repository.edition.UserByNameRepository;
import web.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleByNameRepository roleByNameRepository;
    private final UserByNameRepository userByNameRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleByNameRepository roleByNameRepository,
                           UserByNameRepository userByNameRepository) {

        this.userRepository = userRepository;
        this.roleByNameRepository = roleByNameRepository;
        this.userByNameRepository = userByNameRepository;
    }

    @Override
    public User addNewUser(User user) { return userRepository.saveAndFlush(user); }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getCurrentUser(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserName(String username) {
        return userByNameRepository.findByUserName(username);
    }

    @Override
    public Role findByRoleName(String role) {
        return roleByNameRepository.findByRoleName(role);
    }
}

