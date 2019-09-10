package com.nguyen.texttovoice;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextToSpeech textToSpeech;
    private EditText edtTextToVoice;
    private Button btnVoice;
    private Button btnMock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTextToVoice = findViewById(R.id.edt_text_to_voice);
        btnVoice = findViewById(R.id.btn_voice);
        btnMock = findViewById(R.id.btn_mock);

        //Init TextToSpeech
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                textToSpeech.setLanguage(new Locale("vi_VN"));
            }
        });

        //Play voice
        btnVoice.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                String text = edtTextToVoice.getText().toString();

                if (TextUtils.isEmpty(text)) {
                    text = "Chưa nhập dữ liệu!";
                }

                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        //Mock data
        btnMock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mockData =
                        "Truyền thuyết Hoa Bỉ Ngạn.\n" +
                        "Không chỉ mang ý nghĩa sâu sắc, loài hoa chốn Hoàng Tuyền này còn gắn liền với truyền thuyết rất độc đáo. Chuyện kể rằng, có một loài hoa rất đặc biệt mang một cái tên rất độc đáo Hoa Bỉ Ngạn.\n" +
                        "Bảo vệ bên cạnh Bỉ Ngạn hoa là hai yêu tinh, một người tên là Mạn Châu, một người tên là Sa Hoa. Bọn họ đã canh giữ Bỉ Ngạn hoa suốt mấy nghìn năm nhưng trước giờ chưa từng tận mắt nhìn thấy đối phương.\n" +
                        "Bởi vì lúc hoa nở nhìn không thấy lá; khi có lá lại không thấy hoa. Giữa hoa và lá, cuối cùng cũng không thể gặp nhau, đời đời lầm lỡ. Thế nhưng, Mạn Châu và Sa Hoa lại điên cuồng nhung nhớ đối phương, và bị nỗi đau khổ hành hạ sâu sắc.\n" +
                        "Cuối cùng , họ cũng định làm trái quy định của thần, lén gặp nhau một lần. Thần biết được đã trách tội 2 yêu tinh. Mạn Châu và Sa Hoa bị đánh vào luân hồi, và bị lời nguyền vĩnh viễn không thể ở cùng nhau, đời đời kiếp kiếp ở nhân gian chịu đựng nỗi đau khổ.\n" +
                        " Về sau, Mạn Châu Sa Hoa chỉ nở trên con đường Hoàng Tuyền, hoa có hình dạng như những cánh tay hướng về thiên đường để cầu khẩn, mỗi khi Mạn Châu và Sa Hoa luân hồi chuyển thế, trên con đường Hoàng Tuyền ngửi thấy mùi hương của Bỉ Ngạn hoa thì có thể nhớ lại bản thân ở kiếp trước, sau đó thề không bao giờ chia lìa nữa nhưng vẫn lần nữa bị lời nguyền kéo vào.\n" +
                        "Từ đó, bên bờ Hoàng Tuyền, dưới cầu Nại Hà, cây hoa đỏ rực, yêu dị diễm lệ vô cùng cứ bừng nở, sinh sôi, dẫn đường cho các đôi tình nhân chia cắt, cho những vong hồn còn nhiều oán khí quay lại luân hồi, nhận lấy nhân quả mà số phận chú định.";
                edtTextToVoice.setText(mockData);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (textToSpeech != null && textToSpeech.isSpeaking()) {
            textToSpeech.stop();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (textToSpeech != null && textToSpeech.isSpeaking()) {
            textToSpeech.stop();
        }
    }
}
