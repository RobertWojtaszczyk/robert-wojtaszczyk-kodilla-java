package com.kodilla.hibernate.manytomany.mapper;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.facade.CompanyDto;
import com.kodilla.hibernate.manytomany.facade.EmployeeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DomainMapper {

    public CompanyDto mapToCompanyDto(final Company company) {
        return new CompanyDto(company.getId(), company.getName());
    }

    public List<CompanyDto> mapToCompanyDtoList(final List<Company> companies) {
        return companies.stream()
                .map(this::mapToCompanyDto)
                .collect(Collectors.toList());
    }

    public EmployeeDto mapToEmployeeDto(final Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getFirstname(), employee.getLastname());
    }

    public List<EmployeeDto> mapToEmployeeDtoList(final List<Employee> employees) {
        return employees.stream()
                .map(this::mapToEmployeeDto)
                .collect(Collectors.toList());
    }
}
