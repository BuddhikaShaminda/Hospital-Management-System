/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.hospital.GUI;

import hms.hospital.Code.EmployeeCode;
import hms.hospital.DbConeection.DB;
import hms.hospital.Objects.EmployeeObj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Asitha Imala
 */
public class Employee extends javax.swing.JFrame {

    /**
     * Creates new form Employee
     */
    public Employee() {
        initComponents();

    }

    //metode for save employee
//    public void save() {
//        try {
//            if (!jTextField2.getText().isEmpty() && !jTextField3.getText().isEmpty() && !jTextField4.getText().isEmpty() && !jTextField5.getText().isEmpty() && !jTextField6.getText().isEmpty()) {
//                Connection con = DB.connect();
//                PreparedStatement r = con.prepareStatement("insert into employee values('" + jTextField1.getText() + "','" + jTextField2.getText() + "','" + jComboBox1.getSelectedItem() + "','" + jTextField3.getText() + "','" + jTextField4.getText() + "','" + jTextArea1.getText() + "','" + jTextField5.getText() + "','" + jTextField6.getText() + "','" + jComboBox2.getSelectedItem() + "','" + jTextField7.getText() + "')");
//                r.executeUpdate();
//                r.close();
//                JOptionPane.showMessageDialog(null, "Successfuly Saved");
//
//            } else {
//                JOptionPane.showMessageDialog(null, "Check Text filds");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    // methode for Delete a Employee
//    public void delete() {
//        try {
//            Connection com = DB.connect();
//            PreparedStatement r = com.prepareStatement("delete from employee where emp_id='" + jTextField1.getText() + "'");
//            r.executeUpdate();
//            r.close();
//            JOptionPane.showMessageDialog(null, "Successfuly delete");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    //methode for update Employee
//    public void update() {
//        try {
//            Connection con = DB.connect();
//            PreparedStatement r = con.prepareStatement("update employee set emp_name='" + jTextField2.getText() + "',gender='" + jComboBox1.getSelectedItem() + "', birth='" + jTextField3.getText() + "',phn_no='" + jTextField4.getText() + "',address='" + jTextArea1.getText() + "',email='" + jTextField5.getText() + "',nic='" + jTextField6.getText() + "',position='" + jComboBox2.getSelectedItem() + "',salary='" + jTextField7.getText() + "'where emp_id='" + jTextField1.getText() + "'");
//            r.executeUpdate();
//            r.close();
//            JOptionPane.showMessageDialog(null, "Successfuly Update");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    public void search() {
        try {
            Connection con = DB.connect();
            ResultSet r = con.createStatement().executeQuery("select * from employee where emp_id='" + jTextField8.getText() + "'");
            boolean b = false;
            while (r.next()) {
                b = true;
                String a0 = r.getString("emp_id");
                jTextField1.setText(a0);
                String a = r.getString("emp_name");
                jTextField2.setText(a);
                String a1 = r.getString("gender");
                jComboBox1.setSelectedItem(a1);
                String a11 = r.getString("birth");
                jTextField3.setText(a11);
                String a2 = r.getString("phn_no");
                jTextField4.setText(a2);
                String a3 = r.getString("address");
                jTextArea1.setText(a3);
                String a4 = r.getString("email");
                jTextField5.setText(a4);
                String a5 = r.getString("nic");
                jTextField6.setText(a5);
                String a6 = r.getString("position");
                jComboBox2.setSelectedItem(a6);
                String a7 = r.getString("salary");
                jTextField7.setText(a7);

            }
            if (b) {
            } else {
                clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
            
        }
    }

    public void clear() {

        jTextField2.setText("");

        jTextField3.setText("");
        jTextField4.setText("");
        jTextArea1.setText("");
        jTextField5.setText("");
        jTextField6.setText("");

        jTextField7.setText("");

    }

    void EmployeeList() {
        try {
            Connection com = DB.connect();
            Object obj = jList1.getSelectedValue();

            Vector v = new Vector();

            ResultSet r = com.createStatement().executeQuery("select * from employee where position='" + obj.toString() + "'");
            while (r.next()) {
                String a = r.getString("emp_id");
                String b = r.getString("emp_name");
                String c = a + "-" + b;
                v.add(c);
                //System.out.println(a);
            }
            jList2.setListData(v);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void setEmployee() {
        try {

            Connection com = DB.connect();
            Object b = jList2.getSelectedValue();
            String lst[] = b.toString().split("-");
            ResultSet r = com.createStatement().executeQuery("select * from employee where emp_id='" + lst[0] + "'");
            while (r.next()) {
                String a0 = r.getString("emp_id");
                jTextField1.setText(a0);
                String a = r.getString("emp_name");
                jTextField2.setText(a);
                String a1 = r.getString("gender");
                jComboBox1.setSelectedItem(a1);
                String a11 = r.getString("birth");
                jTextField3.setText(a11);
                String a2 = r.getString("phn_no");
                jTextField4.setText(a2);
                String a3 = r.getString("address");
                jTextArea1.setText(a3);
                String a4 = r.getString("email");
                jTextField5.setText(a4);
                String a5 = r.getString("nic");
                jTextField6.setText(a5);
                String a6 = r.getString("position");
                jComboBox2.setSelectedItem(a6);
                String a7 = r.getString("salary");
                jTextField7.setText(a7);

            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Emloyee ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 78, 22));

        jLabel2.setText("Employee Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, -1, -1));

        jLabel3.setText("Date of Birth");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 108, -1, -1));

        jLabel4.setText("Contact Number");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel5.setText("Gender");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 76, -1, -1));

        jLabel6.setText("Permenent Address");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 172, -1, -1));

        jLabel7.setText(" ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel8.setText("e-mail Address");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel9.setText("NIC Number");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel10.setText("Position");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));

        jLabel11.setText("Salary");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 12, 170, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 41, 170, -1));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 105, 170, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 73, 170, -1));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 137, 170, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 170, -1));
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 170, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doctor", "Administrator", "MLT", "Receptionist" }));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 30, 120, -1));
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 120, -1));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 610, 350));

        jList2.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee Name"));
        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 130, 210));

        jList1.setBorder(javax.swing.BorderFactory.createTitledBorder("Position"));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Doctor", "Administrator", "MLT", "Receptionist" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 120, 210));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Add ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 580, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Staff Details");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel13.setText("Emplyee ID");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });
        jPanel3.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 110, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            if (!jTextField2.getText().isEmpty() && !jTextField3.getText().isEmpty() && !jTextField4.getText().isEmpty() && !jTextField5.getText().isEmpty() && !jTextField6.getText().isEmpty()) {

                EmployeeObj employeeObj = new EmployeeObj();
                employeeObj.setEmp_id(jTextField1.getText());
                employeeObj.setEmp_name(jTextField2.getText());
                employeeObj.setGender(jComboBox1.getSelectedItem().toString());
                employeeObj.setBirth(jTextField3.getText());
                employeeObj.setPhn_no(Integer.parseInt(jTextField4.getText()));
                employeeObj.setAddress(jTextArea1.getText());
                employeeObj.setEmail(jTextField5.getText());
                employeeObj.setNic(jTextField6.getText());
                employeeObj.setPosition(jComboBox2.getSelectedItem().toString());
                employeeObj.setSalary(Integer.parseInt(jTextField7.getText()));

                EmployeeCode employeeSave = new EmployeeCode();
                employeeSave.save(employeeObj);

            } else {
                JOptionPane.showMessageDialog(null, "Check Text filds");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {

            EmployeeObj employeeObj = new EmployeeObj();
            employeeObj.setEmp_id(jTextField1.getText());
            EmployeeCode employeeDelete = new EmployeeCode();
            employeeDelete.delete(employeeObj);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {

            EmployeeObj employeeObj = new EmployeeObj();
            employeeObj.setEmp_id(jTextField1.getText());
            employeeObj.setEmp_name(jTextField2.getText());
            employeeObj.setGender(jComboBox1.getSelectedItem().toString());
            employeeObj.setBirth(jTextField3.getText());
            employeeObj.setPhn_no(Integer.parseInt(jTextField4.getText()));
            employeeObj.setAddress(jTextArea1.getText());
            employeeObj.setEmail(jTextField5.getText());
            employeeObj.setNic(jTextField6.getText());
            employeeObj.setPosition(jComboBox2.getSelectedItem().toString());
            employeeObj.setSalary(Integer.parseInt(jTextField7.getText()));

            EmployeeCode employeeSave = new EmployeeCode();
            employeeSave.update(employeeObj);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased

    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        search();
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        EmployeeList();
    }//GEN-LAST:event_jList1ValueChanged

    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
        if (!jList2.getSelectedValue().isEmpty()) {
            setEmployee();
        }
    }//GEN-LAST:event_jList2ValueChanged

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
