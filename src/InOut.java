public class InOut {
    public static void createTXT(String n){
        //Create a text document called n
        System.out.println("\""+n+"\" created");
    }
    public static void write(String n, String s){
        //Add the string on to the end of document n
        if(s.equals("")){
            System.out.println("¶");
        }else{
            System.out.println("Writing \""+s+"\" to \""+n+"\"");
        }
    }
    
    //includesG text text text text min max min max min max
    //placeHolder text text text text
    public static String[][][][] getResources(){
        String[][][][] data=new String[2][2][30][11];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<30;k++){
                    data[i][j][k][0]="1";
                    data[i][j][k][1]="A";
                    data[i][j][k][2]="B";
                    data[i][j][k][3]="C";
                    data[i][j][k][4]="D";
                    data[i][j][k][5]="0";
                    data[i][j][k][6]="10";
                    data[i][j][k][7]="0";
                    data[i][j][k][8]="10";
                    data[i][j][k][9]="0";
                    data[i][j][k][10]="10";
                }
            }
        }
        return data;
    }
    
    public static String[] getExplanations(){
        String[] data=new String[20];
        for(int i=0;i<20;i++){
            data[i]="A";
        }
        return data;
    }
}
