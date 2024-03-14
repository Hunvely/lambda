package com.rod.api.freeboard;

import lombok.Getter;
import com.rod.api.productboard.ProductBoardServiceImpl;

public class FreeBoardServiceImpl implements FreeBoardService {

    @Getter
    private static FreeBoardServiceImpl instance = new FreeBoardServiceImpl();
    private FreeBoardRepository freeBoardRepository;

    private FreeBoardServiceImpl() {
        freeBoardRepository = FreeBoardRepository.getInstance();
    }
}
