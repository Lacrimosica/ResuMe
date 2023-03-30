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
@Table(name = "education_table" ,  schema = "resume")
public class EducationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "resume_education_rel",
            joinColumns = @JoinColumn(name = "education_id"),
            inverseJoinColumns = @JoinColumn(name = "resume_id"))
    private List<ResumeEntity> resumes;

    @Column(name = "institution_name" , nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String institutionName;

    @Column(name = "job_title" , nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String jobTitle;

    @Column(name = "start_date" , nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String startDate;

    @Column(name = "end_date" , nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String endDate;

    @Column(name = "degree", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String degree;

    @Column(name = "major", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String major;

    @Column(name = "description" , nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String description;


}
