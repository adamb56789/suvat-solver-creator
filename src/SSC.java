import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


public class SSC extends JFrame implements KeyListener{
    private final Interface draw;
    public static String[][] input;
    public static int[] length;
    public static String highlighted = ""; //"s", "u", "v", "a", "t", " ",
    public static String createHighlighted = ""; //"q", "n"
    public static String[][] createInput;
    public static int[] createLength;
    public static int decimalPlaces = 0;
    public static double G;
    public static String gravity[];
    public static int GNum = 0;
    public static double FT = 42.42*42.42*42.42*42.42;
    public static String latex = "\\textrm{Solutions\\ will\\ appear\\ here.}";
    public static String find = "";
    public static String version = "0.4";
    public static String docName = "";
    public static String docNameA = "";
    public static boolean[] includeQuestions;
    public static boolean[] difficulties;
    public static boolean makeAnswers = true;
    public static boolean solveMode = true;
    

    @Override
    public void keyPressed(KeyEvent e) {
        if (solveMode) {
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                switch (highlighted) {
                    case "":                        
                        break;
                    case "s":
                        if (length[0] != 0) {
                            input[0][length[0] - 1] = null;
                            length[0]--;
                        }
                        break;
                    case "u":
                        if (length[1] != 0) {
                            input[1][length[1] - 1] = null;
                            length[1]--;
                        }
                        break;
                    case "v":
                        if (length[2] != 0) {
                            input[2][length[2] - 1] = null;
                            length[2]--;
                        }
                        break;
                    case "a":
                        if (length[3] != 0) {
                            input[3][length[3] - 1] = null;
                            length[3]--;
                        }
                        break;
                    case "t":
                        if (length[4] != 0) {
                            input[4][length[4] - 1] = null;
                            length[4]--;
                        }
                        break;
                }
            }
            
            if (e.getKeyCode() == KeyEvent.VK_TAB) {
                if (solveMode) {
                    switch (highlighted) {
                        case "":                            
                            break;
                        case "s":
                            highlighted = "u";
                            break;
                        case "u":
                            highlighted = "v";
                            break;
                        case "v":
                            highlighted = "a";
                            break;
                        case "a":
                            highlighted = "t";
                            break;
                        case "t":
                            highlighted = "s";
                            break;
                    }
                }
            }
        }else{//Create mode
            if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                switch(createHighlighted){
                    case "":
                        break;
                    case "q":
                        if (createLength[0] != 0) {
                            createInput[0][createLength[0] - 1] = null;
                            createLength[0]--;
                        }
                        break;
                    case "n":
                        if (createLength[1] != 0) {
                            createInput[1][createLength[1] - 1] = null;
                            createLength[1]--;
                        }
                        break;
                }
            }
            if(e.getKeyCode()==KeyEvent.VK_SPACE){
                switch(createHighlighted){
                    case "":
                        break;
                    case "q":
                        createInput[0][createLength[0]] = " ";
                        createLength[0]++;
                        break;
                    case "n":
                        createInput[1][createLength[1]] = " ";
                        createLength[1]++;
                        break;
                }
            }
        }
        repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {
        
        if (solveMode) {
            if (!isN(e.getKeyChar())) {
                return;
            }
            switch (highlighted) {
                case "":                    
                    break;
                case "s":
                    input[0][length[0]] = "" + e.getKeyChar();
                    length[0]++;
                    break;
                case "u":
                    input[1][length[1]] = "" + e.getKeyChar();
                    length[1]++;
                    break;
                case "v":
                    input[2][length[2]] = "" + e.getKeyChar();
                    length[2]++;
                    break;
                case "a":
                    input[3][length[3]] = "" + e.getKeyChar();
                    length[3]++;
                    break;
                case "t":
                    input[4][length[4]] = "" + e.getKeyChar();
                    length[4]++;
                    break;
            }
        }else{//Create mode
            if(Character.isLetterOrDigit(e.getKeyChar())){
                switch(createHighlighted){
                    case "":
                        break;
                    case "q":
                        createInput[0][createLength[0]] = "" + e.getKeyChar();
                        createLength[0]++;
                        break;
                    case "n":
                        createInput[1][createLength[1]] = "" + e.getKeyChar();
                        createLength[1]++;
                        break;
                }
            }
        }      
        repaint();
    }

    public SSC(){
        this.draw=new Interface();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public static void main(String[] args) {
        input = new String[5][15];
        createInput = new String[2][64];
        createInput[0][0]="1";
        createInput[0][1]="6";
        length = new int[5];
        createLength = new int[2];
        createLength[0]=2;
        includeQuestions = new boolean[20];
        includeQuestions = allTrue(includeQuestions);
        difficulties = new boolean[2];
        difficulties = allTrue(difficulties);
        gravity = new String[7];
        gravity[0] = "Earth (9.81)";
        gravity[1] = "10";
        gravity[2] = "Mars (3.75)";
        gravity[3] = "Jupiter (26)";
        gravity[4] = "Moon (1.62)";
        gravity[5] = "Sun (273)";
        gravity[6] = "Pluto (0.62)";
        createInput[1][0]="Untitled Document "+explain.parseD(RNG(0,999999,0));
        createLength[1]=1;
        InOut.getExplanations();
        javax.swing.SwingUtilities.invokeLater(() -> {
            SSC frame = new SSC();
            frame.setTitle("Suvat Solver Creator "+version);
            frame.setResizable(false);
            frame.setSize(1300, 750);
            frame.setMinimumSize(new Dimension(1300, 750));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(frame.draw);
            frame.pack();
            frame.setLocationRelativeTo(frame);
            frame.setVisible(true);
            frame.getContentPane().setBackground(Color.decode("#F3F3F3"));
        });
    }
    
    public static boolean over(int x1, int x2, int y1, int y2, int x, int y){
        return x1-1<x&&x<x2&&y1-1<y&&y<y2;
    }
    
    public static boolean containsData(String[] array){
        for (String array1 : array) {
            if (array1 != null) {
                return true;
            }
        }
        return false;
    }
    
    public static void reset(String[] array){
      int len = array.length;

      if (len > 0){
        array[0] = null;
      }

      for (int i = 1; i < len; i += i) 
      {
        System.arraycopy(array, 0, array, i, ((len - i) < i) ? (len - i) : i);
      }
}
    
    public static void resetInput(){
        for(int i=0;i<5;i++){
            reset(input[i]);
        }
    }
    
    public static void resetLength(){
        for(int i=0;i<5;i++){
            length[i]=0;
        }
    }
    
    public static boolean[] allTrue(boolean[] array){
        for(int i=0;i<array.length;i++){
            array[i]=true;
        }
        return array;
    }
    
    public static boolean[] allFalse(boolean[] array){
        for(int i=0;i<array.length;i++){
            array[i]=false;
        }
        return array;
    }
    
    public static int nNotNull(String[] s){
        int a=0;
        while(true){
            if(s[a]==null){
                return a;
            }
            a++;
        }
    }
    
    public static String arrayToString(String[] array){
        String string="";
        for(int i=0;i<nNotNull(array);i++){
            string+=array[i];
        }
        return string;
    }
    
    public static boolean isN(char c){
        switch (c) {
            case '0':
                return true;
            case '1':
                return true;
            case '2':
                return true;
            case '3':
                return true;
            case '4':
                return true;
            case '5':
                return true;
            case '6':
                return true;
            case '7':
                return true;
            case '8':
                return true;
            case '9':
                return true;
            case '.':
                return true;
            case '-':
                return true;
            default:
                break;
        }
        return false;
    }
    
    public static int swap(int a){
        return (int) Math.pow(a-1,2);
    }
    
    public static double RNG(int min, int max,int decimals){
        if(min==42){//If a value not used
            return FT;
        }
        if(max==69){//If value is set
            return min;
        }
        //If G is used, also add 8024 in the max spot
        String f;
        if(decimalPlaces==0){
            f="#";
        }else{
            f="#.";
            for(int i=0;i<decimalPlaces;i++){
                f+="#";
            }
        }
        DecimalFormat df = new DecimalFormat(f);
        return Double.parseDouble(df.format(ThreadLocalRandom.current().nextDouble(min, max)));
    }
    
    public static int[][] resetBans(int[][] bans, int EorH){
        int NBans=0;
        for(int i=0;i<30;i++){
            bans[EorH][i]=0;
        }
        for(int i=0;i<20;i++){
            if(!includeQuestions[i]){
                bans[0][NBans]=i;
                bans[1][NBans]=i;
                NBans++;
            }
        }
        for(int i=0;i<20;i+=2){
            if(!includeQuestions[i] || !includeQuestions[i+1]){
                bans[0][NBans]=20+i/2;
                bans[1][NBans]=20+i/2;
                NBans++;
            }
        }
        return bans;
    }
    
    public static String solve(){
        InOut.getExplanations();
        //Getting the list of entered values
        String m="";
        for(int i=0;i<5;i++){
            if(containsData(input[i])){
                switch(i){
                    case 0: m+="s";
                        break;
                    case 1: m+="u";
                        break;
                    case 2: m+="v";
                        break;
                    case 3: m+="a";
                        break;
                    case 4: m+="t";
                        break;
                }
            }
        }

        //Checking too see if valid data was entered
        if(m.length()!=3||find.equals("")){
            return "Make\\ sure\\ that\\ you\\ have\\ entered\\ information\\\\into\\ exactly\\ three\\ boxes,\\ and\\ that\\ you\\ have\\\\selected\\ a\\ value\\ that\\ is\\ not\\ already\\ known";
        }
        for(int i=0;i<m.length();i++){
            if(m.charAt(i)==find.charAt(0)){
                return "Make\\ sure\\ that\\ you\\ have\\ entered\\ information\\\\into\\ exactly\\ three\\ boxes,\\ and\\ that\\ you\\ have\\\\selected\\ a\\ value\\ that\\ is\\ not\\ already\\ known";
            }
        }
        
        //Turning the input array into numbers
        double s=0;
        double u=0;
        double v=0;
        double a=0;
        double t=0;
        String[] merged={"","","","",""};
        for (int i=0;i<5;i++) {
            if (containsData(input[i])) {
                for (int j = 0; j < nNotNull(input[i]); j++) {
                    merged[i] += input[i][j];
                }
            }
        }
        try {
            if (!"".equals(merged[0])) {
                s = Double.parseDouble(merged[0]);
            }
            if (!"".equals(merged[1])) {
                u = Double.parseDouble(merged[1]);
            }
            if (!"".equals(merged[2])) {
                v = Double.parseDouble(merged[2]);
            }
            if (!"".equals(merged[3])) {
                a = Double.parseDouble(merged[3]);
            }
            if (!"".equals(merged[4])) {
                t = Double.parseDouble(merged[4]);
            }
        } catch (NumberFormatException numberFormatException) {return "Make\\ sure\\ that\\ you\\\\ have\\ only\\ entered\\ numbers.";}
        
        //send the values to the approriate solve method, and return the solution
        switch(m){
            case "sat": if("u".equals(find)){return explain.sat_u(s,a,t);}else if("v".equals(find)){return explain.sat_v(s,a,t);}else{return "Error";}
            case "sut": if("v".equals(find)){return explain.sut_v(s,u,t);}else if("a".equals(find)){return explain.sut_a(s,u,t);}else{return "Error";}
            case "svt": if("u".equals(find)){return explain.svt_u(s,v,t);}else if("a".equals(find)){return explain.svt_a(s,v,t);}else{return "Error";}
            case "sua": if("v".equals(find)){return explain.sua_v(s,u,a);}else if("t".equals(find)){return explain.sua_t(s,u,a);}else{return "Error";}
            case "sva": if("u".equals(find)){return explain.sva_u(s,v,a);}else if("t".equals(find)){return explain.sva_t(s,v,a);}else{return "Error";}
            case "suv": if("a".equals(find)){return explain.suv_a(s,u,v);}else if("t".equals(find)){return explain.suv_t(s,u,v);}else{return "Error";}
            case "uvt": if("s".equals(find)){return explain.uvt_s(u,v,t);}else if("a".equals(find)){return explain.uvt_a(u,v,t);}else{return "Error";}
            case "uat": if("s".equals(find)){return explain.uat_s(u,a,t);}else if("v".equals(find)){return explain.uat_v(u,a,t);}else{return "Error";}
            case "uva": if("s".equals(find)){return explain.uva_s(u,v,a);}else if("t".equals(find)){return explain.uva_t(u,v,a);}else{return "Error";}
            case "vat": if("s".equals(find)){return explain.vat_s(v,a,t);}else if("u".equals(find)){return explain.vat_u(v,a,t);}else{return "Error";}
        }
        return "Error";
    }
    
    public static String create(){
        int foobar=0;
        for(int i=0;i<20;i++){
            if(includeQuestions[i]){
                foobar++;
            }
        }
        if(foobar==0){
            return "\\textrm{Make\\ sure\\ that\\ you\\ have\\ selected\\\\at\\ least\\ one\\ question\\ type.}";
        }
        if(containsData(createInput[1])){
            docName=arrayToString(createInput[1]);
        }else{
            docName="Untitled Document";
        }
        switch (GNum) {
            case 0:
                G=9.81;
                break;
            case 1:
                G=10;
                break;
            case 2:
                G=3.75;
                break;
            case 3:
                G=26;
                break;
            case 4:
                G=1.62;
                break;
            case 5:
                G=273;
                break;
            case 6:
                G=0.62;
                break;
            default:
                break;
        }
        int NQuestions=Integer.parseInt(arrayToString(createInput[0]));
        String[][][][] r=InOut.getResources();
        int[][] rng=new int[NQuestions][2];
        double[][] rngD=new double[NQuestions][3];
        int[][] bans=new int[2][30];
        int[] NBans=new int[2];
        int NPermabans=0;
        
        for(int i=0;i<20;i++){
            if(!includeQuestions[i]){
                NPermabans++;
            }
        }
        for(int i=0;i<20;i+=2){
            if(!includeQuestions[i] || !includeQuestions[i+1]){
                NPermabans++;
            }
        }

        bans=resetBans(bans,0);
        bans=resetBans(bans,1);
        NBans[0]=NPermabans;
        NBans[1]=NPermabans;
        
        for(int i=0;i<NQuestions;i++){
            if(difficulties[0]&&!difficulties[1]){
                rng[i][0]=0;
            }else if(difficulties[1]&&!difficulties[0]){
                rng[i][0]=1;
            }else{
                if(i<NQuestions/2){
                    rng[i][0]=0;
                }else{
                    rng[i][0]=1;
                }
            }
            
            int EorH;
            
            if(rng[i][0]==0){
                EorH=0;
            }else{
                EorH=1;
            }
            
            boolean temp=true;
            int n=0;
            
            while(temp){
                n=(int) RNG(0,29,0);
                temp=false;
                for(int j=0;j<NBans[EorH];j++){
                    if(n==bans[EorH][j]){
                        temp=true;
                    }
                }
            }
            
            rng[i][1]=n;
            bans[EorH][NBans[EorH]]=n;
            NBans[EorH]++;
            
            if(NBans[EorH]==30){
                NBans[EorH]=NPermabans;
                bans=resetBans(bans,EorH);
            }
            rngD[i][0]=RNG(Integer.parseInt(r[0][rng[i][0]][rng[i][1]][5]),Integer.parseInt(r[0][rng[i][0]][rng[i][1]][6]),decimalPlaces);
            rngD[i][1]=RNG(Integer.parseInt(r[0][rng[i][0]][rng[i][1]][7]),Integer.parseInt(r[0][rng[i][0]][rng[i][1]][8]),decimalPlaces);
            rngD[i][2]=RNG(Integer.parseInt(r[0][rng[i][0]][rng[i][1]][9]),Integer.parseInt(r[0][rng[i][0]][rng[i][1]][10]),decimalPlaces);
        }
        
        String[][] rngDS=new String[NQuestions][3];
        if(decimalPlaces==0){
            for(int i=0;i<NQuestions;i++){
                rngDS[i][0]=(int)rngD[i][0]+"";
                rngDS[i][1]=(int)rngD[i][1]+"";
                rngDS[i][2]=(int)rngD[i][2]+"";
            }
        }else{
            for(int i=0;i<NQuestions;i++){
                rngDS[i][0]=rngD[i][0]+"";
                rngDS[i][1]=rngD[i][1]+"";
                rngDS[i][2]=rngD[i][2]+"";
            }
        }
        
        //Set to blank if not needed (RNG should have returned FT)
        for(int i=0;i<NQuestions;i++){
            for(int j=0;j<3;j++){
                if(rngD[i][j]==FT){
                    rngDS[i][j]="";
                }
            }
        }
        
        for(int i=0;i<NQuestions;i++){
            System.out.println(Arrays.deepToString(rngDS));
            String question=i+1+". ";
            question+=r[0][rng[i][0]][rng[i][1]][1];
            question+=rngDS[i][0];
            question+=r[0][rng[i][0]][rng[i][1]][2];
            question+=rngDS[i][1];
            question+=r[0][rng[i][0]][rng[i][1]][3];
            question+=rngDS[i][2];
            question+=r[0][rng[i][0]][rng[i][1]][4];
            if("1".equals(r[0][rng[i][0]][rng[i][1]][0])){
                question+=G;
            }
            
            //The final writing
            InOut.write(docName, question);
            InOut.write(docName, "");
        }
        
        //Answers document
        if(makeAnswers){
            docNameA=docName+" - Answers";
            for(int i=0;i<NQuestions;i++){
                
                //Display the question
                String question=i+1+". ";
                question+=r[0][rng[i][0]][rng[i][1]][1];
                question+=rngDS[i][0];
                question+=r[0][rng[i][0]][rng[i][1]][2];
                question+=rngDS[i][1];
                question+=r[0][rng[i][0]][rng[i][1]][3];
                question+=rngDS[i][2];
                question+=r[0][rng[i][0]][rng[i][1]][4];
                if("1".equals(r[0][rng[i][0]][rng[i][1]][0])){
                    question+=G;
                }
                
//                if("1".equals(r[0][rng[i][0]][rng[i][1]][0])){
//                    rngDS[i][2]=G+"";
//                }
                //Display the explanation
                String explain=r[1][rng[i][0]][rng[i][1]][0];
                explain+=rngDS[i][0];
                explain+=r[1][rng[i][0]][rng[i][1]][1];
                explain+=rngDS[i][1];
                explain+=r[1][rng[i][0]][rng[i][1]][2];
                explain+=rngDS[i][2];
                explain+=r[1][rng[i][0]][rng[i][1]][3];
                
                //Solution(s)
                System.out.println(Arrays.deepToString(rngD));
                System.out.println(Arrays.deepToString(rngDS));
                for(int j=0;j<3;j++){
                    if(rngD[i][j]==FT){
                        System.out.println("J");
                        if("8024".equals(r[0][rng[i][0]][rng[i][1]][6+(2*j)])){
                            rngD[i][j]=G;
                            System.out.println(Arrays.deepToString(rngD));
                            System.out.println(Arrays.deepToString(rngDS));
                            rngDS[i][j]=G+"";
                        }else{
                            rngD[i][j]=Double.parseDouble(r[0][rng[i][0]][rng[i][1]][6+(2*j)]);
                            rngDS[i][j]=r[0][rng[i][0]][rng[i][1]][6+(2*j)];
                        }
                    }
                }
                System.out.println(Arrays.deepToString(rngD));
                System.out.println(Arrays.deepToString(rngDS));
                String[][] v={{"S = ","U = ","V = ","A = ","T = "},{"?","?","?","?","?"},{" m"," m/s"," m/s"," m/s/s"," s"}};
                String nv="";
                String S="Solution: ";
                switch(rng[i][1]){
                    case 20 : S+="u "+solve.sat_u(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s and v = "+solve.sat_v(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s";nv="sat";
                        break;
                    case 21 : S+="v "+solve.sut_v(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s and a "+solve.sut_a(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s/s";nv="sut";
                        break;
                    case 22 : S+="u "+solve.svt_u(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s and a "+solve.svt_a(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s/s";nv="svt";
                        break;
                    case 23 : S+="v "+solve.sua_v(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s and t "+solve.sua_t(rngD[i][0], rngD[i][1], rngD[i][2])+" s";nv="sua";
                        break;
                    case 24 : S+="u "+solve.sva_u(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s and t "+solve.sva_t(rngD[i][0], rngD[i][1], rngD[i][2])+" s";nv="sva";
                        break;
                    case 25 : S+="a "+solve.suv_a(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s/s and t "+solve.suv_t(rngD[i][0], rngD[i][1], rngD[i][2])+" s";nv="suv";
                        break;
                    case 26 : S+="a "+solve.uvt_a(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s/s and s "+solve.uvt_s(rngD[i][0], rngD[i][1], rngD[i][2])+" m";nv="uvt";
                        break;
                    case 27 : S+="s "+solve.uat_s(rngD[i][0], rngD[i][1], rngD[i][2])+" m and v "+solve.uat_v(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s";nv="uat";
                        break;
                    case 28 : S+="s "+solve.uva_s(rngD[i][0], rngD[i][1], rngD[i][2])+" m and t "+solve.uva_t(rngD[i][0], rngD[i][1], rngD[i][2])+" s";nv="uva";
                        break;
                    case 29 : S+="s "+solve.vat_s(rngD[i][0], rngD[i][1], rngD[i][2])+" m and u "+solve.vat_u(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s";nv="vat";
                        break;
                    case 0: S+="u "+solve.sat_u(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s";nv="sat";
                        break;
                    case 1: S+="v "+solve.sat_v(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s";nv="sat";
                        break;
                    case 2: S+="v "+solve.sut_v(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s";nv="sut";
                        break;
                    case 3: S+="a "+solve.sut_a(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s/s";nv="sut";
                        break;
                    case 4: S+="u "+solve.svt_u(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s";nv="svt";
                        break;
                    case 5: S+="a "+solve.svt_a(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s/s";nv="svt";
                        break;
                    case 6: S+="v "+solve.sua_v(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s";nv="sua";
                        break;
                    case 7: S+="t "+solve.sua_t(rngD[i][0], rngD[i][1], rngD[i][2])+" s";nv="sua";
                        break;
                    case 8: S+="u "+solve.sva_u(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s";nv="sva";
                        break;
                    case 9: S+="t "+solve.sva_t(rngD[i][0], rngD[i][1], rngD[i][2])+" s";nv="sva";
                        break;
                    case 10: S+="a "+solve.suv_a(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s/s";nv="suv";
                        break;
                    case 11: S+="t "+solve.suv_t(rngD[i][0], rngD[i][1], rngD[i][2])+" s";nv="suv";
                        break;
                    case 12: S+="s "+solve.uvt_s(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s/s";nv="uvt";
                        break;
                    case 13: S+="a "+solve.uvt_a(rngD[i][0], rngD[i][1], rngD[i][2])+" m";nv="uvt";
                        break;
                    case 14: S+="s "+solve.uat_s(rngD[i][0], rngD[i][1], rngD[i][2])+" m";nv="uat";
                        break;
                    case 15: S+="v "+solve.uat_v(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s";nv="uat";
                        break;
                    case 16: S+="s "+solve.uva_s(rngD[i][0], rngD[i][1], rngD[i][2])+" m";nv="uva";
                        break;
                    case 17: S+="t "+solve.uva_t(rngD[i][0], rngD[i][1], rngD[i][2])+" s";nv="uva";
                        break;
                    case 18: S+="s "+solve.vat_s(rngD[i][0], rngD[i][1], rngD[i][2])+" m";nv="vat";
                        break;
                    case 19: S+="u "+solve.vat_u(rngD[i][0], rngD[i][1], rngD[i][2])+" m/s";nv="vat";
                        break;
                }
                
                for(int j=0;j<3;j++){
                    switch(nv.charAt(j)){
                        case 's':v[1][0]=rngDS[i][j];
                            break;
                        case 'u':v[1][1]=rngDS[i][j];
                            break;
                        case 'v':v[1][2]=rngDS[i][j];
                            break;
                        case 'a':v[1][3]=rngDS[i][j];
                            break;
                        case 't':v[1][4]=rngDS[i][j];
                            break;
                    }
                }
                
                InOut.write(docNameA,question);
                InOut.write(docNameA,"");
                InOut.write(docNameA,explain);
                InOut.write(docNameA,"");
                for(int j=0;j<5;j++){
                    InOut.write(docNameA,v[0][j]+v[1][j]+v[2][j]);
                }
                InOut.write(docNameA,"");
                InOut.write(docNameA,S);
                InOut.write(docNameA,"_____________________________________________________________________");
                InOut.write(docNameA,"");
            }
        }
        return "\\textrm{Document(s)\\ created.}";
    }
}
