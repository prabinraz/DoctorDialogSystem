package doctordialogsystem;



/*
 *UnicodeConverter.java
 *Converts from standard keyboard input (modern) to nepali unicode characters.
 *Written On: 22nd April, 2006
 *Author: Kushal Paudyal
 */

import java.util.Vector;
import javax.swing.JOptionPane;
import java.util.Date;
public class UnicodeGenerator {
        /*
         *Declare a vector that will store all nepali unicode characters
         */
    Vector unicodeVector;
        /*
         *Declare and define a standard string that holds the keyboard input for
         *nepali unicode sets in ascending order.
         *There are some charaters for which no keys are assigned on the keyboard
         *for their input. I have used dummy characters or their unicode values
         *themselves in preparing the standard string of keysets.
         */
    //faults 123456789 \u0944 \u0945 \u0946 \u0949 \u094A \u094E \u094F \u0951 \u0953 \u0954
    static String standard=" 0123456789VM:\u0904HA[{fFZ\u090C\u090D\u090E]}\u0911"+
            "\u0912OWkKgG<CcjJYqQxXNtTdDn\u0929pPbBmyr\u0931lL"+
            "\u0934vSzsh`~aiIuUR\u0944\u0945\u0946eE\u0949"+
            "\u094Aow/\u094E\u094F\\\u0951|\u0953\u0954\u0958\u0959";
    String language;
    
    public UnicodeGenerator(String language) {
        this.language=language;
        if(language=="np") {
            prepareVector();
        }
        
        
    }
    
        /* This method will take a string formed by proper keying for text that
         * has to be converted into unicode. It will read the string characterwise
         * and generate the index of that character from the standard string. Using
         * this index, it will generate a corresponding nepali unicode from the
         * unicodeVector.
         */
    public String format(String str) {
        //System.out.println("Formatting "+str);
        if(language=="np") {
            
            String formattedStr="";
            for(int i=0;i<str.length();i++) {
                char temp=str.charAt(i);
                int index=standard.indexOf(temp);
                if(index<0) //handle non-nepali characters
                {
                    formattedStr+=temp;
                } else {
                    formattedStr+=unicodeVector.elementAt(index);
                }
                
            }
            return formattedStr;
        } else return str;
    }
    
        /*
         * Method to format the date
         */
    
    public String formatDate(Date date) {
        String formattedDate="";
        if(language=="np") //if nepali
        {
            String [] monthNames={"jnvrI","Peb/ruHrI","mar/C","Hp/ril",
            "me","jun","jula{","Hgs/q","sep/qem/br",
            "Hk/tubr","noBem/br","xisem/br"};
            int year=1900+date.getYear();
            int month=date.getMonth();
            int theDate=date.getDate();
            formattedDate+=format(year+"");
            formattedDate+=" "+format(monthNames[month]);
            formattedDate+=" "+format(theDate+"");
            return formattedDate;
        }
        
        else return (1900+date.getYear())+" "+date.getMonth()+" "+
                date.getDate();
    }
    
    public void prepareVector() {
        unicodeVector=new Vector();
        
                /*
                 * Keep all the nepali unicode characters in the vector
                 */
        unicodeVector.addElement(" "); 			//space
        unicodeVector.addElement("\u0966");		//zero
        unicodeVector.addElement("\u0967");		//one
        unicodeVector.addElement("\u0968");		//two
        unicodeVector.addElement("\u0969");		//three
        unicodeVector.addElement("\u096A");		//four
        unicodeVector.addElement("\u096B");		//five
        unicodeVector.addElement("\u096C");		//six
        unicodeVector.addElement("\u096D");		//seven
        unicodeVector.addElement("\u096E");		//eight
        unicodeVector.addElement("\u096F");		//nine
        unicodeVector.addElement("\u0901");
        unicodeVector.addElement("\u0902");
        unicodeVector.addElement("\u0903");
        unicodeVector.addElement("\u0904");
        unicodeVector.addElement("\u0905");		//a
        unicodeVector.addElement("\u0906");		//aa
        unicodeVector.addElement("\u0907");		//i
        unicodeVector.addElement("\u0908");		//ii
        unicodeVector.addElement("\u0909");		//u
        unicodeVector.addElement("\u090A");		//U
        unicodeVector.addElement("\u090B");		//vocalic R (ri)
        unicodeVector.addElement("\u090C");		//vocalic L (lri)
        unicodeVector.addElement("\u090D");		//candra E
        unicodeVector.addElement("\u090E");		//short E
        unicodeVector.addElement("\u090F");		//E
        unicodeVector.addElement("\u0910");		//AI
        unicodeVector.addElement("\u0911");		//candra o
        unicodeVector.addElement("\u0912");		//short o
        unicodeVector.addElement("\u0913");		//O
        unicodeVector.addElement("\u0914");		//AU
        unicodeVector.addElement("\u0915");		//ka
        unicodeVector.addElement("\u0916");		//kha
        unicodeVector.addElement("\u0917");		//ga
        unicodeVector.addElement("\u0918");		//gha
        unicodeVector.addElement("\u0919");		//nga
        unicodeVector.addElement("\u091A");		//cha
        unicodeVector.addElement("\u091B");		//chha
        unicodeVector.addElement("\u091C");		//ja
        unicodeVector.addElement("\u091D");		//jha
        unicodeVector.addElement("\u091E");		//nya
        unicodeVector.addElement("\u091F");		//tta
        unicodeVector.addElement("\u0920");		//ttha
        unicodeVector.addElement("\u0921");		//dda
        unicodeVector.addElement("\u0922");		//ddha
        unicodeVector.addElement("\u0923");		//nna
        unicodeVector.addElement("\u0924");		//ta
        unicodeVector.addElement("\u0925");		//tha
        unicodeVector.addElement("\u0926");		//da
        unicodeVector.addElement("\u0927");		//dha
        unicodeVector.addElement("\u0928");		//na
        unicodeVector.addElement("\u0929");		//nna
        unicodeVector.addElement("\u092A");		//pa
        unicodeVector.addElement("\u092B");		//pha
        unicodeVector.addElement("\u092C");		//ba
        unicodeVector.addElement("\u092D");		//bha
        unicodeVector.addElement("\u092E");		//ma
        unicodeVector.addElement("\u092F");		//ya
        unicodeVector.addElement("\u0930");		//ra
        unicodeVector.addElement("\u0931");		//rra
        unicodeVector.addElement("\u0932");		//la
        unicodeVector.addElement("\u0933");		//lla
        unicodeVector.addElement("\u0934");		//llla
        unicodeVector.addElement("\u0935");
        unicodeVector.addElement("\u0936");
        unicodeVector.addElement("\u0937");
        unicodeVector.addElement("\u0938");
        unicodeVector.addElement("\u0939");
        unicodeVector.addElement("\u093C");
        unicodeVector.addElement("\u093D");
        unicodeVector.addElement("\u093E");
        unicodeVector.addElement("\u093F");
        unicodeVector.addElement("\u0940");
        unicodeVector.addElement("\u0941");
        unicodeVector.addElement("\u0942");
        unicodeVector.addElement("\u0943");
        unicodeVector.addElement("\u0944");
        unicodeVector.addElement("\u0945");
        unicodeVector.addElement("\u0946");
        unicodeVector.addElement("\u0947");
        unicodeVector.addElement("\u0948");
        unicodeVector.addElement("\u0949");
        unicodeVector.addElement("\u094A");
        unicodeVector.addElement("\u094B");
        unicodeVector.addElement("\u094C");
        unicodeVector.addElement("\u094D");
        unicodeVector.addElement("\u094E");
        unicodeVector.addElement("\u094F");
        unicodeVector.addElement("\u0950");
        unicodeVector.addElement("\u0951");
        unicodeVector.addElement("\u0952");
        unicodeVector.addElement("\u0953");
        unicodeVector.addElement("\u0954");
        unicodeVector.addElement("\u0958");
        unicodeVector.addElement("\u0959");
    }
    public String getMaping(){
        
        String finalString="";
        char[] distChar;
        distChar=standard.toCharArray();
        for(int i=0; i <distChar.length;i++){
            String key=String.valueOf(distChar[i]);
            String LineSeperator="\t";
            if((i%4)==0){
                LineSeperator="\n";
            }else{
                LineSeperator="\t";
            }
            finalString= finalString + distChar[i] + " = " + format(key) +LineSeperator ;
        }
        return finalString;
    }
}