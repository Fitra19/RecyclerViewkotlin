package com.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.Superhero

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superheroList = listOf<Superhero>(
            Superhero(
                R.drawable.itachi,
                "Itachi Uchiha",
                "Itachi Uchiha adalah kakak dari sasuke yang memiliki ilmu genjutsu" +
                        "dan rela untuk membantai klannya sendiri demi kepentingan desa Konoha"
            ),
            Superhero(
                R.drawable.jiraiya,
                "Jiraiya",
                "Dikenal sebagai sannin legendaris jiraiya merupakan guru dari naruto dan" +
                        "nagato yang biasa dipanggil sebagai pertapa genit oleh naruto"
            ),
            Superhero(
                R.drawable.kakashi,
                "Hatake Kakashi",
                "Kakashi merupakan murid dari minato sensei dan juga guru dari team 7" +
                        "yaitu naruto,sasuke,dan sakura. ia juga merupakan teman dari obito"
            ),
            Superhero(
                R.drawable.madara,
                "Uchiha Madara",
                "Madara merupakan main villain dari serial naruto dan berupaya untuk" +
                        "menghancurkan dunia Shinobi dengan bersekongkol bersama Zetsu"
            ),
            Superhero(
                R.drawable.naruto,
                "Naruto",
                "Naruto adalah main character dari serialnya dan memiliki ayah seorang" +
                        "hokage yaitu Minato dan teman dari Sasuke"
            ),
            Superhero(
                R.drawable.paintendou,
                "Pain",
                "Identitas Pain sebenarnya adalah mantan murid dari Jiraiya dan " +
                        "ia berupaya untuk balas dendam atas kematian temannya dulu di desa Amegakure"
            ), Superhero(
                R.drawable.saske,
                "Sasuke Uchiha",
                "Sasuke merupakan rival dari naruto sejak kecil,ia juka berupaya " +
                        "untuk balas dendam kepada kakaknya atas pembantaian klannya.ia mempelajari berbagai " +
                        "teknik dengan menjadi murid Orochimaru"
            )
        )
        val recyclerView = findViewById<RecyclerView>(R.id.rvHero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SuperheroAdapter(this,superheroList){
            val intent = Intent(this,DetailSuperheroActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)

        }
    }
}