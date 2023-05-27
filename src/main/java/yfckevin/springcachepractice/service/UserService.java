package yfckevin.springcachepractice.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import yfckevin.springcachepractice.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    User getUserById(Long id);

    User create(User user);

    User update(User user);


    void delete(Long id);
}
