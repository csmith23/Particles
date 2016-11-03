/**
 * Created by Coleman on 10/25/2016.
 */

package particles;

public interface Force {
  public void calculateForce(Particle[] particles);
  public void applyForce(Particle particle);
  
  public int getRadius(Particle particle);
  public int getColor();
}
