/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.hospital.GUI;

import hms.hospital.DbConeection.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Asitha Imala
 */
public class Ward extends javax.swing.JFrame {

    /**
     * Creates new form Ward
     */
    public Ward() {
        initComponents();
        WardList();
        LoadDoctorList();
    }

    public void LoadDoctorList() {
        try {
            Connection con = DB.connect();
            ResultSet r = con.createStatement().executeQuery("select * from doctor");
            while (r.next()) {
                jComboBox1.addItem(r.getString("doc_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addWard() {
        try {
            Connection con = DB.connect();
            ResultSet r1 = con.createStatement().executeQuery("select doc_id from doctor where doc_name='" + jComboBox1.getSelectedItem() + "'");
            String did = null;
            boolean b1 = false;
            while (r1.next()) {
                b1 = true;
                did = r1.getString("doc_id");
            }

            if (!jTextField1.getText().isEmpty() && !jTextField2.getText().isEmpty() && !jTextField4.getText().isEmpty()) {

                PreparedStatement r = con.prepareStatement("insert into ward values('" + jTextField1.getText() + "','" + jTextField2.getText() + "','" + did + "','" + jTextField4.getText() + "','" + jTextField5.getText() + "')");
                r.executeUpdate();
                r.close();
                JOptionPane.showMessageDialog(null, "Successfuly Saved");

                validate();

            } else {
                JOptionPane.showMessageDialog(null, "Check Text fields");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // methode for Delete a ward
    public void delete() {
        try {
            Connection con = DB.connect();
            PreparedStatement r = con.prepareStatement("delete from ward where ward_id='" + jTextField1.getText() + "'");
            r.executeUpdate();
            r.close();
            JOptionPane.showMessageDialog(null, "Successfuly delete");
            validate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //methode for update ward
    public void update() {
        try {
            Connection con = DB.connect();

            ResultSet r1 = con.createStatement().executeQuery("select doc_id from doctor where doc_name='" + jComboBox1.getSelectedItem() + "'");
            String did = null;
            boolean b1 = false;
            while (r1.next()) {
                b1 = true;
                did = r1.getString("doc_id");
            }

            PreparedStatement r = con.prepareStatement("update ward set ward_name='" + jTextField2.getText() + "',doc_id='" + did + "',maxnop='" + jTextField4.getText() + "',curnop='" + jTextField5.getText() + "'where doc_id='" + jTextField1.getText() + "'");
            r.executeUpdate();
            r.close();
            JOptionPane.showMessageDialog(null, "Successfuly Update");
            validate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void search() {
        try {
            Connection con = DB.connect();

            ResultSet r = con.createStatement().executeQuery("select * from ward where ward_id='" + jTextField6.getText() + "'");
            boolean b = false;
            while (r.next()) {
                b = true;
                String s = r.getString("ward_id");
                jTextField1.setText(s);
                String s2 = r.getString("ward_name");
                jTextField2.setText(s2);
                String s3 = r.getString("doc_id");

                String s4 = r.getString("maxnop");
                jTextField4.setText(s4);
                String s5 = r.getString("curnop");
                jTextField5.setText(s5);

                ResultSet r1 = con.createStatement().executeQuery("select doc_name from doctor where doc_id='" + s3 + "'");
                String dname = null;
                boolean b1 = false;
                while (r1.next()) {
                    b1 = true;
                    dname = r1.getString("doc_name");
                    jComboBox1.setSelectedItem(dname);
                }

            }
            if (b) {
            } else {
                clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear() {

        jTextField1.setText("");
        jTextField2.setText("");

        jTextField4.setText("");
        jTextField5.setText("");

    }

    void WardList() {
        try {
            Connection con = DB.connect();
            Vector v = new Vector();

            ResultSet r = con.createStatement().executeQuery("select * from ward");
            while (r.next()) {
                String a = r.getString("ward_id");
                String b = r.getString("ward_name");
                String c = a + "-" + b;
                v.add(c);
                //System.out.println(a);
            }
            jList1.setListData(v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setWard() {

        try {
            Object b = jList1.getSelectedValue();
            String lst[] = b.toString().split("-");
            Connection con = DB.connect();

            ResultSet r = con.createStatement().executeQuery("select * from ward where ward_id='" + lst[0] + "'");
            while (r.next()) {
                String s = r.getString("ward_id");
                jTextField1.setText(s);
                String s2 = r.getString("ward_name");
                jTextField2.setText(s2);
                String s3 = r.getString("doc_id");

                String s4 = r.getString("maxnop");
                jTextField4.setText(s4);
                String s5 = r.getString("curnop");
                jTextField5.setText(s5);
                
                ResultSet r1 = con.createStatement().executeQuery("select doc_name from doctor where doc_id='" + s3 + "'");
                String dname = null;
                boolean b1 = false;
                while (r1.next()) {
                    b1 = true;
                    dname = r1.getString("doc_name");
                    jComboBox1.setSelectedItem(dname);
                    
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Ward Number");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 150, 30));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 16, 210, -1));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 52, 210, -1));

        jLabel2.setText("Ward Name ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, 140, 30));

        jLabel3.setText("Ward Doctor");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 103, -1, -1));
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 138, 210, -1));

        jLabel4.setText("Maximum No of Patients");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 141, -1, -1));

        jLabel5.setText("Current No of Patient");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 179, -1, -1));
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 176, 210, -1));

        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 210, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 480, 290));

        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 208, 380));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Add New Ward");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        jButton2.setText("Delete Ward");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 100, 30));

        jButton3.setText("Update Ward");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 100, 30));

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 100, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 480, 70));

        jLabel6.setText("Search Ward Number");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, 20));

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 160, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("WARD");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 160, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addWard();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        search();
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        delete();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        update();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        setWard();
    }//GEN-LAST:event_jList1ValueChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Ward.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ward.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ward.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ward.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ward().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
