package com.lld.tictactoe.main.src.models;

// Intrinsic state - state that will not change

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String email;
    private String photo;
}
