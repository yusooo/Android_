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
 

// layout_width, layout_height : 뷰 크기 지정 속성
// 미선언시 빌드할 때 에러 발생
<TextView
    android:layout_width="wrap_content" // wrap_content : 뷰 크기 속성값
    android:layout_height="wrap_content" // match_parent = fill_parent : 해당 뷰의 크기를 부모 계층의 뷰가 지정한 크기에 들어차게 자동 결정
    android:text="hello world!"         // wrap_content : 해당 뷰의 내용을 화면에 보이기 위해 적절한 크기를 계산해 결정 ( 폰트 크기를 키울 시 뷰 크기도 늘어남 )
    android:background="#FF0000"        // 100px 등 수치 직접 지정 : 각 디바이스마다 크기가 모두 달라 크기 대응 화면의 개발 불가
    android:textcolor="#FFFFFF"/>
    
// margin, padding
    // margin : 뷰와 뷰 사이의 간격 지정 속성
        // 단일방향 margin 속성 : layout_marginLeft, layout_marginRight, layout_marginTop, layout_margintBottom
    // padding : 뷰 내부에서 내용과 뷰의 테두리 간의 간격 지정 속성
        // 단일방향 padding 속성 : paddingLeft, paddingRight, paddingTop, paddingBottom
<Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Button1"
    android:padding="24dp"
    />
    <Button
        android:layout_width:"wrap_content"
        android:layout_height:"wrap_content"
        android:text="Button2"
        android:layout_marginLeft="16dp"    // Button1의 padding값에 따라 Button1의 뷰 크기가 Button2보다 크게 출력됨
        />
            
// clickable 속성 : TextView나 ImageView 등에 클릭 이벤트를 발생시킴
        
    
