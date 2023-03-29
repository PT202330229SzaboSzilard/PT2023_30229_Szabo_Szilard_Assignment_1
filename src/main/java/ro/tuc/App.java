package ro.tuc;

import ro.tuc.gui.View;

import javax.swing.*;
public class App
{
    public static void main( String[] args )
    {
        JFrame frame = new View("Simple calculator using MVC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
