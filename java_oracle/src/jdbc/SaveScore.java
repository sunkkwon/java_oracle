package jdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SaveScore extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfMat;
	private JTextField tfEng;
	private JTextField tfKor;
	private JTextField tfName;
	private JTextField tfStudentNo;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SaveScore frame = new SaveScore();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public SaveScore(ScoreMain parent) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// DISPOSE_ON_CLOSE : 현재 화면만 닫음
		setBounds(100, 100, 216, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl1 = new JLabel("학번");
		lbl1.setBounds(10, 29, 50, 15);
		contentPane.add(lbl1);

		JLabel lbl2 = new JLabel("이름");
		lbl2.setBounds(10, 54, 50, 15);
		contentPane.add(lbl2);

		JLabel lbl3 = new JLabel("국어");
		lbl3.setBounds(10, 79, 50, 15);
		contentPane.add(lbl3);

		JLabel lbl4 = new JLabel("영어");
		lbl4.setBounds(10, 104, 50, 15);
		contentPane.add(lbl4);

		JLabel lbl5 = new JLabel("수학");
		lbl5.setBounds(10, 129, 50, 15);
		contentPane.add(lbl5);

		tfMat = new JTextField();
		tfMat.setBounds(70, 126, 124, 21);
		contentPane.add(tfMat);
		tfMat.setColumns(10);

		tfEng = new JTextField();
		tfEng.setBounds(70, 101, 124, 21);
		contentPane.add(tfEng);
		tfEng.setColumns(10);

		tfKor = new JTextField();
		tfKor.setBounds(70, 76, 124, 21);
		contentPane.add(tfKor);
		tfKor.setColumns(10);

		tfName = new JTextField();
		tfName.setBounds(70, 51, 124, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);

		tfStudentNo = new JTextField();
		tfStudentNo.setBounds(70, 26, 124, 21);
		contentPane.add(tfStudentNo);
		tfStudentNo.setColumns(10);

		JButton btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreDAO dao = new ScoreDAO();
				String student_no = tfStudentNo.getText();
				String name = tfName.getText();
				int kor = Integer.valueOf(tfKor.getText());
				int eng = Integer.valueOf(tfEng.getText());
				int mat = Integer.valueOf(tfMat.getText());

				dao.insertScore(new ScoreDTO(student_no, name, kor, eng, mat));
				JOptionPane.showMessageDialog(SaveScore.this, "추가 되었습니다.");
				parent.refreshTable();
				dispose();	// 현재창 종료
			}
		});
		btnSave.setBounds(70, 168, 93, 23);
		contentPane.add(btnSave);
	}
}
