/*
Interface allowing adding relation, greater than, and then query the relation
*/
package demos.barclays;

public interface Ordering {
	
	public void addRelation (Object a, Object b, boolean greater);
	public boolean isGreater (Object x, Object y);
}