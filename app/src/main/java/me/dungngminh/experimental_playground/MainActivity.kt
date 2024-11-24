package me.dungngminh.experimental_playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache

class MainActivity : AppCompatActivity(), ImageLoaderFactory {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun newImageLoader(): ImageLoader =
        ImageLoader
            .Builder(this)
            .respectCacheHeaders(false)
            .memoryCache {
                MemoryCache
                    .Builder(this)
                    .maxSizePercent(0.25)
                    .build()
            }.diskCache {
                DiskCache
                    .Builder()
                    .directory(this.cacheDir.resolve("image_cache"))
                    .maxSizePercent(0.1)
                    .build()
            }.build()
}