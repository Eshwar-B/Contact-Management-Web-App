package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByEmail(String email);
	
}
