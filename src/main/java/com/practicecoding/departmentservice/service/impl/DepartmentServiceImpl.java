package com.practicecoding.departmentservice.service.impl;

import com.practicecoding.departmentservice.dto.DepartmentDto;
import com.practicecoding.departmentservice.entity.Department;
import com.practicecoding.departmentservice.mapper.DepartmentServiceMapper;
import com.practicecoding.departmentservice.repository.DepartmentRepository;
import com.practicecoding.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    ModelMapper modelMapper;
    DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
//        Department department = new Department(departmentDto.getId(),
//                departmentDto.getDepartmentName(),departmentDto.getDepartmentDescription(),
//                departmentDto.getDepartmentCode());
//Model Mapper->
//        Department department = modelMapper.map(departmentDto,Department.class);
//MapStruct->
        Department department = DepartmentServiceMapper.MAPPER.mapToDepartment(departmentDto);
        Department savedDepartment =departmentRepository.save(department);

//        return new DepartmentDto(savedDepartment.getId(), savedDepartment.getDepartmentName(),
//                savedDepartment.getDepartmentDescription(), savedDepartment.getDepartmentCode());
//Model Mapper->
//        return modelMapper.map(savedDepartment,DepartmentDto.class);
//Map Struct->
        return DepartmentServiceMapper.MAPPER.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
//        return new DepartmentDto(department.getId(),department.getDepartmentName(),
//                department.getDepartmentDescription(),department.getDepartmentCode());
//Model Mapper->
//        return modelMapper.map(department,DepartmentDto.class);
//MapStruct->
        return DepartmentServiceMapper.MAPPER.mapToDepartmentDto(department);
    }
}
