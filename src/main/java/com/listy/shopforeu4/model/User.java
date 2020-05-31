package com.listy.shopforeu4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // naprawia błądxD
@Data //lombok uzupełnia standardowe metody
@NoArgsConstructor // konstruktor ze wszystkimi argumentam // i
@AllArgsConstructor
public class User {
    @Id
    private String login;
    private String password;
    private boolean leader;
    //

}
