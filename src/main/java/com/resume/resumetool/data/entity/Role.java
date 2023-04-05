package com.resume.resumetool.data.entity;

import com.resume.resumetool.common.constants.StringConstants;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role_table" ,  schema = "resume")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = StringConstants.ROLE_COLUMN_ID_NAME, nullable = false)
//    @JdbcTypeCode(SqlTypes.INTEGER)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
//    @JdbcTypeCode(SqlTypes.BIGINT)
    User user;


    @Column(name = "role_name" , nullable = false)
//    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String roleName;

}
