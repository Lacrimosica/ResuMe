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
@Table(name = "education_table" ,  schema = "resume")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = StringConstants.EDUCATION_COLUMN_ID_NAME, nullable = false)
//    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "resume_education_rel",
            joinColumns = @JoinColumn(name = "education_id"),
            inverseJoinColumns = @JoinColumn(name = "resume_id"))
    private List<Resume> resumes;

    @Column(name = "institution_name" , nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String institutionName;

    @Column(name = "job_title" , nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String jobTitle;

    @Column(name = "start_date" , nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String startDate;

    @Column(name = "end_date" , nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String endDate;

    @Column(name = "degree", nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String degree;

    @Column(name = "major", nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String major;

    @Column(name = "description" , nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String description;


}
