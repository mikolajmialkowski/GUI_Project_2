import javax.print.DocFlavor;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class ModelTabeliPrzedmioty implements TableModel {
    ArrayList<Magazyn> lisaMagazynow;
    ArrayList<Przedmiot> lisaPrzedmiotow;
    ArrayList<Przedmiot> listaPrzedmiotowWMagazynach;
    ArrayList<Przedmiot> listaPrzedmiotowNIEwMagazynach;

    public ModelTabeliPrzedmioty(ArrayList<Magazyn> listaMagazynow, ArrayList<Przedmiot> listaPrzedmiotow) {


        this.lisaMagazynow = listaMagazynow;
        this.lisaPrzedmiotow = listaPrzedmiotow;

        listaPrzedmiotow.clear();

        for (Magazyn magazynTMP : listaMagazynow) {
            listaPrzedmiotow.addAll(magazynTMP.listaPrzedmiotow);
        }
    }

    @Override
    public int getRowCount() {
        return lisaPrzedmiotow.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Nazwa";
            case 1:
                return "Opis";
            case 2:
                return "Powierzchnia";
            case 3:
                return "ID";
        }
        return "null";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Double.class;
            case 3:
                return Integer.class;
        }
        return Object.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Przedmiot tmp = lisaPrzedmiotow.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getNazwa();
            case 1:
                return tmp.getOpis();
            case 2:
                return tmp.getPowierzchnia();
            case 3:
                return tmp.getID();

        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
