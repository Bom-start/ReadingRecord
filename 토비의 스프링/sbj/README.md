## 1장. 오브젝트와 의존관계

1장에서는 본격적으로 스프링에 대해서 학습하기 전에 스프링의 핵심 철학인 객체지향의 중요점에 대해서 설명하고 있다.  

객체지향이 지켜지지 않았을 때 생길 수 있는 극단적인 예제의 코드를 수정하면서  
객체지향이 왜 중요한 지 스프링은 이러한 문제를 어떻게 해결해 주며 왜 스프링이 필요한지 생각해 볼 수 있게 해준다.  

<strong>"스프링은 객체지향적 설계 원칙과 디자인 패턴에 나타난 장점을 자연스럽게 개발자들이 활용할 수 있게 해주는 프레임워크이다."</strong>

<details>
<summary>학습 내용 정리</summary>
<div markdown="1">

- ### 메소드 추출
  리펙토링의 한 방법으로 여러 메소드에서 중복되는 관심사를 별도의 메소드로 분리해 내는 것으로 <strong>리팩토링의 한 방법</strong>  
  [예제코드](./chapter01/src/main/java/bomstart/toby/chapter01/refactoring/ExtractMethod.java)
  
- ### 템플릿 메소드 패턴
  슈퍼클래스에서 기본적인 로직을 구현하고, 일부 기능에 대해서 추상 메소드나 오버라이딩이 가능한 protected 메소드 등으로 만든 뒤  
  서브클래스에서 이런 메소드를 필요에 맞게 구현, 오버라이딩해서 사용하도록 하는 <strong>디자인 패턴</strong>   
  [예제코드](./chapter01/src/main/java/bomstart/toby/chapter01/pattern/templatemethod/Beverage.java)

- ### 팩토리 메소드 패턴
  서브클래스에서 어떤 오브젝트를 생성할지 결정하게 하는 <strong>디자인 패턴</strong>   
  [예제코드](./chapter01/src/main/java/bomstart/toby/chapter01/pattern/factorymethod/ShapeFactory.java)

- ### 전략 패턴
  자신의 기능 맥락(context)에서 필요에 따라서 변경이 필요한 알고리즘을 인터페이스를 통해서 통째로 외부로 분리시키고,   
  이를 구현한 구체적인 알고리즘 클래스를 필요에 따라서 바꿔서 사용할 수 있게 하는 디자인 패턴이다.   
  [예제코드](./chapter01/src/main/java/bomstart/toby/chapter01/user/dao/UserDao.java)

- ### 개방 폐쇄 원칙
  "소프트웨어 개체(클래스, 모듈, 함수 등등)는 확장에 대해 열려 있어야 하고, 수정에 대해서는 닫혀 있어야 한다"는 <strong>프로그래밍 원칙</strong>  
  특정 개체를 수정할 때 그 모듈을 이용하고 있는 모든 개체를 고쳐야 한다면 '개방 폐쇄 원칙'이 잘 지켜지고 있는지 확인해봐야 할 필요가 있다.   
  <br>
  <strong>확장에 대해 열려 있다?</strong>   
  새로운 기능이 추가, 수정될 때 해당 모듈을 가져다 쓰는 다른 코드들에 영향을 주지 않으며 기능을 확장할 수 있어야 한다.  
  <strong>변경에 대해 닫혀 있다?</strong>  
  기존에 작성되어 있는 코드를 수정하지 않고도 애플리케이션의 동작을 추가하거나 변경할 수 있어야 한다.

</div>
</details>
