package settings_io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import reversiapp.GameSettings;

public class SettingsWriter {

    /**
     * @param settings - a game settings object to write.
     */
    public static void writeFile(GameSettings settings) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new OutputStreamWriter(
                    new FileOutputStream(SettingsReader.kLocation)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        List<String> fields = settingsFields(settings);
        for (String field : fields) {
            writer.println(field);
        }
        writer.close();
    }

    /**
     * @param settings - a game settings object.
     * @return - a list of strings to write to the file.
     */
    private static List<String> settingsFields(GameSettings settings) {
        List<String> fields = new LinkedList<String>();
        String field = SettingsReader.kStartingPlayer
                + SettingsReader.kSeparator + settings.getStartingPlayerStr();
        fields.add(field);
        field = SettingsReader.kPlayer1Color + SettingsReader.kSeparator
                + settings.getPlayer1Str();
        fields.add(field);
        field = SettingsReader.kPlayer2Color + SettingsReader.kSeparator
                + settings.getPlayer2Str();
        fields.add(field);
        field = SettingsReader.kBoardSize + SettingsReader.kSeparator
                + settings.getBoardSizeStr();
        fields.add(field);
        return fields;

    }
}
