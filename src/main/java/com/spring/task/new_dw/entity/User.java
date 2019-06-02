package com.spring.task.new_dw.entity;

import com.spring.task.new_dw.entity.enums.Gender;
import com.spring.task.new_dw.entity.enums.Role;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @NotNull
    @Column(unique = true)
    private String login;

    @NotNull
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "owner")
    private Set<Ticket> tickets;

    @NotNull
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Column(nullable = false)
    private String lastName;

    @NotNull
    @Column(nullable = false)
    private String patronymic;

    private Gender gender;

}
