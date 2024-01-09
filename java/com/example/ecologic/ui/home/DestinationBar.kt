package com.example.ecologic.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecologic.ui.components.ecologicDivider
import com.example.ecologic.ui.theme.AlphaNearOpaque
import com.example.ecologic.ui.theme.EcologicTheme
import com.example.ecologic.ui.theme.ecologicTheme

@Composable
fun DestinationBar(modifier: Modifier = Modifier) {
    Spacer(Modifier.height(24.dp))
    TopAppBar(
        backgroundColor = ecologicTheme.colors.uiBackground.copy(alpha = AlphaNearOpaque),
        contentColor = ecologicTheme.colors.textSecondary,
        elevation = 7.dp,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom

        ) {
            Spacer(Modifier.height(24.dp))
            Text(
                text = "Welcome!",
                style = MaterialTheme.typography.h6,
                color = ecologicTheme.colors.textSecondary,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Visible,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(Modifier.height(24.dp))

        }

    }
    ecologicDivider()
}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
fun PreviewDestinationBar() {
    EcologicTheme {
        DestinationBar()
    }
}
