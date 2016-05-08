public class explain {
    public static String e[][];
    
    public static String parseD(double d){
        String s;
        if(d%1==0){
            s=""+(int)d;
        }else{
            s=""+d;
        }
        return s;
    }
    
    public static String sat_u(double s, double a, double t){
        return e[0][0]+parseD(a)+e[0][1]+parseD(t)+e[0][2]+parseD(s)+e[0][3]+parseD(t)+e[0][4]+solve.sat_u(s, a, t);
    }
    
    public static String sat_v(double s, double a, double t){
        return e[1][0]+parseD(a)+e[1][1]+parseD(t)+e[1][2]+parseD(s)+e[1][3]+parseD(t)+e[1][4]+solve.sat_v(s, a, t);
    }

    public static String sut_v(double s, double u, double t){
        return e[2][0]+parseD(s)+e[2][1]+parseD(t)+e[2][2]+parseD(u)+e[2][3]+solve.sut_v(s, u, t);
    }

    public static String sut_a(double s, double u, double t){
        return e[3][0]+parseD(s)+e[3][1]+parseD(u)+e[3][2]+parseD(t)+e[3][3]+parseD(t)+e[3][4]+solve.sut_a(s, u, t);
    }

    public static String svt_u(double s, double v, double t){
        return e[4][0]+parseD(s)+e[4][1]+parseD(t)+e[4][2]+parseD(v)+e[4][3]+solve.svt_u(s, v, t);
    }

    public static String svt_a(double s, double v, double t){
        System.out.println(e[5][0]);
        return e[5][0]+parseD(v)+e[5][1]+parseD(t)+e[5][2]+parseD(s)+e[5][3]+parseD(t)+e[5][4]+solve.svt_a(s, v, t);
    }

    public static String sua_v(double s, double u, double a){
        return e[6][0]+parseD(u)+e[6][1]+parseD(a)+e[6][2]+parseD(s)+e[6][3]+solve.sua_v(s, u, a);
    }

    public static String sua_t(double s, double u, double a){
        return e[6][0]+parseD(u)+e[6][1]+parseD(a)+e[6][2]+parseD(s)+e[6][3]+solve.sua_v(s, u, a)+"\\\\"+e[17][0]+parseD(Math.sqrt(u*u+2*a*s))+e[17][1]+parseD(u)+e[17][2]+parseD(a)+e[17][3]+solve.uva_t(u, Math.sqrt(u*u+2*a*s), a);
    }

    public static String sva_u(double s, double v, double a){
        return e[8][0]+parseD(v)+e[8][1]+parseD(a)+e[8][2]+parseD(s)+e[8][3]+solve.sva_u(s, v, a);
    }

    public static String sva_t(double s, double v, double a){
        return e[8][0]+parseD(v)+e[8][1]+parseD(a)+e[8][2]+parseD(s)+e[8][3]+solve.sva_u(s, v, a)+"\\\\"+e[17][0]+parseD(v)+e[17][1]+parseD(Math.sqrt(v*v-2*a*s))+e[17][2]+parseD(a)+e[17][3]+solve.uva_t(Math.sqrt(v*v-2*a*s), v, a);
    }

    public static String suv_a(double s, double u, double v){
        return e[10][0]+parseD(v)+e[10][1]+parseD(u)+e[10][2]+parseD(s)+e[10][3]+solve.suv_a(s, u, v);
    }

    public static String suv_t(double s, double u, double v){
        return e[11][0]+parseD(s)+e[11][1]+parseD(u)+e[11][2]+parseD(v)+e[11][3]+solve.suv_t(s, u, v);
    }

    public static String uvt_s(double u, double v, double t){
        return e[12][0]+parseD(u)+e[12][1]+parseD(v)+e[12][2]+parseD(t)+e[12][3]+solve.uvt_s(u, v, t);
    }

    public static String uvt_a(double u, double v, double t){
        return e[13][0]+parseD(v)+e[13][1]+parseD(u)+e[13][2]+parseD(t)+e[13][3]+solve.uvt_a(u, v, t);
    }

    public static String uat_s(double u, double a, double t){
        return e[14][0]+parseD(u)+e[14][1]+parseD(t)+e[14][2]+parseD(a)+e[14][3]+parseD(t)+e[14][4]+solve.uat_s(u, a, t);
    }

    public static String uat_v(double u, double a, double t){
        return e[15][0]+parseD(u)+e[15][1]+parseD(a)+e[15][2]+parseD(t)+e[15][3]+solve.uat_v(u, a, t);
    }

    public static String uva_s(double u, double v, double a){
        return e[16][0]+parseD(v)+e[16][1]+parseD(u)+e[16][2]+parseD(a)+e[16][3]+solve.uva_s(u, v, a);
    }

    public static String uva_t(double u, double v, double a){
        return e[17][0]+parseD(v)+e[17][1]+parseD(u)+e[17][2]+parseD(a)+e[17][3]+solve.uva_t(u, v, a);
    }

    public static String vat_s(double v, double a, double t){
        return e[18][0]+parseD(v)+e[18][1]+parseD(t)+e[18][2]+parseD(a)+e[18][3]+parseD(t)+e[18][4]+solve.vat_s(v, a, t);
    }

    public static String vat_u(double v, double a, double t){
        return e[19][0]+parseD(v)+e[19][1]+parseD(a)+e[19][2]+parseD(t)+e[19][3]+solve.vat_u(v, a, t);
    }
}
