package br.univel.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import br.univel.pojo.Cliente;


public class ModeloClientes extends AbstractTableModel implements TableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Cliente> listaClientes;
	private Object[][] matriz;
	private int linhas;
	
	public ModeloClientes(List<Cliente> lista) {
		this.listaClientes = lista;
	}

	public int getColumnCount() {
		return 5;
	}

	public int getRowCount() {
		return listaClientes.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cliente c = listaClientes.get(rowIndex);
		switch (columnIndex) {  
        case 0:  
            return c.getId();  
        case 1:  
            return c.getNome();
        case 2:
        	return c.getSobrenome();
        case 3:
        	return c.getIdade();
        case 4:
        	return c.getSexo();
        }  
        return null;  
	}
	
	 @Override
	 public String getColumnName (int col) {
        switch (col) {
        case 0:
            return "Id";
        case 1:
            return "Nome";
        case 2:
        	return "Sobrenome";
        case 3:
        	return "Idade";
        case 4:
        	return "Sexo";
        default:
            return "Erro";
        }
    }

	public void refresh(List<Cliente> list){
		this.listaClientes = list;
		super.fireTableDataChanged();
	}
	
}
