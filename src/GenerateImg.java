/**
 * Created by Coleman on 10/26/2016.
 */

/** used to generate the image for displaying particles */

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

class GenerateImg {
  // x * ln(x) - x + 1, 0 <= x <= 1
  // -x * ln(-x) + x + 1, -1 <= x <= 0
  private static double[][] imageRaster;
  public static void main(String[] args) {
    int dimensions = 500;
    gen(dimensions);
    BufferedImage image = new BufferedImage(dimensions, dimensions, BufferedImage.TYPE_INT_RGB);
    for(int x = 0; x < dimensions; x++) {
      for(int y = 0; y < dimensions; y++) {
        int value = (int)(255 * (imageRaster[x][y]));
        value = value << 16 | value << 8 | value;
        image.setRGB(x, y, value);
      }
    }
    try{
        File f = new File("out.png");
        ImageIO.write(image, "PNG", f);
    }
    catch(Exception e){
        e.printStackTrace();
    }
  }

// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
  private static void gen(int dimensions) {
    imageRaster = new double[dimensions][dimensions];
    if((dimensions / 2) * 2 == dimensions) {
      for(int i_counter = 0; i_counter < dimensions; i_counter += dimensions / 2) {
        for(int i = 0; i < dimensions / 2; i++) {
//          System.out.println(i+i_counter);
          for(int j_counter = 0; j_counter < dimensions; j_counter += dimensions / 2) {
            for(int j = 0; j < dimensions / 2; j++) {
              imageRaster[i+i_counter][j+j_counter] = func(((dimensions / 2) - i_counter * (1 + 2.0 / dimensions) - i) / (dimensions / 2.0), ((dimensions / 2) - j_counter * (1 + 2.0 / dimensions) - j) / (dimensions / 2.0));
            }
          }
        }
      }
    } else {

    }
  }
  private static double func(double x, double y) {
    if(x < 0) {x = -x;}
    if(y < 0) {y = -y;}
    return(x * Math.log(x) - x + 1) * (y * Math.log(y) - y + 1);
  }
}
