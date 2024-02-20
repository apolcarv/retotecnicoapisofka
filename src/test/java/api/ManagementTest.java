package api;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagementTest {

    @Test
     void testParallel(){
        Results results = Runner.path("classpath:api").outputCucumberJson(true).parallel(4);
        generateReport(results.getReportDir());
        assertEquals(0, results.getFailCount());
    }

    public static void generateReport(String karateOutPutPath){
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutPutPath), new String[]{"json"},true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration configuration = new Configuration(new File("Build"),"retoKarate");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths,configuration);
        reportBuilder.generateReports();
    }
}