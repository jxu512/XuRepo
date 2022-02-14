package demos.coding;

import java.util.ArrayList;
import java.util.List;

// Main class
public class RoutesSrcToDest {

	List<Route> direct = null;
	List<List<Character>> result=null;
	List<Character> temp=null;
	
	public RoutesSrcToDest() {
		
		temp=new ArrayList<Character>();
		result=new ArrayList<List<Character>>();
		initRoutes();
		temp.add('C');
		findRoutes();
		// 
		System.out.println("All possible routes from C to D::");
		result.forEach(route->System.out.println(route));
	}
	
	//Find connecting route for C->D
	private void findRoutes() {
		
		for(Route route:direct) {
			Character current = temp.get(temp.size()-1);
			if(current.equals(route.getSrc()) && !temp.contains(route.getDest())) {
				temp.add(route.getDest());
				if('D'!=route.getDest()) findRoutes();	// Dest not matching dest D
				
				// Add to result
				if('D'==temp.get(temp.size()-1)) {
					ArrayList<Character> matchRoute = new ArrayList();
					matchRoute.addAll(temp);
					result.add(matchRoute);
				}
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
		direct.add(new Route('D','B'));
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