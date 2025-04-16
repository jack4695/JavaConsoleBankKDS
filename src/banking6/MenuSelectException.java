package banking6;

//개발자가 직접 정의한 예외처리 클래스

/* 메뉴선택 : 지정된 정수 이외의 숫자를 입력한 경우(개발자정의 예외처리) */

class MenuSelectException extends Exception {
    public MenuSelectException() {
        super("숫자를 잘못입력하셨습니다. (1~5만 입력 가능)");
    }
}


