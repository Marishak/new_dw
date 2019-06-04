package com.spring.task.new_dw.entity;

import com.spring.task.new_dw.entity.enums.Gender;
import com.spring.task.new_dw.entity.enums.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = "tickets")
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE)
    private List<Ticket> tickets;

    @NotNull
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Column(nullable = false)
    private String lastName;

    @NotNull
    @Column(nullable = false)
    private String patronymic;

    private boolean active;

    private Gender gender;

    public String printWithId () {
        return String.format("%d %s %s %s", id, lastName, firstName, patronymic);
    }

    public String print () {
        return String.format("%s %s %s", lastName, firstName, patronymic);
    }

}
