/*package com.example.ecologic

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.ecologic.ui.home.HomeSections
import com.example.ecologic.ui.home.addHomeGraph
import com.example.ecologic.ui.navigation.MainDestinations
import com.example.ecologic.ui.navigation.rememberEcologicNavController
import com.example.ecologic.ui.Challengedetail.ChallengeDetail
import com.example.ecologic.ui.theme.ecologicTheme
import kotlin.reflect.KFunction0

@Composable
fun ecologicApp() {
    ecologicTheme {
        val ecologicNavController = rememberEcologicNavController()

        NavHost(
            navController = ecologicNavController.navController,
            startDestination = MainDestinations.HOME_ROUTE
        ) {
            ecologicNavGraph(
                onSnackSelected = { id, entry -> ecologicNavController.navigateToSnackDetail(id, entry) },
                upPress = ecologicNavController::upPress,
                onNavigateToRoute = ecologicNavController::navigateToBottomBarRoute,
                onLogout = ecologicNavController::logout
                /*{ route -> ecologicNavController.navigateToRoute(route) } */
            )
        }
    }
}

private fun NavGraphBuilder.ecologicNavGraph(
    onSnackSelected: (Long, NavBackStackEntry) -> Unit,
    upPress: () -> Unit,
    onNavigateToRoute: (String) -> Unit,
    onLogout: KFunction0<Unit> // Make sure this line ends here without a comma
) {
    navigation(
        route = MainDestinations.HOME_ROUTE,
        startDestination = HomeSections.FEED.route
    ) {
        addHomeGraph(onSnackSelected, upPress, onNavigateToRoute, onLogout)
    }
    composable(
        "${MainDestinations.SNACK_DETAIL_ROUTE}/{${MainDestinations.SNACK_ID_KEY}}",
        arguments = listOf(navArgument(MainDestinations.SNACK_ID_KEY) { type = NavType.LongType })
    ) { backStackEntry ->
        val arguments = requireNotNull(backStackEntry.arguments)
        val snackId = arguments.getLong(MainDestinations.SNACK_ID_KEY)
        ChallengeDetail(snackId, upPress)
    }
}

 */

