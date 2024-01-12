import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.WritePendingException;

public class CopyFile {
    public static void main(String[] args) {
        boolean result = copyFile("src/copyfile.txt","src/file.txt");
        System.out.println(result);
    }

    private static boolean copyFile(String path1, String path2) {
        StringBuilder stringBuilder1 = new StringBuilder();
        try (FileReader reader = new FileReader(path1);) {
            int c;
            while((c=reader.read())!=-1){
                stringBuilder1.append((char) c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            return false;
        } catch (IOException e) {
            System.out.println("error");
            return false;
        }

        try (FileWriter writer = new FileWriter(path2)) {
            writer.write(stringBuilder1.toString());
        } catch (WritePendingException e) {
            System.out.println("write error");
            return false;
        } catch (IOException e) {
            System.out.println("error");
            return false;
        }
        return true;
    }

}
