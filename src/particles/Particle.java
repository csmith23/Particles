/**
 * Created by Coleman on 10/24/2016.
 */

package particles;

import java.util.HashMap;

public class Particle {
  private double pos_x, pos_y;
  private double vel_x, vel_y;
  private double accel_x, accel_y;

  private HashMap<String, double> charges;  // for electric, weak, strong, mass, and others

  public Particle(double pos_x, double pos_y, double vel_x, double vel_y) {
    this.pos_x = pos_x;
    this.pos_y = pos_y;
    this.vel_x = vel_x;
    this.vel_y = vel_y;
  }
  public double getPos_x() {return pos_x;}
  public double getPox_y() {return pox_y;}
  private void setCharge(String type, double value) {charges.put(type, charge);}  // called within the constructor of the particle
  public double getCharge(String type) {
    if(charges.containsKey(type)) {
      return charges.get(type);
    }
    return 0;
  }

  public void applyForce(double accel_x, double accel_y) {
    this.accel_x += accel_x;
    this.accel_y += accel_y;
  }

  public void update(int width, int height) {
    vel_x += accel_x;
    vel_y += accel_y;

    pox_x += vel_x;
    pox_y += vel_y;

    if(pos_x < 0) {
      pos_x += width;
    } else if(pos_x > width) {
      pos_x -= width;
    }
    if(pos_y < 0) {
      pos_y += height;
    } else if(pos_y > height) {
      pos_y -= height;
    }

    accel_x = 0;
    accel_y = 0;
  }
}
