package socadastroevendatambem.utils;

import java.awt.Component;
import java.io.EOFException;

import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

import socadastroevendatambem.model.Movimento;


//Essa Classe interna serve para Dizer quando a celula foi alterada e o seu respectivo valor  
  public class EditarCelulaTabela extends AbstractCellEditor implements TableCellEditor {  
         // Este � o componente que vai segurar o valor da edicao da celula  
         JComponent component = new JTextField();  

         
         //Este metodo � chamado quando a celula � editada pelo usuario.    
        public Component getTableCellEditorComponent(JTable table, Object value,  
                boolean isSelected, int rowIndex, int vColIndex) {  
            //'value'� o valor contido na celula que esta na localizacao ((rowIndex, vColIndex)  
               
            if (isSelected)  
            {  
                // Celula (e talvez outras celulas) sao selecionadas  
            }  
            // Configura o componente com o valor Especificado  

            ((JTextField)component).setText( (String) value);  

            ((JTextField)component).setText((String) value);  

      
            // Retorna a configuracao do componente  
            return component;  
        }  
      
      
        // Esse metodo � chamado quando � Terminado de Editar a Celula  
        // Ela retorna o novo valor da Celula.  
        public Object getCellEditorValue() {  
          
             //Chama a funcao insert update da Tabela1 e passa o valor do da celula  
              
             // Imprime o conteudo que o usuario digitou na Celula  
             System.out.println(((JTextField)component).getText());      
            
//             FrmMovimento(((JTextField)component).getText());
             
//             AlteraAssociado(((JTextField)component).getText());                
             //System.out.println(((JTextField)component).getText());                 
          
            return ((JTextField)component).getText();  
        }
         
         
     }   

