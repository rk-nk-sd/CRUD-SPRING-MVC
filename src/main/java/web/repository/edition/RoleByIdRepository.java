package web.repository.edition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.model.Role;

public interface RoleByIdRepository extends JpaRepository<Role, Integer> {
    @Query("select r from Role r where r.id=:id")
    Role findById(@Param("id") Long id);

    void deleteById(Long id);
}
