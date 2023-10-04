package Library.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Library.com.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
