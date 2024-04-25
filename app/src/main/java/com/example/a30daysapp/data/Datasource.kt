/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.affirmations.data

import com.example.a30daysapp.R
import com.example.affirmations.model.Affirmation

//import com.example.affirmations.R
//import com.example.affirmations.model.Affirmation

/**
 * [Datasource] generates a list of [Affirmation]
 */
class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.day1, R.string.content_1, R.drawable.image1, R.string.description1),
            Affirmation(R.string.day2, R.string.content_2, R.drawable.image2, R.string.description2),
            Affirmation(R.string.day3, R.string.content_3, R.drawable.image3, R.string.description3),
            Affirmation(R.string.day4, R.string.content_4, R.drawable.image4, R.string.description4),
            Affirmation(R.string.day5, R.string.content_5, R.drawable.image5, R.string.description5),
            Affirmation(R.string.day6, R.string.content_6, R.drawable.image6, R.string.description6),
            Affirmation(R.string.day7, R.string.content_7, R.drawable.image7, R.string.description7),
            Affirmation(R.string.day8, R.string.content_8, R.drawable.image8, R.string.description8),
            Affirmation(R.string.day9, R.string.content_9, R.drawable.image9, R.string.description9),
            Affirmation(R.string.day10, R.string.content_10, R.drawable.image10, R.string.description10)
        )
    }
}
