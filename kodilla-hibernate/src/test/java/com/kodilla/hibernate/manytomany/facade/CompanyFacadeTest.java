package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CompanyFacadeTest {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CompanyFacade companyFacade;

    @Test
    public void testFindCompany() {
        //Given
        Company softwareMachine = new Company("Software Machinater");
        Company dataMasters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");
        Company aaa = new Company("Aaa");

        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMasters);
        int dataMastersId = dataMasters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        companyDao.save(aaa);
        int aaaId = aaa.getId();

        //When
        List<CompanyDto> companies = companyFacade.findCompany("ter");
        //Then
        assertEquals(4, companyDao.count());
        assertEquals(3, companies.size());

        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMastersId);
            companyDao.delete(greyMatterId);
            companyDao.delete(aaaId);
        } catch (Exception e) {
            // do nothing!!!!!!!!!!!!
        }
    }

    @Test
    public void testFindEmployee() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Clarovsky");

        employeeDao.save(johnSmith);
        int johnSmithId = johnSmith.getId();
        employeeDao.save(stephanieClarckson);
        int stephanieClarcksonId = stephanieClarckson.getId();
        employeeDao.save(lindaKovalsky);
        int lindaKovalskyId = lindaKovalsky.getId();

        //When
        List<EmployeeDto> employees = companyFacade.findEmployee("clar");
        //Then
        assertEquals(3, employeeDao.count());
        assertEquals(2, employees.size());

        try {
            companyDao.delete(johnSmithId);
            companyDao.delete(stephanieClarcksonId);
            companyDao.delete(lindaKovalskyId);
        } catch (Exception e) {
            // do nothing!!!!!!!!!!!!
        }
    }
}