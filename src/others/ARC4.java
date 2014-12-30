package others;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by dheeraj on 30/12/14.
 */
public class ARC4 {

    public static void encrypt() throws Exception {
        final byte[] buf = new byte[8192];
        final Cipher c = Cipher.getInstance("AES/CTR/NoPadding");
        c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec("1234567890123456".getBytes(), "AES"), new IvParameterSpec(new byte[16]));
        final InputStream is = new FileInputStream("/home/sujeet/Downloads/clear.mp4");
        final OutputStream os = new CipherOutputStream(new FileOutputStream("/home/sujeet/Downloads/ttt.mp4"), c);
        while (true) {
            int n = is.read(buf);
            if (n == -1) break;
            os.write(buf, 0, n);
        }
        os.close(); is.close();
    }

    public static void main(String[] args) throws Exception{
        encrypt();
    }

}
