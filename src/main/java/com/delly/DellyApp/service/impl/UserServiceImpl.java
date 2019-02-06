package com.delly.DellyApp.service.impl;

import com.delly.DellyApp.dto.UserRequestDto;
import com.delly.DellyApp.model.User;
import com.delly.DellyApp.repository.UserRepository;
import com.delly.DellyApp.service.UserService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation service of {@link UserService} interface.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createNewUser(UserRequestDto newUser) {
        User user = new User();
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setPhoneNumber(newUser.getPhoneNumber());
        user.setRole(newUser.getRole());
        user.setUsername(newUser.getUserName());
        user.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));

        //create stripe customer
        Customer customer = null;
        try {
            customer = createStripeCustomer(newUser);
        } catch (StripeException e) {
            //TODO add logger here
        }
        user.setStripeCustomerId(customer.getId());
        userRepository.save(user);

        return user;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User findUserByUserNameOrEmail(String userName, String email) {
        return userRepository.findUserByUsernameOrEmail(userName, email);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    private Customer createStripeCustomer(UserRequestDto user) throws StripeException {
        Stripe.apiKey = "sk_test_0bVvqqJeGfmDEBNBjiBTYyjs";

        Map<String, Object> customerParams = new HashMap<>();
        customerParams.put("email", user.getEmail());
        customerParams.put("source", user.getStripeToken());

        return Customer.create(customerParams);
    }
}
