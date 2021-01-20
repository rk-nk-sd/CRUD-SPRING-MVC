package web.repository.edition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.model.Role;

public interface RoleByNameRepository extends JpaRepository<Role, String> {
    @Query("select r from Role r where r.name=:role")
    Role findByRoleName(@Param("role") String role);
}
