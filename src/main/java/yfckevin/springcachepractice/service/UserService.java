package yfckevin.springcachepractice.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import yfckevin.springcachepractice.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    @Cacheable(value = "user", key = "#id")
    User getUserById(UUID id);

    @CachePut(value = "user", key = "#result.id")
    User create(User user);

    @CachePut(value = "user", key = "#a0.id")
    User update(User user);

    @CacheEvict(value = "user", key = "#id")
    void delete(Integer id);
}
