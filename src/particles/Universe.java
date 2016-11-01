/**
 * Created by Coleman on 10/26/2016.
 */

/** Universe class meant to be extended to create a Universe that acts on the given physics */
// ^^^possibly not meant to be extended???

class Universe {
  Force[] forces;
  Particle[] particles;

  public Universe(Force[] forces; Particle[] particles) {
    this.forces = forces;
    this.particles = particles;
  }

  public void run() {
    while(True) {
      step();
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
      particles[i].update();
    }

  }
}
