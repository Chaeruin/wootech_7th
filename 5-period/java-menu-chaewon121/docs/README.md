
## 📈 기능 목록

### 메뉴 추천을 위해 준비

- [x] 카테고리와 각 카테고리의 메뉴를 저장한다.

### 메뉴 추천 진행

- [x] 코치의 이름들을 입력받는다.
    - [x] [예외처리] 각 코치의 이름이 2~4글자 사이가 아닌 경우 예외처리
    - [x] [예외처리] 2~5명이 아닌 코치를 입력받은 경우 예외처리

- [x] 각 코치들이 못먹는 메뉴들을 입력받는다.
    - [x] [예외처리] 입력받은 메뉴가 존재하지 않을 경우 예외처리
    - [x] [예외처리] 3개 이상인 경우 예외처리

- [x] 월, 화, 수, 목, 금에 추천할 메뉴의 카테고리를 랜덤으로 생성한다.
    - [x] 한 카테고리가 3번 중복되면 다시 랜덤으로 생성한다.

- [x] 생성한 카테고리에 따라 각 코치들에게 요일별로 메뉴를 랜덤으로 추천하고 저장한다.
    - [x] 코치가 먹지 못하는 메뉴는 제외시킨다.
    - [x] 이전에 추천한 메뉴인지 중복 검사를 한다.

### 결과 출력

- [x] 메뉴 추천 결과를 출력한다.
    - [x] 요일 출력
    - [x] 카테고리 출력
    - [x] 각 코치별로 추천받은 메뉴 출력