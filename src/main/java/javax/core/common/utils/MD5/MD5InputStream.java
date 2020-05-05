//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package javax.core.common.utils.MD5;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

public class MD5InputStream extends FilterInputStream {
    private MD5 md5 = new MD5();

    public MD5InputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        int c = super.in.read();
        if (c == -1) {
            return -1;
        } else {
            if ((c & -256) != 0) {
                System.out.println("MD5InputStream.read() got character with (c & ~0xff) != 0)!");
            } else {
                this.md5.Update(c);
            }

            return c;
        }
    }

    public int read(byte[] bytes, int offset, int length) throws IOException {
        int r;
        if ((r = super.in.read(bytes, offset, length)) == -1) {
            return r;
        } else {
            this.md5.Update(bytes, offset, r);
            return r;
        }
    }

    public byte[] hash() {
        return this.md5.Final();
    }

    public MD5 getMD5() {
        return this.md5;
    }

    public static void main(String[] arg) {
        try {
            String filename = arg[arg.length - 1];
            boolean use_default_md5 = false;
            boolean use_native_lib = true;

            for(int i = 0; i < arg.length - 1; ++i) {
                if (arg[i].equals("--use-default-md5")) {
                    use_default_md5 = true;
                } else if (arg[i].equals("--no-native-lib")) {
                    use_native_lib = false;
                }
            }

            byte[] buf = new byte[65536];
            if (use_default_md5) {
                InputStream in = new BufferedInputStream(new FileInputStream(filename));
                MessageDigest digest = MessageDigest.getInstance("MD5");

                int num_read;
                while((num_read = in.read(buf)) != -1) {
                    digest.update(buf, 0, num_read);
                }

                System.out.println(MD5.asHex(digest.digest()) + "  " + filename);
                in.close();
            } else {
                if (!use_native_lib) {
                    MD5.initNativeLibrary(true);
                }

                MD5InputStream in = new MD5InputStream(new BufferedInputStream(new FileInputStream(filename)));

                while(true) {
                    if (in.read(buf) == -1) {
                        System.out.println(MD5.asHex(in.hash()) + "  " + filename);
                        in.close();
                        break;
                    }
                }
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }
}
