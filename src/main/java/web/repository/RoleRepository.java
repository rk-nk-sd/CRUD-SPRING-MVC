package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

@Repository
public interface RoleRepository  extends JpaRepository<Role, String> {
    @Query("select r from Role r where r.name=:role")
    Role findByRoleName(@Param("role") String role);
}
