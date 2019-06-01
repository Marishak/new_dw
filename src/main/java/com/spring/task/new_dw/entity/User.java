package com.spring.task.new_dw.entity;

import com.spring.task.new_dw.entity.enums.Gender;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "people")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String login;

    @NotNull
    private String password;

    @OneToMany(mappedBy = "owner")
    private List<Ticket> tickets;

    private String firstName;
    private String lastName;
    private String patronymic;
    private Integer age;
    private Gender gender;

}
