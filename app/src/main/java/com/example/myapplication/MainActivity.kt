package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.view.ui.InfoList
import com.example.myapplication.view.ui.InfiniteList
import com.example.myapplication.view.theme.AppMaterialTheme
import com.example.myapplication.view.ui.InfiniteInfoList
import com.example.myapplication.viewmodel.Message

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            var items = listOf(
                Message("SomeOne", "Bla bla bla"),
                Message("AnyOne", "Take a look at Jetpack Compose, it's great!"),
                Message("Duck123", "Take another look at Jetpack Compose, it's great!"),
                Message("SomeOne", "Take yet another look at Jetpack Compose, it's great!"),
                Message("Xyz Abc", "Lorem ipsum, lorem ipsum, lorem ipsum."),
                Message("SomeOne", "Take another look at Jetpack Compose, it's great!"),
                Message("SomeOne", "Bla bla bla"),
                Message("AnyOne", "Take a look at Jetpack Compose, it's great!"),
                Message("Duck123", "Take another look at Jetpack Compose, it's great!"),
                Message("SomeOne", "Take yet another look at Jetpack Compose, it's great!"),
                Message("Xyz Abc", "Lorem ipsum, lorem ipsum, lorem ipsum."),
                Message("SomeOne", "Take another look at Jetpack Compose, it's great!"),
                Message("SomeOne", "Bla bla bla"),
                Message("AnyOne", "Take a look at Jetpack Compose, it's great!"),
                Message("Duck123", "Take another look at Jetpack Compose, it's great!"),
                Message("SomeOne", "Take yet another look at Jetpack Compose, it's great!"),
                Message("Xyz Abc", "Lorem ipsum, lorem ipsum, lorem ipsum."),
                Message("SomeOne", "Take another look at Jetpack Compose, it's great!")
            )
            val extraItems = listOf(
                Message("Extra 1", "Extra bla bla bla"),
                Message("Extra 2", "Extra bla bla bla"),
                Message("Extra 3", "Extra bla bla bla"),
                Message("Extra 4", "Extra bla bla bla"),
                Message("Extra 5", "Extra bla bla bla"),
                Message("Extra 6", "Extra bla bla bla")
            )
            val liveData = MutableLiveData(items);
            val loadMore: () -> Unit = {
                liveData.value = items.plus(extraItems);
            }
            AppMaterialTheme {
                Surface {
                    InfiniteInfoList(liveData) {
                        loadMore()
                    }
                }
            }

        }
    }
}


