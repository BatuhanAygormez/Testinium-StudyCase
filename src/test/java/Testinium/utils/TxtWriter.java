package Testinium.utils;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TxtWriter {
    public void Writer(String value) {
        try {
            String txtLocation = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "productInfo.txt").toString();
            PrintWriter printWriter = new PrintWriter(txtLocation);
            printWriter.write(value);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String ReadProductPrice() {
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "productInfo.txt"))) {
            list = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String regexPattern = "([0-9,.]+) TL";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(list.get(0));

        if (matcher.find()) {
            return matcher.group(1);
        }else{
            return "";
        }
    }
}
