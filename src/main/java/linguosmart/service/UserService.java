package linguosmart.service;


import linguosmart.domain.User;
import linguosmart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> queryUserAll(String name){

        return userRepository.findByUsername(name);
    }

    public void createUser(User userCreateForm){
        userRepository.findByEmail(userCreateForm.getEmail()).ifPresent(
                user -> {
                    throw new RuntimeException(" email already exist !!!");
                }
        );
        userRepository.save(userCreateForm);
    }

    public void updateUser(User userUpdate){
        userRepository.findById(Long.valueOf(userUpdate.getUserId())).ifPresentOrElse(
                user -> {
                    userRepository.save(userUpdate);
                }, ()-> {
                    throw new RuntimeException(" email already exist !!!");
                }
        );
    }

    public void deleteUser(Long userId){
        userRepository.findById(userId).ifPresent(
                user -> {
                    user.setActive("N");
                }
        );
    }


}
