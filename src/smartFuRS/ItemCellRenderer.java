package smartFuRS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class ItemCellRenderer extends JPanel implements ListCellRenderer<DormItem>{

    private static final Border SAFE_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
    private static final Border DEFAULT_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
    protected static Border noFocusBorder = DEFAULT_NO_FOCUS_BORDER;

    JLabel fname = new JLabel("");
    JLabel lname = new JLabel("");
    JLabel gender = new JLabel("");
    JLabel age = new JLabel("");

    public ItemCellRenderer() {
        setLayout(new GridBagLayout());
        //first name and lastname
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.gridx = 0;
        c1.gridy = 0;
        add(fname,c1);
        
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.weightx = 0.5;
        c2.gridx = 1;
        c2.gridy = 0;
        add(lname,c2);
        
        add(age);
        add(gender);
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(100, 20);
    }

    @Override
    public Dimension getPreferredSize() {
        return getMinimumSize();
    }


protected Border getNoFocusBorder() {
    Border border = UIManager.getBorder("List.cellNoFocusBorder");
    if (System.getSecurityManager() != null) {
        if (border != null) return border;
        return SAFE_NO_FOCUS_BORDER;
    } else {
        if (border != null &&
                (noFocusBorder == null ||
                noFocusBorder == DEFAULT_NO_FOCUS_BORDER)) {
            return border;
        }
        return noFocusBorder;
    }
}

    @Override
    public Component getListCellRendererComponent(JList<? extends DormItem> list, DormItem value, int index, boolean isSelected, boolean cellHasFocus) {
        setComponentOrientation(list.getComponentOrientation());

        Color bg = null;
        Color fg = null;

        JList.DropLocation dropLocation = list.getDropLocation();
        if (dropLocation != null
                        && !dropLocation.isInsert()
                        && dropLocation.getIndex() == index) {

            bg = UIManager.getColor("List.dropCellBackground");
            fg = UIManager.getColor("List.dropCellForeground");

            isSelected = true;
        }

        if (isSelected) {
            setBackground(bg == null ? list.getSelectionBackground() : bg);
            setForeground(fg == null ? list.getSelectionForeground() : fg);
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        fname.setText(value.getFname()+"  ");
        lname.setText(value.getLname());
        gender.setText(value.getGender());
        age.setText(value.getAge()+" ");

        fname.setForeground(getForeground());
        lname.setForeground(getForeground());
        gender.setForeground(getForeground());
        age.setForeground(getForeground());

        setEnabled(list.isEnabled());

        fname.setFont(list.getFont());
        lname.setFont(list.getFont());
        gender.setFont(list.getFont());
        age.setFont(list.getFont());

        Border border = null;
        if (cellHasFocus) {
            if (isSelected) {
                border = UIManager.getBorder("List.focusSelectedCellHighlightBorder");
            }
            if (border == null) {
                border = UIManager.getBorder("List.focusCellHighlightBorder");
            }
        } else {
            border = getNoFocusBorder();
        }
        setBorder(border);

        return this;
    }
}
