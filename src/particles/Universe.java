/**
 * Created by Coleman on 10/26/2016.
 */

/** Universe class meant to be extended to create a Universe that acts on the given physics */
// ^^^possibly not meant to be extended???

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

private class ImageComponent extends JComponent{
    private static final long serialVersionUID = 1L;
    private Image image;
    public ImageComponent(width, height){
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // this.image = image;
    }
    public void paintComponent (Graphics g){
        if(image == null) return;
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

}

public class Universe extends JFrame{
  public static final int DEFAULT_WIDTH = 700;
  public static final int DEFAULT_HEIGHT = 700;

  private Force[] forces;
  private Particle[] particles;

  private int width, height;
  private ImageComponent image_component;

  public Universe(int width, int height) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setTitle("Universe");
    setSize(width, height);
    image_component = new ImageComponent(width, height);
    add(image_component);
    this.width = width;
    this.height = height;
  }
  public void setForces(Force[] forces) {this.forces = forces;}
  public Force[] getForces() {return this.forces;}
  public void setParticles(Particle[] particles) {this.particles = particles}
  public Particle[] getParticles() {return particles;}

  public void run() {
    while(True) {
      step();
      update();
    }
  }
  private void step() {
    for(int i = 0; i < forces.length; i++) {
      forces[i].calculateForce(particles);
      for(int j = 0; j < particles.length; j++) {
        forces[i].applyForce(particles[j]);
      }
    }
    for(int i = 0; i < particles.length; i++) {
      particles[i].update(width, height);
    }

  }
  private void update() {
    int[] raster = new int[width*height];
    for(int k = 0; k < forces.length; k++) {
      for(int i = 0; i < particles.length; i++) {
        Particle particle = particles[i];
        int x = particles[i].getPos_x();
        int y = particles[i].getPos_y();
        int radius = forces[k].getRadius(particle);
        int color = forces[k].getColor();
        for(int i = x - radius; i < x + radius + 1; i ++) {
          for(int j = y - radius; i < y + radius + 1; j ++) {
            if(i == x || j == y) {
              raster[i][j] += color | (255 << 16 | 255 << 8 | 255);
            } else {
              int value = func((double)(i - x + radius) / (2 * radius, (double)(j - y + radius) / (2 * radius));
              raster[j*width + i] += color | value;
            }
          }
        }
      }
    }
    WritableRaster image_raster = image_component.image.getRaster();
    image_raster.setPixels(0, 0, width, height, raster);
  }
  private int func(double x, double y) {
    x *= 2; x -= 1;
    y *= 2; y -= 1;
    value = (x * Math.log(x) - x + 1) * (y * Math.log(y) - y + 1);
    return (int)(value * 255) << 16 | (int)(value * 255) << 8 | (int)(value * 255);
  }
}



//
//
//
//
// public class ImageTest {
//     public static void main(String[] args){
//         EventQueue.invokeLater(new Runnable()
//         {
//             public void run(){
//                 ImageFrame frame = new ImageFrame();
//                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                 frame.setVisible(true);
//
//
//             }
//         }
//         );
//     }
// }
//
// class ImageFrame extends JFrame{
//
//     public ImageFrame(){
//         setTitle("ImageTest");
//         setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
//
//         ImageComponent component = new ImageComponent();
//         add(component);
//
//     }
//
//     public static final int DEFAULT_WIDTH = 300;
//     public static final int DEFAULT_HEIGHT = 200;
// }
//
//
// class ImageComponent extends JComponent{
//     /**
//      *
//      */
//     private static final long serialVersionUID = 1L;
//     private Image image;
//     public ImageComponent(){
//         try{
//             File image2 = new File("bishnu.jpg");
//             image = ImageIO.read(image2);
//
//         }
//         catch (IOException e){
//             e.printStackTrace();
//         }
//     }
//     public void paintComponent (Graphics g){
//         if(image == null) return;
//         int imageWidth = image.getWidth(this);
//         int imageHeight = image.getHeight(this);
//
//         g.drawImage(image, 50, 50, this);
//
//         for (int i = 0; i*imageWidth <= getWidth(); i++)
//             for(int j = 0; j*imageHeight <= getHeight();j++)
//                 if(i+j>0) g.copyArea(0, 0, imageWidth, imageHeight, i*imageWidth, j*imageHeight);
//     }
//
// }
