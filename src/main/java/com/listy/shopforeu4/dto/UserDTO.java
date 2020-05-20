package com.listy.shopforeu4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //lombok uzupełnia standardowe metody
@AllArgsConstructor // konstruktor ze wszystkimi argumentami
public class UserDTO {
    private String mail;
    private String passwd;
    //

}
