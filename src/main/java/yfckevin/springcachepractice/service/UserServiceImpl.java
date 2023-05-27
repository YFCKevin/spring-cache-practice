package yfckevin.springcachepractice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import yfckevin.springcachepractice.entity.User;
import yfckevin.springcachepractice.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Cacheable(value = "user", key = "#id")
    @Override
    public User getUserById(Long id) {
        log.info("id: {}", id);

        return userRepo
                .findById(id)
                .orElseThrow(() -> new RuntimeException("會員不存在"));
    }

    @CachePut(value = "user", key = "#result.id", unless = "#result == null")
    @Override
    public User create(User user) {
        return userRepo.save(user);
    }

    @CachePut(value = "user", key = "#a0.id")
    @Override
    public User update(User user) {
        return null;
    }

    @CacheEvict(value = "user", key = "#id")
    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}
