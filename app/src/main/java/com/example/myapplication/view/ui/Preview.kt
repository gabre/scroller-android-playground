package com.example.myapplication.view.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.view.theme.AppMaterialTheme
import com.example.myapplication.viewmodel.Message
import java.util.*

@Preview
@Composable
fun PreviewMessageCard() {
    MaterialTheme {
        Surface {
            InfoCard(
                msg = Message("Colleague", "Take a look at Jetpack Compose, it's great!")
            )
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    AppMaterialTheme {
        Surface {
            InfoList(
                listOf(
                    Message("SomeOne", "Bla bla bla"),
                    Message("SomeOne", "Take a look at Jetpack Compose, it's great!"),
                    Message("SomeOne", "Take a look at Jetpack Compose, it's great!")
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewInfiniteInfoList() {
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

