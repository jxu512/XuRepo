package demos.basics;

public class RecordTest {
    public static void main(String[] args) {
        RecordClass record1 = new RecordClass(1, "record-1");
        RecordClass record2 = new RecordClass(2, "record-2");
        System.out.println(record1);
        System.out.format("id=%d, name=%s\n",record2.id(), record2.name());
    }
}
