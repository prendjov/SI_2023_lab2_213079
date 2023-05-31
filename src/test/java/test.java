import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class SILab2Test {

    private final SILab2 function = new SILab2();

    @Test
    public void testValidUser() {
        User user = new User("TestOne", "password123", "testone@gmail.com");
        List<User> allUsers = new ArrayList<>();
        Assertions.assertTrue(function.function(user, allUsers));
    }

    @Test
    public void testNullUser() {
        List<User> allUsers = new ArrayList<>();
        Assertions.assertThrows(RuntimeException.class, () -> function.function(null, allUsers));
    }

    @Test
    public void testMissingPassword() {
        User user = new User("TestOne", null, "testone@gmail.com");
        List<User> allUsers = new ArrayList<>();
        Assertions.assertThrows(RuntimeException.class, () -> function.function(user, allUsers));
    }

    @Test
    public void testMissingEmail() {
        User user = new User("TestOne", "password123", null);
        List<User> allUsers = new ArrayList<>();
        Assertions.assertThrows(RuntimeException.class, () -> function.function(user, allUsers));
    }

    @Test
    public void testMissingMandatoryInformation() {
        User user = new User("TestOne", null, null);
        List<User> allUsers = new ArrayList<>();
        Assertions.assertThrows(RuntimeException.class, () -> function.function(user, allUsers));
    }

    @Test
    public void testNullUsername() {
        User user = new User(null, "password123", "testone@gmail.com");
        List<User> allUsers = new ArrayList<>();
        Assertions.assertTrue(function.function(user, allUsers));
        Assertions.assertEquals(user.getEmail(), user.getUsername());
    }

    @Test
    public void testExistingUser() {
        User user = new User("TestOne", "password123", "testone@gmail.com");
        List<User> allUsers = new ArrayList<>();
        allUsers.add(new User("existing", "existing123", "existing123@gmail.com"));
        Assertions.assertFalse(function.function(user, allUsers));
    }

    @Test
    public void testPasswordContainsUsername() {
        User user = new User("testone", "testone123", "testone@gmail.com");
        List<User> allUsers = new ArrayList<>();
        Assertions.assertFalse(function.function(user, allUsers));
    }

    @Test
    public void testShortPassword() {
        User user = new User("TestOne", "pass", "testone@gmail.com");
        List<User> allUsers = new ArrayList<>();
        Assertions.assertFalse(function.function(user, allUsers));
    }

    @Test
    public void testPasswordWithoutSpecialCharacters() {
        User user = new User("TestOne", "password123", "testone@gmail.com");
        List<User> allUsers = new ArrayList<>();
        Assertions.assertFalse(function.function(user, allUsers));
    }

    @Test
    public void testValidPassword() {
        User user = new User("TestOne", "Password123@", "testone@gmail.com");
        List<User> allUsers = new ArrayList<>();
        Assertions.assertTrue(function.function(user, allUsers));
    }

    @Test
    void function() {
        testNullUser();
    }
}
