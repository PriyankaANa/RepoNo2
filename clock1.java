import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DigitalWatch extends JFrame {
    
    private final JLabel timeLabel;
    private final DateTimeFormatter timeFormatter;

    public DigitalWatch() {
        // Configure the window (JFrame)
        setTitle("Java Digital Watch");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centers the window
        setLayout(new BorderLayout());

        // Create and style the time display label
        timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
        timeLabel.setForeground(new Color(0, 150, 0)); // Sleek green text
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);
        add(timeLabel, BorderLayout.CENTER);

        // Define a 12-hour format with AM/PM indicators
        timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        // Initialize the watch display immediately
        updateTime();

        // Set up a swing timer to update the text every 1000 milliseconds (1 second)
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();
    }

    // Fetches the current system time and updates the GUI label
    private void updateTime() {
        LocalTime currentTime = LocalTime.now();
        String formattedTime = currentTime.format(timeFormatter);
        timeLabel.setText(formattedTime);
    }

    public static void main(String[] args) {
        // Ensure GUI updates happen on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            new DigitalWatch().setVisible(true);
        });
    }
}
