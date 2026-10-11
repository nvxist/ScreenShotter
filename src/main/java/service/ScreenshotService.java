package service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ScreenshotService {
    private static Robot robot;
    private static Dimension dimension;
    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
    }


    public ScreenshotService() throws AWTException {

    }

    public static void shot () throws IOException {
        BufferedImage image = robot.createScreenCapture(new Rectangle(dimension));
        StorageService.save(image);


    }

}
