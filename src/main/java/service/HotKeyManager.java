package service;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HotKeyManager {
    private GlobalKeyboardHook globalKeyboardHook;
    private Set<Integer> pressedKeys = new HashSet<>();
    Runnable onKeyPressed;
    public HotKeyManager (Runnable onKeyPressed){
        this.onKeyPressed = onKeyPressed;
        globalKeyboardHook = new GlobalKeyboardHook(false);


        for (Map.Entry<Long, String> keyboard : GlobalKeyboardHook.listKeyboards().entrySet()) {
            System.out.format("%d: %s\n", keyboard.getKey(), keyboard.getValue());
        }

        globalKeyboardHook.addKeyListener(new GlobalKeyAdapter() {


            @Override
            public void keyPressed(GlobalKeyEvent event) {
                int keyCode = event.getVirtualKeyCode();
                pressedKeys.add(keyCode);

                System.out.println(
                        "PRESSED: " + event + " | keyCode = " + keyCode
                );

                boolean ctrlPressed =
                        pressedKeys.contains(162) || pressedKeys.contains(163);

                boolean shiftPressed =
                        pressedKeys.contains(160) || pressedKeys.contains(161);

                boolean sPressed =
                        pressedKeys.contains(GlobalKeyEvent.VK_S);


                System.out.println(
                        "CTRL=" + ctrlPressed
                                + ", SHIFT=" + shiftPressed
                                + ", S=" + sPressed
                );
                if(ctrlPressed && shiftPressed && sPressed){
                    onKeyPressed.run();
                }
            }

            @Override
            public void keyReleased(GlobalKeyEvent event) {
                System.out.println(
                        "RELEASED: " + event
                                + " | keyCode = " + event.getVirtualKeyCode()
                );
                pressedKeys.remove(event.getVirtualKeyCode());
            }
        });
    }
}
