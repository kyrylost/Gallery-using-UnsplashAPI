package com.example.unsplashapi.model

import com.google.gson.annotations.SerializedName


data class PhotoData (
    val id: String,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("updated_at")
    val updatedAt: String,

    val width: Long,
    val height: Long,
    val color: String,

    @SerializedName("blur_hash")
    val blurHash: String,

    val downloads: Long,
    val likes: Long,

    @SerializedName("liked_by_user")
    val likedByUser: Boolean,

    val description: String,
    val exif: Exif,
    val location: Location,

    @SerializedName("current_user_collections")
    val currentUserCollections: List<CurrentUserCollection>,

    val urls: Urls,
    val links: Links,
    val user: User
) {
    data class CurrentUserCollection(
        val id: Long,
        val title: String,

        @SerializedName("published_at")
        val publishedAt: String,

        @SerializedName("last_collected_at")
        val lastCollectedAt: String,

        @SerializedName("updated_at")
        val updatedAt: String,

        @SerializedName("cover_photo")
        val coverPhoto: Any? = null,

        val user: Any? = null
    )

    data class Exif(
        val make: String,
        val model: String,

        @SerializedName("exposure_time")
        val exposureTime: String,

        val aperture: String,

        @SerializedName("focal_length")
        val focalLength: String,

        val iso: Long
    )

    data class Links(
        val self: String,
        val html: String,
        val download: String,

        @SerializedName("download_location")
        val downloadLocation: String
    )

    data class Location(
        val name: String,
        val city: String,
        val country: String,
        val position: Position
    )

    data class Position(
        val latitude: Double,
        val longitude: Double
    )

    data class Urls(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String
    )

    data class User(
        val id: String,

        @SerializedName("updated_at")
        val updatedAt: String,

        val username: String,
        val name: String,

        @SerializedName("portfolio_url")
        val portfolioURL: String,

        val bio: String,
        val location: String,

        @SerializedName("total_likes")
        val totalLikes: Long,

        @SerializedName("total_photos")
        val totalPhotos: Long,

        @SerializedName("total_collections")
        val totalCollections: Long,

        @SerializedName("instagram_username")
        val instagramUsername: String,

        @SerializedName("twitter_username")
        val twitterUsername: String,

        val links: UserLinks
    )

    data class UserLinks(
        val self: String,
        val html: String,
        val photos: String,
        val likes: String,
        val portfolio: String
    )
}