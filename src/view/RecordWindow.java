package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.CatogoryDao;
import dao.DbHelper;
import dao.IndexDao;
import dao.NormDao;
import dao.WeightDao;
import dao.model.Catogory;
import dao.model.Index;
import dao.model.Norm;
import dao.model.Weight;

public class RecordWindow extends JInternalFrame {

	Map<JButton, ActionListener> buttonListenerList;
	Box baseBox,weightBox,normBox,indexBox,catogoryBox;
	String weightAction = "添加权重";
	String normAction = "添加指标类别";
	String indexAction = "添加指标级别";
	String catogoryAction = "添加指标体系";
	String weightPrompt = "权重";
	String normPrompt = "指标类别";
	String indexPrompt = "指标级别";
	String catogoryPrompt = "指标体系";
	JTextField weightTextField;
	JTextField normTextFied;
	JTextField indexTextFied;
	JTextField catogoryTextFied;

	public RecordWindow(String s) {
		setTitle(s);
		setBackground(Color.GRAY);

		add(getMenu(), BorderLayout.NORTH);
		add(getContentBox(), BorderLayout.CENTER);

		validate();
		setVisible(true);
		setBounds(100, 100, 480, 320);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		buttonListenerList = new HashMap<JButton, ActionListener>();
	}

	private Box getContentBox() {
		weightTextField = new JTextField(10);
		normTextFied = new JTextField(10);
		indexTextFied = new JTextField(10);
		catogoryTextFied = new JTextField(10);

		JButton weightButton = new JButton(weightAction);
		JButton normButton = new JButton(normAction);
		JButton indexButton = new JButton(indexAction);
		JButton catogoryButton = new JButton(catogoryAction);

		MyListener myListener = new MyListener();
		weightButton.addActionListener(myListener);
		normButton.addActionListener(myListener);
		indexButton.addActionListener(myListener);
		catogoryButton.addActionListener(myListener);
		
		weightBox = Box.createHorizontalBox();
		weightBox.add(getJComboBox(new String[]{"A","B"},weightPrompt));
		weightBox.add(weightTextField);
		weightBox.add(weightButton);
		
		normBox = Box.createHorizontalBox();
        normBox.add(getJComboBox(new String[]{"A","B"},normPrompt));
        normBox.add(normTextFied);
        normBox.add(normButton);

        indexBox = Box.createHorizontalBox();
        indexBox.add(getJComboBox(new String[]{"A","B"},indexPrompt));
        indexBox.add(indexTextFied);
        indexBox.add(indexButton);


        catogoryBox = Box.createHorizontalBox();
        catogoryBox.add(getJComboBox(new String[]{"A","B"},catogoryPrompt));
        catogoryBox.add(catogoryTextFied);
        catogoryBox.add(catogoryButton);

        baseBox = Box.createVerticalBox();
        baseBox.add(catogoryBox);
        baseBox.add(indexBox);
        baseBox.add(normBox);
        baseBox.add(weightBox);
        return baseBox;
	}

	private JPanel getMenu() {
		JPanel panel = new JPanel();
		panel.add(getEventButton("返回", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// To change body of implemented methods use File | Settings |
				// File Templates.
			}
		}));
		return panel;
	}

	private JButton getEventButton(String value, ActionListener listener) {
		JButton button = new JButton(value);
		button.addActionListener(listener);
		return button;
	}
	
	private JComboBox getJComboBox(Object[] items,String prompt){
        final JComboBox list = new JComboBox(items);
        list.setBorder(BorderFactory.createTitledBorder(prompt));
        return list;
    }

	private Map<JButton, ActionListener> setListener(JButton button,
			ActionListener listener) {
		buttonListenerList.put(button, listener);
		return buttonListenerList;
	}

	class MyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals(weightAction)){
				WeightDao weightDao = new WeightDao();
				Weight weight = new Weight();
				weight.setWeight(weight.getWeight());
			}
			if (e.getActionCommand().equals(normAction)) {
				NormDao normDao = NormDao.getInstance();
				Norm norm = new Norm();
				norm.setName(normTextFied.getText().toString());
				normDao.insert(norm);
			}
			if (e.getActionCommand().equals(indexAction)) {
				IndexDao indexDao = IndexDao.getInstance();
				Index index = new Index();
				index.setName(indexTextFied.getText().toString());
				indexDao.insert(index);
			}
			if (e.getActionCommand().equals(catogoryAction)) {
				CatogoryDao catogoryDao = CatogoryDao.getInstance();
				Catogory catogory = new Catogory();
				catogory.setName(catogoryTextFied.getText().toString());
				catogoryDao.insert(catogory);
			}
		}

	}

}
