package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
     private   int UserID ;
    private  int LicenceID;
    boolean Available;
    private String Username ;
    private String Password ;
    private String FirstName ;
    private String LastName ;


}
