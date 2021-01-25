# JPA
* EntityManagerFactory는 하나만 생성하여 애플리케이션 전체에서 공유해야 한다.
* EntityManager는 Thread 간에 공유하면 안된다. (사용하고 버려야 한다.)
* JPA의 모든 데이터 변경은 Transaction 안에서 실행한다.
