package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;
import web.repository.RoleRepository;
import web.repository.UserRepository;
import web.repository.edition.RoleByIdRepository;
import web.repository.edition.RoleByNameRepository;
import web.service.RoleService;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final UserRepository userRepository;
    private final RoleByIdRepository roleByIdRepository;
    private final RoleByNameRepository roleByNameRepository;

    @Autowired
    public RoleServiceImpl(UserRepository userRepository, RoleByIdRepository roleByIdRepository, RoleByNameRepository roleByNameRepository) {
        this.userRepository = userRepository;
        this.roleByIdRepository = roleByIdRepository;
        this.roleByNameRepository = roleByNameRepository;
    }

    @Override
    public Role createRole(Role role) {
        return roleByIdRepository.saveAndFlush(role);
    }

    @Override
    public void delete(Long id) {
        roleByIdRepository.deleteById(id);
    }

    @Override
    public Role getCurrentRole(Long id) {
        return roleByIdRepository.findById(id);
    }

    @Override
    public Role update(Role role) {
        return roleByIdRepository.saveAndFlush(role);
    }

    @Override
    public List<Role> getAllRole() {
        return roleByIdRepository.findAll();
    }
}
