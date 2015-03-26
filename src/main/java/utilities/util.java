/*
 * apodeiknietai en polois oti h java san aisxrh glwssa arneitai 
 * peismatika na trexei script pou exei detach commands mesa.
 * Orizetai ws default port/starting port to 9200
 */

package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;

/**
 *
 * @author nikolao {Ioannis Nikolaou AM 4504 mailto:Gianhspc@gmail.com}
 * 15/3/2015 Created{First write}
 */

public class util {
    public static void startServerTest() throws IOException, InterruptedException
    {
        System.out.println("Testing server opening...");
        int i;
        int port=9200;
        Runtime term = null;
        Process anom=null;
        String[] commands = new String [3];
        String[] args = new String [28];
        //String s=null;
        PrintWriter writer = new PrintWriter("anom.c", "UTF-8");
        //writer.println("#!/bin/bash");
        writer.println("#include <stdio.h>");
        writer.println("void main(){");
        writer.println("system(\"./anom.sh\");");
        for(i=0;i<28;i++)
        {
           //writer.println("system(\"jubaanomaly --configpath jubaanomaly-config.json --rpc-port "+port+"&\");");
           //commands[0]="sh";
           //commands[1]="anom.sh";
           //commands[2]=""+port;
            //Runtime runtime = Runtime.getRuntime();
        //Process process = runtime.exec("java ProcessHelper");
          //anom = new ProcessBuilder("sh", "anom.sh",""+port).start();
            //sleep(100);
            //anom = term.getRuntime().exec("cat logf"+port+".log");
            //sleep(1000);
            port++;
            /*BufferedReader stdError = new BufferedReader(new InputStreamReader(anom.getErrorStream()));
            System.out.println("errors....");
             while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        stdError.close();//*/
        
        }
        writer.println("}");
        writer.close();
        System.out.println("Executing server Script ......");
        term.getRuntime().exec("chmod 775 anom.c");
        term.getRuntime().exec("gcc anom.c -o anom");
        term.getRuntime().exec("chmod 775 anom");
        anom=term.getRuntime().exec("sudo ./anom &");
        //String[] lala ={"sh","anom.sh&"};
           //anom = Runtime.getRuntime().exec(lala);
            //anom = new ProcessBuilder("/bin/bash","anom.sh").start();
            //anom.continue()
            //anom = Runtime.getRuntime().exec("sh anom.sh");
           sleep(10000);
            BufferedReader stdErrort = new BufferedReader(new InputStreamReader(anom.getErrorStream()));
            BufferedReader stdInput2 = new BufferedReader(new InputStreamReader(anom.getInputStream()));
        for (String s = stdInput2.readLine() ; s != null ; s = stdInput2.readLine()) {
           System.out.println("line: "+s);           
        }
        stdInput2.close();
        
            System.out.println("errors....");
             for (String s = stdErrort.readLine() ; s != null ; s = stdErrort.readLine()) {
                System.out.println(s);
            }
             Runtime.getRuntime().gc();
        
    }
    public static void testServers() throws IOException
    {
        System.out.println("Geting istances ids...");
        Runtime term = null;
        Process anom=null;
        anom = term.getRuntime().exec("ps -ef | grep jubaanomaly | grep -v grep | awk \'{print $2}\'");
    }
    public static void kill() throws IOException
    {
        System.out.println("Kill instances...");
        Runtime term = null;
        Process anom=null;
        anom = term.getRuntime().exec("kill -9 `ps -ef | grep jubaanomaly | grep -v grep | awk \'{print $2}\'`");
    }
}
