package user;

import enums.Messenger;

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

    public String save(Scanner input) {
        user.save(User.bulder()
                .username(input.next())
                .password(input.next())
                .name(input.next())
                .socialSecurityNumber(input.next())
                .phoneNumber(input.next())
                .address(input.next())
                .job(input.next())
                .build());

        return "gd";
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
                .socialSecurityNumber(input.next())
                .address(input.next())
                .phoneNumber(input.next())
                .password(input.next())
                .build());
    }

    public String deleteUser(Scanner input) {
        return user.delete(User.bulder()
                .username(input.next())
                .build());
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

    public Long count() {
        System.out.println("회원수");
        return user.count();
    }

    public Map<String, ?> getUserMap() {
        return user.getUserMap();
    }

}
