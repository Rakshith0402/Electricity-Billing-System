package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class NewCustomer extends JFrame implements ActionListener {
    JTextField tfName,tfAddress,tfstate,tfcity,tfPhone,tfEmail;
    JButton next,cancel;
    JLabel lblmeter;


    NewCustomer(){
        setSize(700,500);
        setLocation(400,200);

        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(Color.GRAY);
        add(p);

        JLabel heading=new JLabel("New Customer");
        heading.setBounds(180,10,200,25);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);

        JLabel lblName=new JLabel("Customer Name");
        lblName.setBounds(100,80,100,20);
        p.add(lblName);

        tfName=new JTextField();
        tfName.setBounds(240,80,200,20);
        p.add(tfName);

        JLabel lblMeterno=new JLabel("Meter Number");
        lblMeterno.setBounds(100,120,100,20);
        p.add(lblMeterno);

        lblmeter=new JLabel("");
        lblmeter.setBounds(240,120,100,20);
        p.add(lblmeter);

        Random ran=new Random();
        long randomNum=ran.nextLong()%1000000;
        lblmeter.setText(""+Math.abs(randomNum));

        JLabel lbladress=new JLabel("Address");
        lbladress.setBounds(100,160,100,20);
        p.add(lbladress);

        tfAddress=new JTextField();
        tfAddress.setBounds(240,160,200,20);
        p.add(tfAddress);

        JLabel lblcity=new JLabel("City");
        lblcity.setBounds(100,200,100,20);
        p.add(lblcity);

        tfcity=new JTextField();
        tfcity.setBounds(240,200,200,20);
        p.add( tfcity);

        JLabel lblstate=new JLabel("State");
        lblstate.setBounds(100,240,100,20);
        p.add(lblstate);

        tfstate=new JTextField();
        tfstate.setBounds(240,240,200,20);
        p.add(tfstate);

        JLabel lblEmail=new JLabel("Email");
        lblEmail.setBounds(100,280,100,20);
        p.add(lblEmail);

        tfEmail=new JTextField();
        tfEmail.setBounds(240,280,200,20);
        p.add(tfEmail);

        JLabel lblPhone=new JLabel("Phone Number");
        lblPhone.setBounds(100,320,100,20);
        p.add(lblPhone);

        tfPhone=new JTextField();
        tfPhone.setBounds(240,320,200,20);
        p.add(tfPhone);

        next=new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.DARK_GRAY);
        next.setForeground(Color.GRAY);
        next.addActionListener(this);
        p.add(next);

        cancel=new JButton("Cancel");
        cancel.setBounds(250,390,100,25);
        cancel.setBackground(Color.DARK_GRAY);
        cancel.setForeground(Color.GRAY);
        cancel.addActionListener(this);
        p.add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2=i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image,"West");

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            String name = tfName.getText();
            String meter = lblmeter.getText();
            String address = tfAddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String email = tfEmail.getText();
            String phone = tfPhone.getText();

            String query1 = "insert into customer values('"+name+"', '"+meter+"', '"+address+"', '"+city+"', '"+state+"', '"+email+"', '"+phone+"')";
            String query2 = "insert into login values('"+meter+"', '', '"+name+"', '', '')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);

                // new frame
                new MeterInfo(meter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new NewCustomer();
    }
}
