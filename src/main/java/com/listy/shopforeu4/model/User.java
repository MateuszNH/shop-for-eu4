package com.listy.shopforeu4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lombok uzupełnia standardowe metody
@NoArgsConstructor // konstruktor ze wszystkimi argumentam // i
@AllArgsConstructor
public class User {
    private String login;
    private String password;
    private boolean leader;
    //

}
