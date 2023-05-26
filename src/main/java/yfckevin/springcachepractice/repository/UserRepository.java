package yfckevin.springcachepractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yfckevin.springcachepractice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}