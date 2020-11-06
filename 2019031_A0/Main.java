package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.util.Calendar;


@SuppressWarnings("deprecation")
public class Main {
    public static void main(String[] args) {
        Patient A1 = new Patient("Flora", 6, 1, new Date(2020, 4, 1));
        Patient A2 = new Patient("Denys", 24, 2, new Date(2020, 4, 1));
        Patient A3 = new Patient("Jim", 42, 3, new Date(2020, 5, 18));
        Patient A4 = new Patient("Hazel", 87, 4, new Date(2020, 6, 23));
        Patient A5 = new Patient("Caery", 72, 1, new Date(2020, 6, 1));
        Patient A6 = new Patient("David", 7, 2, new Date(2020, 6, 14));
        Patient A7 = new Patient("Kevim", 37, 4, new Date(2020, 6, 5));
        Patient A8 = new Patient("Tom", 67, 4, new Date(2020, 6, 20));
        Patient A9 = new Patient("Bob", 74, 1, new Date(2020, 7, 4));
        Patient A10 = new Patient("Rachel", 48, 3, new Date(2020, 7, 24));
        Patient A11 = new Patient("Thomas", 21, 3, new Date(2020, 6, 11));
        Patient A12 = new Patient("Mary", 17, 4, new Date(2020, 6, 21));
        Patient A13 = new Patient("Smith", 89, 1, new Date(2020, 8, 7));
        Patient A14 = new Patient("Pearson", 47, 2, new Date(2020, 6, 4));
        Patient A15 = new Patient("Anderson", 62, 2, new Date(2020, 7, 27));
        Patient A16 = new Patient("Johnson", 10, 4, new Date(2020, 8, 1));
        Patient A17 = new Patient("Julie", 86, 2, new Date(2020, 5, 2));
        Patient A18 = new Patient("Edith", 42, 4, new Date(2020, 6, 7));
        Patient A19 = new Patient("John", 95, 4, new Date(2020, 6, 1));
        Patient A20 = new Patient("Robertz", 50, 1, new Date(2020, 8, 9));
        System.out.println(Arrays.toString(Patient.list.toArray()));
        SwingTest obj = new SwingTest(Patient.list);
        Set<Integer> set_of_towers = obj.listTower;
//        System.out.println(obj.IWTK);
    }
    }
class SwingTest extends JFrame{
    JTextField jTextField1;
    JCheckBox jCheckBox1;
    JCheckBox jCheckBox2;
    JCheckBox jCheckBox3;
    JCheckBox jCheckBox4;
    JButton submitButton;
    Set<Integer> listTower;
    IsItADate IWTK;
    IsItADate EndDate;
    List<Patient> list_of_patients;
    public SwingTest(List<Patient> list_of_patients){
        this.jTextField1 = new JTextField(20);
        this.jCheckBox1 = new JCheckBox("A");
        this.jCheckBox2 = new JCheckBox("B");
        this.jCheckBox3 = new JCheckBox("C");
        this.jCheckBox4 = new JCheckBox("D");
        this.submitButton = new JButton("SUBMIT YOUR QUERY HERE. ");
        this.listTower = new HashSet<Integer>();
        this.list_of_patients = list_of_patients;
        JPanel p = new JPanel();
        add(jTextField1);
     //   System.out.println(Arrays.toString(list_of_patients.toArray()));

        jCheckBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1){
                    listTower.add(1);
                }
                else{
                    listTower.remove(1);
                    }
                }
            }
        );
         jCheckBox2.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == 1){
                listTower.add(2);
            }
            else{
                listTower.remove(2);
            }
        }
    }
);
        jCheckBox3.addItemListener(new ItemListener() {
                                       @Override
                                       public void itemStateChanged(ItemEvent e) {
                                           if (e.getStateChange() == 1){
                                               listTower.add(3);
                                           }
                                           else{
                                               listTower.remove(3);
                                           }
                                       }
                                   }
        );
        jCheckBox4.addItemListener(new ItemListener() {
                                       @Override
                                       public void itemStateChanged(ItemEvent e) {
                                           if (e.getStateChange() == 1){
                                               listTower.add(4);
                                           }
                                           else{
                                               listTower.remove(4);
                                           }
                                       }
                                   }
        );
        p.add(jCheckBox1);
        p.add(jCheckBox2);
        p.add(jCheckBox3);
        p.add(jCheckBox4);
        add(p);

        submitButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                String k = jTextField1.getText();
                String[] k2 = k.split("/", k.length());
                try {
                    int day = Integer.parseInt(k2[0]);
                    int month = Integer.parseInt(k2[1]) ;
                    int year = Integer.parseInt(k2[2]);
                    IsItADate date = new IsItADate(day, month, year);
                    if (date.isValid()){
                        setIWTK(year, month, day);
                        EndDate = date.add21Days();
                        System.out.println(IWTK.date + " " + IWTK.month + " " + IWTK.year);
                        System.out.println(EndDate.date + " " + EndDate.month + " " + EndDate.year);
                        System.out.println(Arrays.toString(list_of_patients.toArray()));
         //               System.out.println(listTower.toString());
                        new Answer_Panel(list_of_patients, listTower, IWTK, EndDate);
                        dispose();
                    }
                    else{
         //               System.out.println("Please Enter A Date Between April 2020 && August 2020.");
                        JOptionPane.showMessageDialog(submitButton,"Please enter a Date between April 2020 && August 2020");
                    }
                }
                catch (Exception g){
        //            System.out.println("Please provide the date in the correct format(DD/MM/YY)");
                    JOptionPane.showMessageDialog(submitButton ,"Please provide the date in the correct format (DD/MM/YY)");
                }
            }
        });
        add(submitButton);
        FlowLayout flowLayout = new FlowLayout();
        setLayout(flowLayout);
        setSize(300 ,400);
        setVisible(true);
        setTitle("Corona Tracker ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void setIWTK(int year, int month, int day){
        this.IWTK = new IsItADate(day, month, year);
        return ;
    }
}
class Patient{
    public static List<Patient> list = new ArrayList<Patient>();
    String name;
    int age;
    int Tower;
    Date dateReport;
    String jugaad;
    public Patient(String name, int age, int Tower, Date dateReport){
        this.name = name;
        this.age = age;
        this.dateReport = dateReport;
        this.Tower = Tower;
        if (Tower == 1)this.jugaad ="A" ;
        else if (Tower == 2)this.jugaad = "B";
        else if (Tower == 3) this.jugaad = "C";
        else this.jugaad = "D";
        list.add(this);
    }

}

class Answer_Panel extends JFrame {
    JPanel jDisplayTheNames_Active;
    JPanel jDisplayTheNames_Rest;
    JTable table1;
    JTable table2;
    List<Patient> list_of_patients;
    Set<Integer> list_of_towers;
    IsItADate start_date;
    IsItADate end_date;
    int active_cases = 0;
    int rest_cases = 0;
    public Answer_Panel(List<Patient> list_of_patients, Set<Integer> list_of_towers, IsItADate start_date, IsItADate end_date){
        this.list_of_patients = list_of_patients;
        this.list_of_towers = list_of_towers;
        this.start_date = start_date;
        this.end_date = end_date;
        this.jDisplayTheNames_Active = new JPanel();

        this.jDisplayTheNames_Rest = new JPanel();

        jDisplayTheNames_Active.setLayout(new GridBagLayout());

        jDisplayTheNames_Rest.setLayout(new GridBagLayout());
        GridBagConstraints cA = new GridBagConstraints();

        cA.gridx = 0;//set the x location of the grid for the next component
        cA.gridy = 0;

        GridBagConstraints cR = new GridBagConstraints();

        cR.gridx = 0;//set the x location of the grid for the next component
        cR.gridy = 0;

        setSize(1000, 1000);
        setLayout(new GridBagLayout());
        setVisible(true);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;

        setTitle("Your Search Result");

        cA.gridy += 1;
        cR.gridy += 1;
        jDisplayTheNames_Active.add(new JLabel("Name " + "   " + "Tower " + "   " + "Age" + "    " + "RecoveryDate"), cA);
        jDisplayTheNames_Rest.add(new JLabel("Name " + "    " + "Tower" + "    " + "Age" + "    "  + "RecoveryDate"), cR);
        for (Patient p: list_of_patients){
 //           System.out.println("In A Loop!! " + p.Tower + " " + p.name);
            if (list_of_towers.contains(p.Tower)) {
            //    System.out.println("Hurray!!");
                Date datey = p.dateReport;
                Date start = new Date(start_date.year,start_date.month, start_date.date);
                Date end = new Date(end_date.year, end_date.month, end_date.date);
                System.out.println(datey.compareTo(start) + " " + datey.compareTo(end));
                if (datey.compareTo(start) <= 0 && datey.compareTo(end) >= 0){
                    cA.gridy += 1;
                    IsItADate Date_pres = new IsItADate(datey.getDate(), datey.getMonth(), datey.getYear());
                    IsItADate k = Date_pres.low21Days();
                    jDisplayTheNames_Active.add(new JLabel(p.name + "    " + p.jugaad + "    " + p.age + "    " + k.date+"/"+k.month+"/"+ k.year), cA);
                    active_cases += 1;

                }
                else if (datey.compareTo(start) <= 0 && datey.compareTo(end) <= 0){
                    cR.gridy += 1;
                    IsItADate Date_pres = new IsItADate(datey.getDate(), datey.getMonth(), datey.getYear());
                    IsItADate k2 = Date_pres.low21Days();
                    jDisplayTheNames_Rest.add(new JLabel(p.name + "     " + p.jugaad + "    " + p.age + "    " + k2.date+ "/"+ k2.month+"/" + k2.year), cR);
                    rest_cases += 1;
                }
            }
        }
        cA.gridy = 0; cR.gridy = 0;
        jDisplayTheNames_Active.add(new JLabel("Active Cases on " + start_date.date + "/" + start_date.month+"/"+start_date.year+ ": " + active_cases ), cA);
        jDisplayTheNames_Rest.add(new JLabel("Rest cases on " + start_date.date + "/" + start_date.month + "/" + start_date.year + ": " + rest_cases), cR);
        jDisplayTheNames_Active.setBackground(Color.RED);
        add(jDisplayTheNames_Active);


        jDisplayTheNames_Rest.setBackground(Color.GREEN);
        add(jDisplayTheNames_Rest);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class IsItADate {
    int date;
    int month;
    int year;
    public IsItADate(int date, int month, int year){
        this.date = date;
        this.month = month;
        this.year = year;
    }
    public boolean isValid(){
        if (year != 2020){
            return false;
        }
        if (month < 4 || month > 8){
            return false;
        }
        if (date< 1){return false;}
        if (month == 4){if (date > 30){return false;}}
        else if (month == 5){if (date> 31){return false;}}
        else if (month == 6){if (date > 30){return false;}}
        else if (month == 7){if (date > 31){return false;}}
        else if (month == 8){if (date > 30){return false;}}
        return true;
    }
    public IsItADate add21Days(){
        Date k = new Date(year, month - 1, date);
        Calendar c = Calendar.getInstance();
        c.setTime(k);
        c.add(Calendar.DATE, -21);
        Date newDate = c.getTime();

        //  System.out.println(newDate);
        IsItADate theEndDate = new IsItADate(newDate.getDate(),newDate.getMonth() + 1, newDate.getYear());
        return theEndDate;
    }
    public IsItADate low21Days(){
        Date k = new Date(year, month - 1, date);
        Calendar c = Calendar.getInstance();
        c.setTime(k);
        c.add(Calendar.DATE, 21);
        Date newDate = c.getTime();

        //  System.out.println(newDate);
        IsItADate theEndDate = new IsItADate(newDate.getDate(),newDate.getMonth() + 1, newDate.getYear());
        return theEndDate;
    }
}
