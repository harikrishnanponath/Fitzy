package com.harikrish.fitzy.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.harikrish.fitzy.ui.screens.components.bottomnav.BottomNavItem
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion.SideEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.harikrish.fitzy.data.Constants.BROWN_GRADIENT
import com.harikrish.fitzy.ui.screens.components.product.ProductDetailScreen
import com.harikrish.fitzy.ui.screens.main.CartScreen
import com.harikrish.fitzy.ui.screens.main.HomeScreen
import com.harikrish.fitzy.ui.screens.main.ProfileScreen
import com.harikrish.fitzy.ui.screens.main.WishListScreen
import com.harikrish.fitzy.ui.theme.Brown400
import com.harikrish.fitzy.ui.theme.FitzyTheme
import com.harikrish.fitzy.ui.theme.Green800
import com.harikrish.fitzy.ui.theme.Purple400
import com.harikrish.fitzy.ui.theme.Purple600

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val items = listOf(
        BottomNavItem.Home, BottomNavItem.Cart, BottomNavItem.Wishlist, BottomNavItem.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val hideBottomBarRoutes = listOf("productDetail/{productId}")

    Scaffold(
        modifier = Modifier
            .background(BROWN_GRADIENT)
            .statusBarsPadding(),
        bottomBar = {
            if (currentRoute !in hideBottomBarRoutes) {
                NavigationBar {
                    items.forEach { navItem ->
                        val selected = currentRoute == navItem.route

                        val animatedScale by animateFloatAsState(
                            targetValue = if (selected) 1.2f else 1f,
                            label = "Icon Scale"
                        )

                        val animatedColor by animateColorAsState(
                            targetValue = if (selected) Brown400 else Color.Gray,
                            label = "Icon Color"
                        )

                        NavigationBarItem(
                            icon = {
                                Icon(
                                    imageVector = navItem.icon,
                                    contentDescription = navItem.title,
                                    tint = animatedColor,
                                    modifier = Modifier
                                        .size(24.dp)
                                        .graphicsLayer {
                                            scaleX = animatedScale
                                            scaleY = animatedScale
                                        }
                                )
                            },
                            selected = currentRoute == navItem.route,
                            onClick = {
                                if (currentRoute != navItem.route) {
                                    navController.navigate(navItem.route) {
                                        popUpTo(navController.graph.startDestinationId) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Green800,
                                unselectedIconColor = Color.Gray,
                                indicatorColor = Color.Transparent
                            )
                        )
                    }
                }
            }
        }) { innerpadding ->

        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(innerpadding)
        ) {
            composable(BottomNavItem.Home.route) { HomeScreen(navController = navController) }
            composable(BottomNavItem.Cart.route) { CartScreen() }
            composable(BottomNavItem.Wishlist.route) { WishListScreen() }
            composable(BottomNavItem.Profile.route) { ProfileScreen() }
            composable("productDetail/{productId}") { backStackEntry ->
                val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
                ProductDetailScreen(productId = productId, navController = navController)
            }
        }
    }
}
