
package com.example.formularioasistencia

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_web_view) // Mismo layout que antes

        val webView = findViewById<WebView>(R.id.webViewSanPedrito)
        webView.webViewClient = WebViewClient()

        // HABILITAR JAVASCRIPT
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // Cargar URL
        webView.loadUrl("https://es.wikipedia.org/wiki/Fiesta_patronal_de_San_Pedrito")
    }
}
