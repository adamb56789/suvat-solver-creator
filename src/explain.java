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
        double d=2*(s/t)-u;
        return "= "+d;
    }

    public static String sut_a(double s, double u, double t){
        return e[3][0]+parseD(s)+e[3][1]+parseD(u)+e[3][2]+parseD(t)+e[3][3]+parseD(t)+e[3][4]+solve.sut_a(s, u, t);
    }

    public static String svt_u(double s, double v, double t){
        double d=2*(s/t)-v;
        return "= "+d;
    }

    public static String svt_a(double s, double v, double t){
        return e[5][0]+parseD(v)+e[5][1]+parseD(t)+e[5][2]+parseD(s)+e[5][3]+parseD(t)+e[5][4]+solve.svt_a(s, v, t);
    }

    public static String sua_v(double s, double u, double a){
        double d=Math.sqrt(u*u+2*a*s);
        return "= "+d;
    }

    public static String sua_t(double s, double u, double a){
        double d=((Math.sqrt(u*u+2*a*s))-u)/a;
        return "= "+d;
    }

    public static String sva_u(double s, double v, double a){
        double d=Math.sqrt(v*v+2*a*s);
        return "= "+d;
    }

    public static String sva_t(double s, double v, double a){
        double d=((Math.sqrt(v*v+2*a*s))-v)/a;
        return "= "+d;
    }

    public static String suv_a(double s, double u, double v){
        double d=((v*v)-(u*u))/(2*s);
        return "= "+d;
    }

    public static String suv_t(double s, double u, double v){
        double d=s/(.5*(u+v));
        return "= "+d;
    }

    public static String uvt_s(double u, double v, double t){
        double d=.5*t*(u+v);
        return "= "+d;
    }

    public static String uvt_a(double u, double v, double t){
        double d=(v-u)/t;
        return "= "+d;
    }

    public static String uat_s(double u, double a, double t){
        return e[14][0]+parseD(u)+e[14][1]+parseD(t)+e[14][2]+parseD(a)+e[14][3]+parseD(t)+e[14][4]+solve.uat_s(u, a, t);
    }

    public static String uat_v(double u, double a, double t){
        double d=u+a*t;
        return "= "+d;
    }

    public static String uva_s(double u, double v, double a){
        double d=((v*v)-(u*u))/(2*a);
        return "= "+d;
    }

    public static String uva_t(double u, double v, double a){
        double d=(v-u)/a;
        return "= "+d;
    }

    public static String vat_s(double v, double a, double t){
        return e[18][0]+parseD(v)+e[18][1]+parseD(t)+e[18][2]+parseD(a)+e[18][3]+parseD(t)+e[18][4]+solve.vat_s(v, a, t);
    }

    public static String vat_u(double v, double a, double t){
        double d=v-a*t;
        return "= "+d;
    }
}
