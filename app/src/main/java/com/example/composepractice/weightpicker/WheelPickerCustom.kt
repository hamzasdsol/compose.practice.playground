@file:OptIn(ExperimentalSnapperApi::class)

package com.example.composepractice.weightpicker

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.SnapperLayoutInfo
import dev.chrisbanes.snapper.rememberLazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior
import kotlin.math.absoluteValue

@OptIn(ExperimentalSnapperApi::class)
@Composable
internal fun WheelPicker(
    modifier: Modifier = Modifier,
    startIndex: Int = 0,
    count: Int,
    rowCount: Int,
    size: DpSize = DpSize(128.dp, 128.dp),
    onScrollFinished: (snappedIndex: Int) -> Int? = { null },
    content: @Composable LazyItemScope.(index: Int, selected: Boolean) -> Unit,
) {
    val lazyListState = rememberLazyListState(startIndex)
    val snapperLayoutInfo = rememberLazyListSnapperLayoutInfo(lazyListState = lazyListState)
    val isScrollInProgress = lazyListState.isScrollInProgress

    LaunchedEffect(isScrollInProgress, count) {
        if (!isScrollInProgress) {
            onScrollFinished(calculateSnappedItemIndex(snapperLayoutInfo) ?: startIndex)?.let {
                lazyListState.scrollToItem(it)
            }
        }
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .background(Color(0xFF99f5ff).copy(alpha = 0.2f))
                .height(size.height)
                .width(size.width),
            state = lazyListState,
            contentPadding = PaddingValues(
                vertical = size.height / rowCount * ((rowCount - 1) / 2),
                horizontal = 0.dp
            ),
            flingBehavior = rememberSnapperFlingBehavior(
                lazyListState = lazyListState
            )
        ) {
            items(count) { index ->
                val rotationX = calculateAnimatedRotationX(
                    lazyListState = lazyListState,
                    snapperLayoutInfo = snapperLayoutInfo,
                    index = index,
                    rowCount = rowCount
                )
                Box(
                    modifier = Modifier
                        .height(size.height / rowCount)
                        .width(size.width)
                        .graphicsLayer {
                            this.rotationX = rotationX
                        },
                    contentAlignment = Alignment.Center
                ) {
                    content(
                        index = index,
                        selected =
                        calculateAnimatedAlpha(
                            lazyListState = lazyListState,
                            snapperLayoutInfo = snapperLayoutInfo,
                            index = index,
                            rowCount = rowCount
                        ) >= 1
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalSnapperApi::class)
private fun calculateSnappedItemIndex(snapperLayoutInfo: SnapperLayoutInfo): Int? {
    var currentItemIndex = snapperLayoutInfo.currentItem?.index

    if (snapperLayoutInfo.currentItem?.offset != 0) {
        if (currentItemIndex != null) {
            currentItemIndex++
        }
    }
    return currentItemIndex
}

@Composable
private fun calculateAnimatedAlpha(
    lazyListState: LazyListState,
    snapperLayoutInfo: SnapperLayoutInfo,
    index: Int,
    rowCount: Int
): Float {

    val distanceToIndexSnap = snapperLayoutInfo.distanceToIndexSnap(index).absoluteValue
    val layoutInfo = remember { derivedStateOf { lazyListState.layoutInfo } }.value
    val viewPortHeight = layoutInfo.viewportSize.height.toFloat()
    val singleViewPortHeight = viewPortHeight / rowCount

    return if (distanceToIndexSnap in 0..singleViewPortHeight.toInt()) {
        1.2f - (distanceToIndexSnap / singleViewPortHeight)
    } else {
        0.2f
    }
}

@Composable
private fun calculateAnimatedRotationX(
    lazyListState: LazyListState,
    snapperLayoutInfo: SnapperLayoutInfo,
    index: Int,
    rowCount: Int
): Float {

    val distanceToIndexSnap = snapperLayoutInfo.distanceToIndexSnap(index)
    val layoutInfo = remember { derivedStateOf { lazyListState.layoutInfo } }.value
    val viewPortHeight = layoutInfo.viewportSize.height.toFloat()
    val singleViewPortHeight = viewPortHeight / rowCount

    return -20f * (distanceToIndexSnap / singleViewPortHeight)
}


