package Kursovik;

import java.net.ConnectException;
import java.net.SocketException;

public abstract class Worker implements Runnable {
    @Override
    public void run() {
        try {
            init();

            while (!isInterrupted()) {
                loop();
            }
        } catch (ConnectException e) {
            System.out.println("ConnectException " + e.getMessage());
        } catch (SocketException e) {
            System.out.println("SocketException " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stop();
            } catch (SocketException e) {
                System.out.println("SocketException " + e.getMessage());
            } catch (Exception e) {
                //
                throw new RuntimeException(e);
            }
        }
    }

    protected void init() throws Exception {
    }

    protected void stop() throws Exception {
    }

    protected void loop() throws Exception {
    }

    protected boolean isInterrupted() {
        return Thread.currentThread().isInterrupted();
    }
}