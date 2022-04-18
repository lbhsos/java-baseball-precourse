## 기능 요구사항
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- [x] 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
- [x] 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 
- [x] 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 게임 플레이어가 입력한 숫자에 대한 결과를 출력한다.
- [x] 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- [x] 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 구현할 기능
### Computer
- [x] 1볼 1스트라이크의 경우를 정상적으로 비교하는지 확인한다.
- [x] 사용자의 입력이 상대방 수와 모두 일치할 경우 3스트라이크를 정상적으로 비교하는지 확인한다.
- [x] 사용자의 입력이 상대방 수와 아무것도 일치하지 않을 경우 낫싱을 리턴하는지 확인한다.
- [x] 중복된 수가 랜덤 함수에서 제공될 경우 중복을 제거하여 상대방 수로 지닌다.

### Player
- [x] 사용자의 입력이 숫자가 아닌 경우 IllegalArgumentException을 발생시킨다.
- [x] 사용자의 입력 문자 길이가 세 글자가 아닌 경우 IllegalArgumentException을 발생시킨다.
- [x] 사용자의 입력 중 숫자 겹칠 경우 IllegalArgumentException을 발생시킨다.
- [x] 게임 종료 후 사용자 입력이 1 또는 2가 아닌 경우 IllegalArgumentException을 발생시킨다.
- [x] 게임 종료 후 사용자 입력이 숫자가 아닌 경우 IllegalArgumentException을 발생시킨다.
- [x] 게임 종료 후 사용자의 입력 문자 길이가 한 글자가 아닌 경우 IllegalArgumentException을 발생시킨다.

### Result
- [x] Baseball 객체의 strikeCount가 3일 때, 정답인지 확인하면 true를 리턴한다.
- [x] Baseball 객체의 strikeCount가 3이 아닐 때, 정답인지 확인하면 false를 리턴한다.
- [x] Baseball 객체의 strikeCount와 bollCount가 둘 다 0일 때 결과는 '낫싱'스트링을 리턴한다.
- [x] Baseball 객체의 strikeCount가 3이면 결과는 '3스트라이크' 스트링을 리턴한다.
- [x] Baseball 객체의 ballCount가 3이면 결과는 '3볼' 스트링을 리턴한다.
- [x] 결과 호출시 Baseball 객체의 strikeCount와 bollCount 갯수만큼 스트링을 리턴한다.
- [x] 결과 호출시 Baseball 객체의 strikeCount가 0이면 스트라이크 문자열은 포함하지 않는다.
- [x] 결과 호출시 Baseball 객체의 ballCount가 0이면 스트라이크 문자열은 포함하지 않는다.
