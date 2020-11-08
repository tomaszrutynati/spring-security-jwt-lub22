package pl.sda.jwtlub22.external.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Document(collection = "users")
public class UserDocument {
    @Id
    private String id;

    private String username;
    private String password;
    private String role;
}
