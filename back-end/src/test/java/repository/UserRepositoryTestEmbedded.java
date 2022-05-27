package repository;

import com.shareExp.backend.model.User;
import com.shareExp.backend.repository.UserRepository;
import com.shareExp.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static com.shareExp.backend.enumeration.Role.CLIENT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTestEmbedded {

    private UserRepository userRepository ;

    private UserService userService;
    @Test
    public void shouldSaveUser(){
        User user = new User("jihad","dourhnou",new Date(2000, Calendar.NOVEMBER,2),CLIENT,"jihad@gmail.com","12345");
        User savedUser = (User) userRepository.save(user);
        assertThat(savedUser).usingRecursiveComparison().ignoringFields("id").isEqualTo(user);
    }
    @Test
    @Sql("classpath:test-data.sql")
    public void shouldSaveUserThroughSqlFile(){
        Optional<User> test = userRepository.findByEmail("jihad@gmail.com");
        assertThat(test).isNotEmpty();
    }
}
