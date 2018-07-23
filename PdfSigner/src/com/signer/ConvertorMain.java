package com.signer;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ConvertorMain implements IGetFilePath {

	String selectedSrcFilePath, selectedDestFilePath, selectedPfxFilePath, password;
	SwingUI swingUI;
	SignPdf signPdf;

	public static void main(String[] args) {

		ConvertorMain main = new ConvertorMain();
		main.showUi();
	}

	@Override
	public void getSelectedFilePath(String selectedSrcFilePath, String selectedDestFilePath, String selectedPfxFilePath,
			String password) {

		try {
			this.selectedSrcFilePath = selectedSrcFilePath;
			this.selectedDestFilePath = selectedDestFilePath;
			this.selectedPfxFilePath = selectedPfxFilePath;
			this.password = password;
			System.out.println("File Path is " + selectedSrcFilePath);

			swingUI.disableConvertButton();
			
			signPdf = new SignPdf(selectedSrcFilePath, selectedDestFilePath, password, selectedPfxFilePath);
			
			
			readAndConvertFiles(selectedSrcFilePath, selectedDestFilePath, selectedPfxFilePath, password);

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(swingUI.main_frame, "Exception Occured " + e.getMessage());
		}

	}

	private void readAndConvertFiles(String selectedSrcFilePath2, String selectedDestFilePath2,
			String selectedPfxFilePath2, String password2) {

		try {

			File srcFile = new File(selectedSrcFilePath2);
			File destFile = new File(selectedDestFilePath2);

			if (!destFile.exists()) {
				if (destFile.mkdirs()) {
					JOptionPane.showMessageDialog(swingUI.main_frame, "Unable to make directory at that position");
				}
			}

			if (srcFile.exists() && srcFile.isDirectory()) {
				File[] pdfFile = srcFile.listFiles();
				
				for (int i = 0; i < pdfFile.length; i++) {

					String fileName = destFile.getAbsolutePath() + "/"  +pdfFile[i].getName();

					signPdf.signFile(pdfFile[i].getAbsolutePath(), fileName, selectedPfxFilePath2, password2);
				}
				
				enableConvertButton("PDF successfully signed...");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(swingUI.main_frame,  e.getMessage());
			enableConvertButton("Please try again");
		}
	}

	public void showUi() {
		swingUI = new SwingUI(ConvertorMain.this);
		swingUI.showUI();
	}

	public void enableConvertButton(String message) {
		swingUI.enableConvertButton(message);
	}
}
