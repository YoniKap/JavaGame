import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String[] createBoard(int idx){
        Random rnd = new Random();
        String [] board =new String[idx];
        int one ,two,three,four;

        do {
          one = rnd.nextInt(idx);
          two = rnd.nextInt(idx);
          three = rnd.nextInt(idx);
          four = rnd.nextInt(idx);
        }while (one==two||one==three||one==four||two==three||two==four||three==four);
        board[one]="Coin";
        board[two]="Coin";
        board[three]="Coin";
        board[four]="Coin";
        return board;
    }
    public static void moveACoin(String []arr , int a ,int b){
        int tmp=a;
        if(a==b){
            System.err.println("Same Index Given");
            return;
        }
        if(b>a) {
            System.err.println("Cant Move Right");
            return;
        }
        if(a<0||a>=arr.length){
            System.err.println("Invalid Index");
            return;
        }
        if(b<0)
        {
            System.err.println("Invalid index to move to");
            return;
        }
        if(arr[a]==null) {
            System.err.println("No Coin At The Specified Index");
            return;
        }
        if(b==a-1 && arr[b]!=null){
            System.err.println("Imposible move , a coin is blocking your way!");
            return;
        }


            while(a!=b&&a!=arr.length){
                a--;
                if(arr[a]!=null){
                    a+=1;
                        System.err.println("Coin In The way Moved To Closest Possible Index"+"("+(a+1)+")");
                        arr[a] = "Coin";
                        arr[tmp] = null;
                        return;
                }

            }


        arr[b]="Coin";
        arr[tmp]=null;

    }
    public static int digitcount(int a){
        int cnt=0;
        while (a >0)
        {
            cnt++;
            a/=10;
        }
        return cnt;
    }
    public static void prntBoard(String[] arr){


        System.out.println();
        System.out.print("|");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==null)
                System.out.print("    |");
            else
                System.out.print(arr[i]+"|");
        }
        System.out.println();
        System.out.print("|");

        for (int i = 1; i <=arr.length; i++) {
            if (digitcount(i)==1)
                System.out.print(" "+i+"  |");
            if (digitcount(i)==2)
                System.out.print(" "+i+" |");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Size");
        int size = scn.nextInt();

        String [] brd= createBoard(size);
        prntBoard(brd);
        int player=0;
        while(brd[0]==null||brd[1]==null||brd[2]==null||brd[3]==null){
            if(player%2==0)
                System.out.println("Player 1:");
            if(player%2!=0)
                System.out.println("Player 2:");
            System.out.println("Move from :");
            int mv=scn.nextInt()-1;
            System.out.println("Move to :");
            int to=scn.nextInt()-1;
            moveACoin(brd,mv,to);
                prntBoard(brd);
                player++;

        }
        if(player%2==0) {
            System.out.println("*************");
            System.out.println("Player 2 Wins");
            System.out.println("*************");
        }
        if(player%2!=0){
            System.out.println("*************");
            System.out.println("Player 1 Wins");
            System.out.println("*************");
        }

    }
}