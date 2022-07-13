public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linear=new LinearLayout(this);

        Button bt=new Button(this);
        bt.setText("Button 1");
        linear.addView(bt);

        Button bt2=new Button(this);
        bt2.setText("Button 2");
        linear.addView(bt2);

        setContentView(linear);
    }
}

// LinearLayout에 버튼 2개를 생성해 추가 + 화면에 출력
// LinearLayout이 버튼 2개를 포함했으므로 setContentView() 함수에 linear만 전달해도 버튼 2개가 함께 출력