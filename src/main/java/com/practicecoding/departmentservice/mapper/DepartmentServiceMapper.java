package com.practicecoding.departmentservice.mapper;

import com.practicecoding.departmentservice.dto.DepartmentDto;
import com.practicecoding.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentServiceMapper {

    DepartmentServiceMapper MAPPER = Mappers.getMapper(DepartmentServiceMapper.class);

    DepartmentDto mapToDepartmentDto(Department department);

    Department mapToDepartment(DepartmentDto departmentDto);
}
