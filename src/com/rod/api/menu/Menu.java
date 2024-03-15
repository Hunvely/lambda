package com.rod.api.menu;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {

    private Long id;
    private String item;
    private String category;

}
