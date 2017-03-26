package pl.footyper.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.footyper.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
}
