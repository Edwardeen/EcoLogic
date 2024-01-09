package com.example.ecologic

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.ecologic.ui.Challengedetail.ChallengeDetail
import com.example.ecologic.ui.home.HomeSections
import com.example.ecologic.ui.home.ProfilePage
import com.example.ecologic.ui.home.addHomeGraph
import com.example.ecologic.ui.navigation.EcologicNavController
import com.example.ecologic.ui.navigation.MainDestinations
import com.example.ecologic.ui.navigation.rememberEcologicNavController
import com.example.ecologic.ui.signinsignup.LoginScreen
import com.example.ecologic.ui.signinsignup.RegisterScreen
import com.example.ecologic.ui.theme.EcologicTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import kotlin.reflect.KFunction0

class EcoLogicApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize Firebase if needed
        FirebaseApp.initializeApp(this)

        val user = FirebaseAuth.getInstance().currentUser
        user?.let {
            val name = it.displayName
            val email = it.email
            val photoUrl = it.photoUrl
            val emailVerified = it.isEmailVerified
            val uid = it.uid
        }

        val providerData = user?.providerData
        providerData?.forEach { profile ->
            val providerId = profile.providerId
            val uid = profile.uid
            val name = profile.displayName
            val email = profile.email
            val photoUrl = profile.photoUrl
        }

        setContent {

            EcologicTheme {
                val navController = rememberNavController()
                val ecologicNavController = rememberEcologicNavController()

                // Navigate from MainContent to EcologicApp
                MainContent(navController) {
                    EcologicApp(ecologicNavController)
                }
            }
        }
    }
}

@Composable
fun MainContent(navController: NavHostController, content: @Composable () -> Unit) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("register") {
            RegisterScreen(navController = navController)
        }
        composable("home/feed") {
            content() // This will navigate to EcologicApp when ecologicapp route is called
        }
        composable("home/profile") { // Add composable for the profile route
            ProfilePage(onNavigateToRoute = { }) // Replace ProfileScreen() with the screen you want to navigate to for the "profile" route
        }
    }
}


@Composable
fun EcologicApp(ecologicNavController: EcologicNavController) {
    EcologicTheme {
        NavHost(
            navController = ecologicNavController.navController,
            startDestination = MainDestinations.HOME_ROUTE
        ) {
            ecologicNavGraph(
                onSnackSelected = { id, entry -> ecologicNavController.navigateToSnackDetail(id, entry) },
                upPress = ecologicNavController::upPress,
                onNavigateToRoute = ecologicNavController::navigateToBottomBarRoute,
                onLogout = ecologicNavController::logout
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
