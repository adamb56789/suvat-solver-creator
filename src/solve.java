public class solve {
    
        public static String sat_u(double s, double a, double t){
            double d=-(.5*a*t*t-s)/t;
            return "= "+d;
        }
        
        public static String sat_v(double s, double a, double t){
            double d=(.5*a*t*t-s)/t;
            return "= "+d;
        }
        
        public static String sut_v(double s, double u, double t){
            double d=2*(s/t)-u;
            return "= "+d;
        }
        
        public static String sut_a(double s, double u, double t){
            double d=2*((s-u*t)/(t*t));
            return "= "+d;
        }
        
        public static String svt_u(double s, double v, double t){
            double d=2*(s/t)-v;
            return "= "+d;
        }
        
        public static String svt_a(double s, double v, double t){
            double d=2*((v*t-s)/(t*t));
            return "= "+d;
        }
        
        public static String sua_v(double s, double u, double a){
            double d=Math.sqrt(u*u+2*a*s);
            if(Double.isNaN(d)){
                return "=\\mathrm{No\\ real\\ solution\\\\ square\\ root\\ of\\ a\\ negative}";
            }else{
                return "= "+d;
            }
        }
        
        public static String sua_t(double s, double u, double a){
            double d=((Math.sqrt(u*u+2*a*s))-u)/a;
            if(Double.isNaN(d)){
                return "=\\mathrm{No\\ real\\ solution\\\\ square\\ root\\ of\\ a\\ negative}";
            }else{
                return "= "+d;
            }
        }
        
        public static String sva_u(double s, double v, double a){
            double d=Math.sqrt(v*v-2*a*s);
            if(Double.isNaN(d)){
                return "=\\mathrm{No\\ real\\ solution\\\\ square\\ root\\ of\\ a\\ negative}";
            }else{
                return "= "+d;
            }
        }
        
        public static String sva_t(double s, double v, double a){
            double d=((Math.sqrt(v*v+2*a*s))-v)/a;
            if(Double.isNaN(d)){
                return "=\\mathrm{No\\ real\\ solution\\\\ square\\ root\\ of\\ a\\ negative}";
            }else{
                return "= "+d;
            }
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
            double d=u*t+.5*a*t*t;
            return "= "+d;
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
            double d=v*t-.5*a*t*t;
            return "= "+d;
        }
        
        public static String vat_u(double v, double a, double t){
            double d=v-a*t;
            return "= "+d;
        }
}
