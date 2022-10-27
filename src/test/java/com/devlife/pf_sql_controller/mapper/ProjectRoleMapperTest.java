package com.devlife.pf_sql_controller.mapper;

import com.devlife.pf_sql_controller.dto.ProjectDto;
import com.devlife.pf_sql_controller.dto.ProjectRoleDto;
import com.devlife.pf_sql_controller.dto.RoleDto;
import com.devlife.pf_sql_controller.dto.UserDto;
import com.devlife.pf_sql_controller.entity.Project;
import com.devlife.pf_sql_controller.entity.ProjectRole;
import com.devlife.pf_sql_controller.entity.Role;
import com.devlife.pf_sql_controller.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
@DisplayName("ProjectRole Mapper Tests")
class ProjectRoleMapperTest {

    @Autowired
    ProjectRoleMapper mapper;

    @Test
    void convertToEntity() {
        User refUser = User.builder()
                .id(1L)
                .build();
        Role refRole = Role.builder()
                .id(2L)
                .build();
        Project refProject = Project.builder()
                .id(3L)
                .build();

        ProjectRole referenceProjectRole = new ProjectRole();
        referenceProjectRole.setId(1L);
        referenceProjectRole.setProject(refProject);
        referenceProjectRole.setRole(refRole);
        referenceProjectRole.setUser(refUser);
        referenceProjectRole.setRoleLevel("roleLevel");
        referenceProjectRole.setStartDate(LocalDate.EPOCH);
        referenceProjectRole.setEndDate(LocalDate.MAX);

        ProjectRoleDto projectRoleDto = ProjectRoleDto.builder()
                .id(1L)
                .user(UserDto.builder().id(1L).build())
                .role(RoleDto.builder().id(2L).build())
                .project(ProjectDto.builder().id(3L).build())
                .startDate(LocalDate.EPOCH)
                .endDate(LocalDate.MAX)
                .roleLevel("roleLevel")
                .build();

        ProjectRole projectRole = mapper.convertToEntity(projectRoleDto);
        assertEquals(referenceProjectRole, projectRole);
    }

    @Test
    void convertToDto() {
        ProjectRoleDto referenceProjectRoleDto = ProjectRoleDto.builder().id(1L).startDate(LocalDate.EPOCH)
                .endDate(LocalDate.EPOCH).roleLevel("roleLevel").build();

        ProjectRole projectRole = new ProjectRole();
        projectRole.setId(1L);
        projectRole.setRoleLevel("roleLevel");
        projectRole.setStartDate(LocalDate.EPOCH);
        projectRole.setEndDate(LocalDate.EPOCH);

        ProjectRoleDto projectRoleDto = mapper.convertToDto(projectRole);
        assertEquals(referenceProjectRoleDto, projectRoleDto);

    }
}