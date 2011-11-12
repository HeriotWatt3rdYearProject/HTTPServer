package Tools;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//Code 'swiped' from http://danajaatcse.wordpress.com/2011/04/02/a-simple-java-log-writer-class-for-debugging-a-multi-thread-execution/
//


public class LogWriter{

 private static final String LOG_FILE = System.getProperty("user.dir")+"/log.txt";

 private static LogWriter writer=new LogWriter();

 public synchronized void WriteLog(String entry){

    BufferedWriter bw=null;

    try {

        bw =new BufferedWriter(new FileWriter(LOG_FILE,true));
        bw.append(entry);
        bw.newLine();

    } catch (IOException e) {

        e.printStackTrace();

    }finally{

      try {

              bw.close();

      } catch (IOException e) {

               e.printStackTrace();

     }

  }

 }

public static LogWriter getInstance(){

     return writer;

 }

}