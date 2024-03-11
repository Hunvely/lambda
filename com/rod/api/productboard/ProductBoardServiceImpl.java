package com.rod.api.productboard;

import lombok.Getter;
import com.rod.api.user.UserServiceImpl;

public class ProductBoardServiceImpl implements ProductBoardService{

    @Getter
    private static ProductBoardServiceImpl instance = new ProductBoardServiceImpl();
    ProductBoardRepository productBoardRepository;

    private ProductBoardServiceImpl() {
        this.productBoardRepository = ProductBoardRepository.getInstance();
    }


}
