package com.devlife.pf_sql_controller.controller.v1;

import com.devlife.pf_sql_controller.dto.EmployerDto;
import com.devlife.pf_sql_controller.mapper.EmployerMapper;
import com.devlife.pf_sql_controller.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/")
public class EmployerController {

    private final EmployerService service;
    private final EmployerMapper mapper;

    @PutMapping("employer")
    Long addEmployer(@RequestBody EmployerDto employerDto) {
        return service.addEmployer(mapper.convertToEntity(employerDto));
    }

    @GetMapping("employer/{id}")
    EmployerDto getEmployer(@PathVariable("id") Long id) {
        return mapper.convertToDto(service.getEmployer(id));
    }

    @GetMapping("employer")
    List<EmployerDto> getAllEmployers() {
        return service.getAllEmployers().stream().map(mapper::convertToDto).collect(Collectors.toList());
    }

    @DeleteMapping("employer/{id}")
    Boolean deleteEmployerById(@PathVariable("id") Long id) {
        return service.deleteEmployerById(id);
    }

}
