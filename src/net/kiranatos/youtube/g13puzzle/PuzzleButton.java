package net.kiranatos.youtube.g13puzzle;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PuzzleButton extends JButton {
    private boolean isLastButton;
    
    public PuzzleButton(){
        super();
        initUI();
    }
    
    public PuzzleButton(Image i){
        super(new ImageIcon(i));
        initUI();
    }
    
    private void initUI(){
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.yellow));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.gray));
            }
        });
    }
    
    public boolean isLastButton() {
        return isLastButton;
    }
    
    public void setLastButton(boolean isLastButton) {
        this.isLastButton = isLastButton;
    }
}
