package com.rod.api.freeboard;

import com.rod.api.productboard.ProductBoardRepository;

public class FreeBoardRepository {

    private static FreeBoardRepository instance;

    public static FreeBoardRepository getInstance() { // 정적 생성 메서드
        return instance;
    }
}
