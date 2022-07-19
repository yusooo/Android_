// View의 계층구조
/*
소프트웨어 모델 : DOM ; Document Object Model
패턴 Pattern : Gof 디자인 패넡의 Composite 패턴이 적용

------>*View
|      ㄱ   /-           [Class Diagram]
|     /       \
ㄴ ViewGroup  TextView

View : 안드로이드 뷰 클래스의 최상위 클래스, 액티비티에 출력되는 클래스는 모두 View의 서브 클래스
ViewGroup : 뷰의 서브 클래스=>화면 출력 But 뷰그룹 자체의 UI는 X ( 화면에 출력은 잇지만 아무것도 나오지 않음 )
            다른 뷰 여러개를 뷰그룹에 포함하여 한 번에 제어하기 위한 목적 ( 컨테이너Container 역할 담당 )
            뷰그룹의 서브 클래스들인 레이아웃 클래스들이 사용됨
TextView : 특정 UI 출력의 목적으로 제공되는 클래스 ( 대표적으로 TextView : 지정한 문자열 출력 뷰 )
*/

// View 계층구조 구현
// 1. 레이아웃 XML로 계층구조 구현
// 뷰의 계층구조를 레이아웃 XML로 구현 <= 태그의 상하 관계를 이용 (서브 태그로 등록한 뷰 객체가 상위 태그 객체에 포함)
<LinearLayout
  android:layout_width="match_parent"
  android:layout_height="wrap_content"
  android:orientation="horizontal">
  <Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Button 1"/>
  <Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Button 2"/>
</LinearLayout>     // => LinearLayout(뷰그룹)에 Button(뷰) 2개 포함

// 2. 자바 코드로 계층 구현
// 자바 코드에서 직접 뷰의 계층 구조를 구현 => addView() 함수 사용
LinearLayout linearLayout=new LinearLayout(this);
Button bt1=new Button(this);
linearLayout.addView(bt1);
Button bt2=new Button(this);
linearLayout.addView(bt2);

// 기초 뷰 활용
/*
1. TextView
  text = 화면에 출력할 문자열 지정 속성, XML 파일에 직접 문자열 명시 or 문자열 리소스 이용
  typeface = 화면 출력 문자열의 폰트 지정 속성, normal (default), sans, serif, monospace => 안드로이드 기본 제공 폰트
             임의 적용을 원할 시 폰트 파일(ttf)을 assets 폴더에 복사 후 setTypeFace() 함수 이용해 TextView에 지정
  textStyle = 화면에 출력할 문자열 효과, normal (default), bold, italic 중 하나를 입력
  textColor = 화면에 출력할 문자열의 색상을 16진수 RGB 포맷으로 지정
  textSize = 화면에 출력할 문자열의 폰트 크기 지정
  autoLink = TextView의 문자열 분석 => 문자열 내에 autoLink 값 해당 URL 문자열 포함? URL 문자열 부분을 자동 링크 형태로 출력
             이벤트  처리 없이도 자동으로 사용자 클릭 시 화면으로 연결
  maxLines = 특정 줄만큼만 출력 ( 최대 줄 수 )
  ellipsize = 문자열 줄임 표시의 자동화 속성, end, start, middle 등으로 말줄임표 위치 지정

2. ImageView
  src = 화면에 출력할 이미지 지정
  maxWidth, maxHeight = 화면 출력할 이미지의 최대 크기 지정 속성 / adjustViewBounds 속성과 함께 사용
  adjustViewBounds = 가로 세로 비율의 유지 여부 (true, false)
  tint = 이미지 위 타 색상을 덮을 때 사용
  
3. EditText
  사용자에게 데이터 입력 (TextView 상속받아 작성 => TextView의 대부분 속성을 EditText에 지정 가능
  lines = 행 수 고정 (처음부터 고정)
  maxLines = 최대 행 수 고정 (처음에는 한줄)
  inputType = 1. 키보드 모드 제어 : phone/number/textEmailAddress/textPassword 등
              2. 한 줄 혹은 여러 줄 입력의 강제 : text(한줄입력)
              3. 기타 속성
                none : 모든 문자 및 줄바꿈 입력 가능
                textCapCharacters : 자동 대문자 입력 모드
                textCapWords : 각 단어의 첫 글자 입력 시 키보드 자동 대문자 입력 모드
                textCapSentences : 각 문자의 첫 글자 입력 시 키보드 자동 대문자 입력 모드
                textMultiLine : 여러 줄 입력 가능
                textNoSuggestions : 단어 입력 시 키보드의 추천 단어 보여주기 비활성화
                textUri : 키보드 URL 입력 모드
                textEmailAddress : 이메일 주소 입력 모드
                textPassword : 비밀번호 입력용, 입력 문자의 점 표시 및 키보드 영문자/숫자/특수키만 표시
                textVisiblePassword : textPassword와 동일하지만 입력된 문자열 표시됨
                number : 키보드의 숫자 입력 모드
                numberSigned : number와 동일하지만 부호키인 - 입력 가능
                numberDecimal : number와 동일하지만 소수점 입력 가능
                numberPassword : 숫자키만 입력 가능 + 입력 문자는 점으로 표시
                phone : 전화번호 입력 모드
                datetime : 날짜 및 시간 입력을 위한 /,:키 제공
                date : 날짜를 입력하기 위한 / 키 제공
                time : 시간을 입력하기 위한 : 키 제공
  gravity = EditText에 입력할 글의 위치 지정 가능 ( 기본값 left top, center/right 등 지정으로 위치 조정 )

4. Button
  화면에서 사용자의 이벤트 처리를 위한 가장 기본적인 뷰
    
5. Checkbox, RadioButton
  Checkbox
    선택/미선택의 2가지 상태를 표현하기 위한 뷰 (TextView의 서브 클래스 => textColor, textSize 등 문자열 속성 적용 가능)
      isChecked() : 해당 체크박스가 체크된 상태인지 반환 (true -> 체크, false -> 미체크)
      setChecked() : 체크 상태를 바꾸기 위한 함수, true -> 체크 상태 / false -> 미체크 상태로 변환
      toggle() : 현재 상태와 상관 없이 반대로 바뀜
    
      현재 체크된 상태인지를 확인 : OnClickChangeListener()
    
  RadioButton
    체크 상태를 표현하기 위한 뷰 ( 같은 RadioGroup 중 단일선택 )
      check() : 매개변수로 체크하려 하는 RadioButton의 id값을 줄 시 해당 RadioButton 체크
      clearCheck() : RadioGroup의 RadioButton의 체크 상태를 해제
      getCheckRadioButtonId() : 체크된 RadioButton의 id값 획득
*/
