/**
 * Created by Coleman on 10/25/2016.
 */

package particles;

public interface Force {
  public void calculateForce(Particle[] particles);
  public void applyForce(Particle particle);
  public void getRadius(Particle particle);
}
