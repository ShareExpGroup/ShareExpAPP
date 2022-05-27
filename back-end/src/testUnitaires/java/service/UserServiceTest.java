package service;

import com.shareExp.backend.model.User;
import com.shareExp.backend.repository.UserRepository;
import com.shareExp.backend.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static com.shareExp.backend.enumeration.Role.CLIENT;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock

    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;



    @Test
    @DisplayName("should find user by Email")
    void ShouldFindUserByEmail() {
        UserService userService = new UserService(userRepository);

        User user = new User("jihad","dourhnou",new Date(2000, Calendar.NOVEMBER,2),CLIENT,"jihad@gmail.com","12345");
        User expectedUserResponse = new User("jihad","dourhnou",new Date(2000, Calendar.NOVEMBER,2),CLIENT,"jihad@gmail.com","12345");
        Mockito.when(userRepository.findByEmail("jihad@gmail.com")).thenReturn(Optional.of(user));
        User actualUserResponse = userService.getUserWithEmail("jihad@gmail.com");
        org.assertj.core.api.Assertions.assertThat(actualUserResponse.getEmail()).isEqualTo(expectedUserResponse.getEmail());
    }


}