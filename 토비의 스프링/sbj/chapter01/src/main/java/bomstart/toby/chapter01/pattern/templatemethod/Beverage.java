package bomstart.toby.chapter01.pattern.templatemethod;

/**
 * 템플릿 메소드 패턴
 */
public abstract class Beverage {
    public final void makeBeverage() {
        prepareWater();
        addCondiments();
    }

    /**
     * 선택적으로 오버라이드해서 사용
     */
    protected void prepareWater() {
        System.out.println("물을 컵에 준비");
    }

    /**
     * 서브클래스에서 구현해서 사용
     */
    public abstract void addCondiments();
}

class IceTea extends Beverage {
    public void addCondiments() {
        System.out.println("아이스티 가루 첨가");
    }
}

class MixCoffee extends Beverage {
    @Override
    protected void prepareWater() {
        System.out.println("물을 끓여서 준비");
    }

    public void addCondiments() {
        System.out.println("믹스커피 가루 첨가");
    }
}
