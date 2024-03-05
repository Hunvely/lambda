package user;

import common.AbstractService;
import common.UtilService;
import common.UtilServiceImpl;
import enums.Messenger;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Getter
    private static UserServiceImpl instance = new UserServiceImpl();
    Map<String, User> users;

    private UserServiceImpl() {
        this.users = new HashMap<>();
    }


    @Override
    public Messenger save(User user) {
        users.put(user.getUsername(), user);
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
                "로그인 성공" : "로그인 실패";
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String updatePassword(User user) {
        users.get(user.getUsername()).setPassword(user.getPassword());

        return "비번 변경 성공";
    }

    @Override
    public String delete(User user) {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
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

        return users
                .values()
                .stream()
                .filter(i -> i.getName().equals(job))
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
    public Long count() {
        return null;
    }

    @Override
    public Optional getOne(String id) {
        return Optional.empty();
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
}
