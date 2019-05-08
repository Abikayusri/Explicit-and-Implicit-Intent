package abika.sinaudicodingjava.myintentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoveWithDataActivity extends AppCompatActivity {
    public static final String EXTRA_AGE = "extra_age";
    public static final String EXTRA_NAME = "extra_name";

    TextView tvDataReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);

        tvDataReceived = findViewById(R.id.tv_data_received);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE, 0);

        /*
         * Dalam konteks di atas, key yang digunakan untuk mengirim dan mengambil nilai data adalah sama,
         * yaitu EXTRA_NAME (yang bernilai “extra_name”). Nilai dari data yang dikirimkan melalui intent
         * disimpan ke dalam variabel name bertipe data string.
         * ----------------------------------------------------------------------------------------------
         * Nilai dari variabel age yang bertipe data integer berasal dari getIntent().getIntExtra(Key, nilai default).
         * Key yang digunakan untuk mengirimkan dan mengambil data adalah EXTRA_AGE (yang bernilai “extra_age”).
         * Nilai default di sini merupakan nilai yang akan digunakan jika ternyata datanya kosong.
         * Data kosong atau nilainya null bisa terjadi ketika datanya memang tidak ada, atau key-nya tidak sama.
         * */


        String text = "Name : " + name + ",\nYour Age : " + age;
        tvDataReceived.setText(text);
    }
}
