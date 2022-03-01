package demos.coding;

import java.util.ArrayList;
import java.util.List;

// Main class
public class RoutesSrcToDest {

	List<Route> direct = null;
	
	public RoutesSrcToDest() {
		
		List<List<Character>> result=null;
		List<Character> temp=null;
		temp=new ArrayList<Character>();
		result=new ArrayList<List<Character>>();
		initRoutes();
		temp.add('C');
		findRoutes(direct, result, temp);
		// 
		System.out.println("All possible routes from C to D::");
		result.forEach(route->System.out.println(route));
	}
	
	//Find connecting route for C->D
	private void findRoutes(List<Route> direct, List<List<Character>> result, List<Character> temp) {
			Character current = temp.get(temp.size()-1);
			// Add to result
			if('D'==current) {
				List<Character> matchRoute = new ArrayList(temp);
				result.add(matchRoute);
				return;
			}

		for(Route route:direct) {
			if(current.equals(route.getSrc()) && !temp.contains(route.getDest())) {
				temp.add(route.getDest());
				findRoutes(direct, result, temp);	// Dest not matching dest D
				
				// Prepare for next
				temp.remove(temp.size()-1);
			}
		}
		// No more unused direct route
		return;
	}
	private void initRoutes() {

		direct = new ArrayList<Route>();
		direct.add(new Route('A','B'));
		direct.add(new Route('B','A'));
		direct.add(new Route('A','C'));
		direct.add(new Route('C','A'));
		direct.add(new Route('A','D'));
		direct.add(new Route('D','A'));
		direct.add(new Route('B','C'));
		direct.add(new Route('C','B'));
		direct.add(new Route('B','D'));
		direct.add(new Route('D','B'));
		
		System.out.println("Input route:");
		direct.forEach(route-> System.out.println(route));
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		RoutesSrcToDest routes = new RoutesSrcToDest();
		
	}

	
}

// Inner class
class Route {
	
	public Character getSrc() {
		return src;
	}

	public void setSrc(Character src) {
		this.src = src;
	}

	public Character getDest() {
		return dest;
	}

	public void setDest(Character dest) {
		this.dest = dest;
	}

	private Character src, dest;
	
	public Route(Character src, Character dest) {
		this.src=src;
		this.dest=dest;
	}
	
	public String toString() {
		return "["+src+"->"+dest+"]";
	}
}