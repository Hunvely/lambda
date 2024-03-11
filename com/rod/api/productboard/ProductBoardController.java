package com.rod.api.productboard;

import com.rod.api.user.UserServiceImpl;

public class ProductBoardController {

    ProductBoardService productBoardService;
    public ProductBoardController() {
        productBoardService = ProductBoardServiceImpl.getInstance();
    }
}
