package com.jajanurjaman.jajanurjaman

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.jajanurjaman.jajanurjaman.adapter.AdapterTeamBola
import com.jajanurjaman.jajanurjaman.databinding.ActivityMainBinding
import com.jajanurjaman.jajanurjaman.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Casilas",R.drawable.image1, "Penjaga Gawang", "2.00 M","Bree (Belgia)","11 Mei 1980"))
        listPemain.add(Pemain("Ronaldo", R.drawable.image2,"Penyerang", "1,85 M","Lyon (Perancis)","19 Desember 1980"))
        listPemain.add(Pemain("bale",R.drawable.image3, "Penyerang", "1.74 M","Rio deJaneiro (Brazil)","11 Mei 1980"))
        listPemain.add(Pemain("benzema",R.drawable.image4, "Penyerang", "1.84 M","Camas (Sevilla)","30 Maret 1980"))
        listPemain.add(Pemain("Zinedine Yazid Zidane", R.drawable.image5,"Penyerang","1.85 M","Marseille (Pranciss)","22 Juni 1990"))

        binding.List.adapter = AdapterTeamBola(this,listPemain,object : AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txt_namapemain)
                    val posisi = this.findViewById<TextView>(R.id.txtposisi)
                    val tinggi = this.findViewById<TextView>(R.id.txttinggibadan)
                    val tempatlahir = this.findViewById<TextView>(R.id.txt_tempatlahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txt_tanggallahir)
                    val btn = this.findViewById<Button>(R.id.btnclose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }
        })
    }
}