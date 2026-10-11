package service;

import java.awt.*;
import java.io.IOException;


public class ScreenshotApplication {
    public void start() throws AWTException, IOException {

        HotKeyManager hotKeyManager = new HotKeyManager(() -> {
            try {
                ScreenshotService.shot();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


    }
}
