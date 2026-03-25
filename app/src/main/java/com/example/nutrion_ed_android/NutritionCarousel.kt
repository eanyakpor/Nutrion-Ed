//package com.example.nutrion_ed_android
//
//import androidx.compose.runtime.Composable
//
//@Composable
//fun NutritionCarousel() {
//    data class CarouselItem(
//        val id: Int,
//        @DrawableRes val imageResId: Int,
//        val contentDescription: String
//    )
//
//    val carouselItems = remember {
//        listOf(
//            CarouselItem(0, R.drawable.cupcake, "cupcake"),
//            CarouselItem(1, R.drawable.donut, "donut"),
//            CarouselItem(2, R.drawable.eclair, "eclair"),
//            CarouselItem(3, R.drawable.froyo, "froyo"),
//            CarouselItem(4, R.drawable.gingerbread, "gingerbread"),
//        )
//    }
//
//    HorizontalUncontainedCarousel(
//        state = rememberCarouselState { carouselItems.count() },
//        modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight()
//            .padding(top = 16.dp, bottom = 16.dp),
//        itemWidth = 186.dp,
//        itemSpacing = 8.dp,
//        contentPadding = PaddingValues(horizontal = 16.dp)
//    ) { i ->
//        val item = carouselItems[i]
//        Image(
//            modifier = Modifier
//                .height(205.dp)
//                .maskClip(MaterialTheme.shapes.extraLarge),
//            painter = painterResource(id = item.imageResId),
//            contentDescription = item.contentDescription,
//            contentScale = ContentScale.Crop
//        )
//    }
//}