package sead.assignment2.internal.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import sead.assignment2.external.enums.AuthRole;
import sead.assignment2.external.service.ExternalUserService;

@Service
public class UserServiceImpl implements InternalUserService, ExternalUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User createUser(String emailAddress, String password) throws Exception {
        if (repository.findByEmailAddress(emailAddress).isPresent()) {
            throw new DataIntegrityViolationException("This email has already been registered");
        }

        User user = new User(null, emailAddress, password, AuthRole.ROLE_USER, null, null);

        return repository.save(user);
    }

    @Override
    public User getUserById(Long id) throws EntityNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with this id does not exists"));
    }

    @Override
    public User getUserByEmailAddress(String emailOrPhone) throws EntityNotFoundException {
        return repository.findByEmailAddress(emailOrPhone)
                .orElseThrow(() -> new EntityNotFoundException("User with this email address does not exists"));
    }
}
