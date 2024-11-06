package me.sqsw.buildandroll.service;

import lombok.RequiredArgsConstructor;
import me.sqsw.buildandroll.exception.RoleNotFound;
import me.sqsw.buildandroll.model.Role;
import me.sqsw.buildandroll.model.User;
import me.sqsw.buildandroll.repository.RoleRepository;
import me.sqsw.buildandroll.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User create(User user) {
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            user.setRoles(Set.of(roleRepository.findByName("ROLE_USER")
                    .orElseThrow(() -> new RoleNotFound("Role USER not found"))));
        }
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return Optional.empty();
    }
}
