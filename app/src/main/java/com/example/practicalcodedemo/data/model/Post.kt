package com.example.practicalcodedemo.data.model

import java.io.Serializable

data class Post(
    var author: String= "",
    var avatar: String= "",
    var builtBy: List<BuiltBy> = emptyList(),
    var currentPeriodStars: Int = 0,
    var description: String= "",
    var forks: Int = 0,
    var language: String= "",
    var languageColor: String= "",
    var name: String= "",
    var stars: Int=0,
    var url: String= ""
):Serializable

