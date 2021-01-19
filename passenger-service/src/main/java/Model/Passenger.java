package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {

    int UserID ;
    int Wallet;
    String Username ;
    String Password ;
    String FirstName ;
    String LastName ;
}
