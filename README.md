# Transactional Boundary In MSA

마이크로 서비스 환경에서 구현하는 Transactional Boundary

## Order Server

- 주문 서버
  - 주문을 생성한다
  - 주문이 되면 결제 서버로 결제 요청을 보낸다
  - 결제 서버로부터 결제 실패 메시지가 응답되면 rollback 시킨다

## Payment Server

- 결제 서버
  - 주문이 생성될 때 결제 서버가 요청된 데이터를 받는다.
  - validation 후에 적절한 응답을 내려준다.

## 흐름

1. 주문 요청
2. 주문 생성
3. 결제 서버로 요청
4. valid 한 request 라면 성공적으로 결제
5. 주문 서버는 결제 서버에서 실패했다면 rollback

# 구현 방법

1. 기본적인 Spring `@Transactional` 어노테이션 이용하기
2. ... 추가 요망