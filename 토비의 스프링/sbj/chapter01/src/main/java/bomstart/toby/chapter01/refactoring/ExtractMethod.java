package bomstart.toby.chapter01.refactoring;

/**
 * 메소드 추출
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
     * methodA와 methodB에서 동일하게 필요한 처리를 별도의 메소드로 분리한다.
     */
    public void duplicateLogic() {
        System.out.println("중복된 로직을 분리");
    }
}

