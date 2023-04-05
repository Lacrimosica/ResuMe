package com.resume.resumetool.data.entity;

import com.resume.resumetool.common.constants.StringConstants;
import javax.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resume_table" ,  schema = "resume")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = StringConstants.RESUME_COLUMN_ID_NAME, nullable = false)
//    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Column(name = "title" , nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String title;

    @Column(name = "summary" , nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String summary;

    @Column(name = "objective" , nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String objective;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "resume_experience_rel",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "experience_id"))
    private List<Experience> experiences;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "resume_education_rel",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "education_id"))
    private List<Education> educations;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "resume_skill_rel",
        joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills;
}
