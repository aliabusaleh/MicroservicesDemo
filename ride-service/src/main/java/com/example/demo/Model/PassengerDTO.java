package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDTO {
    private int UserID ;
    private int Wallet;
    private String Username ;
    private String Password ;
    private String FirstName ;
    private String LastName ;


}
