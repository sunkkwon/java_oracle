package jdbc;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class listEmp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	private Vector data, cols;
	private EmpDAO empDao;
	private DeptDAO deptDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listEmp frame = new listEmp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public listEmp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox cboDept = new JComboBox();
		cboDept.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					//getSelectedItem() 은 return type 이 object 이다. string 으로 변환필요
					String dname = cboDept.getSelectedItem().toString();
					DefaultTableModel model = new DefaultTableModel(empDao.listEmp(dname),cols);
					table.setModel(model);
				}
			}
		});
		cboDept.setBounds(10, 10, 263, 23);
		contentPane.add(cboDept);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 592, 378);
		contentPane.add(scrollPane);

		cols = new Vector();
		cols.add("사원번호");
		cols.add("사원이름");
		cols.add("직급");
		cols.add("입사일자");
		cols.add("급여");
		cols.add("소속부서");
		
		empDao = new EmpDAO();
		DefaultTableModel model = new DefaultTableModel(empDao.listEmp("%"),cols);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);

		JButton btnExit = new JButton("종료");
		btnExit.setBounds(500, 10, 102, 23);
		contentPane.add(btnExit);
		
		deptDao = new DeptDAO();
		ArrayList<DeptDTO> deptList = deptDao.listDept();
		cboDept.addItem("전체부서");
		for(DeptDTO dto : deptList) {
			cboDept.addItem(dto.getDname());
		}
	}
}
