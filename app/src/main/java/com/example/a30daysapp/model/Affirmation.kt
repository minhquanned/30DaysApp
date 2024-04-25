package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation (
    @StringRes val dayResourcesId: Int,
    @StringRes val contentResourcesId: Int,
    @DrawableRes val imageResourcesId: Int,
    @StringRes val descriptionResourcesId: Int,
)