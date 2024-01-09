package com.example.ecologic.ui.home

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.ecologic.model.ChallengeCollection
import com.example.ecologic.model.ChallengeRepo
import com.example.ecologic.model.Filter
import com.example.ecologic.ui.components.ChallengeCollection
import com.example.ecologic.ui.components.ecologicDivider
import com.example.ecologic.ui.components.ecologicScaffold
import com.example.ecologic.ui.components.ecologicSurface
import com.example.ecologic.ui.theme.EcologicTheme
import com.example.ecologic.ui.theme.ecologicTheme


@Composable
fun Feed(
    onChallengeClick: (Long) -> Unit,
    onNavigateToRoute: () -> Unit,
    modifier: Modifier = Modifier // Update the default value to Modifier
) {
    val challengeCollectionList = remember { ChallengeRepo.getChallenges() }
    val filters = remember { ChallengeRepo.getFilters() }
    ecologicScaffold(
        bottomBar = {
            ecologicBottomBar(
                tabs = HomeSections.values(),
                currentRoute = HomeSections.FEED.route,
                navigateToRoute = { route: String -> onNavigateToRoute() },
                modifier = Modifier // Use the passed Modifier here
            )
        },
        modifier = modifier // Also pass the Modifier to the scaffold
    ) { paddingValues ->
        FeedContent(
            challengeCollectionList,
            filters,
            onChallengeClick,
            paddingValues,
            modifier
        )
    }
}





@Composable
private fun FeedContent(
    challengeCollection: List<ChallengeCollection>,
    filters: List<Filter>,
    onChallengeClick: (Long) -> Unit,
    paddingValues: PaddingValues,
    modifier: Modifier
) {
    ecologicSurface(modifier = modifier.fillMaxSize()) {
        Box {
            ChallengeCollectionList(challengeCollection, filters, onChallengeClick, modifier)
            DestinationBar()
        }
    }
}

@Composable
private fun ChallengeCollectionList(
    challengeCollection: List<ChallengeCollection>,
    filters: List<Filter>,
    onChallengeClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    var filtersVisible: Boolean by rememberSaveable { mutableStateOf(false) }
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center)
    {
        Spacer(Modifier.height(24.dp))
        LazyColumn {

            item {
                Spacer(
                    Modifier.windowInsetsTopHeight(
                        WindowInsets.statusBars.add(WindowInsets(top = 100.dp))
                    )
                )



                // Inside the ChallengeCollectionList composable function
                Box(
                    modifier = modifier.fillMaxWidth().height(300.dp)
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = "https://pngimg.com/uploads/tree/tree_PNG92709.png",
                            builder = {
                                crossfade(true)
                            }
                        ),
                        contentDescription = "My Image",
                        modifier = Modifier.fillMaxSize()
                    )
                }



                Text(
                    text = "You have 600 points",
                    style = MaterialTheme.typography.button,
                    maxLines = 1,
                    color = ecologicTheme.colors.textSecondary,
                    overflow = TextOverflow.Visible,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                )

                Text(
                    text = "Let's make the world a better place today ❤️",
                    style = MaterialTheme.typography.body1,
                    maxLines = 1,
                    color = ecologicTheme.colors.textSecondary,
                    overflow = TextOverflow.Visible,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                )

            }

            itemsIndexed(challengeCollection) { index, challengeCollection1: ChallengeCollection ->
                if (index > 0) {
                    ecologicDivider(thickness = 5.dp)
                }

                ChallengeCollection(
                    ChallengeCollection = challengeCollection1,
                    onChallengeClick = onChallengeClick,
                    index = index
                )
            }
        }

    }



    AnimatedVisibility(
        visible = filtersVisible,
        enter = slideInVertically() + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically() + shrinkVertically() + fadeOut()
    ) {

    }
}

private fun BoxScope.AsyncImage(model: ImageRequest, placeholder: Painter, modifier: Modifier, contentScale: ContentScale) {

}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
fun HomePreview() {
    EcologicTheme {
        Feed(onChallengeClick = { }, onNavigateToRoute = { })
    }
}
