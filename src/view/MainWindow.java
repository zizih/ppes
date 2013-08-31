package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created with IntelliJ IDEA. User: rain Date: 3/22/13 Time: 10:39 AM To change
 * this template use File | Settings | File Templates.
 */
public class MainWindow extends JFrame {

	Box baseBox, catogoryBox, indexBox, normBox;
	JDesktopPane desktopPane;
	RecordWindow recordWindow;
	ShowWindow showWindow;
	String[] catoArr = new String[] { "A", "B", "C" };
	String[] indexArr = new String[] { "one index", "two index" };
	String[] normArr = new String[] { "想念父亲", "PPP", "WWW" };

	public MainWindow(String s) {
		setTitle(s);
		setLocation(120, 120);
		setBackground(Color.GRAY);

		add(getMenu(), BorderLayout.NORTH);

		validate();
		setVisible(true);
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		desktopPane = new JDesktopPane();
		desktopPane.setDesktopManager(new DefaultDesktopManager());
		add(desktopPane, BorderLayout.CENTER);

		recordWindow = new RecordWindow("Record Window");
		showWindow = new ShowWindow("Show Window");
	}

	private JPanel getMenu() {
		JPanel panel = new JPanel();
		panel.add(getEventButton("Exit", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// To change body of implemented methods use File | Settings |
				// File Templates.
				System.exit(0);
			}
		}));
		panel.add(getEventButton("Restart", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// To change body of implemented methods use File | Settings |
				// File Templates.
				System.exit(0);
			}
		}));
		panel.add(getEventButton("Add", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				desktopPane.remove(showWindow);
				desktopPane.add(recordWindow,BorderLayout.CENTER);
			}
		}));
		panel.add(getEventButton("Show", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				desktopPane.remove(recordWindow);
				desktopPane.add(showWindow,BorderLayout.CENTER);
			}
		}));
		return panel;
	}

	private JButton getJButton(String value) {
		JButton button = new JButton(value);
		return button;
	}

	private JButton getEventButton(String value, ActionListener listener) {
		JButton button = new JButton(value);
		button.addActionListener(listener);
		return button;
	}

}
