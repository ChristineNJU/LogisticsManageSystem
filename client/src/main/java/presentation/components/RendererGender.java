package presentation.components;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
   
public class RendererGender extends FlatComboBox implements TableCellRenderer{  
         private static final long serialVersionUID = -8624401777277852691L;  
         public RendererGender(){  
                   super();  
                   addItem("男");  
                   addItem("女");  
         }  
         public Component getTableCellRendererComponent(JTable table, Object value,  
                            boolean isSelected, boolean hasFocus, int row, int column) {  
                   if(isSelected){  
                            setForeground(table.getForeground());  
                            super.setBackground(table.getBackground());  
                   }else{  
                            setForeground(table.getForeground());  
                            setBackground(table.getBackground());  
                   }  
                   String isMale = value.toString(); 
//                   System.out.println(isMale.equals("女"));
                   setSelectedIndex(isMale.equals("女")? 1 : 0);  
//                   System.out.println(getSelectedIndex());
                   return this;  
         }  
   
} 
