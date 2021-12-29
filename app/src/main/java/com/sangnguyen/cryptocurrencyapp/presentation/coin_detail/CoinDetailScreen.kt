package com.sangnguyen.cryptocurrencyapp.presentation.coin_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.sangnguyen.cryptocurrencyapp.presentation.coin_detail.components.CoinTag
import com.sangnguyen.cryptocurrencyapp.presentation.coin_detail.components.TeamListItem

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.coin?.let { coin ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(all = 24.dp),
            ) {
                item {
                    // Coin description
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coin.rank}. ",
                            style = MaterialTheme.typography.h2,
                        )
                        Column(modifier = Modifier.weight(8f)) {
                            Text(
                                text = "${coin.name} (${coin.symbol})",
                                style = MaterialTheme.typography.h2,
                            )
                            Text(
                                style = MaterialTheme.typography.subtitle2,
                                text = coin.coinId
                            )

                        }
                        Text(
                            text = if (coin.isActive) "active" else "inactive",
                            color = if (coin.isActive) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            maxLines = 1,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(CenterVertically)
                                .weight(2f)
                        )

                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = coin.description,
                        style = MaterialTheme.typography.body1,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    // Started at
                    Text(
                        text = "Started at",
                        style = MaterialTheme.typography.h3,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = coin.startedAt,
                        style = MaterialTheme.typography.body1,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    // First data at
                    Text(
                        text = "First data at",
                        style = MaterialTheme.typography.h3,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = coin.firstDataAt,
                        style = MaterialTheme.typography.body1,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    // First data at
                    Text(
                        text = "Last data at",
                        style = MaterialTheme.typography.h3,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = coin.lastDataAt,
                        style = MaterialTheme.typography.body1,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    // Coin tags
                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h3,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    FlowRow(
                        mainAxisSpacing = 12.dp,
                        crossAxisSpacing = 12.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coin.tags.forEach { tag ->
                            CoinTag(tag = tag)
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    // Coin team member list
                    Text(
                        text = "Team members",
                        style = MaterialTheme.typography.h3,
                    )
                }
                items(coin.team) { teamMember ->
                    TeamListItem(
                        teamMember = teamMember,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 12.dp)
                    )
                    Divider()
                }

            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}