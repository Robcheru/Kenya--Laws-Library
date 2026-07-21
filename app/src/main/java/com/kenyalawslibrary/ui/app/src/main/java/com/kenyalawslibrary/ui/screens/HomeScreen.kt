package com.kenyalawslibrary.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onEvidenceActClick: () -> Unit,
    onSearchClick: () -> Unit,
    onBookmarksClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onAboutClick: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("🇰🇪 Kenya Laws Library")
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            Text(
                text = "Available Laws",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onEvidenceActClick() }
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "📖 Evidence Act (Cap. 80)",
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Browse chapters and sections")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            HomeItem("Search", Icons.Default.Search, onSearchClick)
            HomeItem("Bookmarks", Icons.Default.Bookmark, onBookmarksClick)
            HomeItem("Settings", Icons.Default.Settings, onSettingsClick)
            HomeItem("About", Icons.Default.Info, onAboutClick)

            Spacer(modifier = Modifier.weight(1f))

            Text(
                "Version 1.0",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun HomeItem(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    ListItem(
        headlineContent = { Text(title) },
        leadingContent = {
            Icon(icon, contentDescription = title)
        },
        modifier = Modifier.clickable { onClick() }
    )
}
