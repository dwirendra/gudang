/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gudang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Customer
 */
public class Obat extends javax.swing.JFrame {

    /**
     * Creates new form Obat
     */
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    PreparedStatement pst;
    public Obat()throws SQLException{
        initComponents();
        Koneksi DB = new Koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        kosongkanTabel();
        tampilkanDiTabel();
    }
    public void kosongkanTextField(){
        //copas isi tambahLain
        txtID.setText("");
        txtNama.setText("");
        txtHarga.setText("");
        txtStock.setText("");
    }public ArrayList[] getObatList() throws SQLException{      
        String queryCount = "SELECT COUNT(*) as c FROM obat";
        Statement st;
        ResultSet rsCount, rs;       
        st = con.createStatement();        
        rsCount = st.executeQuery(queryCount);
        int sizeTable=0;

        while(rsCount.next()){
            sizeTable = rsCount.getInt("c");
        }       
        ArrayList[] obatList = new ArrayList[sizeTable];       
        String query = "SELECT * FROM obat";
        rs = st.executeQuery(query);

       int x=0;
        while(rs.next()){
            obatList[x] = new ArrayList<>();
            obatList[x].add(rs.getString("ID"));
            obatList[x].add(rs.getString("Nama"));
            obatList[x].add(rs.getString("Harga"));
            obatList[x].add(rs.getString("Stock"));
            x++;
        }
        return obatList;
    }
    public void tampilkanDiTabel() throws SQLException{
        ArrayList[] list = getObatList();
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        
        Object[] row = new Object[4];
        for(int i= 0; i<list.length; i++){           
            row[0] = list[i].get(0);row[1] = list[i].get(1); 
            row[2] = list[i].get(2);row[3]=list[i].get(3);                                   
            model.addRow(row);
        }       
    }
    public void kosongkanTabel(){
        DefaultTableModel model = (DefaultTableModel)this.tabel.getModel();
        model.setRowCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new gudang.Background();
        Tambah = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        HapusBarang = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Kembali3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        UpdateBarang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-add-32.png"))); // NOI18N
        Tambah.setText("Tambah Barang");
        Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tambah Barang");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("List Barang(Obat-Obatan)");

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Barang", "Nama Barang", "Harga", "Stock"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("ID ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nama Barang");

        HapusBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-delete-32.png"))); // NOI18N
        HapusBarang.setText("Hapus Barang");
        HapusBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusBarangActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Stock");

        Kembali3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-back-to-32.png"))); // NOI18N
        Kembali3.setText("Kembali");
        Kembali3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Kembali3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Harga");

        UpdateBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-edit-32.png"))); // NOI18N
        UpdateBarang.setText("Update Barang");
        UpdateBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBarangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(Tambah)
                        .addGap(42, 42, 42)
                        .addComponent(UpdateBarang)
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Kembali3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(HapusBarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35))
            .addGroup(background1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                        .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(101, 101, 101))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(74, 74, 74))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(108, 108, 108)))
                        .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(background1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel2)
                        .addGap(132, 132, 132)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(background1Layout.createSequentialGroup()
                        .addComponent(HapusBarang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Kembali3)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateBarang)
                    .addComponent(Tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HapusBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusBarangActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        int row = tabel.getSelectedRow();
        String ID = tabel.getModel().getValueAt(row,0).toString();
        try{
            String query="DELETE FROM obat WHERE ID='"+ID+"'";
            pst=con.prepareStatement(query);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Data telah Terhapus!");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        try {
            kosongkanTabel();
            tampilkanDiTabel();
        } catch (SQLException ex) {
            
        }                     
    }//GEN-LAST:event_HapusBarangActionPerformed

    private void Kembali3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Kembali3ActionPerformed
        this.dispose();
        new gudang.KategoriBarang().setVisible(true);
    }//GEN-LAST:event_Kembali3ActionPerformed

    private void UpdateBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBarangActionPerformed
        try {
            String sql = "UPDATE obat SET ID='"+txtID.getText()+"',Nama='"+txtNama.getText()+"',Harga='"+txtHarga.getText()+"',Stock='"+txtStock.getText()+"'WHERE ID='"+txtID.getText()+"'";
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Barang berhasil diUpdate!");
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(UbahAdmin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Barang Gagal diUpdate");
            kosongkanTextField();
        }

        try {
            kosongkanTabel();
            tampilkanDiTabel();
            kosongkanTextField();
        } catch (SQLException ex) {
            Logger.getLogger(BahanMasakan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UpdateBarangActionPerformed

    private void TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahActionPerformed
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO obat(ID,Nama,Harga,Stock)"+ "values(?,?,?,?) ");
            ps.setString(1,txtID.getText());
            ps.setString(2,txtNama.getText());
            ps.setString(3,txtHarga.getText());
            ps.setString(4,txtStock.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data tersimpan!");
            kosongkanTextField();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data gagal tersimpan! (Cek kembali ID barang!)");
            kosongkanTextField();
        }
        try {
            kosongkanTabel();
            tampilkanDiTabel();
        } catch (SQLException ex) {
            //java.util.logging.Logger.getLogger(BahanMasakan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TambahActionPerformed

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
            java.util.logging.Logger.getLogger(Obat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Obat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Obat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Obat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Obat().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Obat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HapusBarang;
    private javax.swing.JButton Kembali3;
    private javax.swing.JButton Tambah;
    private javax.swing.JButton UpdateBarang;
    private gudang.Background background1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}