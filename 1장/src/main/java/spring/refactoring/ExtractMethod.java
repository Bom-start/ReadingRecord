package spring.refactoring;

/**
 * 메소드 추출
 * : 리펙토링의 한 방법으로 여러 메소드에서 중복되는 관심사를 별도의 메소드로 분리해 내는 것
 */
public class ExtractMethod {
    public void methodA() {
        duplicateLogic();
        System.out.println("A method 작업");
    }

    public void methodB() {
        duplicateLogic();
        System.out.println("B method 작업");
    }

    /**
     * methodA와 methodB에서 동일하게 필요하는 관심사를 별도의 메소드로 분리한다.
     */
    public void duplicateLogic() {
        System.out.println("중복된 로직을 분리해서 처리");
    }
}

