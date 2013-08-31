package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

/**
 * @Title ������
 * @Distription ����������,�����˵�����ť��״̬���Լ������� 
 */
public class App extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JToolBar jToolBar;
	private JButton btnExit;
	private JMenuBar jMenuBar;
	private JMenu jMenuProject,jMenuEvaluation,jMenuConfig;
	private JMenuItem itemExit;
	private JPanel jContentPane, jToolBarPane, jMainPane, jStatusPane;
	private JScrollPane jDataListPane;
	private JLabel jLabel;

	// ���ڳ�ʼ��
	public App() {
		this.setBounds(300, 300, 500, 500);
		this.setJMenuBar(getJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("�Ƽ���Ŀ��Ч����ϵͳ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	// �˵�
	public JMenuBar getJMenuBar() {
		jMenuBar = new JMenuBar();
		jMenuProject = new JMenu();
		jMenuProject.setText("��Ŀ��Ϣ");
		jMenuEvaluation = new JMenu();
		jMenuEvaluation.setText("��Ч����");
		jMenuConfig = new JMenu();
		jMenuConfig.setText("ϵͳ����");
		itemExit = new JMenuItem();
		itemExit.setText("�˳�");
		itemExit.addActionListener(this);
		jMenuProject.add(itemExit);
		jMenuBar.add(jMenuProject);
		jMenuBar.add(jMenuEvaluation);
		jMenuBar.add(jMenuConfig);
		return jMenuBar;
	}

	// ����������
	public JPanel getJContentPane() {
		jContentPane = new JPanel();
		jContentPane.setLayout(new BorderLayout());
		jContentPane.add(getJToolBarPane(), BorderLayout.NORTH); // ���ع���������
		jContentPane.add(getJMainPane(), BorderLayout.CENTER); // ������������
		jContentPane.add(getJStatusPane(), BorderLayout.SOUTH); // ����״̬������
		return jContentPane;
	}

	// ����������
	public JPanel getJToolBarPane() {
		if (jToolBarPane == null) {
			jToolBarPane = new JPanel();
		}
		jToolBar = new JToolBar();
		btnExit = new JButton("�˳�");
		btnExit.addActionListener(this);
		jToolBar.add(btnExit);
		jToolBarPane.add(jToolBar);
		return jToolBarPane;
	}

	// ��������
	public JPanel getJMainPane() {
		jMainPane = new JPanel();
		jMainPane.setLayout(new BorderLayout());
		jMainPane.add(getJDataListPane(), BorderLayout.CENTER);
		return jMainPane;
	}

	// ����б�������������ݿ⿪�����������б�
	public JScrollPane getJDataListPane() {
		if (jDataListPane == null) {
			jDataListPane = new JScrollPane();
		}
		jDataListPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jDataListPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		return jDataListPane;
	}

	// ״̬��
	public JPanel getJStatusPane() {
		if (jStatusPane == null) {
			jStatusPane = new JPanel();
		}
		jLabel = new JLabel();
		jLabel.setText("״̬��");
		jStatusPane.add(jLabel);
		return jStatusPane;
	}

	// �˵��¼�����
	public void actionPerformed(ActionEvent e) {

	}

	// ���¼���������
	public void refresh() {
		jMainPane.removeAll();

		this.validate();
	}

	public static void main(String[] args) {
		new App();
	}
}
