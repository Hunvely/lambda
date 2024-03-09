package user;

import enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class UserController {

    UserServiceImpl user;

    public UserController() {
        this.user = UserServiceImpl.getInstance(); // 매개 변수를 생성자를 통해 AuthServie auth = AuthServiceImpl.getIstance()가 메모리에 항상 상주하는 것이 아니라 사용할 때만 메모리를 점유함.
    }

    public String addUsers() {
        String msg = user.addUsers();
        return msg;
    }

    public String save(Scanner input) throws SQLException {
        user.save(User.bulder()
                .username(input.next())
                .password(input.next())
                .name(input.next())
                .phoneNumber(input.next())
                .job(input.next())
                .height(input.next())
                .weight(input.next())
                .build());

        return "반갑습니다.";
    }

    public String login(Scanner input) {
        return user.login(User.bulder()
                .username(input.next())
                .password(input.next())
                .build());
    }

    public Optional<User> findUserById(Scanner input) {
        return user.findById(Long.parseLong(input.next()));
    }

    public String updatePassword(Scanner input) {
        return user.updatePassword(User.bulder()
                .username(input.next())
                .password(input.next())
                .build());
    }

    public String delete(Scanner input) {
        user.delete(User.bulder()
                .username(input.next())
                .build());
        return "회원 탈퇴 완료.";
    }

    public Boolean existsById(Scanner scanner) {
        return user.existsById(Long.parseLong(scanner.next()));
    }

    public List<?> findUsersByName(Scanner input) {
        return user.findUsersByName(input.next());
    }

    public Map<String, ?> findUsersByNameFromMap(Scanner input) {
        return user.findUsersByNameFromMap(input.next());
    }

    public List<?> findUsersByJob(Scanner input) {
        System.out.println("직업으로 검색");
        return user.findUsersByJob(input.next());
    }

    public Map<String, ?> findUsersByJobFromMap(Scanner input) {
        return user.findUserByJobFromMap(input.next());
    }

    public String count() {
        return user.count();
    }

    public Optional<User> getOne(Scanner input) {
        return user.getOne(input.next());
    }

    public Map<String, ?> getUserMap() {
        return user.getUserMap();
    }

    public List<?> findUsers() throws SQLException {
        return user.findUsers();
    }

    public String createTable() throws SQLException {
        return user.createTable();
    }

    public String dropTable() throws SQLException {
        return user.dropTable();
    }
}
