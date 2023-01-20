package ru.netology

data class Video(

    val id: Int,
    val owner_id: Int,
    val title: String
) {

}

data class Audio(
    val id: Int,
    val owner_id: Int,
    val artist: String,
    val duration: Int
) {

}

data class Photo(
    val id: Int,
    val album_id: Int,
    val owner_id: Int,
    val user_id: Int,
    val text: String
) {

}

data class File(
    val id: Int,
    val owner_id: Int,
    val title: String,
    val size: Int
) {

}

data class UrlLink(
    val url: String,
    val title: String,
    val description: String
) {

}

interface Attachement {
    val type: String
}

data class VideoAttachement(
    val video: Video
) {

}

data class AudioAttachement(
    val audio: Audio
) {

}

data class PhotoAttachement(
    val photo: Photo
) {

}

data class FileAttachement(
    val file: File
) {

}

data class UrlAttachement(
    val urlLink: UrlLink
)