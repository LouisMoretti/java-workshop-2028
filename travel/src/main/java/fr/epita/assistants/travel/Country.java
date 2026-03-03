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
    String countryName_;
    ZoneId zoneId_;
    String inputFile_;

    public Country(String countryName, String countryZone, String inputFilePath) {
        countryName_ = countryName;
        zoneId_ = ZoneId.of(countryZone);
        inputFile_ = inputFilePath;
    }

    public Map<String, Integer> initTravelTimes(String inputFilePath) throws IOException {
        Map<String, Integer> res = new HashMap<>();

        CSVReader csv = new CSVReader(new FileReader(inputFile_), ',');

        String[] line = null;
        while ((line = csv.readNext()) != null) {
            if (line[0].equals(countryName_))
                res.put(line[1], parseInt(line[2]));

            if (line[1].equals(countryName_))
                res.put(line[0], parseInt(line[2]));
        }

        return res;
    }
}
