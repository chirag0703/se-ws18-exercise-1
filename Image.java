import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

public class Image {
  public byte[] imData = null ;
  private int width = 0;
  private int height = 0;

  public Image(int width, int height) {
    this.width = width;
    this.height = height;

    int nOfPix = width * height;
    int nOfBytes = nOfPix * 3 ;
    this.imData = new byte[nOfBytes];
  }

  public void set (int x, int y, int val) {
    if (x > this.width && y > this.height) return;
    int positionFirstIndex = (this.width * y + x) * 3;
    this.imData[positionFirstIndex ] = (byte)(val >> 16);
    this.imData[positionFirstIndex + 1] = (byte)(val >> 8);
    this.imData[positionFirstIndex + 2] = (byte)(val >> 0);
  }

  // --- write image data to file as image format P6
  //https://rosettacode.org/wiki/Bitmap/Write_a_PPM_file#P_type
    public void  write( String filename) throws IOException{
    BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
    int rdim = width;
    int cdim = height;
    buffer.write("P6");
    buffer.newLine();
    buffer.write(width+" "+height);
    buffer.newLine();
    buffer.write("255");
    buffer.newLine();
    for(int row=0;row<rdim;row++){
      for(int column=0;column<cdim;column++){
        buffer.write(String.valueOf(imData));
        if(column < cdim - 1)buffer.write(" ");
      }
      buffer.newLine();
    }
    buffer.flush();
    buffer.close();
  }
}
