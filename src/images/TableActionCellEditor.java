/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package images;

import java.awt.Checkbox;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author User1
 */
public class TableActionCellEditor extends DefaultCellEditor{
    
    private TableActionEvent event;
    public TableActionCellEditor(TableActionEvent event) {
        super(new JCheckBox()); 
        this.event = event;
    }
    
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAccion accion = new PanelAccion();
        accion.initEvent(event, row);
        accion.setBackground(table.getSelectionBackground());
        return accion;
    }
    
}
