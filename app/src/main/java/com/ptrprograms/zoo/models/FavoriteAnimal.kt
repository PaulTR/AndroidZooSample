package com.ptrprograms.zoo.models

import androidx.room.*

/**
 * Declaring the column info allows for the renaming of variables without implementing a
 * database migration, as the column name would not change.
 */
@Entity(tableName = "favorites",
        foreignKeys = [ForeignKey(entity = Animal::class, parentColumns = ["id"], childColumns = ["favorite_id"])],
        indices = [Index("favorite_id")])
data class FavoriteAnimal(
        @ColumnInfo(name="favorite_id") val animalId: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var favoriteId: Long = 0
}