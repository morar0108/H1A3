package main.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //wir lesen von den Tastatur die Zahlen
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter length of arrays: ");
        n = s.nextInt();
        int[] m = new int[n];
        System.out.println("Enter elements of the first array: ");
        for (int i = 0; i < n; i++) {
            m[i] = s.nextInt();
        }
        int[] p = new int[n];
        System.out.println("Enter elements of the second array: ");
        for (int i = 0; i < n; i++) {
            p[i] = s.nextInt();
        }
        System.out.println(pr1(m, p, n));
        System.out.println(pr2(m,p,n));
        System.out.println(pr3(m,n,9));
        System.out.println(pr4(m, n, 9));
    }
    
    //Es gibt 2 große Zahlen. Die Zahlen sind als Array dargestellt.

    //1. Summe der Ziffern des Arrays: [1 3 0 0 0 0 0 0 0] + [8 7 0 0 0 0 0 0 0] = [1 0 0 0 0 0 0 0 0 0]
    private static int pr1(int[] a, int[] b, int size_of_arrays){
        int[] c = new int[size_of_arrays+1]; //wir initialisieren einen neuen Array fur das Ergebnis mit eine Stelle grosser
        int sem=0; //wir durchlaufen die Ziffern vom Ende zu Anfang und addieren sie und wenn eine grosser als 9 ist, dann addieren wir zu der nachsten Summe +1
        for(int i=size_of_arrays-1; i>=0; i--){
            int x = a[i] + b[i];
            if(sem==1)
            {
                x+=1;
            }
            if(x>9)
            {
                c[i+1] = x%10;
                sem=1;
            }
            else
            {
                c[i+1] = x;
                sem=0;
            }
        }
        System.out.println("Sum of array: ");

        //wenn auch die letzte Summe >9 ist, dann ist auf die erste Stelle einen 1
        if(sem == 1) {
            c[0] = 1;
            System.out.println(Arrays.toString(c));
        }
        else //wenn die letzte Summe <9 ist, dann kopieren wir den neuen array ohne den zusatzlichen allokierter Speicherplatz 
        {
            int[] newarray = Arrays.copyOfRange(c, 1, size_of_arrays+1);
            System.out.println(Arrays.toString(newarray));
        }

        System.out.println();
        return c.length;
    }

    //2. Differenz der Ziffern des Arrays. z.B. [8 3 0 0 0 0 0 0 0] [5 4 0 0 0 0 0 0 0] = [2 9 0 0 0 0 0 0 0]
    private static int pr2(int[] a, int[] b, int size_of_arrays){
        int[] c = new int[size_of_arrays];
        int ok=0;
        for(int i=size_of_arrays-1; i>=0; i--){
            int x = a[i] - b[i];
            if(ok==1)
            {
                x-=1;
            }
            if(x<0)
            {
                c[i] = 10+x;
                ok=1;
            }
            else
            {
                c[i] = x;
                ok=0;
            }
        }
        System.out.println("Dif of array: ");
        for(int i: c) {
            System.out.print(" " + i);
        }
        //wir zahlen wie viele leere Platze wir haben und losen diese danach
        int anzahl_unbesetzte_Platze=0;
        for(int i:c){
            if(i==0){
                anzahl_unbesetzte_Platze++;
            }
            else {
                break;
            }
        }

        int[] newarray = Arrays.copyOfRange(c, anzahl_unbesetzte_Platze, size_of_arrays);
        System.out.println();
        return newarray.length;
    }

    //3. Berechnen Sie die Multiplikation. Die erste Zahl ist eine große Zahl, die zweite Zahl ist nur eine Ziffer z.B. [2 3 6 0 0 0 0 0 0] * 2 = [4 7 2 0 0 0 0 0 0]
    public static int pr3(int[] a, int size_of_arrays, int y) {
        int[] c = new int[size_of_arrays+1];
        int sem=0;
        for(int i=size_of_arrays-1; i>=0; i--){
            int x = a[i]*y;
            if(sem!=0)
            {
                x+=sem;
            }
            if(x>9)
            {
                c[i+1] = x%10;
                sem=x/10;
            }
            else
            {
                c[i+1] = x;
                sem=0;
            }
        }
        System.out.println("Mul of array: ");

        if(sem != 0) {
            c[0] = (a[0]*y)/10;
            System.out.println(Arrays.toString(c));
        }
        else
        {
            int[] newarray = Arrays.copyOfRange(c, 1, size_of_arrays+1);
            System.out.println(Arrays.toString(newarray));
        }
        System.out.println();
        return 0;
    }

    //Berechnen Sie die ganzzahlige Division. Die erste Zahl ist eine große Zahl, die zweite Zahl ist nur eine Ziffer.
    //z.B. [2 3 6 0 0 0 0 0 0] / 2 = [1 1 8 0 0 0 0 0 0]
    private static int pr4(int[] a, int size_of_arrays, int y){
        int[] c = new int[size_of_arrays];
        int ok=0;
        int x;
        for(int i=0; i<=size_of_arrays-1; i++){
            x = ok*10+a[i];
            ok = x%y;
            x/=y;
            c[i] = x;
        }
        System.out.println("Div of arrays: ");
        if(c[0] == 0)
        {
            int[] newarray = Arrays.copyOfRange(c, 1,size_of_arrays);
            System.out.println(Arrays.toString(newarray));
        }
        else
        {
            System.out.println(Arrays.toString(c));
        }
        System.out.println();
        return 0;
    }
}


