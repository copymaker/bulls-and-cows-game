# 숫자 야구 게임

숫자야구게임 - 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임

## 기능 요구 사항

1. 컴퓨터는 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 만든다.
2. 사용자는 3자리의 숫자를 입력하고, 컴퓨터의 숫자와 비교하여 같은 수가 같은 자리에 있으면 스트라이크, 다른자리에 있으면 볼, 같은 수가 전혀 없으면 포볼(낫싱)을 출력해준다.
3. 사용자가 숫자를 맞출때까지 해당 기능을 반복한다.
4. 사용자가 숫자를 맞췄을 시 게임을 다시 시작하거나, 완전히 종료할 수 있다.

## 고민할 점

1. Digit 의 Position 과 DigitSet 의 index 의 의미가 다르다.
2. DigitSet 은 Position 기반으로 값을 확인해야 할 것 같다.
3. 같은 의미로 DigitSetFactory 에서도 Position 기반으로 DigitSet 을 생성해야 할 것 같다.
