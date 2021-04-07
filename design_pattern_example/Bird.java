/**
 * 전략 패턴(Strategy Pattern) : 자신의 기능 맥락(context)에서 필요에 따라서 변경이 필요한 알고리즘을 인터페이스를
 * 통해서 통째로 외부로 분리시키고, 이를 구현한 구체적인 알고리즘 클래스를 필요에 따라서 바꿔서 사용할 수 있게 하는 디자인 패턴이다.
 */

/**
 * 단일 책임 원칙: 새 객체로써 날거나 우는 행위에 메서드를 호출하는 것에만 관심을 가진다.
 */
class Bird {
  /**
   * 의존 역전 원칙: FlyNoStrategy, FlyWithWingsStrategy와 같이 변화할 수 있는 하위객체에 의존하지 않고 변하지
   * 않는 상위 인터페이스 FlyStrategy에 의존한다.
   */
  FlyStrategy flyStrategy;
  CryStrategy cryStrategy;

  /**
   * 개방-폐쇄 원칙: fly, cry이 전략이 변경 되어도 Bird 객체를 수정하지 않아도 된다.
   */
  public Bird(FlyStrategy flyStrategy, CryStrategy cryStrategy) {
    this.flyStrategy = flyStrategy;
    this.cryStrategy = cryStrategy;
  }

  public void fly() {
    flyStrategy.fly();
  }

  public void cry() {
    cryStrategy.cry();
  }
}

/**
 * 인터페이스 분리 원칙: fly 메서드와 cry 메서드를 기준으로 메서드 별로 인터페이스를 분리 시켜서 필요한 메서드에만 의존할 수 있다.
 * 새가 아닌 비행물체라는 객체를 개발한다고 했을 때 비행물체 객체는 fly 메서드만 필요하기 때문에 FlyStrategy만 사용할 수 있다.
 * 이처럼 메서드를 기준으로 구체적으로 분리시키면 필요한 메서드만 이용할 수 있게 된다.
 */

/**
 * 단일 책임 원칙: 나는 동작에 대해서만 관심을 가진다.
 */
interface FlyStrategy {
  void fly();
}

/**
 * 단일 책임 원칙: 우는 동작에 대해서만 관심을 가진다.
 */
interface CryStrategy {
  void cry();
}

/**
 * 리스코프 치환 원칙: FlyStrategy를 구현만 함으로써 FlyNoStrategy와 FlyWithWingsStrategy는 모두
 * FlyStrategy를 완벽히 대체할 수 있다.
 */
class FlyNoStrategy implements FlyStrategy {
  @Override
  public void fly() {
    System.out.println("날지 못함");
  }
}

class FlyWithWingsStrategy implements FlyStrategy {
  @Override
  public void fly() {
    System.out.println("파닥파닥");
  }
}

/**
 * 리스코프 치환 원칙: CryStrategy를 구현만 함으로써 CryNoStrategy와 CryForChickenStrategy는 모두
 * CryStrategy를 완벽히 대체할 수 있다.
 */
class CryNoStrategy implements CryStrategy {
  @Override
  public void cry() {
    System.out.println("울지 않는다.");
  }
}

class CryForChickenStrategy implements CryStrategy {
  @Override
  public void cry() {
    System.out.println("꼬꼬댁!");
  }
}