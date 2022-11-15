import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    static StringBuilder text = new StringBuilder();

    public static void main(String[] args) {
        File games = new File("C:/Games");

        // 1 part
        File src = new File(games, "src");
        File res = new File(games,"res");
        File savegames = new File(games,"savegames");
        File temp = new File(games, "temp");

        textWriteDirectories(src);
        textWriteDirectories(res);
        textWriteDirectories(savegames);
        textWriteDirectories(temp);

        // 2 part
        File main = new File(src, "main");
        File test = new File(src, "test");

        textWriteDirectories(main);
        textWriteDirectories(test);

        // 3 part
        File javaMain = new File("C:/Games/src/main/Main.java");
        File javaUtils = new File("C:/Games/src/main/Utils.java");

        textWriteFiles(javaMain);
        textWriteFiles(javaUtils);

        // 4 part
        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icons = new File(res, "icons");

        textWriteDirectories(drawables);
        textWriteDirectories(vectors);
        textWriteDirectories(icons);

        // 5 part
        File textTemp = new File("C:/Games/temp/temp.txt");
        textWriteFiles(textTemp);

        String textWrite = text.toString();

        try (FileOutputStream fos = new FileOutputStream(textTemp)) {
            byte[] bytes = textWrite.getBytes();
            fos.write(bytes);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void textWriteDirectories(File file) {
        if (file.mkdir()) {
            System.out.println("Директория " + file.getName()  + " успешно создано в папке " + file.getParent());
            text.append("Директория ").append(file.getName()).append(" успешно создано в папке ").append(file.getParent()).append("\n");
        } else {
            System.out.println("Errors");
            text.append("Errors" + "\n");
        }
    }

    public static void textWriteFiles (File file) {
        try {
            if (file.createNewFile()) {
                System.out.println("Файл " + file.getName() + " создан в папке " + file.getParent());
                text.append("Файл ").append(file.getName()).append(" создан в папке ").append(file.getParent()).append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            text.append(ex.getMessage()).append("\n");
        }
    }
}