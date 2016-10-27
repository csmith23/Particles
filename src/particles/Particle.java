/**
 * Created by Coleman on 10/24/2016.
 */

package particles;

import java.util.HashMap;

class Particle {
  private double pos_x, pos_y;
  private double vel_x, vel_y;
  private double accel_x, accel_y;

  HashMap<String, double> charges;  // for electric, weak, strong, mass, and others

  public Particle(double pos_x, double pos_y, double vel_x, double vel_y) {
    this.pos_x = pos_x;
    this.pos_y = pos_y;
    this.vel_x = vel_x;
    this.vel_y = vel_y;
  }
  private void setCharge(String type, double value) {  // called within the constructor of the particle
    charges.put(type, charge);
  }
  public double getPos_x() {
    return pos_x;
  }
  public double getPox_y() {
    return pox_y;
  }

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

  public void update() {
    vel_x += accel_x;
    vel_y += accel_y;

    pox_x += vel_x;
    pox_y += vel_y;

    accel_x = 0;
    accel_y = 0;
  }
}
