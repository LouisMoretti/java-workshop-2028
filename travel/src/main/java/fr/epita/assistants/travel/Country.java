package fr.epita.assistants.travel;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class Country {
    String countryName;
    ZoneId zoneId;
    String inputFile;
    Map<String, Integer> travelTimes;

    public Country(String countryName, String countryZone, String inputFilePath) {
        this.countryName = countryName;
        this.zoneId = ZoneId.of(countryZone);
        this.inputFile = inputFilePath;
        this.travelTimes = new HashMap<>();
    }

    public Map<String, Integer> initTravelTimes(String inputFilePath) throws IOException {
        CSVReader csv = new CSVReader(new FileReader(inputFilePath), ',');

        String[] line = null;
        while ((line = csv.readNext()) != null) {
            if (line[0].equals(countryName))
                travelTimes.put(line[1], parseInt(line[2]));

            if (line[1].equals(countryName))
                travelTimes.put(line[0], parseInt(line[2]));
        }

        return travelTimes;
    }
}
