package ru.kata.spring.boot_security.demo.servise;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserRepository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;


import java.sql.SQLOutput;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiseImp implements UserServise, UserDetailsService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiseImp(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void add(User user) {


        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);


    }

    @Override
    public User getUser(Long id) {
        User user = null;
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            user = optional.get();
        }
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUser(String name) {
        return userRepository.findByName(name);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByName(s);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return user;
    }
}
