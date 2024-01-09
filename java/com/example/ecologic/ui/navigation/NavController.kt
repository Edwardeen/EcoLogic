    package com.example.ecologic.ui.navigation

    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.Stable
    import androidx.navigation.NavBackStackEntry
    import androidx.navigation.NavDestination
    import androidx.navigation.NavGraph
    import androidx.navigation.NavHostController
    import com.google.firebase.auth.FirebaseAuth

    object MainDestinations {
        const val HOME_ROUTE = "home"
        const val SNACK_DETAIL_ROUTE = "snack"
        const val SNACK_ID_KEY = "snackId"
        const val LOGOUT_SCREEN = "logout"
        const val REGISTER_SCREEN = "register"
        const val LOGIN_SCREEN = "login"
        const val PROFILE_SCREEN = "profile"
    }

    @Composable
    fun rememberEcologicNavController(
        navController: NavHostController = androidx.navigation.compose.rememberNavController()
    ): EcologicNavController = androidx.compose.runtime.remember(navController) {
        EcologicNavController(navController)
    }

    @Stable
    class EcologicNavController(
        val navController: NavHostController,
        private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    ) {
        val currentRoute: String?
            get() = navController.currentDestination?.route

        fun upPress() {
            navController.navigateUp()
        }

        fun navigateToBottomBarRoute(route: String) {
            if (route != currentRoute) {
                navController.navigate(route) {
                    launchSingleTop = true
                    restoreState = true
                    popUpTo(findStartDestination(navController.graph).id) {
                        saveState = true
                    }
                }
            }
        }

        fun navigateToSnackDetail(snackId: Long, from: NavBackStackEntry) {
            if (from.lifecycleIsResumed()) {
                navController.navigate("${MainDestinations.SNACK_DETAIL_ROUTE}/$snackId")
            }
        }

        fun navigateToLoginScreen() {
            navController.navigate(MainDestinations.HOME_ROUTE)
        }

        fun navigateToRegisterScreen() {
            navController.navigate(MainDestinations.SNACK_DETAIL_ROUTE)
        }

        fun navigateToProfileScreen() {
            navController.navigate(MainDestinations.PROFILE_SCREEN)
        }


        fun logout() {
            auth.signOut()
            navController.navigate(MainDestinations.LOGIN_SCREEN)
        }

        fun login() {
            navController.navigate(MainDestinations.HOME_ROUTE)
        }

        fun register(){
            navController.navigate(MainDestinations.REGISTER_SCREEN)
        }


    }

    private fun NavBackStackEntry.lifecycleIsResumed() =
        this.lifecycle.currentState == androidx.lifecycle.Lifecycle.State.RESUMED

    private val NavGraph.startDestination: NavDestination?
        get() = findNode(startDestinationId)

    private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
        return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
    }
