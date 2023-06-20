import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    public static StringBuilder log = new StringBuilder();
    public static void main(String[] args) {

        List<String> directories = List.of(
                "D:\\Games\\src",
                "D:\\Games\\src\\main",
                "D:\\Games\\src\\test",
                "D:\\Games\\res",
                "D:\\Games\\res\\drawables",
                "D:\\Games\\res\\vectors",
                "D:\\Games\\res\\icons",
                "D:\\Games\\savegames",
                "D:\\Games\\temp");

        for (String dir:directories) {
            saveDirectory(dir);
        }

        createFile("D:\\Games\\src\\main", "Main.java");
        createFile("D:\\Games\\src\\main", "Utils.java");
        createFile("D:\\Games\\temp", "temp.txt");


        try (FileWriter writer = new FileWriter("D:\\Games\\temp\\temp.txt")) {
            writer.write(log.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void saveDirectory(String path) {
        File dir = new File(path);
        if (dir.mkdirs()) {
            log.append("Директория " + path + " создана успешно" + "\n");
        } else {
            log.append("Директория " + path + " не создана" + "\n");
        }
    }

    public static void createFile(String path, String fileName) {
        File file = new File(path, fileName);
        try {
            if (file.createNewFile()) {
                log.append("Файл " + fileName + " создан успешно" + "\n");
            } else {
                log.append("Файл " + fileName + " не создан" + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}