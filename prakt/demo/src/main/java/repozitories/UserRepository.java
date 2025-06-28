package repozitories;

import com.example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Найти пользователя по email (уникальное поле)
    Optional<User> findByEmail(String email);

    // Проверить существование пользователя по email
    boolean existsByEmail(String email);

    // Найти пользователей по имени (с учетом регистра)
    List<User> findByUserName(String userName);

    // Найти пользователей по имени (без учета регистра)
    List<User> findByUserNameIgnoreCase(String userName);

    // Найти пользователей, имена которых содержат подстроку
    List<User> findByUserNameContaining(String substring);

    // Найти пользователей по домену email
    @Query("SELECT u FROM User u WHERE u.email LIKE %:domain")
    List<User> findByEmailDomain(@Param("domain") String domain);
}
