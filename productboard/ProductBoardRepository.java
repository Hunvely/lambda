package productboard;

import lombok.Getter;
import user.UserRepository;
import user.UserServiceImpl;

public class ProductBoardRepository {

    private static ProductBoardRepository instance;
    public static ProductBoardRepository getInstance() { // 정적 생성 메서드
        return instance;
    }





}
