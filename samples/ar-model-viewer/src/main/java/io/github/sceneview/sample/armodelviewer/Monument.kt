package io.github.sceneview.sample.armodelviewer

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Monument(
    val id: Int,
    val name: String,
    val description: String,
    val imageResId: Int, // Placeholder for local images for now
    val modelUrl: String,
    val latitude: Double,
    val longitude: Double
) : Parcelable
