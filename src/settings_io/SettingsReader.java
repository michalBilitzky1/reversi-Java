package settings_io;

import java.io.*;

import reversiapp.GameSettings;

public class SettingsReader {
    public static final String kLocation = "settings.txt";
    public static final String kStartingPlayer = "Starting_Player";
    public static final String kPlayer1Color = "Player1_Color";
    public static final String kPlayer2Color = "Player2_Color";
    public static final String kBoardSize = "Board_Size";
    public static final String kSeparator = ":";

    public static GameSettings readFile() {
        File filename = new File(kLocation);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(filename)));
        } catch (FileNotFoundException e) {
            return new GameSettings();
        }
        GameSettings settings = parseFile(reader);
        try {
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return settings;
    }

    private static GameSettings parseFile(BufferedReader reader) {
        GameSettings settings = new GameSettings(); // default settings
        String line = readLine(reader);
        while (line != null) {
            String[] split = line.split(kSeparator);
            updateSetting(split, settings);
            line = readLine(reader);
        }
        return settings;
    }

    /**
     * @param reader - a buffered reader.
     * @return - a line in the file.
     */
    private static String readLine(BufferedReader reader) {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            System.err.println("Failed reading file, error: " + e.getMessage());
            try {
                reader.close();
            } catch (IOException e1) {
                System.err.println(
                        "Failed closing file, error: " + e1.getMessage());
            }
            System.exit(-1);
        }
        return line;
    }

    private static void updateSetting(String[] split, GameSettings settings) {
        String field = split[0];
        String value = split[1];
        if (field.equals(kStartingPlayer)) {
            if (SettingsInterpreter.isStartingPlayerValid(value)) {
                // valid starting player option
                settings.setStartingPlayer(value);
            }
        }
        if (field.equals(kPlayer1Color)) {
            if (SettingsInterpreter.isPlayerColorValid(value)) {
                settings.setPlayer1Color(value);
            }
        }
        if (field.equals(kPlayer2Color)) {
            if (SettingsInterpreter.isPlayerColorValid(value)) {
                settings.setPlayer2Color(value);
            }
        }
        if (field.equals(kBoardSize)) {
            if (SettingsInterpreter.isBoardSizeValid(value)) {
                settings.setBoardSize(value);
            }
        }
    }
}