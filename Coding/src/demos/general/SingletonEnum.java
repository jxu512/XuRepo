package demos.general;

public enum SingletonEnum {

    SERVICE("Singleton");

    private String name;
    private SingletonEnum(String name) {
        this.name = name;
    }

    public void service() {
        System.out.printf("In singleton service implemented with enum: %s.", name);
    }

    public static void main(String[] args) {
        SingletonEnum singleton = SingletonEnum.SERVICE;
        singleton.service();
    }
}
