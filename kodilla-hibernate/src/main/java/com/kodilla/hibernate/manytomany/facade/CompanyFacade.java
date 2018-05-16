package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.mapper.DomainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class CompanyFacade {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DomainMapper domainMapper;

    public List<CompanyDto> findCompany(final String name) {
        return new ArrayList<>(domainMapper.mapToCompanyDtoList(companyDao.findCompanyByPartName("%" + name + "%")));
    }

    public List<EmployeeDto> findEmployee(final String name) {
        return new ArrayList<>(domainMapper.mapToEmployeeDtoList(employeeDao.findEmployeeByPartName("%" + name + "%")));
    }
}
