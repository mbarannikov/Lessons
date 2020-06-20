package ru.ifmo.base.lesson18;

import java.io.*;
import java.util.Arrays;

public class EncodeOutputStream extends FilterOutputStream {
    private String key = "java";
    byte [] byteKey = key.getBytes();

    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field {@code this.out} for later use, or
     *            <code>null</code> if this instance is to be
     *            created without an underlying stream.
     */
    public EncodeOutputStream(OutputStream out) {
        super(out);
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
    public void write(byte[] b) throws IOException {
        byte[] shifr = new byte[b.length];
        for (int i = 0; i < b.length; i++) {
            shifr[i] = (byte) (b[i] ^ byteKey[i % byteKey.length]);
        }
        System.out.println("b = " + b.toString());
        System.out.println("shifr = " + shifr.toString());
        super.write(shifr);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        for (int i = 0; i < off + len; i++) {
            b[i] = (byte) (b[i] ^ byteKey[i % byteKey.length]);
        }
        super.write(b, off, len);
    }
}
