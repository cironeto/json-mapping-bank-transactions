package dev.cironeto.jsonmapping.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.cironeto.jsonmapping.entity.User;
import lombok.*;

import javax.validation.constraints.Email;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class UserDto implements Serializable {

    private String id;
    private String name;

    @Email
    private String email;

    @JsonIgnore
    private String password;


    public UserDto(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        password = entity.getPassword();
    }

}
