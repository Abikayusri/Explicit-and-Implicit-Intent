package abika.sinaudicodingjava.myintentapp;

/*
 * Plain Old Java Object (POJO), berikut penjelasan singkatnya.
 * POJO adalah sebuah kelas Java biasa yang tidak bergantung pada kelas lainnya.
 * Umumnya kelas POJO ini disebut sebagai kelas Java yang memiliki properti/variabel dan metode setter-getter.
 * --------------------------------------------------------------------------------------------------
 * Lalu apa kegunaan obyek POJO? POJO akan membantu kita saat aplikasi semakin kompleks.
 * Contohnya, POJO bisa kita gunakan untuk melakukan koneksi ke server untuk request API atau akses ke database lokal dengan SQLite.
 * --------------------------------------------------------------------------------------------------
 * Seperti yang diketahui bahwa kita dapat menyisipkan data dengan tipe-tipe tertentu seperti string, int, double pada Intent.
 * Tetapi tidak dengan tipe kompleks seperti objek, ArrayList, dll. Di sinilah peran besar Parcelable.
 * Parcelable adalah suatu interface yang memungkinkan kita melakukan pengiriman objek dari suatu Activity ke Activity lain.
 * Dengan bantuan Parcelable, Anda bisa membuat sebuah obyek Parcelable POJO.
 * Obyek yang di implementasikan dengan Parcelable akan memudahkan Anda dalam mengiriman data dari satu activity ke activity lainnya.
 * --------------------------------------------------------------------------------------------------
 * */


import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private String name;
    private int age;
    private String email;
    private String city;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
        dest.writeString(this.email);
        dest.writeString(this.city);
    }

    public Person() {
    }

    protected Person(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
        this.email = in.readString();
        this.city = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
