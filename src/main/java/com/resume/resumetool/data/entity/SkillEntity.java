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
@Table(name = "skill_table" ,  schema = "resume")
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "resume_skill_rel",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "resume_id"))
    private List<ResumeEntity> resumes;

    @Column(name = "skill_name" , nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String skillName;

    @Column(name = "skill_level" , nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String skillLevel;


}
