
package abarrotes;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Tienda extends javax.swing.JFrame {
String productos[]={"Maruchan","Cigarros","Cafe","galletas"};
double precios[]={25.00,75.00,20.00,16.00};

double precio=0;
int cantidad=0;
double subtotal=0; 
double co=0;
double iva=0; 
double total=0; 

DefaultComboBoxModel combomodel = new DefaultComboBoxModel(productos);
DefaultTableModel tableModel = new DefaultTableModel();

   ArrayList<ventas> listaventas = new ArrayList<ventas>();
   
    public Tienda() {
        initComponents();
        cboproductos.setModel(combomodel);
        this.setLocationRelativeTo(null);
        this.setTitle("Abarrotes Rosa");
        
        tableModel.addColumn("Descripcion");
        tableModel.addColumn("Precio U");
        tableModel.addColumn("Cantidad");
        tableModel.addColumn("Importe");
        
        actualizar();
        calcularprecios();
    }
    
     public void actualizar(){
     tblproductos.setModel(tableModel);
     
     while(tableModel.getRowCount()>0){
         tableModel.removeRow(0);
     }
     for(ventas v: listaventas){
         
         Object x[]=new Object[4];
         x[0]=v.getDescripcion();
         x[1]=v.getPrecio();
         x[2]=v.getCantidad();
         x[3]=v.getImporte();
         
         tableModel.addRow(x);
         
     }
        
    }
   
    public void calcularprecios(){
        precio = precios[cboproductos.getSelectedIndex()];
        
        cantidad = Integer.parseInt(spncantidad.getValue().toString());
        
        lblprecio.setText(String.valueOf(precio));
        lblimporte.setText(String.valueOf(precio * cantidad));
        
        
        
    }
     public boolean buscarVenta(ventas nueva) {
    for (ventas v : listaventas) {
        if (v.getId() == nueva.getId()) {
            int nuevaCantidad=v.getCantidad()+nueva.getCantidad();
            v.setCantidad(nuevaCantidad);
            v.setImporte(v.getPrecio()*nuevaCantidad);
            return true; 
        }
    }
    return false; 
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboproductos = new javax.swing.JComboBox<>();
        spncantidad = new javax.swing.JSpinner();
        lblprecio = new javax.swing.JLabel();
        lblimporte = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblproductos = new javax.swing.JTable();
        btnagregar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblsubtotal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblIVA = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Producto");

        jLabel2.setText("Cantidad");

        cboproductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboproductosActionPerformed(evt);
            }
        });

        spncantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        spncantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spncantidadStateChanged(evt);
            }
        });

        lblprecio.setText("0.0 mxn");

        lblimporte.setText("0.0 mxn");

        jLabel5.setText("Costo");

        jLabel6.setText("Subtotal");

        tblproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblproductos);

        btnagregar.setText("+");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        jLabel7.setText("Subtotal");

        lblsubtotal.setText("0.0 mxn");

        jLabel9.setText("IVA");

        lblIVA.setText("0.0 mxn");

        jLabel11.setText("Total");

        lbltotal.setText("0.0 mxn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(spncantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(lblimporte))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(lblprecio)))
                        .addGap(215, 215, 215))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cboproductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(161, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnagregar)
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(47, 47, 47))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(418, 418, 418)
                                .addComponent(jLabel11)
                                .addGap(41, 41, 41)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltotal)
                            .addComponent(lblsubtotal)
                            .addComponent(lblIVA))
                        .addGap(52, 52, 52))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboproductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprecio)
                    .addComponent(jLabel5))
                .addGap(2, 2, 2)
                .addComponent(btnagregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spncantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblimporte)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblsubtotal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblIVA))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbltotal))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
         co+=precio*cantidad;
         lblsubtotal.setText(String.valueOf(co)+" mxn");
         iva =co*0.16;
         lblIVA.setText(String.valueOf(iva)+" mxn");
         total=co+iva;
         lbltotal.setText(String.valueOf(total)+" mxn");
         
        ventas ventas = new ventas();
        
        ventas.setId(cboproductos.getSelectedIndex());
        ventas.setDescripcion(cboproductos.getSelectedItem().toString());
        ventas.setPrecio(precio);
        ventas.setCantidad(cantidad);
        ventas.setImporte(precio*cantidad);
        if (!buscarVenta(ventas)){
       listaventas.add(ventas);   
           
       }
        
        actualizar();
        
     
    }//GEN-LAST:event_btnagregarActionPerformed

    private void cboproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboproductosActionPerformed
        // TODO add your handling code here:
        calcularprecios();
        
    }//GEN-LAST:event_cboproductosActionPerformed

    private void spncantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spncantidadStateChanged
        // TODO add your handling code here:
        calcularprecios();
    }//GEN-LAST:event_spncantidadStateChanged

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
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tienda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JComboBox<String> cboproductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblimporte;
    private javax.swing.JLabel lblprecio;
    private javax.swing.JLabel lblsubtotal;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JSpinner spncantidad;
    private javax.swing.JTable tblproductos;
    // End of variables declaration//GEN-END:variables
}
