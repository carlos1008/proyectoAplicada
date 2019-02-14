/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import dao.myConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author LABORATORIO 10
 */
public class DataBase {

    private String ruta ;
    private String rutaMysql ;
    private String nameBackup ;
//https://gist.github.com/gevorg/955f33a9e5a3a9f90e0e
    //https://omindu.wordpress.com/2011/06/27/mysql-database-backup-restore-using-java/
    //http://www.bosit.be/blog/2008/03/29/dumping-a-mysql-database-from-java/
    public DataBase() {
        ruta= System.getProperty("user.dir") + "/db/";
        rutaMysql = "C:\\wamp\\bin\\mysql\\mysql5.6.17\\bin\\";
        nameBackup =  "backup.sql";
    }

    //TODO
    public void backup() {
        try {
            File dir = new File(ruta);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //String executeCmd = "";
            
            File backupFile = new File(ruta + nameBackup);
           /* String path=  nameBackup;
            String executeCmd = rutaMysql+"mysqldump -umiguel -pjuan --add-drop-database -B " + myConnection.dbName + " -r " + path;
        Process runtimeProcess;
        
            System.out.println(executeCmd);
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
 
            if (processComplete == 0) {
                System.out.println("Backup created successfully");
                //return true;
            } else {
                System.out.println("Could not create the backup");
            }
       */
        String[] command = new String[]{rutaMysql+"mysqldump ", "-umiguel", "-pjuan", " -r "+myConnection.dbName};

        ProcessBuilder processBuilder = new ProcessBuilder(Arrays.asList(command));
        processBuilder.redirectError(Redirect.INHERIT);
        processBuilder.redirectOutput(Redirect.to(backupFile));

        Process process = processBuilder.start();
        process.waitFor();
            
            /*executeCmd = rutaMysql + "mysqldump -u " + myConnection.dbUser + " -p" + myConnection.dbPass +" "+ myConnection.dbName + " -r " + nameBackup;
            System.out.println(executeCmd);
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            FileCopy(rutaMysql + nameBackup, ruta + nameBackup);

            if (processComplete == 0) {
                myLog.message("Proceso completado", 2, "backup()", "DataBase");
            } else {
                myLog.message("Could not take mysql backup", 0, "backup()", "DataBase");
            }*/
        } catch (IOException | InterruptedException e) {
            myLog.message(e.toString(), 0, "backup()", "DataBase");
        }
    }

    public void FileCopy(String sourceFile, String destinationFile) {
        System.out.println("Desde: " + sourceFile);
        System.out.println("Hacia: " + destinationFile);

        try {
            File inFile = new File(sourceFile);
            File outFile = new File(destinationFile);

            FileInputStream in = new FileInputStream(inFile);
            FileOutputStream out = new FileOutputStream(outFile);

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }

            in.close();
            out.close();
        } catch (IOException e) {
            myLog.message("Hubo un error de entrada/salida!!!", 0, "FileCopy()", "DataBase");
        }
    }

    private String getTimeHour() {
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH) + 1;
        int year = c.get(Calendar.YEAR);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        return year + "-" + month + "-" + day + "__" + hour + "_" + minute + "_" + second;
    }

    private void restore() throws IOException, InterruptedException {
        String executeCmd[];
        //mysql -f -u $DB_USERNAME -p$DB_PASSWORD $DB_NAME < $DB_SCHEMA_FILE
        executeCmd = new String[]{"C:\\wamp\\bin\\mysql\\mysql5.6.17\\bin\\", "-u", "mysql -u" + myConnection.dbUser + " -p" + myConnection.dbPass + " " + myConnection.dbName + " < backup.sql"};

        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        int processComplete = runtimeProcess.waitFor();
        if (processComplete == 0) {
            System.out.println("success");
        } else {
            System.out.println("restore failure");
        }
        /*
        command = new String[]{"mysql ", "-uroot", "-proot", "test_new"};

        processBuilder = new ProcessBuilder(Arrays.asList(command));
        processBuilder.redirectError(Redirect.INHERIT);
        processBuilder.redirectInput(Redirect.from(backupFile));

        process = processBuilder.start();
        process.waitFor();
        
        */
    }

    public static void main(String[] args) {
        try {
            new DataBase().backup();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
