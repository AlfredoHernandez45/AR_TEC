package io.github.sceneview.sample.armodelviewer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.sceneview.sample.setFullScreen

class GalleryActivity : AppCompatActivity(R.layout.activity_gallery) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFullScreen(
            findViewById(R.id.recyclerView),
            fullScreen = true,
            hideSystemBars = false,
            fitsSystemWindows = false
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val monuments = listOf(
            Monument(
                1,
                "Monumento al Manatí",
                "Esta atracción turística se encuentra frente a la bella Bahía de Chetumal, entre el Centro Internacional de Convenciones y la Universidad de Quintana Roo (UQROO), fue inaugurada en 1996 con el objetivo de darle realce al Boulevard Bahía y conmemorar a los Manatíes, los amigables mamíferos acuáticos que abundan en la Bahía, la cual fue decretada como santuario del Manatí.",
                android.R.drawable.ic_menu_gallery,
                "https://sceneview.github.io/assets/models/DamagedHelmet.glb", // Placeholder GLB
                18.5002, -88.2961
            ),
            Monument(
                2,
                "Lázaro Cárdenas",
                "Estatua en honor al General Lázaro Cárdenas, ubicada en el Boulevard Bahía de Chetumal. Un punto de referencia histórico y cultural en la capital de Quintana Roo.",
                android.R.drawable.ic_menu_gallery,
                "https://sceneview.github.io/assets/models/DamagedHelmet.glb",
                18.5035, -88.2985
            ),
            Monument(
                3,
                "Cuna del Mestizaje",
                "Monumento que representa el encuentro de dos culturas y el nacimiento del pueblo mestizo en tierras mayas. Ubicado estratégicamente cerca de la entrada a la ciudad.",
                android.R.drawable.ic_menu_gallery,
                "https://sceneview.github.io/assets/models/DamagedHelmet.glb",
                18.5147, -88.3056
            )
        )

        recyclerView.adapter = MonumentAdapter(monuments) { monument ->
            val intent = Intent(this, DetailsActivity::class.java).apply {
                putExtra("EXTRA_MONUMENT", monument)
            }
            startActivity(intent)
        }
    }
}
