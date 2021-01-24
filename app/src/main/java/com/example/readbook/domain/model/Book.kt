package com.example.readbook.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.readbook.utils.Constants


@Entity(tableName = "book_table")
data class Book(
    @PrimaryKey(autoGenerate = true)
    var bookId: Long = 0L,
    @ColumnInfo(name = "book_author")
    var bookAuthor: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "book_name")
    var bookName: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "book_type")
    var bookType: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "book_years")
    var bookYears: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "book_place")
    var bookPlace: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "book_main_characters")
    var bookMainCharacters: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "book_story")
    var bookStory: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "book_meaning")
    var bookMeaning: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "book_rate")
    var bookRate: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "book_aforismi")
    var bookAforismi: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "book_unknown_words")
    var bookUnknownWords: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "book_new_words")
    var bookNewWords: String = Constants.EMPTY_STRING
)