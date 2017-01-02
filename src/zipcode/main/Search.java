package zipcode.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import zipcode.dao.zipcodeDao;
import zipcode.dto.zipcodeDto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<zipcodeDto> list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	public Search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblsido = new JLabel("시도");
		lblsido.setBounds(18, 16, 40, 16);
		contentPane.add(lblsido);
		
	//	JComboBox<zipcodeDto> cbsido = new JComboBox<>();
		JComboBox<zipcodeDto> cbsido = new JComboBox<>();
		
				List<zipcodeDto> list = zipcodeDao.getInstance().selectsido();
				for (zipcodeDto zipdto : list) {
					cbsido.addItem(zipdto);
				}
			
		cbsido.setBounds(43, 12, 127, 27);
		contentPane.add(cbsido);
		
		JLabel lbldoro = new JLabel("도로명");
		lbldoro.setBounds(183, 16, 54, 16);
		contentPane.add(lbldoro);
		
		JComboBox<zipcodeDto> cbdoro = new JComboBox<>();

		
		cbsido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<zipcodeDto> list = zipcodeDao.getInstance().selectdoro();
			 JOptionPane.showConfirmDialog(null, list.get(cbsido.getSelectedIndex()).getDoro());
				//cbdoro.addItem(list.get(cbsido.getSelectedIndex()).getDoro());
			}
		});
		
		cbdoro.setBounds(226, 12, 169, 27);
		contentPane.add(cbdoro);
	
		JButton lblsearch = new JButton("검색");
		lblsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		lblsearch.setBounds(390, 11, 54, 29);
		contentPane.add(lblsearch);
		
		table = new JTable();
		table.setBounds(28, 51, 396, 210);
		contentPane.add(table);
	}
}
