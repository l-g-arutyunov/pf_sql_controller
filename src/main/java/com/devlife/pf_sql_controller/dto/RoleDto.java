package com.devlife.pf_sql_controller.dto;

import com.devlife.pf_sql_controller.entity.RoleType;
import com.devlife.pf_sql_controller.entity.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto implements Serializable {
    private Long id;
    private String name;
    private String description;
    private UserGroupDto userGroupId;
    private RoleTypeDto roleType;
}
