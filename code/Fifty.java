public class Fifty {
//    public double myPow(double x, int n) {
//        return Math.pow(x,n);
//    }
    public double myPow(double x, int m) {
        double temp=x;
        if(m==0)
            return 1;
        temp=myPow(x,m/2);
        if(m%2==0)
            return temp*temp;
        else
        {
            if(m > 0)
                return x*temp*temp;
            else
                return (temp*temp)/x;
        }
    }

    public static void main(String[] args) {
        Fifty fifty = new Fifty();
        System.out.println(fifty.myPow(2, Integer.MAX_VALUE));
        System.out.println(2*Double.POSITIVE_INFINITY);
    }
}
