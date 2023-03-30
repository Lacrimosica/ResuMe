package com.resume.resumetool.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table" , schema = "resume")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Size(min = 3, max = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Size(min = 3, max = 30)
    private String lastName;

    @Column(name = "username", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Size(min = 3, max = 20)
    private String username;

    @Column(name = "password", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Size(min = 3, max = 20)
    private String password;


    @Column(name = "email", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Size(min = 3, max = 20)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ResumeEntity> resumes;

}
