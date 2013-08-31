package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.CatogoryDao;

public class ShowWindow extends JInternalFrame{

	Box baseBox,catogoryBox,indexBox,normBox;
	String normPrompt = "指标类别";
	String indexPrompt = "指标级别";
	String catogoryPrompt = "指标体系";


    public ShowWindow(String s){
        setTitle(s);
        setBackground(Color.GRAY);

        add(getMenu(),BorderLayout.NORTH);
        add(getContentBox(),BorderLayout.CENTER);

        validate();
        setVisible(true);
        setBounds(100,100,480,320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private StringBuffer[] getCatogoryArr(){
    	
    	CatogoryDao catogoryDao = CatogoryDao.getInstance();
    	StringBuffer[] catogoryArr = new StringBuffer[]{};
    	return catogoryArr;
    }
    

    private Box getContentBox(){
        normBox = Box.createHorizontalBox();
        normBox.add(getJComboBox(new String[]{"A","B"},normPrompt));

        indexBox = Box.createHorizontalBox();
        indexBox.add(getJComboBox(new String[]{"A","B"},indexPrompt));


        catogoryBox = Box.createHorizontalBox();
        catogoryBox.add(getJComboBox(new String[]{"A","B"},catogoryPrompt));

        baseBox = Box.createVerticalBox();
        baseBox.add(catogoryBox);
        baseBox.add(indexBox);
        baseBox.add(normBox);
        return baseBox;
    }

    private JPanel getMenu(){
        JPanel panel = new JPanel();
        panel.add(new JTextField(20));
        panel.add(getEventButton("获取", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
                
            }
        }));
        return panel;
    }


    private JButton getJButton(String value){
        JButton button = new JButton(value);
        return button;
    }

    private JButton getEventButton(String value,ActionListener listener){
        JButton button = new JButton(value);
        button.addActionListener(listener);
        return button;
    }
    
    private JComboBox getJComboBox(Object[] items,String prompt){
        final JComboBox list = new JComboBox(items);
        list.setBorder(BorderFactory.createTitledBorder(prompt));
        return list;
    }
	
}
