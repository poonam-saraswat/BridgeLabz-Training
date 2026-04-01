import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String[] messages = {
                "Hello from Writer Thread!",
                "This is a piped stream demo.",
                "Data flows between threads.",
                "End of messages."
            };

            for (String msg : messages) {
                pos.write(msg.getBytes());
                pos.write('\n'); // line break for readability
                pos.flush();
                Thread.sleep(500); // simulate delay
            }
            pos.close();
        } catch (IOException | InterruptedException e) {
            System.out.println("WriterThread Exception: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(pis))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Reader received: " + line);
            }
        } catch (IOException e) {
            System.out.println("ReaderThread Exception: " + e.getMessage());
        }
    }
}

public class PipedStreamDemo {
    public static void main(String[] args) {
        try {
            // Create piped streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            // Create threads
            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            // Start threads
            writer.start();
            reader.start();

            // Wait for threads to finish
            writer.join();
            reader.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Main Exception: " + e.getMessage());
        }
    }
}