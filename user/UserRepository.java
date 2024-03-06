package user;

import crawler.CrawlerRepository;

public class UserRepository {

    private static UserRepository instance = new UserRepository();

    public static UserRepository getInstance() { // 정적 생성 메서드
        return instance;
    }

}
