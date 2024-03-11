package user;

import common.AbstractService;
import common.UtilService;
import common.UtilServiceImpl;
import enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Getter
    private static UserServiceImpl instance = new UserServiceImpl();
    private Map<String, User> users;
    UserRepository userRepo;

    private UserServiceImpl() {
        this.userRepo = UserRepository.getInstance();
        this.users = new HashMap<>();
    }


    @Override
    public Messenger save(User user) throws SQLException {
        users.put(user.getUsername(), user);
        userRepo.save(user);
        return Messenger.SUCCESS;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public String login(User user) {
        return users.getOrDefault(user.getUsername(), User.bulder().password("").build())
                .getPassword()
                .equals(user.getPassword()) ?
                user.getUsername() + "님 로그인 성공" : user.getUsername() + "님 로그인 실패";
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Optional findById(Long id) {
        return Optional.of(users
                .values()
                .stream()
                .filter(i -> i.getUsername().equals(id))
                .collect(Collectors.toList()).get(0));
    }

    @Override
    public String updatePassword(User user) {
        users.get(user.getUsername()).setPassword(user.getPassword());

        return user.getName() + "님 비밀번호 변경 성공";
    }

    @Override
    public String delete(User user) {
        users.remove(user.getUsername());
        return "탈퇴 완료";
    }

    @Override
    public Boolean existsById(Long id) {
        return users.containsKey(id);
    }

    @Override
    public List<?> findUsersByName(String name) {
        return users
                .values()
                .stream()
                .filter(i -> i.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByNameFromMap(String name) {
        return users
                .entrySet()
                .stream()
                .filter(i -> i.getKey().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                ;
    }

    @Override
    public List<?> findUsersByJob(String job) {

        users.values().stream().forEach(i -> System.out.println("직업 :" + i.getJob()));
        return users
                .values()
                .stream()
                .filter(i -> i.getJob().equals(job))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUserByJobFromMap(String job) {
        return users
                .entrySet()
                .stream()
                .filter(i -> i.getKey().equals(job))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public String count() {
        return users.size() + "";
    }

    @Override
    public Optional getOne(String id) {
        return Optional.of(users.get(id));
    }

    @Override
    public Map<String, ?> getUserMap() {
        return users;
    }

    @Override
    public String addUsers() {
        Map<String, User> map = new HashMap<>();
        UtilService util = UtilServiceImpl.getInstance();

        for (int i = 0; i < 5; i++) {
            String username = util.createRandomUsername();
            map.put(username,
                    User.bulder()
                            .username(username)
                            .password("1")
                            .name(util.createRandomName())
                            .build());
        }
        users = map;
        return users.size() + "개 더미값 추가";
    }

    @Override
    public String test(User user) {
        return "";
    }

    @Override
    public Messenger createTable() throws SQLException {
        return userRepo.createTable();
    }

    @Override
    public String dropTable() throws SQLException {
        return userRepo.dropTable();
    }

    @Override
    public List<?> findUsers() throws SQLException {
        return userRepo.findUsers();
    }
}
