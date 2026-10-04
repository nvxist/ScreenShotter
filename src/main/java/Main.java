import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws AWTException, IOException {
        Robot robot = new Robot();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        BufferedImage image = robot.createScreenCapture(new Rectangle(dimension));
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter    formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss.SSS");
        String formattedTimeStamp = now.format(formatter);
        Path filePath = Paths.get("Images/"+ formattedTimeStamp +".png");
        if(filePath.getParent() != null){
            Files.createDirectories(filePath);
        }
        ImageIO.write(image,"PNG",filePath.toFile());
    }
}
