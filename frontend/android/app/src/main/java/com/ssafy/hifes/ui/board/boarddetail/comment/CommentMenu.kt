package com.ssafy.hifes.ui.board.boarddetail.comment

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ssafy.hifes.ui.common.MenuItem
import com.ssafy.hifes.ui.iconpack.MyIconPack
import com.ssafy.hifes.ui.iconpack.myiconpack.More
import kotlin.math.exp

@Composable
fun CommentMenu(menuItemList : MutableList<MenuItem>) {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = Modifier.size(24.dp).background(Color.LightGray)) {
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = MyIconPack.More,
                contentDescription = "More",
                modifier = Modifier.size(16.dp)
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            menuItemList.forEach {
                DropdownMenuItem(
                    onClick = {
                        it.action()
                        expanded = false
                    }
                ){
                    Text(text = it.title)
                }
            }
        }
    }
}