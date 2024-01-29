package com.example.expensemanagementsystem.service;

public interface PasswordEncoder {

    String encode(String password);

    boolean matches(String plaintext, String hashedPassword);
}
