# 블랙잭

### 개요

- 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임-

### 구현할 기능

- [x]  Card
    - [x]  모양, 숫자 정보
- [x]  CardFactory
    - [x]  카드 생성
- [x]  Dealer
    - [x]  카드를 추가하는 기능
    - [x]  첫번째 카드를 리턴하는 기능
    - [x]  카드 합계를 리턴
    - [x]  카드 합계가 16 이하인지 판단
    - [x]  카드 합계가 21을 초과하는지 판단
- [x]  Player
    - [x]  카드를 추가하는 기능
    - [x]  카드 합계를 리턴
- [x]  심판
    - [x]  처음 두장의 카드 합이 21인지
    - [x]  모든 카드 합이 21이 넘는지
    - [x]  이겼는지
    - [x]  졌는지
    - [x]  무승부인지
- [x]  금액 관리
    - [x]  참가자의 처음 두장의 카드 합이 21인 경우 배팅 금액의 1.5배
    - [x]  참가자의 모든 카드 합이 21이 넘는다면 금액 모두 잃음
    - [x]  딜러가 21을 초과하면 배팅 금액만큼 받음(2배)
    - [x]  딜러와 참가자가 같으면 금액을 그대로(1배)
- [ ]  입력
    - [ ]  참여할 사람의 이름 입력
        - [ ]  쉼표 기준으로 분리
        - [ ]  형식에 맞지 않으면 예외 발생
    - [ ]  참여할 사람들의 배팅 금액 입력
        - [ ]  숫자 형식에 맞지 않으면 예외 발생
    - [ ]  참여한 사람들의 추가 카드 발급
        - [ ]  y 혹은 n이 아니면 예외 발생
- [ ]  출력
    - [ ]  입력할 때 출력
    - [ ]  결과 출력

- 예제

```
게임에 참여할 사람의 이름을 입렵하세요.(쉼표 기준으로 분리)
pobi, jason

pobi의 배팅 금액은?
10000

jason의 배팅 금액은?
20000

딜러와 pobi, jason에게 2장을 나누었습니다.
딜러: 3다이아몬드
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드

pobi는 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y

pobi카드: 2하트, 8스페이드, A클로버

pobi는 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n

jason은 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n

jason카드: 7클로버, K스페이드

딜러는 16이하라 한 장의 카드를 더 받았습니다.

딜러 카드: 3다이아몬드, 9클로버, 8다이아몬드 - 결과: 20
pobi카드: 2하트, 8스페이드, A클로버 - 결과 21
jason카드: 7클로버, K스페이드 - 결과 17

## 최종 수익
딜러: 10000
pobi: 10000
jason: -20000
```

- https://github.com/chanil4129/java-blackjack-precourse