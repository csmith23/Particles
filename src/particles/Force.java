/**
 * Created by Coleman on 10/25/2016.
 */

package particles;

interface Force {
  void calculateForce(Particle[] particles);
  void applyForce(Particle particle);
}
