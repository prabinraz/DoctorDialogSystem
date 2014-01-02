/*
 * DialogFrame.java
 *
 * Created on November 19, 2006, 12:17 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package doctordialogsystem;

/**
 *
 * @author Sanjeeb
 */

//import com.sun.corba.se.impl.ior.iiop.JavaSerializationComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import jpl.*;
import jpl.Query;


public class DialogFrame extends JFrame{
    String Question="";
    String Answer="";
    String NextItem="";
    String Description="";
    String NextRule="";
    /** Creates a new instance of DialogFrame */
    //JButton okButton=new JButton("OK");
   // JTextArea QuestionTA=new JTextArea();
   // JTextArea messageTextArea=new JTextArea();
    RadioPanel myRadioPanel=new RadioPanel();
    JLabel QuestionLabel= new JLabel();
    UnicodeGenerator Ug=new UnicodeGenerator("np");
    QuestionAnswerCollector qac=new QuestionAnswerCollector();
    Query q1;
    JMenuBar menuBar = new JMenuBar();
    JMenu menuFile = new JMenu("File");
    JMenuItem menuFileCompile = new JMenuItem("re-compile main.pl");
    
    public void addRadioButtons(){
                myRadioPanel.addRadioButton("ke ko Kop kun ho.");
                myRadioPanel.addRadioButton("poliyo ko Kop kun ho.");
                myRadioPanel.addRadioButton("ke ko Kop qi.qi. ho.");
                myRadioPanel.addRadioButton("ke ko Kop di.pi.ti. ho.");
    }
    public void addQuestionLabel(){
        String currentQuestion=getQuestion();
        QuestionLabel.setText(currentQuestion);
    }
    public String getQuestion(){
        
        //myRadioPanel.addMessage(Ug.getMaping());
        
        String RomanizedQuestion="lets talk.";
        String nepaliQuestion =Ug.format(RomanizedQuestion);
        return nepaliQuestion;
    }
    public void init(){
                Container contentpane =getContentPane();
                contentpane.setLayout(new BorderLayout());
                setLayout(new BorderLayout());
                addRadioButtons();
                addQuestionLabel();
                contentpane.add(QuestionLabel,BorderLayout.NORTH);
                contentpane.add(myRadioPanel,BorderLayout.CENTER);
                menuFile.add(menuFileCompile);
                menuBar.add(menuFile);
                setJMenuBar(menuBar);
                menuFileCompile.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                        String t1="consult('F:/WORKINGPLACE/DoctorDialogSystem/src/doctordialogsystem/main.pl')";
                         q1= new Query(t1);
                          myRadioPanel.messageTextArea.append("\nJava Engine:" + t1 + " " + (q1.hasSolution() ? "succeeded" : "failed") );
                    }
                });
                
               
                
    }
    public DialogFrame(String Name){
                super(Name);
                setSize(400,400);
                init();
                //q1=new Query("consult",new Term[]{new Atom("F:/WORKINGPLACE/DoctorDialogSystem/src/doctordialogsystem/main.pl")});
                String t1="consult('F:/WORKINGPLACE/DoctorDialogSystem/src/doctordialogsystem/main.pl')";
                q1= new Query(t1);
                myRadioPanel.messageTextArea.append("Java Engine:" + t1 + " " + (q1.hasSolution() ? "succeeded" : "failed") );
                //q1.allSolutions();
                myRadioPanel.messageTextArea.append("\n"+qac.getInitialUserQuestion());
                qac.setNextRule("startTalk");
                setVisible(true);
    }

 public Query getQ1() {
        return q1;
    }
    
    
    class RadioPanel extends JPanel{
        JRadioButton[] radio=new JRadioButton[10];
        public JTextArea messageTextArea=new JTextArea(10,10);
        JScrollPane sp=new JScrollPane(messageTextArea);
        JTextField replyTextField=new JTextField();
        JPanel MessagePanel=new JPanel();
        JButton okButton=new JButton("Ok");
        ButtonGroup group=new ButtonGroup();
        int buttonCount=0;
        
        Box Boxlayout=Box.createVerticalBox();
        JPanel mybuttonPanel=new JPanel();
        
     public String removeDash(String text1){
            String temp=text1;
            if(text1.charAt(0)==((char)39)){
                temp=text1.substring(1,text1.length()-1);
            }
            if(text1.charAt(text1.length()-1)==((char)39)){
                temp=temp.substring(0,text1.length()-2);
            }
         return temp;
     }
        
        RadioPanel(){
           setLayout(new BorderLayout());
           
           mybuttonPanel.setLayout(new BorderLayout());
           MessagePanel.setLayout(new BorderLayout());
           MessagePanel.add(sp,BorderLayout.CENTER);
           MessagePanel.add(replyTextField,BorderLayout.SOUTH);
           mybuttonPanel.add(okButton,BorderLayout.SOUTH);
           mybuttonPanel.add(MessagePanel,BorderLayout.CENTER);
           add(mybuttonPanel,BorderLayout.SOUTH);
           okButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    
                    String QueryString=replyTextField.getText();
                    qac.setUserChoice(QueryString);
                    String FinalString=qac.getNextPrologQuestion();
                    Query q2=new Query(FinalString);
                    //Query q2=new Query("nepaliNumber(tin,Answer).");
                    //q2.hasMoreSolutions()
                   // messageTextArea.append("\nJava:" + FinalString);
                    try{
                        while(q2.hasMoreSolutions()){
                            Hashtable ht=q2.nextSolution();
                            Answer=removeDash(ht.get("Answer").toString());
                            NextItem=removeDash(ht.get("NextItem").toString());
                            Description=removeDash(ht.get("Description").toString());
                            NextRule=removeDash(ht.get("NextRule").toString());
                            if(NextItem.equals("Question")){
                                messageTextArea.append("\nAnswer="+Answer);
                                //messageTextArea.append("\nNextRule=" +NextRule);
                                messageTextArea.append("\nExpert:" + Description);
                                qac.setNextRule(NextRule);
                            }else if(NextItem.equals("Rule")){
                                messageTextArea.append("\nAnswer="+Answer);
                                //messageTextArea.append("\nDescription=" + Description);
                                //messageTextArea.append("\nNextRule=" +NextRule);
                                qac.setNextRule(NextRule);                                
                            }else{
                                messageTextArea.append("\nAnswer="+Answer);                            
                                messageTextArea.append("\nNextItem=" + NextItem);
                                messageTextArea.append("\nDescription=" + Description);
                                messageTextArea.append("\nNextRule=" +NextRule);
                            }
                            
                            
                        }
                        
                    }catch(JPLException jple){
                        jple.printStackTrace();
                    }
                    
//                    try{
//                                            String QueryString=getQuery(getSelectedNo());
//                                            Query q2=new Query(QueryString);
//                                            Hashtable[] solutions=q2.allSolutions();
//
//                                            for(int k=0;k<solutions.length;k++){
//                                                   
//                                                   messageTextArea.append(Ug.format("\n"+solutions[k].get("Ke")+" ko Kop "+solutions[k].get("Kun") + " ho."));
//                                                   messageTextArea.append("\n------------------------");
//                                             }
//                                           repaint();   
//                                       
//                                           q1.close();
//                                           q2.close();
//                                        }catch(JPLException je){
//                                            je.printStackTrace();
//                                        }
                }  
           });
        }//end of constructior Radiopanel 
        
        public void addMessage(String Message){
            messageTextArea.append(Message);        
        }
        public void addRadioButton(String Title){
            
            radio[buttonCount]=new JRadioButton(Ug.format(Title));
            group.add(radio[buttonCount]);
            Boxlayout.add(radio[buttonCount]);
            add(Boxlayout,BorderLayout.NORTH);
            buttonCount++;
            //add(radio[buttonCount],FlowLayout.LEADING);
        }
        public String getQuery(int no){
            System.out.println(no);
            String returnQuery="dadura ko kop Kun ho.";
            switch(no){
                case 0:
                    returnQuery="Ke ko kop Kun ho.";
                    break;
                case 1:
                    returnQuery="poliyo ko kop Kun ho.";
                    break;
                case 2:
                    returnQuery="Ke ko kop qiqi ho.";
                    break;
                case 3:
                    returnQuery="Ke ko kop dpt ho.";
                    break;
                default:
                    returnQuery="dadura ko kop Kun ho.";
            }
            return returnQuery;
        }//end of method getQuery
        
        public String getSelectedString(){
            //int selected=-1;
            String selectedString="Radio Button is not Selected.";
            if(buttonCount>=1){
                for(int i=0;i<buttonCount;i++){
                   DefaultButtonModel model=(DefaultButtonModel)radio[i].getModel();
                    if(model.getGroup().isSelected(model)){
                      selectedString=radio[i].getText();
                    }
                   System.out.println("Button Count"+buttonCount);
                 }
            } 
            
            return selectedString;
        }//end of method getSelectedString();
        
        public int getSelectedNo(){
          int selected=-1;
            String selectedString="Radio Button is not Selected.";
            if(buttonCount>=1){
                for(int i=0;i<buttonCount;i++){
                   DefaultButtonModel model=(DefaultButtonModel)radio[i].getModel();
                    if(model.getGroup().isSelected(model)){
                      selectedString=radio[i].getText();
                      selected=i;
                    }
                   
                 }
            } 
            
            return selected;
        }//end of method getSelectedNo()     
            
    
    }
   
    
   
}



