package productboard;

import user.UserServiceImpl;

public class ProductBoardController {

    ProductBoardService productBoardService;
    public ProductBoardController() {
        productBoardService = ProductBoardServiceImpl.getInstance();
    }
}
