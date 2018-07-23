package com.signer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;

import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfSignatureAppearance;
import com.lowagie.text.pdf.PdfStamper;

public class SignPdf {

	String srcFilePath,destFilePath,password,pfxFilepath ;

	public SignPdf(String srcFilePath, String destFilePath, String password, String pfxFilepath) {
		super();
		this.srcFilePath = srcFilePath;
		this.destFilePath = destFilePath;
		this.password = password;
		this.pfxFilepath = pfxFilepath;
	}

	public void signFile(String srcFileName, String destFileName,String pfxFileName,String password) throws Exception{
		try {

			SSLContext ctx = SSLContext.getInstance("SSL");
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			KeyStore ks = KeyStore.getInstance("JKS");
			ks.load(new FileInputStream(pfxFileName), password.toCharArray());
			kmf.init(ks, "emudhra".toCharArray());
			ctx.init(kmf.getKeyManagers(), null, null);

			String aliaas = (String) ks.aliases().nextElement();
			PrivateKey key = (PrivateKey) ks.getKey(aliaas, password.toCharArray());
			java.security.cert.Certificate[] chain = ks.getCertificateChain(aliaas);

			for(int i =0 ; i < chain.length ; i++){
				System.out.println(chain[i].getType() + " " +
						chain[i].getEncoded() + " "
				+chain[i].getPublicKey() + " ");
			}

//			System.out.println("Alias is " + aliaas);
//			Enumeration<String> aliases = ks.aliases();
//			while(aliases.hasMoreElements()){
//				String alias = aliases.nextElement();
//				System.out.println("Alias is below " + alias);
//				if(ks.getCertificate(alias).getType().equals("X.509")){
//					Date expDate = ((X509Certificate) ks.getCertificate(alias)).getNotAfter();
//					Date fromDate= ((X509Certificate) ks.getCertificate(alias)).getNotBefore();
//					System.out.println("Expiray Date:-"+expDate );
//					System.out.println("From Date:-"+fromDate);
//				}
//			}
//			chain[0].

			PdfReader reader = new PdfReader(srcFileName);
			FileOutputStream fout = new FileOutputStream(destFileName);
			PdfStamper stp = PdfStamper.createSignature(reader, fout, '\0');
			ArrayList arr = stp.getAcroFields().getBlankSignatureNames();
			PdfSignatureAppearance sap = stp.getSignatureAppearance();

			sap.setCrypto(key, chain, null, PdfSignatureAppearance.SELF_SIGNED);
			sap.setAcro6Layers(true);
			sap.setImage(null);
//			sap.setLocation("JS The Institue of Charted Accountant of India");

			// comment next line to have an invisible signature
			sap.setVisibleSignature(new Rectangle(400, 140, 650, 10), 1, null);

			stp.close();
		} catch (Exception e) {
				//throw e;
		}
	}
}