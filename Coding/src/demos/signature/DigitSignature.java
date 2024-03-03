package demos.signature;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class DigitSignature {

	String algorithm = "SHA256withRSA";
	
	public byte[] signSignature(PrivateKey key, String value_to_sign) {
		
		Signature sign=null;
		byte[] signature = null;
		
		try {
			sign = Signature.getInstance(algorithm);
			sign.initSign(key);
			sign.update(value_to_sign.getBytes());
			signature = sign.sign();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return signature;
	}

	public boolean verifySignature(PublicKey key, String value_to_verify) {
		
		Signature sign=null;
		boolean verify  = false;
		
		try {
			sign = Signature.getInstance(algorithm);
			sign.initVerify(key);
			sign.update(value_to_verify.getBytes());
			byte[] signed = Base64.getDecoder().decode(value_to_verify);
			verify = sign.verify(signed);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return verify;
	}

	private PublicKey getPublicKey(InputStream is) {
		
		PublicKey key=null;
		
		try {
			
			BufferedInputStream bis = new BufferedInputStream(is);
			ByteArrayOutputStream bos = new ByteArrayOutputStream(4096);
			byte[] tmp = new byte[1024];
			int len;
			while((len=bis.read(tmp))!= -1) {
				bos.write(tmp,0,len);
			}
			bos.flush();
			bos.close();
			bis.close();
			
			KeyFactory factory = KeyFactory.getInstance(algorithm);
			X509EncodedKeySpec spec = new X509EncodedKeySpec(bos.toByteArray());
			key = factory.generatePublic(spec);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return key;
	}
}
