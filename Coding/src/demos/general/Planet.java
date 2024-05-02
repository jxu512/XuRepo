/*
enum is compiled into final class, and can't be extended
*/

package demos.general;

public enum Planet {
	EARTH(3,3),
	MARS(1,1),
	ZEUS(5,5);

	final private int size;
	private int weight;
	private Planet(int size, int weight) {
		this.size = size;
		this.weight = weight;
	}

	public static void main(String[] args) {

		Planet[] planets = new Planet[3];
		planets[0] = Planet.EARTH;
		planets[1] = Planet.MARS;
		planets[2] = Planet.ZEUS;

		for (Planet planet : planets) {
			System.out.format("%s : %d/%d\n", planet.name(), planet.size, planet.weight);
			// enum should be immutable, but it is not enforced by default
			planet.weight *= 2;
			System.out.format("%s : %d/%d\n", planet.name(), planet.size, planet.weight);
		}
	}
}
