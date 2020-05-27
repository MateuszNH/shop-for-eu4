package com.listy.shopforeu4.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Team {
    private User leader;
    private User player;
    private String teamName;
}
