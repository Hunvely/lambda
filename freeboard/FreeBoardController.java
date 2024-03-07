package freeboard;

public class FreeBoardController {

    FreeBoardService freeBoardService;

    public FreeBoardController() {
        freeBoardService = FreeBoardServiceImpl.getInstance();
    }
}
