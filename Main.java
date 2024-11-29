import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/grantsolt/Desktop/49205929/Assignment1/log-data.csv");
        Scanner sc = new Scanner(file);
        String str = sc.nextLine();
        int i;
        int total=0;
        int count=0;
        Queue<LogReport> Reports = new Queue<LogReport>();
        Stack<LogReport> Errors = new Stack<LogReport>();
        int warn=0;
        int info=0;
        int error=0;
        int memory=0;

        while(sc.hasNextLine()){
            total++;
            String s1="";
            String s2="";
            String s3="";
            char c='a';
            str=sc.nextLine();
            for(i=0;c!=']';i++){
                c=str.charAt(i);
                s1=s1+c;
            }
            i++;
            c=str.charAt(i);
            while(c!=' '){
                s2=s2+c;
                i++;
                c=str.charAt(i);
            }
            i++;
            while(i<str.length()){
                c=str.charAt(i);
                s3=s3+c;
                i++;
                //System.out.println(c);
            }

            LogReport current= new LogReport(s1,s2,s3);
            Reports.Enqueue(current);
        }
        System.out.println("100 recent logs: ");
        while(!(Reports.isEmpty())){
            count++;
            LogReport analyze=Reports.Dequeue();
            if(analyze.getLog().equals("ERROR")) {
                error++;
                Errors.push(analyze);
            }
            else if(analyze.getLog().equals("WARN")) {
                warn++;
                String test= analyze.getMessage();
                if(test.contains("Memory"))
                    memory++;
            }
            else if(analyze.getLog().equals("INFO"))
                info++;
            if((count+100)>total) {
                System.out.println(analyze.toString());
            }
        }






        System.out.println("Total number of error logs: "+error);
        System.out.println("Total number of warn logs: "+warn);
        System.out.println("Total number of info logs: "+info);

        System.out.println("Total number of memory warnings: "+memory);
    }
}