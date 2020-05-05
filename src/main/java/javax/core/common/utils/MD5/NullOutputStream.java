//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package javax.core.common.utils.MD5;

import java.io.IOException;
import java.io.OutputStream;

public class NullOutputStream extends OutputStream {
    private boolean closed = false;

    public NullOutputStream() {
    }

    public void close() {
        this.closed = true;
    }

    public void flush() throws IOException {
        if (this.closed) {
            this._throwClosed();
        }

    }

    private void _throwClosed() throws IOException {
        throw new IOException("This OutputStream has been closed");
    }

    public void write(byte[] b) throws IOException {
        if (this.closed) {
            this._throwClosed();
        }

    }

    public void write(byte[] b, int offset, int len) throws IOException {
        if (this.closed) {
            this._throwClosed();
        }

    }

    public void write(int b) throws IOException {
        if (this.closed) {
            this._throwClosed();
        }

    }
}
