package test.java;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;

public class ImageTest {
    @Test
    public void test() throws IOException {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("G:\\tank\\src\\images\\bulletD.gif"));
            assertNotNull(image);
//        fail("not yet implemented");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
