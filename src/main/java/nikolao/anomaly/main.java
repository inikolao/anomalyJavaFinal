/*
 * Apodeiknietai en polois oti h java san aisxrh glwssa arneitai 
 * peismatika na trexei script pou exei detach commands mesa.
 * Orizetai ws default port/ starting port to 9200.
 * H efarmogh proypothetei thn uparksh bash scrip sto opoio emperiexetai to jar-aki.
 *
 * Basika Stixeia
 * Default folder arxeiwn orizetai to trainDat
 * Opoiadhpote prosthikh ekei ayksanei ton arithmo twn istanse kai twn clients.
 * wstoso h logikh ayth hlopoieitai se epipedo bash script gia tous parapanw logous.
 *
 * Ioannis Nikolaou AM 4504
 * Martios 2015
 */

package nikolao.anomaly;

import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static nikolao.anomaly.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import us.jubat.anomaly.AnomalyClient;

/**
 *
 * @author nikolao {Ioannis Nikolaou AM 4504 mailto:Gianhspc@gmail.com}
 * 15/3/2015 Created{First write}
 */

@ComponentScan
@EnableAutoConfiguration
public class main {
    public static void main(String[] args) throws UnknownHostException, IOException, FileNotFoundException, InterruptedException {
    InetAddress thisIp = null;
   String filename="";
   //String host="83.212.112.190";
   AnomalyClient cl;
   String host="192.168.2.5";
   try{
   host=thisIp.getHostAddress().toString();}
   catch (NullPointerException ex){}
   int port=9200;
   String name="test";
   int timeout=10;
   client myclient= new client(host,port,name,timeout);
   boolean t;
   int i;
   int size;
   String [] nams;
   int [] ptrs;
   String [] files;
   matrixPrt mtport = new matrixPrt();
   util.servermatching=mtport;
   util.host=host;
   files = getFileNames();
   //createServerScript();
   //i=0;
  for(i=0;i<getNumFileNames();i++){ 
        //do{
        //t=checkPort(host,port);
        //  if(t==true)
        //    {
                mtport.SetNewMember(files [i], port);//.replaceAll("\\s","")
        //         port++;
        //    }
       //     else
       //     {
            port++;
       //     }
       // }while(t==false);
    }
//open clients
    //client myclient= new client("83.212.112.190",9200,"test",10);
  //System.out.println(myclient.getName());
    size=mtport.getSize();
    nams=mtport.getFilename();
    ptrs=mtport.getPort();
    for(i=0;i<3;i++){
        myclient.setName(nams [i]);//.replaceAll("\\s","")
        myclient.setPort(ptrs [i]);
        cl=openClient(myclient);
        System.out.println(myclient.getHost());
        System.out.println(myclient.getPort());
        System.out.println(myclient.getName());
        System.out.println(cl.getStatus());
        trainCl(nams[i],cl);//train what
    }
    SpringApplication.run(main.class, args);
    }
}
