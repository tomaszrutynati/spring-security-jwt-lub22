package pl.sda.jwtlub22.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TokenSubject {
    private String username;
    private String role;
    //.. kolejne pola, email, imie, nazwisko itd.
}
