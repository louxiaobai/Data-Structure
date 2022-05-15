package Builder.demo;

/**
 * @author lqw
 * @date 2022/3/15-5:35 下午
 */
public class Product {

    private String BuildA;
    private String BuildB;
    private String BuildC;
    private String BuildD;

    public Product() {

    }

    public Product(String buildA, String buildB, String buildC, String buildD) {
        BuildA = buildA;
        BuildB = buildB;
        BuildC = buildC;
        BuildD = buildD;
    }
    public void setBuildA(String buildA) {
        BuildA = buildA;
    }

    public void setBuildB(String buildB) {
        BuildB = buildB;
    }

    public void setBuildC(String buildC) {
        BuildC = buildC;
    }

    public void setBuildD(String buildD) {
        BuildD = buildD;
    }

    @Override
    public String toString() {
        return "Product{" +
                "BuildA='" + BuildA + '\'' +
                ", BuildB='" + BuildB + '\'' +
                ", BuildC='" + BuildC + '\'' +
                ", BuildD='" + BuildD + '\'' +
                '}';
    }
}