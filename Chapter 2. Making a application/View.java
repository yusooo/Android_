// id 속성 ; 뷰의 식별자 속성, 필수 X
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="hello"/>
// TextView = 화면에 문자열 출력
// 출력만이 목적이라면 id 속성 생략 가능
// 생략 시 속성 변경 등의 작업 수행 불가능 (객체명 미확인)

<TextView
    android:id="@+id/myText"    // 임의의 이름으로 id 값을 하나 부여 => 지정한 id값이 R.java에 등록됨
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="hello"/>

public static final class id{
    // ...
    public static final int myText=0x7f0b0059;  // id변수 하나 추가됨
    // ...
}

TextView myTextView=findViewById(R.id.myText);
// 자바 코드에서 뷰 객체 획득 => 이용 가능
 