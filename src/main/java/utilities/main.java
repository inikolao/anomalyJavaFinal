/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilities;

import java.io.IOException;
import static java.lang.Thread.sleep;
import static nikolao.anomaly.util.checkPort;
import static nikolao.anomaly.util.startServer;
import static utilities.util.*;

/**
 *
 * @author nikolao {Ioannis Nikolaou AM 4504 mailto:Gianhspc@gmail.com}
 * 15/3/2015 Created{First write}
 */

public class main {
    public static void main(String[] args) throws IOException, InterruptedException{
        boolean t;
        int port=9200;
        int i;
        String host="192.168.2.5";
        System.out.println("Runing tests...");
        //startServerTest();
       // testServers();
        for(i=0;i<28;i++){
        do{
        t=checkPort(host,port);
            if(t==true)
            {
                System.out.println("port "+port+" available...");
            }
            else
            {
                System.out.println("port "+port+" skata...");
            //port++;
            }
            port++;
        }while(t==false);
    }
        sleep(1000);
        kill();
        System.exit(0);
        
    }
    
}
