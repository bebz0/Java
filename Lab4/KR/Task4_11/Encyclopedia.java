// Task 4.11
public class Encyclopedia extends Book {
    private int volumes;

    public Encyclopedia(String title, String author, int pages, int volumes) {
        super(title, author, pages);
        this.volumes = volumes;
    }

    public int getVolumes() {
        return volumes;
    }

    @Override
    public String getType() {
        return "Encyclopedia";
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("  volumes: " + volumes);
    }
}
