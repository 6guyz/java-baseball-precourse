# 미션 - 숫자 야구게임

> 일단 가장 초점에 뒀던 것은 
>
> `indent` , `depth` 를 합쳐 2를 이하로 만드는 것이 초점을 뒀다.

---



첫번째로, 알고리즘을 풀듯이 고려했던 것은, 게임이 반복되는 부분이 많기에

분명히 `while` 문 이나, `재귀(recursion)` 이 사용될 것이라 생각했습니다. 



`while` 문이나 `재귀` 가 사용될 부분은 총 두 가지 였습니다.

1. 전체 게임의 반복
2. 게임 내에서, 입력한 숫자가 틀렸을 때의 반복



기존에 제가 알고리즘 풀듯이 접근한다면, 

```java
while(true) {
    ...
    // 실행 후 나오는 결과값에 따라 while문을 빠져나가도록 설계
    boolean result = function();
    if (result) { ... }
    else { ... }
}
```

이런식의 풀이 코드를 많이 작성했을 것입니다.

그러나, `while` 문이 총 두 번 있기에, 사실상 한 번의 조건문을 넣는다는 것은 불가능에 가까웠습니다.



따라서 제가 생각한 해법은 **`while`문의 탈출 조건을 하나의 변수로 두는 것** 이었습니다.

바뀐 코드는 다음과 같습니다.

```java
boolean game = true;
while (game) {
    ...
    // 실행 후 변수를 변경함으로, 자연스럽게 탈출할 수 있도록
    game = funtion(); // function의 return 값은 boolean
}
```

이렇게 하여 탈출을 위한 조건문 하나를 줄일 수 있었습니다..!



전체코드는 아래를 참고해주세요! 

[코드참조]: https://github.com/6guyz/java-baseball-precourse/tree/hsj	"SangjinH 의 Github"

