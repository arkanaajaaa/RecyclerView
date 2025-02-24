package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AbsenAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private AbsenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<AbsenItem> absenItems = new ArrayList<>();
        absenItems.add(new AbsenItem("Dat $tick", "2.06", "Hip Hop", R.drawable.richbriand, "Rich Brian", "Lagu \"Dat $tick\" yang dibawakan oleh Rich Brian (dulu dikenal sebagai Rich Chigga) merupakan sebuah lagu hip hop dengan nuansa yang unik dan menonjolkan ciri khas rapper asal Indonesia ini. Dirilis pada tahun 2016, lagu ini memadukan beat trap dengan gaya rap yang agresif dan sering kali humoris.")); // Perbaiki konstruktor
        absenItems.add(new AbsenItem("Hit 'Em Up", "5.12", "Rap", R.drawable.tupac, "Tupac Shakur", "Lagu \"Hit 'Em Up\" oleh Tupac Shakur adalah salah satu dis track paling terkenal dalam sejarah hip hop. Dirilis pada tahun 1996, lagu ini adalah salah satu karya yang mencerminkan perseteruan besar dalam dunia hip hop pada waktu itu, khususnya antara Tupac Shakur dan Notorious B.I.G., serta label rekaman mereka, Death Row Records dan Bad Boy Records."));
        absenItems.add(new AbsenItem("Bola Muntah", "3.17", "Pop Rock", R.drawable.idrak, "Ibrahim Idrak", "Lagu \"Bola Muntah\" yang dibawakan oleh Arsyih Idrak adalah salah satu karya yang cukup unik dan menarik dalam dunia musik Indonesia. Lagu ini mengusung tema yang berbeda dan menyentuh sisi humor serta kritik sosial, dengan musik yang menggugah dan lirik yang mudah diingat."));
        absenItems.add(new AbsenItem("BRUCE", "2.34", "Rap", R.drawable.tregadd, "Tre 'Gadd", "Lagu \"BRUCE\" oleh Tre 'Gadd masuk ke dalam genre hip hop atau rap. Lagu ini mencerminkan gaya khas Tre 'Gadd dengan beat yang modern dan penuh energi, serta lirik yang tajam dan penuh makna. Biasanya, dalam lagu-lagu Tre 'Gadd, ada perpaduan antara aliran trap dengan elemen-elemen musik hip hop kontemporer."));
        absenItems.add(new AbsenItem("Till She Can't No Mo", "1.45", "Hip Hop", R.drawable.glizzy, "870glizzy", "Lagu \"Till She Can't No Mo\" oleh 870Glizzy masuk ke dalam genre hip hop dan trap. Lagu ini mengusung beat yang berat dengan bass yang mendalam, ciri khas dari musik trap, serta vokal yang terdistorsi atau menggunakan autotune, memberikan nuansa yang lebih gelap dan atmosferik.\n"));
        absenItems.add(new AbsenItem("Could Be Nice", "2.50", "R&B", R.drawable.starberry, "Starberry", "Lagu \"Could Be Nice\" oleh Stawberry cenderung masuk ke dalam genre indie pop atau R&B. Lagu ini memiliki suasana yang santai dan melodi yang catchy, dengan elemen-elemen musik yang ringan namun penuh emosi."));

        adapter = new AbsenAdapter(this, absenItems, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AbsenItem item) {
        Intent intent = new Intent(this, NewFormActivity.class);

        String nama = item.getNama();
        String genre = item.getGenre();
        String duration = item.getDuration();
        String creator = item.getArtist();
        String description = item.getDeskripsi();

        if (nama == null || nama.isEmpty()) {
            nama = "Nama Tidak Tersedia";  // Menetapkan nilai default jika nama null atau kosong
        }
        if (genre == null || genre.isEmpty()) {
            genre = "Genre Tidak Tersedia";  // Menetapkan nilai default jika genre null atau kosong
        }
        if (duration == null || duration.isEmpty()) {
            duration = "Durasi Tidak Tersedia";  // Menetapkan nilai default jika durasi null atau kosong
        }
        if (creator == null || creator.isEmpty()) {
            creator = "Pembuat Tidak Tersedia";  // Menetapkan nilai default jika creator null atau kosong
        }
        if (description == null || description.isEmpty()) {
            description = "Deskripsi Tidak Tersedia";  // Menetapkan nilai default jika description null atau kosong
        }

        // Mengirimkan data ke NewFormActivity
        intent.putExtra("NAMA", nama);
        intent.putExtra("GENRE", genre);
        intent.putExtra("DURASI", duration);
        intent.putExtra("CREATOR", creator);
        intent.putExtra("DESCRIPTION", description);

        startActivity(intent);
    }
}
