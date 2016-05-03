
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class InOut {
    public static void write(String n, String s){
        //Add the string on to the end of document n
        String name ="Created Documents/"+n+".txt";
        if(s.equals("")){
            System.out.println("¶");
        }else{
            System.out.println("Writing \""+s+"\" to \""+n+"\"");
        }
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(name, true)))) {
            out.println(s);
        }catch (IOException e) {}
    }
    
    //includesG text text text text min max min max min max
    //placeHolder text text text text
    public static String[][][][] getResources(){
        String[][][][] data=new String[2][2][30][11];
        
        try{
            FileReader fR = new FileReader("Resources/Questions.txt");
            try (BufferedReader bR = new BufferedReader(fR)) {
                for(int i=0;i<2;i++){
                    for(int j=0;j<2;j++){
                        for(int k=0;k<30;k++){
                            for(int l=0;l<11;l++){
                                data[i][j][k][l]=bR.readLine();
                            }
                        }
                    }
                }
            }
        }catch(Exception e){}
        
        return data;
    }
    
    //text (n) text (n) text (n) text (n) text (n)
    public static void getExplanations(){
        String[][] data=new String[20][5];
            try{
            FileReader fR = new FileReader("Resources/Explanations.PFNE");
            try (BufferedReader bR = new BufferedReader(fR)) {
                for(int i=0;i<20;i++){
                    for(int j=0;j<5;j++){
                        data[i][j]=bR.readLine();
                    }
                }
            }
        }catch(Exception e){}
        explain.e=data;
    }

}
