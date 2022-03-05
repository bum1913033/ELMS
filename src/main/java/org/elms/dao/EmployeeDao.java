package org.elms.dao;

import org.elms.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    int save(Employee employee) throws ClassNotFoundException, SQLException;

    int update(Employee employee) throws ClassNotFoundException, SQLException;

    int delete(int id) throws ClassNotFoundException, SQLException;

    List<Employee> findAll() throws ClassNotFoundException, SQLException;

    Employee findOne(int id) throws ClassNotFoundException, SQLException;
}
