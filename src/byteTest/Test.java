package byteTest;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;

/**
 * Created by dheeraj on 25/2/15.
 */
public class Test {
    

    
    public static void main(String[] args)throws Exception{
        byte b = 7;
        System.out.println(b);
        System.out.println(~b);
        System.out.println(~~b);

        final byte[] buf = new byte[1024];
        byte test;
        final InputStream is = new FileInputStream("/home/dheeraj/dash-junk/manifest.mpd");
        final OutputStream os = new FileOutputStream("/home/dheeraj/dash-junk/manifestE.mpd");
        while (true) {
            int n = is.read(buf);
            if (n == -1) break;
            for(int k =0;k<n;k++) {
            test = buf[k];  
                if(test != -128) {
                    buf[k] = (byte)~test;
                }
            }
            os.write(buf, 0, n);
        }
        os.close(); is.close();
    }
}
