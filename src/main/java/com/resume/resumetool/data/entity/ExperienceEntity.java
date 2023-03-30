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
@Table(name = "experience_table" ,  schema = "resume")
public class ExperienceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "resume_experience_rel",
            joinColumns = @JoinColumn(name = "experience_id"),
            inverseJoinColumns = @JoinColumn(name = "resume_id"))
    private List<ResumeEntity> resumes;

    @Column(name = "company_name" , nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String companyName;

    @Column(name = "job_title" , nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String jobTitle;

    @Column(name = "start_date" , nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String startDate;

    @Column(name = "end_date" , nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String endDate;

    @Column(name = "location" , nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String location;


    @Column(name = "description" , nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String description;



}
