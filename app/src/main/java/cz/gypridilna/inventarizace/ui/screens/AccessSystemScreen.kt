package cz.gypridilna.inventarizace.ui.screens

import android.net.Uri
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import cz.gypridilna.inventarizace.ui.theme.GraphiteCore

private const val ACCESS_SYSTEM_URL = "http://sshdilna.playit.plus:1226/"

@Composable
fun AccessSystemScreen() {
    val context = LocalContext.current
    val graphiteCoreArgb = GraphiteCore.toArgb()

    val customTabsIntent = CustomTabsIntent.Builder()
        .setDefaultColorSchemeParams(
            CustomTabColorSchemeParams.Builder()
                .setToolbarColor(graphiteCoreArgb)
                .build()
        )
        .setShowTitle(false)
        .build()

    LaunchedEffect(Unit) {
        customTabsIntent.launchUrl(context, Uri.parse(ACCESS_SYSTEM_URL))
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            customTabsIntent.launchUrl(context, Uri.parse(ACCESS_SYSTEM_URL))
        }) {
            Text("Open Access System")
        }
    }
}
