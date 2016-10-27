/**
 * Created by Coleman on 10/26/2016.
 */

/** Newtonian Gravity */

import java.lang.*
import particles.*

class NGForce implements particles.Force {
  //                  1    2    3    4    5    6    7    8    9   10   11
  doube G = 6.674 / (10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10)

  double center_x, center_y;
  double mass;
  int number_particles;

  calculateForce(Particle[] particles) {
    for(int i = 0; i < particles.length; i++) {
      center_x += particles[i].getPos_x();
      center_y += particles[i].getPos_y();
      mass += particles[i].charges["mass"];
    }
    center_x /= particles.length;
    center_y /= particles.length;

    number_particles = particles.length;
  }
  ApplyForce(Particle particle) {
    double mass = this.mass - particle.charges["mass"];
    double center_x -= this.center_x / number_particles;
    double center_y -= this.center_y / number_particles;

    double distance_x = center_x - particles.getPos_x();
    double distance_y = center_y - particles.getPos_y();
    // distance = Math.sqrt((distance_x * distance_x) + (distance_y * distance_y));

    double force_y = (G * particle.mass * mass) / (distance_y * distance_y)
    double force_x = (G * particle.mass * mass) / (distance_X * distance_x)

    particle.applyForce(force_x, force_y);
  }
}
