package service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StorageService {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss.SSS");

    public static void save(BufferedImage image) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        String formattedTimeStamp = now.format(formatter);
        Path filePath = Paths.get("Images/" + formattedTimeStamp + ".png");

        if(filePath.getParent() != null){
            Files.createDirectories(filePath);
        }
        ImageIO.write(image,"PNG", filePath.toFile());
    }
}
