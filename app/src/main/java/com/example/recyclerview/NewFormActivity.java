package com.example.recyclerview;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NewFormActivity extends AppCompatActivity {

    private TextView tvItemName, tvItemDescription, tvCreator, tvDetailedDescription;
    private ImageView imgItemPhoto;
    private Button btnPlay;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_form);

        tvItemName = findViewById(R.id.tv_item_name);
        tvCreator = findViewById(R.id.tv_item_creator);
        tvItemDescription = findViewById(R.id.tv_item_description);
        tvDetailedDescription = findViewById(R.id.tv_item_number_description);
        imgItemPhoto = findViewById(R.id.img_item_photo);
        btnPlay = findViewById(R.id.btnPlay);

        String nama = getIntent().getStringExtra("NAMA");
        String genre = getIntent().getStringExtra("GENRE");
        String duration = getIntent().getStringExtra("DURASI");
        String artist = getIntent().getStringExtra("CREATOR");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int imageResId = getIntent().getIntExtra("IMAGE_RES_ID", R.drawable.person);

        if (nama == null || nama.isEmpty()) {
            nama = "Nama Tidak Tersedia";
        }
        if (genre == null || genre.isEmpty()) {
            genre = "Genre Tidak Tersedia";
        }
        if (duration == null || duration.isEmpty()) {
            duration = "Durasi Tidak Tersedia";
        }
        if (artist == null || artist.isEmpty()) {
            artist = "Pembuat Tidak Tersedia";
        }
        if (description == null || description.isEmpty()) {
            description = "Deskripsi Tidak Tersedia";
        }

        tvItemName.setText(nama);
        tvCreator.setText("Pembuat : " + artist);
        tvItemDescription.setText("Durasi : " + duration + "\nGenre : " + genre);
        tvDetailedDescription.setText("Deskripsi : " + description);

        String finalArtist = artist;
        if ("Rich Brian".equals(finalArtist)) {
            imgItemPhoto.setImageResource(R.drawable.richbriand);
        } else if ("Tupac Shakur".equals(finalArtist)) {
            imgItemPhoto.setImageResource(R.drawable.tupac);
        } else if ("Ibrahim Idrak".equals(finalArtist)) {
            imgItemPhoto.setImageResource(R.drawable.idrak);
        } else if ("Tre 'Gadd".equals(finalArtist)) {
            imgItemPhoto.setImageResource(R.drawable.tregadd);
        } else if ("870glizzy".equals(finalArtist)) {
            imgItemPhoto.setImageResource(R.drawable.glizzy);
        } else if ("Starberry".equals(finalArtist)){
            imgItemPhoto.setImageResource(R.drawable.starberry);
        } else {
            imgItemPhoto.setImageResource(R.drawable.person);
        }

        btnPlay.setOnClickListener(v -> {
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                if ("Rich Brian".equals(finalArtist)){
                    mediaPlayer = MediaPlayer.create(NewFormActivity.this, R.raw.datsit);
                }
                else if ("Tupac Shakur".equals(finalArtist)) {
                    mediaPlayer = MediaPlayer.create(NewFormActivity.this, R.raw.hitemup);
                } else if ("Ibrahim Idrak".equals(finalArtist)) {
                    mediaPlayer = MediaPlayer.create(NewFormActivity.this, R.raw.bolamuntah);
                } else if ("Tre 'Gadd".equals(finalArtist)) {
                    mediaPlayer = MediaPlayer.create(NewFormActivity.this, R.raw.bruce);
                }
                else if ("870glizzy".equals(finalArtist)) {
                    mediaPlayer = MediaPlayer.create(NewFormActivity.this, R.raw.glizzy);
                }
                else if ("Starberry".equals(finalArtist)){
                    mediaPlayer = MediaPlayer.create(NewFormActivity.this, R.raw.couldbenice);
                }

                if (mediaPlayer != null) {
                    mediaPlayer.start();
                    btnPlay.setText("Pause");
                    Toast.makeText(NewFormActivity.this, "Playing song...", Toast.LENGTH_SHORT).show();
                }
            } else {
                mediaPlayer.pause();
                btnPlay.setText("Play");
                Toast.makeText(NewFormActivity.this, "Song paused", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
