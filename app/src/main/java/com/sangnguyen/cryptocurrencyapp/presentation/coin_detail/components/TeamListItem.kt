package com.sangnguyen.cryptocurrencyapp.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import com.sangnguyen.cryptocurrencyapp.data.remote.data_transfer_object.TeamMember

@Composable
fun TeamListItem(teamMember: TeamMember, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = teamMember.name,
            style = MaterialTheme.typography.h4,
        )
        Text(
            text = teamMember.position,
            style = MaterialTheme.typography.subtitle2,
            fontStyle = FontStyle.Italic
        )
    }

}