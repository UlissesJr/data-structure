package top.luobogan.annotation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by LuoboGan
 * Date:2022/12/17
 */
public class ButtonTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            ButtonFrame frame = new ButtonFrame();
            frame.setTitle("ButtonTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
