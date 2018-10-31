import TinyTestJ.Test;
import TinyTestJ.RunTests;
import TinyTestJ.Image;

public class TestSuite {

  @Test public static void ImageTest1() {
    Image i = new Image(100,100);
    assert (i.imData.length == 30000);
  }

  @Test public static void ImageTest2() {
    Image i = new Image(100,100);
    i.set(0,0,0x123456);
    assert (i.imData[0] == (byte)0x12);
    assert (i.imData[1] == (byte)0x34);
    assert (i.imData[2] == (byte)0x56);
    assert (i.imData[3] == (byte)0x00);
  }

  @Test public static void ImageTest3() {
    Image i = new Image(100,100);
    i.set(99,99,0x123456);
    assert (i.imData[29995] == (byte)0x00);
    assert (i.imData[29996] == (byte)0x00);
    // the first byte in pixel has index = (99 * 100 + 99) * 3 = 29997
    assert (i.imData[29997] == (byte)0x12);
    assert (i.imData[29998] == (byte)0x34);
    assert (i.imData[29999] == (byte)0x56);
  }

  @Test public static void ImageTest4() throws java.io.FileNotFoundException,java.io.IOException {
    String filename = "test.ppm";
    Image i = new Image(100,100);
    i.write(filename);
    java.io.File f = new java.io.File(filename);
    boolean exists = f.exists() && f.isFile();
    assert (exists);
  }
}
