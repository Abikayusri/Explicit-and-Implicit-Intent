package abika.sinaudicodingjava.myintentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObjectActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";

    /*
     * EXTRA_PERSON merupakan variabel static bertipe data string dan bernilai “extra_person”.
     * ---------------------------------------------------------------------------------------------
     * */

    TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        tvObject = findViewById(R.id.tv_object_received);

        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);

        /*
         * Dan ini yang seru.. Karena obyek ini terdiri dari beragam tipe data pada atribut atau propertinya,
         * kita hanya cukup membungkus itu semua kedalam obyek parcelable. Melalui getIntent().getParcelableExtra(Key)
         * Anda dapat mengambil nilai obyek Person yang sebelumnya telah dikirim dan menampilkannya seperti ini.
         * -----------------------------------------------------------------------------------------
         * */

        String text = "Name : " + person.getName() + ",\nEmail : " + person.getEmail() + ",\nAge : " + person.getAge() + ",\nLocation : " + person.getCity();
        tvObject.setText(text);
    }
}

/*
 * ROWS OF DATA
 * Lalu, bagaimana jika kita ingin mengirimkan kumpulan obyek parcelable ke Activity lain?
 * Untuk mengirimkan kumpulan data, kita bisa memanfaatkan arraylist dan metode putParcelableArrayListExtra.
 * Contoh kode ketika put extra adalah seperti ini.
 * -----------------------------------------------------------------------------------------
 * ArrayList<Person> persons = new ArrayList<>();
 *
 * ...
 *
 * moveWithObjectIntent.putParcelableArrayListExtra(KEY,persons);
 * -----------------------------------------------------------------------------------------
 * Dan ketika mengambil kumpulan datanya, kita bisa menggunakan kode ini.
 * -----------------------------------------------------------------------------------------
 * ArrayList<Person> persons = getIntent().getParcelableArrayListExtra(KEY);
 * */
