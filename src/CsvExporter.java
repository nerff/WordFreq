import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by nerff on 11.09.13.
 */
public class CsvExporter implements Exporter {

    CsvExporter() {
        System.out.println("Exporting vocabulary to CSV...");
    }

    public void export(Vocabulary vocabulary, String path) {
        List<WordEntry> mList = vocabulary.asList();
        try {
            FileWriter writer = new FileWriter(path);
            for (WordEntry wordEntry : mList) {
                //writer.write(wordEntry.get_frequency() + ";" + wordEntry.get_word() + "\n");
                writer.write(wordEntry.get_word() + ";" + wordEntry.get_frequency() + ";" +
                        String.format("%.2f", ((float) wordEntry.get_frequency() / (float) vocabulary.getSize()) * 100) + "%\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
