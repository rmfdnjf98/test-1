# Guestbook Project

Spring Boot 기반의 간단한 방명록 프로젝트입니다.  
사용자가 이름과 내용을 입력해 글을 등록하고, 등록된 글 목록을 최신순으로 확인하고, 필요 시 삭제할 수 있습니다.

평가자가 프로젝트를 빠르게 파악할 수 있도록 구현 범위, 실행 방법, 기술 스택, 확인 포인트 위주로 정리했습니다.

## 1. Project Overview

- 프로젝트명: `javatest`
- 목적: Spring Boot MVC, Mustache, JPA 기본 흐름을 이용한 CRUD 기초 구현
- 핵심 기능:
  - 방명록 목록 조회
  - 방명록 작성
  - 방명록 삭제

## 2. Tech Stack

- Java 21
- Spring Boot 4.0.4
- Spring Web MVC
- Spring Data JPA
- Mustache
- H2 Database
- Lombok
- Gradle

## 3. Main Features

### 3.1 목록 조회

- URL: `GET /guestbook`
- 설명:
  - 저장된 방명록 데이터를 조회합니다.
  - 최신 글이 먼저 보이도록 `id desc` 정렬을 적용했습니다.

### 3.2 작성 페이지 조회

- URL: `GET /guestbook/write`
- 설명:
  - 방명록 입력 폼을 제공합니다.

### 3.3 방명록 등록

- URL: `POST /guestbook/write`
- 요청 파라미터:
  - `author`
  - `content`
- 설명:
  - 사용자가 입력한 값을 엔티티에 담아 저장합니다.
  - 저장 후 목록 페이지로 리다이렉트합니다.

### 3.4 방명록 삭제

- URL: `POST /guestbook/{id}/delete`
- 설명:
  - 선택한 방명록을 삭제합니다.
  - 삭제 후 목록 페이지로 리다이렉트합니다.

## 4. Project Structure

```text
src/main/java/com/example/javatest
├─ JavatestApplication.java
├─ Guestbook.java
├─ GuestbookController.java
└─ GuestbookRepository.java

src/main/resources
├─ application.properties
└─ templates
   ├─ guestbook-list.mustache
   └─ guestbook-write.mustache
```

## 5. Core Code Summary

### Entity

- `Guestbook`
  - 방명록 데이터를 나타내는 엔티티입니다.
  - 필드:
    - `id`
    - `author`
    - `content`
    - `createdAt`

### Repository

- `GuestbookRepository`
  - `JpaRepository<Guestbook, Long>` 상속
  - 사용자 정의 조회 메서드:
    - `findAllOrderByIdDesc()`

### Controller

- `GuestbookController`
  - 요청 URL과 화면을 연결합니다.
  - 목록 조회, 작성 폼 이동, 저장, 삭제를 처리합니다.

## 6. How To Run

### 6.1 Requirements

- JDK 21 설치
- Gradle Wrapper 사용 가능 환경

### 6.2 Run Command

Windows 기준:

```bash
gradlew.bat bootRun
```

또는 테스트/빌드:

```bash
gradlew.bat build
```

### 6.3 Access URL

- 메인 방명록 목록: `http://localhost:8080/guestbook`
- 작성 페이지: `http://localhost:8080/guestbook/write`

## 7. Evaluation Points

이 프로젝트에서는 아래 항목을 평가할 수 있습니다.

- Spring Boot MVC 기본 구조 이해
- Controller, Repository, Entity 역할 분리
- JPA를 이용한 데이터 저장 및 조회
- Mustache 템플릿을 이용한 서버 사이드 렌더링
- 간단한 CRUD 흐름 구현 능력
- URL 매핑 및 리다이렉트 처리 이해

## 8. Strengths

- 구조가 단순해서 흐름을 따라가기 쉽습니다.
- 방명록 기능에 필요한 최소 기능이 명확하게 분리되어 있습니다.
- JPA와 템플릿 엔진을 함께 사용한 전형적인 입문형 웹 프로젝트입니다.

## 9. Limitations

현재 프로젝트는 학습 및 평가용 기초 구현 수준이며, 아래 항목은 확장 가능 영역입니다.

- 입력값 검증 부족
- 예외 처리 미구현
- 수정 기능 없음
- 테스트 코드 미흡
- 화면 문구 및 UI 고도화 여지 존재

## 10. Possible Improvements

- `@Valid`를 이용한 입력 검증 추가
- 서비스 계층 분리
- 수정 기능 추가
- 등록일 포맷팅 개선
- 에러 페이지 처리
- 단위 테스트 및 통합 테스트 추가

## 11. Conclusion

이 프로젝트는 Spring Boot 기반 웹 애플리케이션의 가장 기본적인 흐름을 확인할 수 있는 방명록 예제입니다.  
복잡한 기능보다 MVC 구조, JPA 활용, 템플릿 렌더링, 요청 처리 흐름을 평가하기에 적합합니다.
