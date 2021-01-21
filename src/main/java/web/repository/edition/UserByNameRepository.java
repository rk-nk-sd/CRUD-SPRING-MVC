package web.repository.edition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.model.User;

@Repository
public interface UserByNameRepository extends JpaRepository<User, String> {
    @Query("select u from User u where u.login=:name")
    User findByUserName(@Param("name") String name);
}
