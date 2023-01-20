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

class VideoAttachement(
    override val type: String,
    val video: Video
) : Attachement {

}

class AudioAttachement(
    override val type: String,
    val audio: Audio
) : Attachement {

}

class PhotoAttachement(
    override val type: String,
    val photo: Photo
) : Attachement {

}

class FileAttachement(
    override val type: String,
    val file: File
) : Attachement {

}

class UrlAttachement(
    override val type: String,
    val urlLink: UrlLink
) : Attachement {

}