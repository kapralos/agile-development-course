package ru.unn.agile.queue;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueueForm{
    private JButton pushButton;
    private JTextField txtPushElement;
    private JButton popButton;
    private JTextField txtPopElement;
    private JButton cleanButton;
    private JPanel mainPanel;
    private JLabel lbStatus;
    private JLabel lbSize;
    private ViewModel viewModel;

    public QueueForm(ViewModel viewModel)
    {
        this.viewModel = viewModel;

        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bind();
                QueueForm.this.viewModel.pushProcessAction();
                backBind();
            }
        });
        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bind();
                QueueForm.this.viewModel.popProcessAction();
                backBind();
            }
        });
        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bind();
                QueueForm.this.viewModel.cleanProcessAction();
                backBind();
            }
        });
    }

    public void bind() {
        viewModel.Element = txtPushElement.getText();
        viewModel.message = lbStatus.getText();
        viewModel.size = lbSize.getText();
    }

    public void backBind() {
        txtPushElement.setText(viewModel.Element);
        txtPopElement.setText(viewModel.topElement);
        lbStatus.setText(viewModel.message);
        lbSize.setText(viewModel.size);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("QueueForm");
        frame.setContentPane(new QueueForm(new ViewModel()).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
