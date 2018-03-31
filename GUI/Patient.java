/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.hospital.GUI;

import hms.hospital.DbConeection.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asitha Imala
 */
public class Patient extends javax.swing.JFrame {

    /**
     * Creates new form Patient
     */
    public Patient() {
        initComponents();
        PatientList();

    }

    public void searchPatient() {
        try {
            Connection con = DB.connect();
            ResultSet r = con.createStatement().executeQuery("select * from patient where p_id='" + jTextField12.getText() + "'");
            boolean b = false;
            while (r.next()) {
                b = true;
                String s = r.getString("p_id");
                jTextField1.setText(s);
                String s2 = r.getString("p_name");
                jTextField2.setText(s2);
                String s3 = r.getString("age");
                jTextField3.setText(s3);
                String s4 = r.getString("gender");
                jTextField4.setText(s4);
                String s5 = r.getString("nic");
                jTextField5.setText(s5);
                String s6 = r.getString("blood_group");
                jTextField6.setText(s6);

            }

            ResultSet r2 = con.createStatement().executeQuery("select * from admit where p_id='" + jTextField12.getText() + "'");
            boolean b2 = false;
            while (r2.next()) {
                b2 = true;
                String s7 = r2.getString("admit_id");
                jTextField7.setText(s7);
                String s8 = r2.getString("admit_date");
                jTextField8.setText(s8);
                String s9 = r2.getString("medical");
                jTextArea1.setText(s9);
                String s10 = r2.getString("ward_id");
                jTextField9.setText(s10);
                jTextField7.setText(s7);
                String dt = r2.getString("external");
                jTextField13.setText(dt);
                String dt2 = r2.getString("consultant");
                jTextField14.setText(dt2);
                String dt3 = r2.getString("recommand");
                jTextField15.setText(dt3);
            }

            ResultSet r3 = con.createStatement().executeQuery("select * from ward where ward_id='" + jTextField9.getText() + "'");
            boolean b3 = false;
            while (r3.next()) {
                b3 = true;
                String s11 = r3.getString("ward_name");
                jTextField10.setText(s11);

            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void PatientList() {
        try {
            Connection con = DB.connect();
            Vector v = new Vector();

            ResultSet r = con.createStatement().executeQuery("select * from patient");
            while (r.next()) {
                String a = r.getString("p_id");
                String b = r.getString("p_name");
                String c = a + "-" + b;
                v.add(c);
                //System.out.println(a);
            }
            jList1.setListData(v);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void setPatient() {
        try {
            Object obj = jList1.getSelectedValue();
            String lst[] = obj.toString().split("-");

            Connection con = DB.connect();
            ResultSet r = con.createStatement().executeQuery("select * from patient where p_id='" + lst[0] + "'");
            boolean b = false;
            while (r.next()) {
                b = true;
                String s = r.getString("p_id");
                jTextField1.setText(s);
                String s2 = r.getString("p_name");
                jTextField2.setText(s2);
                String s3 = r.getString("age");
                jTextField3.setText(s3);
                String s4 = r.getString("gender");
                jTextField4.setText(s4);
                String s5 = r.getString("nic");
                jTextField5.setText(s5);
                String s6 = r.getString("blood_group");
                jTextField6.setText(s6);

            }

            ResultSet r2 = con.createStatement().executeQuery("select * from admit where p_id='" + lst[0] + "'");
            boolean b2 = false;
            while (r2.next()) {
                b2 = true;
                String s7 = r2.getString("admit_id");
                jTextField7.setText(s7);
                String s8 = r2.getString("admit_date");
                jTextField8.setText(s8);
                String s9 = r2.getString("medical");
                jTextArea1.setText(s9);
                String s10 = r2.getString("ward_id");
                jTextField9.setText(s10);
                String dt = r2.getString("external");
                jTextField13.setText(dt);
                String dt2 = r2.getString("consultant");
                jTextField14.setText(dt2);
                String dt3 = r2.getString("recommand");
                jTextField15.setText(dt3);
            }

            ResultSet r3 = con.createStatement().executeQuery("select * from ward where ward_id='" + jTextField9.getText() + "'");
            boolean b3 = false;
            while (r3.next()) {
                b3 = true;
                String s11 = r3.getString("ward_name");
                jTextField10.setText(s11);

            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void AssignDoctorList() {
        try {
            Connection con = DB.connect();
            Vector v = new Vector();

            ResultSet r = con.createStatement().executeQuery("select * from assign where p_id ='" + jTextField1.getText() + "'");
            while (r.next()) {
                String a = r.getString("doc_id");

                ResultSet r3 = con.createStatement().executeQuery("select * from doctor where doc_id='" + a + "'");
                boolean b3 = false;
                while (r3.next()) {
                    b3 = true;
                    String name = r3.getString("doc_name");

                    String c = a + "-" + name;
                    v.add(c);

                }

            }
            jList2.setListData(v);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void LoadTest() {

        try {

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            int i = dtm.getRowCount();
            while (i > 0) {
                dtm.removeRow(i - 1);
                i--;
            }
            Connection con = DB.connect();
            ResultSet r = con.createStatement().executeQuery("select * from test where p_id='" + jTextField1.getText() + "'");
            boolean b = false;

            while (r.next()) {

                b = true;

                Vector v = new Vector();
                v.add(r.getString("t_id"));
                v.add(r.getString("t_date"));
                v.add(r.getString("emp_id"));
                v.add(r.getString("t_name"));
                v.add(r.getString("detail"));

                dtm.addRow(v);

            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    
     public void LoadTreatment() {

        try {

            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
            int i = dtm.getRowCount();
            while (i > 0) {
                dtm.removeRow(i - 1);
                i--;
            }
            Connection con = DB.connect();
            ResultSet r = con.createStatement().executeQuery("select * from treatment where p_id='" + jTextField1.getText() + "'");
            boolean b = false;

            while (r.next()) {

                b = true;

                Vector v = new Vector();
                v.add(r.getString("tr_id"));
                v.add(r.getString("tr_date"));
                v.add(r.getString("emp_id"));
                v.add(r.getString("tr_name"));
                v.add(r.getString("detail"));
                System.out.println(r.getString("tr_id"));
                dtm.addRow(v);

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Patients"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 210, 560));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 240, 600));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setText("Reg ID:");
        jPanel11.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel9.setText("Registration Date");
        jPanel11.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel10.setText("Medical Detail");
        jPanel11.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        jPanel11.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 310, 90));

        jLabel11.setText("Ward Number");
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel18.setText("Ward Name");
        jPanel11.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));
        jPanel11.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 150, -1));
        jPanel11.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 150, -1));
        jPanel11.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 150, -1));
        jPanel11.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 150, -1));

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 810, 240));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Patient Details"));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Patient ID");
        jPanel9.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 39, -1, -1));

        jLabel4.setText("Patient Name ");
        jPanel9.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 69, -1, -1));

        jLabel5.setText("Age");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 99, -1, -1));

        jLabel6.setText("Gender");
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 129, -1, -1));

        jTextField1.setEnabled(false);
        jPanel9.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 39, 370, -1));
        jPanel9.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 69, 370, -1));
        jPanel9.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 99, 370, -1));

        jLabel13.setText("NIC NO");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 159, -1, -1));

        jLabel19.setText("Blood Group");
        jPanel9.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 189, -1, -1));
        jPanel9.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 370, -1));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel9.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 370, -1));
        jPanel9.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 370, -1));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 800, 240));

        jTabbedPane1.addTab("Registration Details", jPanel2);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setText("External Physician");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 38, -1, -1));

        jLabel14.setText("Consultant");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 70, -1, -1));

        jLabel15.setText("Recomand");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 102, -1, -1));

        jLabel16.setText("Other");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 134, -1, -1));
        jPanel8.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 32, 170, -1));
        jPanel8.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 67, 170, -1));
        jPanel8.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 99, 170, -1));

        jScrollPane6.setViewportView(jList2);

        jPanel8.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 170, 180));

        jTabbedPane1.addTab("Physicians", jPanel8);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test ID", "Test Date", "Employee ID", "Test Name", "Details"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 19, 631, 299));

        jTabbedPane1.addTab("Test Reports", jPanel5);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test ID", "Test Date", "Employee ID", "Test Name", "Details"
            }
        ));
        jScrollPane4.setViewportView(jTable3);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 19, 631, 299));

        jTabbedPane1.addTab("Treatments Reports", jPanel6);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 850, 560));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Patient Name ");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 15, -1, -1));

        jLabel2.setText("Patient ID");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 15, 136, -1));
        jPanel4.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 173, -1));

        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
        });
        jPanel4.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 12, 196, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 850, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Patient Details");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 640, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1143, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(190, 25, 1143, 680);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        searchPatient();
        AssignDoctorList();
        LoadTest();
        LoadTreatment();
    }//GEN-LAST:event_jTextField12KeyReleased

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        setPatient();
        AssignDoctorList();
        LoadTest();
        LoadTreatment();
    }//GEN-LAST:event_jList1ValueChanged

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

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
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
