/*
 * QuestionAnswerCollector.java
 *
 * Created on March 24, 2007, 12:37 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package doctordialogsystem;

/**
 *
 * @author sanjeeb
 */
public class QuestionAnswerCollector {
    String initialUserQuestion="Expert: Tapai ko sishu ko umer kati bhyo?mahina ma bhannu hos";
    String nextRule;
    String nextUserQuestion;
    String nextPrologQuestion;
    String userChoice;
    
    /** Creates a new instance of QuestionAnswerCollector */
    public QuestionAnswerCollector() {
    
    }
    
  
    
    public void clearAll(){
        nextRule="";
        nextUserQuestion="";
    }
    public void setUserChoice(String userChoice){
        this.userChoice=userChoice;
    }
    
    public String getNextUserQuestion(){
        return nextUserQuestion;
    }
    
    public void setNextUserQuestion(String nextQuestion){
        this.nextUserQuestion=nextQuestion;
    }
    
    public String getNextPrologQuestion(){
        prologQuestionGenerator();
        return nextPrologQuestion;
    }
    public void setNextRule(String rule){
        this.nextRule=rule;
    }
    public String getNextRule(){
        return nextRule;
    }
    
    private void prologQuestionGenerator(){
                nextPrologQuestion=nextRule + "(" + userChoice +", Answer , NextItem, Description, NextRule).";
    }
    
    public String getInitialUserQuestion(){
               return initialUserQuestion;
    }
}


