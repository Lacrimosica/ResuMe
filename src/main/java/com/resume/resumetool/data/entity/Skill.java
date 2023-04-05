package com.resume.resumetool.data.entity;

import com.resume.resumetool.common.constants.StringConstants;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "skill_table" ,  schema = "resume")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = StringConstants.SKILL_COLUMN_ID_NAME, nullable = false)
//    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "resume_skill_rel",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "resume_id"))
    private List<Resume> resumes;

    @Column(name = "skill_name" , nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String skillName;

    @Column(name = "skill_level" , nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String skillLevel;


}
