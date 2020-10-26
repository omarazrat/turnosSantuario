/*
 *  Turnos Santuario
 *  Asignador de turnos para estudiantes.
 *  Este programa fue dise�ado para la Santa Iglesia Gn�stica Universal, por Nestor Arias -nestor_arias@hotmail.com
 */
package oa.gnosis.turnossantuario.ui;

import java.util.Arrays;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import oa.gnosis.turnossantuario.Main;
import oa.gnosis.turnossantuario.spring.model.Persona;
import oa.gnosis.turnossantuario.spring.repositories.PersonaRepository;
import oa.gnosis.turnossantuario.utils.RBHelper;

/**
 * RF1 CRUD Personas CA1: Se requiere tener una lista con todos los asistentes a
 * reuniones, poder agregar y eliminar personas. CA2: Cuando se abra cualquier
 * persona debe poder verse sus nombre, apellidos y tel�fono.
 *
 * @author nesto
 */
public class CRUDPersona extends javax.swing.JFrame {

    private PersonaRepository repository = Main.getPersonaRepository();
    private RBHelper rb = new RBHelper("RF1.");

    /**
     * Creates new form Personas
     */
    public CRUDPersona() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        personsTblSP = new javax.swing.JScrollPane();
        personsTbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        personsTblSP.setMinimumSize(new java.awt.Dimension(400, 200));

        personsTbl.setModel(getModel());
        personsTblSP.setViewportView(personsTbl);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(personsTblSP, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private TableModel getModel() {
        Vector<String> columnNames = new Vector<>(
                Arrays.asList(
                        rb.getString("person.nombres"),
                        rb.getString("person.apellidos"),
                        rb.getString("person.telefono")
                ));
        Vector<Vector<String>> data = new Vector<>();
        for(Persona persona:repository.findAll()){
            Vector<String> record = new Vector<>();
            record.add(persona.getNombres());
            record.add(persona.getApellidos());
            record.add(persona.getTelefono());
            data.add(record);
        }

        TableModel persontblModel = new DefaultTableModel(data, columnNames);
        return persontblModel;
    }

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
            java.util.logging.Logger.getLogger(CRUDPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDPersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable personsTbl;
    private javax.swing.JScrollPane personsTblSP;
    // End of variables declaration//GEN-END:variables
}
