package ru.ifmo.base.lesson18;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class EncodeInputStream extends FilterInputStream {
    private String key = "java";
    byte [] byteKey = key.getBytes();
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected EncodeInputStream(InputStream in) {
        super(in);
    }

    public static byte[] encode (String text, String key){
        byte [] byteText = text.getBytes();
        byte [] byteKey = key.getBytes();
        byte [] res = new byte[text.length()];
        for (int i = 0; i < text.length(); i++) {
            res[i] = (byte) (byteText[i] ^ byteKey[i % byteKey.length]);
        }
        return res;
    }
    public static String decode (byte[] text, String key){
        byte [] res = new byte[text.length];
        byte [] byteKey = key.getBytes();
        for (int i = 0; i < text.length; i++) {
            res[i] = (byte) (text[i] ^ byteKey[i % byteKey.length]);
        }
        return new String(res);
    }


    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = in.read(b, off, len);
        for (int i = 0; i < off + len; i++) {
            System.out.println("b[i]1 = " + b[i]);
            b[i] = (byte) (b[i] ^ byteKey[i % byteKey.length]);
            System.out.println("b[i]2 = " + b[i]);
        }
        return result;
    }


}
