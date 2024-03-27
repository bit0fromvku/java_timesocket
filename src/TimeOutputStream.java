import java.io.OutputStream;
import java.time.LocalDateTime;

public class TimeOutputStream extends Thread {
    private final OutputStream outputStream;
    private final int delay;

    public TimeOutputStream(OutputStream outputStream, int delay) {
        this.outputStream = outputStream;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = LocalDateTime.now().toString() + "\n";
                outputStream.write(message.getBytes());
                outputStream.flush();
                Thread.sleep(delay);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
