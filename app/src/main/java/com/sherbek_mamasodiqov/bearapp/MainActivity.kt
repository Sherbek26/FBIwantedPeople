package com.sherbek_mamasodiqov.bearapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.sherbek_mamasodiqov.bearapp.presentation.WantedPersonScreen
import com.sherbek_mamasodiqov.bearapp.presentation.WantedPersonViewModel
import com.sherbek_mamasodiqov.bearapp.ui.theme.BearAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BearAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel = hiltViewModel<WantedPersonViewModel>()
                    val wantedPeople = viewModel.wantedPeoplePagingFlow.collectAsLazyPagingItems()
                    WantedPersonScreen(wantedPeople = wantedPeople,modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
