package com.example.myapplication.view.ui

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.viewmodel.Message
import kotlinx.coroutines.flow.dropWhile

@Composable
fun InfiniteListHandler(
    listState: LazyListState,
    buffer: Int = 2,
    loadMoreItems: () -> Unit
) {
    val shouldLoadMore = remember {
        derivedStateOf {
            val totalItemsCount = listState.layoutInfo.totalItemsCount
            val lastVisibleItemIndex = (listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0) + 1

            lastVisibleItemIndex > totalItemsCount - buffer
        }
    }

    LaunchedEffect(shouldLoadMore) {
        snapshotFlow { shouldLoadMore.value }
            .dropWhile { !it }
            .collect {
                loadMoreItems()
            }
    }
}

@Composable
fun <Item> InfiniteList(
    items: List<Item>,
    createList: @Composable (List<Item>, LazyListState) -> Unit,
    buffer: Int = 2,
    loadMoreItems: () -> Unit,
    listState: LazyListState = rememberLazyListState()
) {
    createList(items, listState)
    InfiniteListHandler(listState, buffer) {
        loadMoreItems()
    }
}

@Composable
fun InfiniteInfoList(
    messages: LiveData<List<Message>>,
    buffer: Int = 3,
    loadMoreItems: () -> Unit
) {
    InfiniteList(
        messages.observeAsState().value !!,
        @Composable { messages, listState -> InfoList(messages, listState) },
        buffer,
        loadMoreItems
    )
}
