package demos.barclays;

public interface Ordering {
	
	public void addRelation (Object a, Object b, boolean greater);
	public boolean isGreater (Object x, Object y);
}