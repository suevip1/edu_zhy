import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin.
 * Time 2023/12/12 14:41
 * Desc 文件描述
 */
public class TestV2 {




    @Test
    public void paoLiVay(){
        String logAllFilePath = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\channid.txt";


        List<String> lines2 = readLinesFromFile(logAllFilePath);

        String channIds = lines2.stream().findFirst().get();

        String[] split = channIds.split(",");



        System.err.println(Arrays.stream(split).count());


    }






    /**
     * *读取资源并关闭
     * // try-with-resources 语句中创建reader2的实例。BufferedReader当执行退出try块时，
     * // 会自动调用close()每个实例的方法，释放关联的资源。BufferedReader
     * //        try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
     * //             BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {
     * //            // Code to read and compare lines
     * //        } catch (IOException e) {
     * //            e.printStackTrace();
     * //        }
     * @param filePath
     * @return
     */
    private static List<String> readLinesFromFile(String filePath) {
        List<String> lines = new ArrayList<>();

        // try-with-resources
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }



}
