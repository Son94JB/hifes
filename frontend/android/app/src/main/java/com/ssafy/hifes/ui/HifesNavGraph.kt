package com.ssafy.hifes.ui

import NavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ssafy.hifes.data.AppContainer
import com.ssafy.hifes.ui.board.BoardScreen
import com.ssafy.hifes.ui.board.BoardViewModel
import com.ssafy.hifes.ui.board.boarddetail.BoardDetailScreen
import com.ssafy.hifes.ui.board.write.PostWriteScreen
import com.ssafy.hifes.ui.detail.DetailViewModel
import com.ssafy.hifes.ui.detail.FestivalDetail
import com.ssafy.hifes.ui.group.GroupViewModel
import com.ssafy.hifes.ui.group.create.GroupCreateScreen
import com.ssafy.hifes.ui.group.info.GroupInfoScreen
import com.ssafy.hifes.ui.group.main.GroupMainScreen
import com.ssafy.hifes.ui.home.HomeScreen
import com.ssafy.hifes.ui.login.LoginDetailScreen
import com.ssafy.hifes.ui.login.LoginScreen
import com.ssafy.hifes.ui.login.LoginViewModel
import com.ssafy.hifes.ui.main.MainViewModel
import com.ssafy.hifes.ui.map.MapScreen
import com.ssafy.hifes.ui.mypage.MyPageScreen
import com.ssafy.hifes.ui.participatedfest.ParticipatedFestScreen

@Composable
fun HifesNavGraph(
    appContainer: AppContainer,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    mainViewModel: MainViewModel,
    startDestination: String = HifesDestinations.LOGIN_ROUTE
//    startDestination: String = NavigationItem.Home.screenRoute
) {

    val boardViewModel: BoardViewModel = viewModel()
    val groupViewModel: GroupViewModel = viewModel()
    val detailViewModel: DetailViewModel = viewModel()
    val loginViewModel: LoginViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(NavigationItem.Home.screenRoute) {
            HomeScreen(navController, mainViewModel)
        }
        composable(NavigationItem.Map.screenRoute) {
            MapScreen(navController, mainViewModel, detailViewModel)
        }
        composable(NavigationItem.Group.screenRoute) {
            GroupMainScreen(navController, groupViewModel)
        }
        composable(
            route = HifesDestinations.LOGIN_ROUTE
        ) {
            LoginScreen(navController = navController, loginViewModel)
        }
        composable(
            route = HifesDestinations.LOGIN_DETAIL_ROUTE
        ) {
            LoginDetailScreen(navController = navController, loginViewModel)
        }
        composable(
            route = HifesDestinations.FESTIVAL_DETAIL
        ) {
            FestivalDetail(navController = navController, viewModel = mainViewModel, detailViewModel = detailViewModel)
        }
        composable(
            route = HifesDestinations.PARTICIPATED_FEST_ROUTE
        ) {
            ParticipatedFestScreen(navController = navController)
        }
        composable(
            route = HifesDestinations.MY_PAGE_ROUTE
        ) {
            MyPageScreen(navController = navController)
        }
        composable(
            route = HifesDestinations.BOARD_ROUTE
        )
        {
            BoardScreen(navController = navController, viewModel = boardViewModel)
        }
        composable(
            route = HifesDestinations.BOARD_DETAIL_ROUTE
        ) {
            BoardDetailScreen(navController = navController, viewModel = boardViewModel)
        }
        composable(
            route = HifesDestinations.GROUP_CREATE
        ) {
            GroupCreateScreen(navController = navController)
        }
        composable(
            route = HifesDestinations.POST_WRITE_ROUTE
        ) {
            PostWriteScreen(navController = navController, viewModel = boardViewModel)
        }
        composable(
            route = HifesDestinations.GROUP_DETAIL
        ) {
            GroupInfoScreen(navController = navController, viewModel = groupViewModel)
        }
    }
}
