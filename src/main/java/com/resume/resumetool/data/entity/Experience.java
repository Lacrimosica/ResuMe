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
@Table(name = "experience_table" ,  schema = "resume")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = StringConstants.EXPERIENCE_COLUMN_ID_NAME, nullable = false)
//    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "resume_experience_rel",
            joinColumns = @JoinColumn(name = "experience_id"),
            inverseJoinColumns = @JoinColumn(name = "resume_id"))
    private List<Resume> resumes;

    @Column(name = "company_name" , nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String companyName;

    @Column(name = "job_title" , nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String jobTitle;

    @Column(name = "start_date" , nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String startDate;

    @Column(name = "end_date" , nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String endDate;

    @Column(name = "location" , nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String location;


    @Column(name = "description" , nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String description;



}
