package smartFuRS;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class SwaperComboItem extends BasicComboBoxRenderer{
	public Component getListCellRendererComponent(
            JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus)
        {
            super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

            if (value != null)
            {
                DormItem item = (DormItem)value;
                setText( item.getFname() +" "+ item.getLname() );
            }

            if (index == -1)
            {
            	DormItem item = (DormItem)value;
                setText( "" + item.getId() );
            }


            return this;
        }
}
