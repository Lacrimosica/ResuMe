package com.resume.resumetool.data.entity;

import jakarta.persistence.*;
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
@Table(name = "resume_table" ,  schema = "resume")
public class ResumeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Column(name = "title" , nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String title;

    @Column(name = "summary" , nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String summary;

    @Column(name = "objective" , nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String objective;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    UserEntity user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "resume_experience_rel",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "experience_id"))
    private List<ExperienceEntity> experiences;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "resume_education_rel",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "education_id"))
    private List<EducationEntity> educations;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "resume_skill_rel",
        joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<SkillEntity> skills;
}
