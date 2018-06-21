import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandling {
     
    public static void fillList(String path,ArrayList<File> list) {
        File file = new File(path);
        File [] fileList = file.listFiles();
        for(File files : fileList) {
            System.out.println("Name : "+files.getName()+" \nPath : "+files.getAbsolutePath());
            if(files.isFile()) {
                list.add(files);
            } else if(file.isDirectory()) {
                fillList(files.getAbsolutePath(),list);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the path of which files you want to print)");
        String path1 = sc.nextLine();
        System.out.println("Enter the path of output file(Ex : /Users/Documents/AcadView/abc.csv): ");
        String path2 = sc.nextLine();
        sc.close();

        ArrayList<File> list = new ArrayList<>();

        try {
            File f1 = new File("abc.txt");
            f1.createNewFile();
            FileWriter fw1 = new FileWriter(f1);
            fw1.write(path1+"\n"+path2);
            fw1.close();

            fillList(path1,list);

            File f2 = new File(path2);
            f2.createNewFile();

            FileWriter fw2 = new FileWriter(f2);

            for(int i=0;i<list.size();i++) {
                fw2.write(list.get(i).getName()+","+list.get(i).getAbsolutePath()+"\n");
            }
            fw2.close();
        }

        catch (Exception e) {
            System.out.print("Error");
        }
    }

}
