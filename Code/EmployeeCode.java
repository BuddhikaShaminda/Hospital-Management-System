/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.hospital.Code;

import hms.hospital.DbConeection.DB;
import hms.hospital.Objects.EmployeeObj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Asitha Imala
 */
public class EmployeeCode {
    
     public static void save( EmployeeObj employeeObj ) {
        try {
            
            
            
                Connection con = DB.connect();
                PreparedStatement r = con.prepareStatement("insert into employee values('" + employeeObj.getEmp_id() + "','" + employeeObj.getEmp_name()+ "','" + employeeObj.getGender()+ "','" +employeeObj.getBirth()+ "','" + employeeObj.getPhn_no()+ "','" + employeeObj.getAddress()+ "','" + employeeObj.getEmail()+ "','" +employeeObj.getNic()+ "','" + employeeObj.getPosition()+ "','" + employeeObj.getSalary()+ "')");
                r.executeUpdate();
                r.close();
                JOptionPane.showMessageDialog(null, "Successfuly Saved");

     
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
     
         public void delete(EmployeeObj employeeObj) {
        try {
            Connection com = DB.connect();
            PreparedStatement r = com.prepareStatement("delete from employee where emp_id='" + employeeObj.getEmp_id() + "'");
            r.executeUpdate();
            r.close();
            JOptionPane.showMessageDialog(null, "Successfuly delete");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
         
           public void update(EmployeeObj employeeObj) {
        try {
            Connection con = DB.connect();
            PreparedStatement r = con.prepareStatement("update employee set emp_name='" + employeeObj.getEmp_name() + "',gender='" + employeeObj.getGender() + "', birth='" + employeeObj.getBirth().toString() + "',phn_no='" + employeeObj.getPhn_no() + "',address='" + employeeObj.getAddress()+ "',email='" + employeeObj.getEmail() + "',nic='" +  employeeObj.getNic()+ "',position='" + employeeObj.getPosition()+ "',salary='" +employeeObj.getSalary() + "'where emp_id='" + employeeObj.getEmp_id()+ "'");
            r.executeUpdate();
            r.close();
            JOptionPane.showMessageDialog(null, "Successfuly Update");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }  
         
         
}
