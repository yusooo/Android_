public class MainActivity extends AppCompatActivity{ // 액티비티 클래스는 Activity (여기서는 AppCompatActivity)를 상속받아 작성
    @Override
    protected void onCreate(Bundle savedInstanceState){ // 액티비티 실행 시 자동으로 onCreate() 함수 호출
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 화면 출력 함수, 매개변수가 R.layout.activity_main이므로 res/layout/activity_main.xml의 구성대로 액티비티 화면의 출력
    }
}