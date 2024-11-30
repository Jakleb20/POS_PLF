package org.example.plf.repos;

import org.example.plf.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("myUserRepositoryJPA")
public interface UserRepository extends JpaRepository<User, Integer> {
    public User getUserById(int id);
}
