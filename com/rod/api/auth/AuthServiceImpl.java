package auth;

import common.UtilServiceImpl;
import user.User;
import common.UtilService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AuthServiceImpl implements AuthService {

    private static AuthService instance = new AuthServiceImpl();

    Map<String, User> users;

    private AuthServiceImpl() { // 기본 생성자 비공개로 생성.
        this.users = new HashMap<>(); // 호출할 때만 객체가 생성됨.
    }

    public static AuthService getInstance() { // 정적 생성 메서드
        return instance;
    }

    @Override
    public String join(Scanner input) {
        System.out.println("ID, 비밀번호, 비밀번호 확인, 이름, 주민 번호," +
                " 전화번호, 주소, 직업을 순서대로 입력하세요.");
        String username = input.next();
        //users.put(username, );
        User userInfo = User.bulder()
                .username(input.next())
                .password(input.next())
                .name(input.next())
                .phoneNumber(input.next())
                .job(input.next())
                .build()
                ;
        return "회원가입을 축하합니다.";
    }

    @Override
    public String login(Scanner input) {

        return null;
    }

    @Override
    public String addUsers() {
        Map<String, User> map = new HashMap<>();
        UtilService util = UtilServiceImpl.getInstance();
        for (int i = 0; i < 5; i++) {
            String username = util.createRandomUsername();
            map.put(username, User.bulder()
                            .username(username)
                            .password("1")
                            .name(util.createRandomName())
                            .build());
        }
        users = map;
        return "더미값 추가";
    }

    @Override
    public User findUser(String username) {
        User user = User.bulder().build();
        return user;
    }

    @Override
    public Map<String, ?> getUserMap() {
        users.forEach((k,v)-> System.out.println("{"+k+","+v+"},"));
        return users;
    }

    @Override
    public String count() {
        return users.size() + "";
    }
}
