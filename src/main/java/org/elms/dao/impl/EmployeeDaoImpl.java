package org.elms.dao.impl;

import org.elms.connectionfactory.ConnectionFactory;
import org.elms.dao.EmployeeDao;
import org.elms.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl  implements EmployeeDao {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    @Override
    public int save(Employee employee) throws ClassNotFoundException, SQLException {
        final String QUERY ="INSERT INTO employee (`firstName`, `lastName`, `faculty`, `absence`) VALUES (?,?,?,?)";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setString(3, employee.getFaculty());
        preparedStatement.setInt(4, employee.getAbsence());

        return preparedStatement.executeUpdate();
    }

    @Override
    public int update(Employee employee) throws ClassNotFoundException, SQLException {
        final String QUERY = "UPDATE employee set firstName = ?, lastName = ?, faculty = ?, absence = ? WHERE id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setString(3, employee.getFaculty());
        preparedStatement.setInt(4, employee.getAbsence());
        preparedStatement.setInt(5, employee.getId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        final String QUERY = "DELETE FROM employee where id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public List<Employee> findAll() throws ClassNotFoundException, SQLException {
        final List<Employee> employees = new ArrayList<>();
        final String QUERY = "SELECT *FROM employee";
        connection = ConnectionFactory.getConnection();
        resultSet = connection.prepareStatement(QUERY).executeQuery();
        while(resultSet.next()) {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setFirstName(resultSet.getString("firstName"));
            employee.setLastName(resultSet.getString("lastName"));
            employee.setFaculty(resultSet.getString("faculty"));
            employee.setAbsence(resultSet.getInt("absence"));
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public Employee findOne(int id) throws ClassNotFoundException, SQLException {
        final String QUERY ="SELECT *FROM employee where id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();

        Employee employee = new Employee();
        while(resultSet.next()){
            employee.setId(resultSet.getInt("id"));
            employee.setFirstName(resultSet.getString("firstName"));
            employee.setLastName(resultSet.getString("lastName"));
            employee.setFaculty(resultSet.getString("faculty"));
            employee.setAbsence(resultSet.getInt("absence"));
        }
        return employee;
    }
}
