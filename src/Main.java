import javax.swing.*;

import static java.lang.Thread.sleep;

class CoinPrint extends Thread {
    int coin = 0;


    public CoinPrint(int coin){
        this.coin=coin;
    }
    @Override
    public void run (){
        for(int i=0;i<coin; i++){
            System.out.print(i+ " ");
            try{
                sleep(500);
            }catch (InterruptedException e){

            };
        }
    }
}

public class Main {

    public static void main(String[] args) {
        /*
        CoinPrint first = new CoinPrint(10);
        CoinPrint second = new CoinPrint(10);
        first.start();
        try{
            sleep(500);
        }catch (InterruptedException e){

        };
        first.currentThread().interrupt();
        second.start();
        */

        JFrame window = new ZWindow();

        window.setVisible(true);

    }
}
