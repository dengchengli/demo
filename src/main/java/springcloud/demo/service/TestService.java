package springcloud.demo.service;

public interface TestService {
    default public void getValue() {
        System.out.println(1111);
    }
}
