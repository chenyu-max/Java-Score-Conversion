package TestFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class TransformFrame extends JFrame {
    public TransformFrame(String title) {
        super(title);
        this.setFondAndSoOn();
        this.addElements();
        this.addListener();
        this.setFrameSelf();
    }

    private final JPanel mainPanel = new JPanel();
    private final JLabel label1 = new JLabel("百分制");
    private final JLabel label2 = new JLabel("五分制");
    private final JTextField label1Field = new JTextField();
    private final JLabel label3 = new JLabel();
    private final JButton transformButton = new JButton("转化");
    private final JButton resetButton = new JButton("重置");

    private void setFondAndSoOn() {
        mainPanel.setLayout(null);

        label1.setBounds(70, 60, 80, 40);
        label1.setFont(new Font("微软雅黑", Font.BOLD, 16));

        label1Field.setBounds(200, 60, 200, 40);
        label1Field.setFont(new Font("微软雅黑", Font.BOLD, 16));

        label2.setBounds(70, 120, 80, 40);
        label2.setFont(new Font("微软雅黑", Font.BOLD, 16));
        label2.setVisible(false);

        label3.setBounds(260, 120, 80, 40);
        label3.setFont(new Font("微软雅黑", Font.BOLD, 16));

        transformButton.setBounds(110, 200, 90, 30);
        transformButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        transformButton.setBackground(Color.LIGHT_GRAY);
        transformButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        resetButton.setBounds(260, 200, 90, 30);
        resetButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        resetButton.setBackground(Color.LIGHT_GRAY);
        resetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }

    private void addElements() {
        mainPanel.add(label1);
        mainPanel.add(label2);
        mainPanel.add(label3);
        mainPanel.add(label1Field);
        mainPanel.add(resetButton);
        mainPanel.add(transformButton);
        this.add(mainPanel);
    }


    private void addListener() {
        // 转换按钮 监听事件
        transformButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String originalNumber = label1Field.getText();
                try {
                    float oNumber = Float.parseFloat(originalNumber);
                    int digitsNumber = Math.round(oNumber * 10 % 100); // 个位数

                    label2.setVisible(true);
                    if (oNumber == 100)
                        label3.setText("5.0分");
                    else if (oNumber >= 90 && oNumber <= 100) {
                        label3.setText("4." + digitsNumber + "分");
                    } else if (oNumber <= 89 && oNumber >= 80) {
                        label3.setText("3." + digitsNumber + "分");
                    } else if (oNumber <= 79 && oNumber >= 70) {
                        label3.setText("2." + digitsNumber + "分");
                    } else if (oNumber <= 69 && oNumber >= 60) {
                        label3.setText("1." + digitsNumber + "分");
                    } else if (oNumber < 60 && oNumber >= 0) {
                        label3.setText("0分");
                    } else {
                        label2.setVisible(false);
                        label3.setText("数据错误！");
                        JOptionPane.showMessageDialog(TransformFrame.this, "输入的数据不在识别范围内！");
                        label3.setText("");
                        label1Field.setText("");
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(TransformFrame.this, "输入的数据不在识别范围内！");
                }
            }
        });

        // 重置按钮监听事件
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label2.setVisible(false);
                label3.setText("");
                label1Field.setText("");
            }
        });


    }

    private void setFrameSelf() {
        this.setBounds(400, 200, 500, 300);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setVisible(true);
    }
}
