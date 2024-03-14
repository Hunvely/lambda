package com.rod.api.productboard;

import lombok.Getter;
import com.rod.api.user.UserRepository;
import com.rod.api.user.UserServiceImpl;

public class ProductBoardRepository {

    private static ProductBoardRepository instance;
    public static ProductBoardRepository getInstance() { // 정적 생성 메서드
        return instance;
    }





}
