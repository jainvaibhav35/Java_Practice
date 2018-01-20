package com.signer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class SwingUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame main_frame;
	JLabel welcome_label, select_src_label, select_destination_label, select_psx_label, select_password_label,
			processing_label;
	JButton browse_src_button, convert_button, browse_dest_button, browse_pfx_button;
	JTextField source_file_path_textField, destination_file_path_textField, pfx_file_path_textField,
			password_file_path_textField;
	JFileChooser choose_src_file, choose_dest_file, choose_pfx_file;
	String selected_src_file_path = null, selected_dest_file_path = null, selected_pfx_file_path = null;
	File list_of_files;
	ArrayList<File> file_list;
	int no_of_files = 0;
	String movie_name;
	Image img;

	IGetFilePath filePath;

	SwingUI(IGetFilePath filePath) {
		this.filePath = filePath;
	}

	SwingUI() {
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == browse_src_button) {

			source_file_path_textField.setText("");

			choose_src_file = new JFileChooser("Select File or Directory");
			choose_src_file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			choose_src_file.showDialog(SwingUI.this, "Select");
			selected_src_file_path = choose_src_file.getSelectedFile().getPath();
			source_file_path_textField.setText(selected_src_file_path);

			File srcFile = new File(selected_src_file_path);

			if (!srcFile.exists()) {
				JOptionPane.showMessageDialog(main_frame, "Folder not exist");
				source_file_path_textField.setText("");
			}
			if (!srcFile.isDirectory()) {
				JOptionPane.showMessageDialog(main_frame, "Please select a folder");
				source_file_path_textField.setText("");
			}
		}
		if (e.getSource() == browse_dest_button) {

			destination_file_path_textField.setText("");

			choose_dest_file = new JFileChooser("Select File or Directory");
			choose_dest_file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			choose_dest_file.showDialog(SwingUI.this, "Select");
			selected_dest_file_path = choose_dest_file.getSelectedFile().getPath();
			destination_file_path_textField.setText(selected_dest_file_path);

			File destFile = new File(selected_dest_file_path);

			if (!destFile.exists()) {
				JOptionPane.showMessageDialog(main_frame, "Folder not exist");
				destination_file_path_textField.setText("");
			}
			if (!destFile.isDirectory()) {
				JOptionPane.showMessageDialog(main_frame, "Please select a folder");
				destination_file_path_textField.setText("");
			}
		}
		if (e.getSource() == browse_pfx_button) {

			pfx_file_path_textField.setText("");

			choose_pfx_file = new JFileChooser("Select File or Directory");
			choose_pfx_file.setFileSelectionMode(JFileChooser.FILES_ONLY);
			choose_pfx_file.showDialog(SwingUI.this, "Select");
			selected_pfx_file_path = choose_pfx_file.getSelectedFile().getPath();
			pfx_file_path_textField.setText(selected_pfx_file_path);

			String extension = selected_pfx_file_path.substring(selected_pfx_file_path.lastIndexOf(".") + 1);
			if (!extension.equalsIgnoreCase("pfx")) {
				JOptionPane.showMessageDialog(main_frame, "Please choose pfx file only.");
				pfx_file_path_textField.setText("");
			}
		}

		if (e.getSource() == convert_button) {

			selected_src_file_path = source_file_path_textField.getText();
			
			if (selected_src_file_path != null && !selected_src_file_path.trim().equalsIgnoreCase("")) {

				File srcFile = new File(selected_src_file_path);

				if (!srcFile.exists()) {
					JOptionPane.showMessageDialog(main_frame, "Source Folder not exist");
					source_file_path_textField.setText("");
					return;
				}
				if (!srcFile.isDirectory()) {
					JOptionPane.showMessageDialog(main_frame, "Please select a source folder");
					source_file_path_textField.setText("");
					return;
				}

			} else {
				JOptionPane.showMessageDialog(main_frame, "Please select source folder");
				return;
			}

			selected_dest_file_path = destination_file_path_textField.getText();
			
			if (selected_dest_file_path != null && !selected_dest_file_path.trim().equalsIgnoreCase("")) {

				File destFile = new File(selected_dest_file_path);

				if (!destFile.exists()) {
					JOptionPane.showMessageDialog(main_frame, "Destination Folder not exist");
					destination_file_path_textField.setText("");
					return;
				}

				if (!destFile.isDirectory()) {
					JOptionPane.showMessageDialog(main_frame, "Please select a destination folder");
					destination_file_path_textField.setText("");
					return;
				}
			} else {
				JOptionPane.showMessageDialog(main_frame, "Please select destination folder");
				return;
			}

			
			selected_pfx_file_path = pfx_file_path_textField.getText() ;
			if (selected_pfx_file_path != null && !selected_pfx_file_path.trim().equalsIgnoreCase("")) {

				String extension = selected_pfx_file_path.substring(selected_pfx_file_path.lastIndexOf(".") + 1);
				if (!extension.equalsIgnoreCase("pfx")) {
					JOptionPane.showMessageDialog(main_frame, "Please choose pfx file only.");
					pfx_file_path_textField.setText("");
					return;
				}

			} else {
				JOptionPane.showMessageDialog(main_frame, "Please select destination folder");
				return;
			}

			if(password_file_path_textField.getText() != null && !password_file_path_textField.getText().equalsIgnoreCase("")) {
				
			}else {
				JOptionPane.showMessageDialog(main_frame, "Please insert password");
				return ;
			}
			
			filePath.getSelectedFilePath(selected_src_file_path,selected_dest_file_path,selected_pfx_file_path,password_file_path_textField.getText());
			
		}

	}

	public String getSelectFilePath() {
		return selected_src_file_path;
	}

	public void showUI() {
		// Making Objects of all Components
		main_frame = new JFrame("PDF Signer");
		welcome_label = new JLabel("Welcome to PDF Signer", JLabel.CENTER);
		select_src_label = new JLabel("Select source Folder : ");
		select_destination_label = new JLabel("Select destination Folder : ");
		select_psx_label = new JLabel("Select .pfx File : ");
		select_password_label = new JLabel("Enter password : ");
		processing_label = new JLabel();
		browse_src_button = new JButton("Browse");
		browse_dest_button = new JButton("Browse");
		browse_pfx_button = new JButton("Browse");
		source_file_path_textField = new JTextField();
		destination_file_path_textField = new JTextField();
		pfx_file_path_textField = new JTextField();
		password_file_path_textField = new JTextField();
		convert_button = new JButton("Convert");

		// Setting welcome_label
		welcome_label.setBounds(0, 0, 1366, 100);
		welcome_label.setForeground(Color.DARK_GRAY);
		welcome_label.setFont(new Font("Serif", Font.ITALIC, 50));

		// Setting select_label
		select_src_label.setBounds(100, 120, 450, 50);
		select_src_label.setForeground(Color.BLUE);
		select_src_label.setFont(new Font("Serif", Font.ITALIC, 30));

		// Setting select_label
		select_destination_label.setBounds(100, 200, 450, 50);
		select_destination_label.setForeground(Color.BLUE);
		select_destination_label.setFont(new Font("Serif", Font.ITALIC, 30));

		select_psx_label.setBounds(100, 280, 450, 50);
		select_psx_label.setForeground(Color.BLUE);
		select_psx_label.setFont(new Font("Serif", Font.ITALIC, 30));

		select_password_label.setBounds(100, 360, 450, 50);
		select_password_label.setForeground(Color.BLUE);
		select_password_label.setFont(new Font("Serif", Font.ITALIC, 30));

		// Setting directory_name_field
		source_file_path_textField.setBounds(580, 135, 400, 30);
		source_file_path_textField.setForeground(Color.BLACK);
		source_file_path_textField.setFont(new Font("Serif", Font.ITALIC, 15));
		source_file_path_textField.setEnabled(true);

		destination_file_path_textField.setBounds(580, 215, 400, 30);
		destination_file_path_textField.setForeground(Color.BLACK);
		destination_file_path_textField.setFont(new Font("Serif", Font.ITALIC, 15));
		destination_file_path_textField.setEnabled(true);

		pfx_file_path_textField.setBounds(580, 295, 400, 30);
		pfx_file_path_textField.setForeground(Color.BLACK);
		pfx_file_path_textField.setFont(new Font("Serif", Font.ITALIC, 15));
		pfx_file_path_textField.setEnabled(true);

		password_file_path_textField.setBounds(580, 375, 400, 30);
		password_file_path_textField.setForeground(Color.BLACK);
		password_file_path_textField.setFont(new Font("Serif", Font.ITALIC, 15));
		password_file_path_textField.setEnabled(true);

		// Setting browse_button
		browse_src_button.setBounds(1000, 135, 150, 30);
		browse_src_button.setForeground(Color.DARK_GRAY);
		browse_src_button.setFont(new Font("Serif", Font.ITALIC, 25));

		// Setting browse_button
		browse_dest_button.setBounds(1000, 215, 150, 30);
		browse_dest_button.setForeground(Color.DARK_GRAY);
		browse_dest_button.setFont(new Font("Serif", Font.ITALIC, 25));

		// Setting browse_button
		browse_pfx_button.setBounds(1000, 295, 150, 30);
		browse_pfx_button.setForeground(Color.DARK_GRAY);
		browse_pfx_button.setFont(new Font("Serif", Font.ITALIC, 25));

		// Setting fetch_info_button
		convert_button.setBounds(520, 500, 150, 30);
		convert_button.setForeground(Color.DARK_GRAY);
		convert_button.setHorizontalAlignment(SwingConstants.CENTER);
		convert_button.setVerticalAlignment(SwingConstants.CENTER);
		convert_button.setFont(new Font("Serif", Font.ITALIC, 25));

		convert_button.setEnabled(true);

		processing_label.setBounds(450, 550, 500, 30);
		processing_label.setForeground(Color.DARK_GRAY);
		processing_label.setFont(new Font("Serif", Font.ITALIC, 25));
		// processing_label.setText("Processing your request...");

		// processing_label.setVisible(false);
		// Adding Components to main_frame

		main_frame.add(welcome_label);
		main_frame.add(select_src_label);
		main_frame.add(select_destination_label);
		main_frame.add(select_psx_label);
		main_frame.add(select_password_label);
		main_frame.add(browse_src_button);
		main_frame.add(browse_dest_button);
		main_frame.add(browse_pfx_button);
		main_frame.add(source_file_path_textField);
		main_frame.add(destination_file_path_textField);
		main_frame.add(pfx_file_path_textField);
		main_frame.add(password_file_path_textField);
		main_frame.add(convert_button);
		main_frame.add(processing_label);

		// Attaching with action_listner
		browse_src_button.addActionListener(this);
		browse_dest_button.addActionListener(this);
		browse_pfx_button.addActionListener(this);
		convert_button.addActionListener(this);

		// Setting main_frame
		main_frame.setSize(1366, 768);
		main_frame.setLayout(null);
		main_frame.setVisible(true);
	}

	public void disableConvertButton() {
		processing_label.setText("Processing your request...");
		processing_label.paintImmediately(processing_label.getVisibleRect());
		convert_button.setEnabled(false);
	}

	public void enableConvertButton(String message) {
		convert_button.setEnabled(true);
//		convert_button.paintImmediately(convert_button.getVisibleRect());
		System.out.println("Enable");
		processing_label.setText(message);
		processing_label.paintImmediately(processing_label.getVisibleRect());
	}

}