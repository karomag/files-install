import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File gamesDir = new File("D:\\Games");
        File src = new File(gamesDir, "src");
        File res = new File(gamesDir, "res");
        File savegames = new File(gamesDir, "savegames");
        File temp = new File(gamesDir, "temp");

        StringBuilder log = new StringBuilder();
        log.append("Создан каталог " + src.getName() + ": " + src.mkdir() + "\n");
        log.append("Создан каталог " + res.getName() + ": " + res.mkdir() + "\n");
        log.append("Создан каталог " + savegames.getName() + ": " + savegames.mkdir() + "\n");
        log.append("Создан каталог " + temp.getName() + ": " + temp.mkdir() + "\n");

        File mainDir = new File(src, "main");
        File testDir = new File(src, "test");
        log.append("Создан каталог " + mainDir.getName() + ": " + mainDir.mkdir() + "\n");
        log.append("Создан каталог " + testDir.getName() + ": " + testDir.mkdir() + "\n");

        File mainFile = new File(mainDir, "Main.java");
        File utilsFile = new File(mainDir, "Utils.java");

        try {
            log.append("Создан файл " + mainFile.getName() + ": " + mainFile.createNewFile() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            log.append("Создан файл " + utilsFile.getName() + ": " + utilsFile.createNewFile() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icons = new File(res, "icons");
        log.append("Создан каталог " + drawables.getName() + ": " + drawables.mkdir() + "\n");
        log.append("Создан каталог " + vectors.getName() + ": " + vectors.mkdir() + "\n");
        log.append("Создан каталог " + icons.getName() + ": " + icons.mkdir() + "\n");

        File tempFile = new File(temp, "temp.txt");
        try {
            log.append("Создан файл " + tempFile.getName() + ": " + tempFile.createNewFile() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(log.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}