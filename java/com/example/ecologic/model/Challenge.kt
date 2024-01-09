package com.example.ecologic.model

import androidx.compose.runtime.Immutable

@Immutable
data class Challenge(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val price: Long,
    val tagline: String = "",
    val tags: Set<String> = emptySet()
)

/**
 * Static data
 */

val challenges = listOf(
    Challenge(
        id = 1L,
        name = "30 Trees",
        tagline = "More Trees",
        imageUrl = "https://images.pexels.com/photos/3617500/pexels-photo-3617500.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        price = 299
    ),
    Challenge(
        id = 2L,
        name = "Rice Field",
        tagline = "Nice rice",
        imageUrl = "https://images.pexels.com/photos/2754200/pexels-photo-2754200.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        price = 299
    ),
    Challenge(
        id = 3L,
        name = "No paper",
        tagline = "Reuse paper",
        imageUrl = "https://images.pexels.com/photos/1072824/pexels-photo-1072824.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        price = 299
    ),
    Challenge(
        id = 4L,
        name = "Laptop stop",
        tagline = "Less carbon footprint!",
        imageUrl = "https://images.pexels.com/photos/2528118/pexels-photo-2528118.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        price = 299
    ),
    Challenge(
        id = 5L,
        name = "Do a backflip",
        tagline = "Just do it",
        imageUrl = "https://images.pexels.com/photos/1098365/pexels-photo-1098365.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        price = 499
    ),
    Challenge(
        id = 6L,
        name = "Give Water",
        tagline = "Nothing other",
        imageUrl = "https://images.pexels.com/photos/327090/pexels-photo-327090.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        price = 299
    ),
    Challenge(
        id = 7L,
        name = "Well Done",
        tagline = "Make a well",
        imageUrl = "https://images.pexels.com/photos/7760793/pexels-photo-7760793.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        price = 1299
    ),
    Challenge(
        id = 8L,
        name = "Watering a Plant",
        tagline = "They're Thirsty",
        imageUrl = "https://www.pexels.com/photo/woman-watering-plant-with-fresh-green-leaves-6913711/",
        price = 299
    ),
    Challenge(
        id = 9L,
        name = "No crank",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/yb16pT5F_jE",
        price = 549
    ),
    Challenge(
        id = 10L,
        name = "Idea 10",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/AHF_ZktTL6Q",
        price = 299
    ),
    Challenge(
        id = 11L,
        name = "Idea 11",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/rqFm0IgMVYY",
        price = 299
    ),
    Challenge(
        id = 12L,
        name = "Idea 12",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/qRE_OpbVPR8",
        price = 299
    ),
    Challenge(
        id = 13L,
        name = "Idea 13",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/33fWPnyN6tU",
        price = 299
    ),
    Challenge(
        id = 14L,
        name = "Idea 14",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/aX_ljOOyWJY",
        price = 299
    ),
    Challenge(
        id = 15L,
        name = "Idea 15",
        imageUrl = "https://source.unsplash.com/UsSdMZ78Q3E",
        price = 299
    ),
    Challenge(
        id = 16L,
        name = "Idea 16",
        imageUrl = "https://source.unsplash.com/7meCnGCJ5Ms",
        price = 299
    ),
    Challenge(
        id = 17L,
        name = "Idea 17",
        imageUrl = "https://source.unsplash.com/m741tj4Cz7M",
        price = 299
    ),
    Challenge(
        id = 18L,
        name = "Idea 18",
        imageUrl = "https://source.unsplash.com/iuwMdNq0-s4",
        price = 299
    ),
    Challenge(
        id = 19L,
        name = "Idea 19",
        imageUrl = "https://source.unsplash.com/qgWWQU1SzqM",
        price = 299
    ),
    Challenge(
        id = 20L,
        name = "Idea 20",
        imageUrl = "https://source.unsplash.com/9MzCd76xLGk",
        price = 299
    ),
    Challenge(
        id = 21L,
        name = "Idea 21",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/1d9xXWMtQzQ",
        price = 299
    ),
    Challenge(
        id = 22L,
        name = "Idea 22",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/wZxpOw84QTU",
        price = 299
    ),
    Challenge(
        id = 23L,
        name = "Idea 23",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/okzeRxm_GPo",
        price = 299
    ),
    Challenge(
        id = 24L,
        name = "Idea 24",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/l7imGdupuhU",
        price = 299
    ),
    Challenge(
        id = 25L,
        name = "Idea 25",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/bkXzABDt08Q",
        price = 299
    ),
    Challenge(
        id = 26L,
        name = "Idea 26",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/y2MeW00BdBo",
        price = 299
    ),
    Challenge(
        id = 27L,
        name = "Idea 27",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/1oMGgHn-M8k",
        price = 299
    ),
    Challenge(
        id = 28L,
        name = "Idea 28",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/TIGDsyy0TK4",
        price = 299
    )
)
