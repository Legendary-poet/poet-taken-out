import org.junit.jupiter.api.Test;

import java.util.UUID;

public class NameTest {
    @Test
    public void test1() {

        //原始文件名称
        String originalFilename = "11111 .jpg";
        System.out.println(originalFilename);
        String[] split = originalFilename.split("\\.");
        String s = ".".toString() + split[split.length - 1];
        System.out.println(s);

    }

}
