package abika.sinaudicodingjava.myintentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnMoveActivity;
    Button btnMoveWithDataActivity;
    Button btnMoveWithObject;
    Button btnDialPhone;
    Button btnMoveResult;
    TextView tvResult;

    private int REQUEST_CODE = 100;

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveWithDataActivity = findViewById(R.id.btn_move_activity_data);
        btnMoveWithObject = findViewById(R.id.btn_move_activity_object);
        btnDialPhone = findViewById(R.id.btn_dial_number);
        btnMoveResult = findViewById(R.id.btn_move_for_result);
        tvResult = findViewById(R.id.tv_result);

        btnMoveActivity.setOnClickListener(this);
        btnMoveWithDataActivity.setOnClickListener(this);
        btnMoveWithObject.setOnClickListener(this);
        btnDialPhone.setOnClickListener(this);
        btnMoveResult.setOnClickListener(this);

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);

                /*
                 * Kita membuat suatu obyek Intent dengan cara seperti di atas dengan memberikan kelas Activity asal
                 * (MainActivity.this) dan kelas Activity tujuan (MoveActivity.class) pada konstruktor kelas Intent.
                 * ----------------------------------------------------------------------------------
                 * startActivity(moveIntent) metode ini akan menjalankan activity baru tanpa membawa data.
                 * Obyek intent yang diinputkan adalah obyek moveIntent yang akan ketika kode ini
                 * dijalankan maka akan membuka MoveActivity.
                 * ----------------------------------------------------------------------------------
                 * */

                break;
            case R.id.btn_move_activity_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5);
                startActivity(moveWithDataIntent);
                break;

                /*
                  putExtra() untuk mengirimkan data bersamaan dengan obyek Intent.
                  Sedangkan metode putExtra() itu sendiri merupakan metode yang menampung pasangan key-value
                  dan memiliki beberapa pilihan tipe input
                  ----------------------------------------------------------------------------------
                  NAME:
                  MoveWithDataActivity.EXTRA_NAME dimana EXTRA_NAME adalah variabel static bertipe data string
                  dan bernilai “extra_name” pada MoveWithDataActivity.java. Penentuan nilai untuk key parameter
                  untuk intent adalah bebas, di sini kami merekomendasikan format terbaik yang biasa diimplementasikan.
                  ----------------------------------------------------------------------------------
                  VALUE:
                  DicodingAcademy Boy dengan tipe data string.
                  ----------------------------------------------------------------------------------
                  */
            case R.id.btn_move_activity_object:
                Person person = new Person();
                person.setName("Abika Nyoba DicodingAcademy");
                person.setAge(22);
                person.setEmail("academy@dicoding.com");
                person.setCity("Bandung");

                /*
                 * Di atas kita menciptakan sebuah obyek Person bernama person yang mana kelas tersebut
                 * adalah Parcelable. Kita atur semua data sesuai dengan propertinya.
                 * Setelah selesai kita akan mengirimkan obyek tersebut ke
                 * MoveWithObjectActivity melalui sebuah intent di bawah ini.
                 * ----------------------------------------------------------------------------------
                 * */

                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person);
                startActivity(moveWithObjectIntent);

                /*
                 * Metode putExtra() yang kita pilih saat ini adalah putExtra(String name, Parcelable value).
                 * ----------------------------------------------------------------------------------
                 * */
                break;


            case R.id.btn_dial_number:
                String phoneNumber = "085718079787";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneIntent);

                /*
                 * Pada bagian new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                 * kita menggunakan inputan new Intent(ACTION, Uri); pada konstruktor sewaktu menciptakan obyek Intent dimana :
                 * Action           : Intent.ACTION_DIAL
                 * Uri                  : Uri.parse("tel:"+phoneNumber)
                 * ----------------------------------------------------------------------------------
                 * Variabel ACTION_DIAL menentukan intent filter dari aplikasi-aplikasi yang bisa menangani action tersebut.
                 * Di sini aplikasi yang memiliki kemampuan untuk komunikasi akan muncul pada opsi pilihan, sebagaimana ditampilkan ke pengguna.
                 * Selain ACTION_DIAL, di Android sudah tersedia berbagai action yang tinggal didefinisikan sewaktu menciptakan obyek Intent untuk mengakomodir
                 * berbagai tujuan.
                 * ----------------------------------------------------------------------------------
                 * Apa itu URI (Uniform Resource Identifier)
                 * Buat yang belum tau apa itu Uri, berikut penjelasan singkatnya :
                 * Uri adalah sebuah untaian karakter yang digunakan untuk mengidentifikasi nama, sumber, atau layanan di internet
                 * sesuai dengan RFC 2396. Pada Uri.parse("tel:"+phoneNumber) kita melakukan parsing Uri dari bentuk teks string
                 * menjadi sebuah obyek uri dengan menggunakan metode static parse(String).
                 *
                 * Uri.parse("tel:" + phoneNumber))
                 *
                 * Dimana “tel” adalah sebuah skema yang disepakati untuk sumber daya telepon dan phoneNumber adalah variabel string yang bernilai “081210841382”.
                 * Skema lain dari Uri seperti “geo” untuk peta, “http” untuk browser.
                 * ----------------------------------------------------------------------------------
                 *
                 * ----------------------------------------------------------------------------------
                 * */

                break;

            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                /*
                * Perbedaan mendasar antara perpindahan activity untuk menghasilkan nilai balik dengan tidak,
                * adalah pada metode untuk menjalankan obyek intent-nya.
                * Sebelumnya kita menggunakan startActivity(Intent) untuk berpindah activity.
                * Nah, kali ini kita menggunakan startActivityForResult(Intent, RequestCode).
                * Pada baris di atas, kita akan menjalankan sebuah activity melalui intent untuk nilai
                * balik ke activity yang menjalankan di mana nilai REQUEST_CODE adalah 110.
                * Penentuan nilai 110 itu dibebaskan dan kalau bisa disesuaikan dengan kebutuhan pengembangan aplikasi.
                 * */
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}
