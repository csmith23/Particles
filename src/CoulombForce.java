/**
 * Created by Coleman on 10/26/2016.
 */

/** Newtonian Gravity */

import java.lang.*
import particles.*

public class NGForce implements particles.Force {
  //                  1    2    3    4    5    6    7    8    9   10   11
  private doube Ke = 8.99 * (10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10) / 9 // 8.99*10^9

  private double center_x, center_y;
  private double charge;
  private int number_particles;

  public calculateForce(Particle[] particles) {
    for(int i = 0; i < particles.length; i++) {
      center_x += particles[i].getPos_x();
      center_y += particles[i].getPos_y();
      charge += particles[i].charges["electric"];
    }
    center_x /= particles.length;
    center_y /= particles.length;

    number_particles = particles.length;
  }
  public ApplyForce(Particle particle) {
    double charge = this.charge - particle.charges["electric"];
    double center_x -= this.center_x / number_particles;
    double center_y -= this.center_y / number_particles;

    double distance_x = center_x - particles.getPos_x();
    double distance_y = center_y - particles.getPos_y();
    // distance = Math.sqrt((distance_x * distance_x) + (distance_y * distance_y));

    double force_y = (Ke * particle.charge * charge) / (distance_y * distance_y)
    double force_x = (Ke * particle.charge * charge) / (distance_X * distance_x)

    particle.applyForce(force_x, force_y);
  }

  public int getRadius(Particle particle) {
    return Math.sqrt(Math.abs(particle.charges["electric"]) + 1);
  }
  
  public int getColor() {
    return 127 << 16 | 127 << 8 | 255;
  }
}
