
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, " + args[0]);
        double res = 0.0;
        double [] num = new double[args.length-1];
        for (int i = 2; i < args.length; i++){
            num[i-2] = Double.parseDouble(args[i]);
        }
        switch (args[1]){
            case("1"): {
                res = 5 * Math.pow(num[0], num[3] * num[4]);
                res = res / (num[1] * num[2]);
                res -= Math.sqrt(Math.abs(Math.pow(Math.cos(num[4]),3)));
                System.out.println("Вариант 1 " + "\na = " + num[0] + "\nb = " + num[1] + "\nc = " + num[2] + "\nn = " + num[3] + "\nx = " + num[4]);
            }
            break;
            case ("2"):{
                res = Math.abs(num[2] - num[3]) / Math.pow((1.0 + 2.0*num[2]),num[0]);
                res -= Math.pow(Math.E, Math.sqrt(1.0 + num[1]));
                System.out.println("Вариант 2 " + "\na = " + num[0] + "\nw = " + num[1] + "\nx = " + num[2] + "\ny = " + num[3]);
            }
            break;
            case ("3"):{
                res = Math.sqrt(num[0] + num[1]*num[3] + num[2]*Math.pow(Math.abs(Math.sin(num[3])),1.0/3.0));
                System.out.println("Вариант 3 " + "\na0 = " + num[0] + "\na1 = " + num[1] + "\na2 = " + num[2] + "\nx = " + num[3]);
            }
            break;
            case("4"):{
                res = Math.log10(Math.abs(Math.pow(num[0],7)));
                res += Math.atan(num[1]*num[1]);
                res += Math.PI / Math.sqrt(Math.abs(num[0] + num[1]));
                System.out.println("Вариант 4 " + "\na = " + num[0] + "\nx = " + num[1]);
            }
            break;
            case("5"):{
                res = Math.pow((num[0] + num[1]),2) / (num[2] + num[3]);
                res += Math.pow(Math.E, Math.sqrt(num[4] + 1));
                res = Math.pow(res,1.0/5.0);
                System.out.println("Вариант 5 " + "\na = " + num[0] + "\nb = " + num[1] + "\nc = " + num[2] + "\nd = " + num[3] + "\nx = " + num[4]);
            }
            break;
            case("6"):{
                double a = (2.0*Math.sin(4*num[0]) + Math.pow(Math.cos(num[0]*num[0]),2));
                a = a / (3.0*num[0]);
                res = Math.pow(Math.E, a);
                System.out.println("Вариант 6 " + "\nx = " + num[0]);
            }
            break;
            case ("7"):{
                res = 0.25 * (((1 + Math.pow(num[0],2)) / (1 - num[0])) + 0.5*Math.tan(num[0]));
                System.out.println("Вариант 7 " + "\nx = " + num[0]);
            }
            break;
        }
        System.out.println("Результат: " + res);
    }
}

