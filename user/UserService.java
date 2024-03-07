package user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public interface UserService {

    String addUsers();

    String login(User user);

    String updatePassword(User user);

    List<?> findUsersByName(String name);

    Map<String, ?> findUsersByNameFromMap(String name);

    List<?> findUsersByJob(String job);

    Map<String, ?> findUserByJobFromMap(String name);

    Map<String, ?> getUserMap();

    String test(User user);

    List<?> findUsers() throws SQLException;

}
