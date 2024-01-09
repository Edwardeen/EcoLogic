package com.example.ecologic.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecologic.R
import com.example.ecologic.ui.theme.EcologicTheme

class EcoTree(private val maxGrowth: Int) {
    var currentCoins: MutableState<Int> = mutableStateOf(0)
    var currentGrowth: MutableState<Int> = mutableStateOf(0)

    fun addCoins(coins: Int) {
        currentCoins.value += coins
        updateTreeGrowth()
    }

    private fun updateTreeGrowth() {
        val growthPerCoin = 5 // Adjust this based on your requirements
        val newGrowth = currentCoins.value / growthPerCoin

        // Ensure the tree doesn't exceed its max growth
        currentGrowth.value = newGrowth.coerceAtMost(maxGrowth)
    }
}

@Composable
fun EcoTreeComponent(ecoTree: EcoTree) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val painter = getTreeImage(ecoTree.currentGrowth.value)
        Image(
            painter = painter,
            contentDescription = "Tree Image",
            modifier = Modifier.size(150.dp)
        )

        Text(
            text = "Points: ${ecoTree.currentCoins.value}",
            modifier = Modifier.padding(top = 16.dp),
        )
    }
}

@Composable
fun getTreeImage(growth: Int): Painter {
    val drawableResId = when (growth) {
        0 -> R.drawable.tree_tiny
        1 -> R.drawable.tree_small
        2 -> R.drawable.tree_med
        3 -> R.drawable.tree_big
        else -> R.drawable.tree_huge
    }
    return painterResource(id = drawableResId)
}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
fun HomePreview() {
    EcologicTheme {
        EcoTreeComponent(ecoTree = EcoTree(5))
    }
}