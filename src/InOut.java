public class InOut {
    public static void createTXT(){
        //Create a text document
    }
    public static void write(String s){
        //Add the string on to the end of the document
        System.out.println(s);
    }
    
    //includesG text text text text min max min max min max
    public static String[][][][] getResources(){
        String[][][][] data;
        data = new String[2][2][30][11];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<30;k++){
                    data[i][j][k][1]="1";
                    for(int l=1;l<5;l++){
                        data[i][j][k][l]="A";
                    }
                    for(int l=5;l<11;l++){
                        data[i][j][k][l]="0";
                    }
                }
            }
        }
        return data;
    }
}
