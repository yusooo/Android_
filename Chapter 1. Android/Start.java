/*
    안드로이드
        1. 플랫폼 : 리눅스 커널 기반
            HAL ; Hardware Abstraction Layer - 자바 API Framework에 하드웨어 기능 이용 표준 인터페이스 제공
            자바 API Framework에서 하드웨어 기기 이용을 위한 코드 실행 시 내부적으로 HAL 모듈 로딩 -> 처리

        2. 런타임 
            ART 가상 머신 사용 -> 위에에 일반 애플리케이션 개발 시 이용 가능한 JavaAPI Framework 제공
            Java로 구성된 타 어플리케이션 -> JVM 이용 / 안드로이드 VM = ART (Android RunTime) 이용
            ART : 앱 실행 시 DEX 파일 실행행
                Java Source(.java) --Java Compiler-> Java Byte Code(.class) --Dex Compiler-> Dalvik Byte Code(.dex) ---> Dex파일 ART
            컴파일러의 자동 DEX파일화 (자동변경), 런타임 때 ART가 DEX 파일 해석 => 수행행
        
        3. 애플리케이션 프레임워크
            Java API Framework : 개발자가 앱을 만들 때 이용하는 표준 라이브러리
                UI 구성 View 클래스, 리소스 관리, 데이터 영속화 등의 기능 제공
*/