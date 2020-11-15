package net.kiranatos.youtube.g11galaxian;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class Input extends JComponent{

    private boolean keyMap[];

    Input(){
        keyMap = new boolean[256];
        for(int i = 0; i < keyMap.length; i ++){
            final int KEY_CODE = i;
            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(i, 0, false), i * 2);
            getActionMap().put(i * 2, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    keyMap[KEY_CODE] = true;
                }
            });

            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(i, 0, true), i * 2 + 1);
            getActionMap().put(i * 2 + 1, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    keyMap[KEY_CODE] = false;
                }
            });
        }
    }

    public boolean[] getKeyMap(){
        return Arrays.copyOf(keyMap, keyMap.length);
    }

    public boolean getKey(int keyCode){
        return keyMap[keyCode];
    }
}
