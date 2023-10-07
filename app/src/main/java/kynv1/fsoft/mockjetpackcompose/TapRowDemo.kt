package kynv1.fsoft.mockjetpackcompose

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier


@Composable
fun TabRowDemo() {
    var selectedTabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Tab 1", "Tab 2", "Tab 3")

    TabRow(
        selectedTabIndex = selectedTabIndex,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
            )
        }
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { selectedTabIndex = index},
                text = { Text(text = title) }
            )
        }
    }

    // Hiển thị nội dung tương ứng với tab được chọn
    when (selectedTabIndex) {
        0 -> Text("Nội dung Tab 1")
        1 -> Text("Nội dung Tab 2")
        2 -> Text("Nội dung Tab 3")
    }
}



