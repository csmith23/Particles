/**
 * Created by Coleman on 11/18/2016.
 */

import java.util.HashMap;
import particles.*;

public class Electron extends particles.Particle{
  public Electron(double pos_x, double pos_y, double vel_x, double vel_y) {
    super(double pos_x, double pos_y, double vel_x, double vel_y);
    setCharge("electromagnetic", -3);  // in thirds of the elementary charge
    setCharge("mass", 511)  // in eV/(c^2)
  }
}
