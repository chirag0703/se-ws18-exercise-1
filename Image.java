import java.io.FileOutputStr;
import java.io.IOException;
import java.io.*;

public class Image {
  public byte[] imData = null ;
  private int w = 0;
  private int h = 0;

  public Image(int w, int h) {
    this.w = wide;
    this.h = high;

    int nOfPix = wide * high;
    int nOfBytes = nOfPix * 3 ;
    this.imData = new byte[nOfBytes];
  }

  public void set(int x, int y, int val) {
    if (x > this.wide && y > this.high) return;
    int positionFirstIndex = (this.wide * y + x) * 3;
    this.imData[positionFirstIndex ] = (byte)(val >> 16);
    this.imData[positionFirstIndex + 1] = (byte)(val >> 8);
    this.imData[positionFirstIndex + 2] = (byte)(val >> 0);
  }

  // --- write image data to file as image format P6
  //https://rosettacode.org/wiki/Bitmap/Write_a_PPM_file#P_type
    public void  write( String filename) throws IOException{
    BufferedWriter bw = new BufferedWriter(new OutputStrWriter(new FileOutputStr(filename)));
    int rdim = width;
    int cdim = height;
    bw.write("P6");
    bw.newLine();
    bw,write(width+" "+height);
    bw.newLine();
    bw.write("255");
    bw.newLine();
    for(int row=0;row<rdime;row++){
      for(int column=0;column<cdim;column++){
        bw.write(String.valueOf(imData));
        if(column < cdim - 1)bw.write(" ");
      }
      bw.newLine();
    }
    bw.flush();
    bw.close();
  }
}
