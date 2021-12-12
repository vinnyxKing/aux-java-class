import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class personalForm extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JLabel enterName = new JLabel("Enter your Name: ");
    JTextField txtName = new JTextField(20);
    JRadioButton homeStd = new JRadioButton("Home Student");
    JRadioButton abroadStd = new JRadioButton("Abroad student");
    JLabel numSelector = new JLabel("Select the number of courses you want to take: ");
    JComboBox comboSelector = new JComboBox();
    JButton btnsend = new JButton("Send");
    JLabel totalFee = new JLabel("Total fees you need to pay: ");
    JTextField txtFee = new JTextField(10);
    JButton btnClear = new JButton("Clear");
    ButtonGroup btngroup = new ButtonGroup();

    public personalForm(){

        setTitle("Fill in all the information below");
        setLayout(new FlowLayout());
        setMaximumSize(new Dimension(450, 400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        add(panel);
        add(enterName);
        add(txtName);
        btngroup.add(abroadStd);
        btngroup.add(homeStd);
        add(homeStd);
        add(abroadStd);
        add(numSelector);
        add(comboSelector);
        add(btnsend);
        add(totalFee);
        add(txtFee);
        add(btnClear);

        for (int i = 0; i <= 8; i++){
            comboSelector.addItem(""+i);
        }

        txtFee.setEnabled(false); //prevents the field from being editable
        txtFee.setText("0.00 TL");

        btnsend.addActionListener(this);
        btnClear.addActionListener(this);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnsend) {

            String Fullname = this.txtName.getText().toString();
            String numCourseStr = this.comboSelector.getSelectedItem().toString();
            boolean isHome = false;

            int numOfCourses = 0;
            if (homeStd.isSelected()){
                isHome = true;
            }else if (abroadStd.isSelected()){
                isHome = false;
            }
            try{
                numOfCourses = Integer.parseInt(numCourseStr);
            }catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Some Error " +
                        "Occured");
                System.out.println(ex.getMessage());
            }

            feeCal fee = new feeCal(Fullname,isHome, numOfCourses);
            txtFee.setText("" + fee.calculateFee() + " TL");
            txtFee.setEnabled(true);

        }
        if (e.getSource() == btnClear){
            txtName.setText("");
            btngroup.clearSelection();
            comboSelector.setSelectedIndex(0);
            txtFee.setEnabled(false);
            txtFee.setText("0.00 TL");
        }
    }
}
