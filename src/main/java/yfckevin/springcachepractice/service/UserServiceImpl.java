package yfckevin.springcachepractice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yfckevin.springcachepractice.entity.User;
import yfckevin.springcachepractice.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Override
    public User getUserById(UUID id) {
        log.info("id: {}", id);

        return userRepo
                .findById(id)
                .orElseThrow(() -> new RuntimeException("會員不存在"));
    }

    @Override
    public User create(User user) {
        return userRepo.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        userRepo.deleteById(id);
    }
}
