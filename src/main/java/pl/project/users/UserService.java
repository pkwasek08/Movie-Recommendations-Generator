package pl.project.users;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    Logger log = LogManager.getLogger(this.getClass());
    @Autowired
    UserRepository userRepository;

    public UserEntity getUserByEmailAndPassword(String email, String password) {
        Optional<UserEntity> user = userRepository.findByEmailAndPassword(email, password);
        return user.isPresent() ? user.get() : null;
    }

    public UserEntity getUser(Integer id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user.isPresent() ? user.get() : null;
    }

    public List<UserEntity> getAllUserList() {
        List<UserEntity> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    public UserEntity addUser(UserEntity newUser) {
        return userRepository.save(newUser);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
