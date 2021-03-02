package commands.uploadandread;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import typesfiles.Flat;
import typesfiles.MyTreeMap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class ReadCommand {
    private static String path = "src/resourse/loads/";

    public static TreeMap<Integer, Flat> readTheCollection(String name){
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(path + name));

            try (InputStreamReader isr = reader) {
                int ch;
                StringBuilder allText = new StringBuilder();
                while ((ch = isr.read()) != -1)
                    allText.append((char) ch);
                //if (allText.toString().equals(""))
                //    throw Inva
                TreeMap<Integer, Flat> loadingCol;
                Type collectionType = new TypeToken<TreeMap<Integer, Flat>>() {}.getType();
                loadingCol = new Gson().fromJson(allText.toString(), collectionType);
                System.out.println("Коллекция успешна загружена!");
                return loadingCol;
            } catch(FileNotFoundException e) {
                System.out.println("Загрузочный файл не найден!");
            } catch (NoSuchElementException e) {
                System.out.println("Загрузочный файл пуст!");
            } catch (JsonParseException | NullPointerException exception) {
                System.out.println("В загрузочном файле не обнаружена необходимая коллекция!");
            } catch (Exception e) {
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Коллекция не найдена");
        return new TreeMap<>();
    }

    public static void allchecking(MyTreeMap map) {

    }
}
