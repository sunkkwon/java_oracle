package jdbc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditScore extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfMat;
	private JTextField tfEng;
	private JTextField tfKor;
	private JTextField tfName;
	private JTextField tfStudent_no;

	/**
	 * Create the frame.
	 */
	public EditScore(ScoreMain parent, ScoreDTO dto) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 248, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("학번");
		lbl1.setBounds(20, 13, 50, 15);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("이름");
		lbl2.setBounds(20, 38, 50, 15);
		contentPane.add(lbl2);
		
		JLabel lbl3 = new JLabel("국어");
		lbl3.setBounds(20, 63, 50, 15);
		contentPane.add(lbl3);
		
		JLabel lbl4 = new JLabel("영어");
		lbl4.setBounds(20, 88, 50, 15);
		contentPane.add(lbl4);
		
		JLabel lbl5 = new JLabel("수학");
		lbl5.setBounds(20, 113, 50, 15);
		contentPane.add(lbl5);
		
		tfMat = new JTextField();
		tfMat.setColumns(10);
		tfMat.setBounds(80, 110, 124, 21);
		contentPane.add(tfMat);
		
		tfEng = new JTextField();
		tfEng.setColumns(10);
		tfEng.setBounds(80, 85, 124, 21);
		contentPane.add(tfEng);
		
		tfKor = new JTextField();
		tfKor.setColumns(10);
		tfKor.setBounds(80, 60, 124, 21);
		contentPane.add(tfKor);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(80, 35, 124, 21);
		contentPane.add(tfName);
		
		tfStudent_no = new JTextField();
		tfStudent_no.setColumns(10);
		tfStudent_no.setBounds(80, 10, 124, 21);
		contentPane.add(tfStudent_no);
		
		tfStudent_no.setText(dto.getStudent_no());
		tfName.setText(dto.getName());
//		tfKor.setText(dto.getKor()+"");	//
		tfKor.setText(String.valueOf(dto.getKor()));
		tfEng.setText(Integer.toString(dto.getEng()));
		tfMat.setText(String.valueOf(dto.getMat()));
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreDAO dao = new ScoreDAO();
				String student_no = tfStudent_no.getText();
				String name = tfName.getText();
				int kor = Integer.valueOf(tfKor.getText());
				int eng = Integer.valueOf(tfEng.getText());
				int mat = Integer.valueOf(tfMat.getText());
				
				dao.updateScore(new ScoreDTO(student_no,name,kor,eng,mat));
				JOptionPane.showMessageDialog(EditScore.this, "수정 되었습니다");
				parent.refreshTable();
				dispose();
			}
		});
		btnUpdate.setBounds(10, 154, 70, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDel = new JButton("삭제");
		btnDel.setBounds(80, 154, 70, 23);
		contentPane.add(btnDel);
		
		JButton btnExit = new JButton("종료");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	// 현재창 종료
			}
		});
		btnExit.setBounds(173, 154, 63, 23);
		contentPane.add(btnExit);
	}

}
