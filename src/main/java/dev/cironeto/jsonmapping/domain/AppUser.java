package dev.cironeto.jsonmapping.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "tb_user")
public class AppUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();


}
