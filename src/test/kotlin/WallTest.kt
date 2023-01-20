import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import ru.netology.*

class WallTest {

    @Before
    fun clearBeforeTest() {
        Wall.clearWall()
    }
    @Test
    fun add() {
        val comment = Comments(
            canClose = false, canOpen = true, canPost = true, count = 10, groupsCanPost = false
        )
        val video = Video(
            id = 1, owner_id = 10, title = "test video"
        )
        val audio = Audio(
            id = 2, owner_id = 10, artist = "test artist", duration = 100
        )
        val videoAttach = VideoAttachement(
            type = "video", video = video
        )
        val audioAttach = AudioAttachement(
            type = "audio", audio = audio
        )
        val post = Post(
            id = 0, ownerId = 1, date = 1673186243, fromId = 2, text = "тест", canDelete = false,
            canEdit = true, canPin = true, comments = comment, isPinned = false,
            attachements = arrayOf(videoAttach, audioAttach)
        )
        val result = Wall.add(post)
        assertEquals(1, result.id)
    }

    @Test
    fun updateExistPost() {
        val comment = Comments(
            canClose = false, canOpen = true, canPost = true, count = 10, groupsCanPost = false
        )
        val video = Video(
            id = 1, owner_id = 10, title = "test video"
        )
        val audio = Audio(
            id = 2, owner_id = 10, artist = "test artist", duration = 100
        )
        val videoAttach = VideoAttachement(
            type = "video", video = video
        )
        val audioAttach = AudioAttachement(
            type = "audio", audio = audio
        )
        val post1 = Post(
            id = 0, ownerId = 1, date = 1673186243, fromId = 2, text = "пост", canDelete = false,
            canEdit = true, canPin = true, comments = comment, isPinned = false,
            attachements = arrayOf(videoAttach, audioAttach)
        )
        val post2 = Post(
            id = 1, ownerId = 1, date = 1673186243, fromId = 2, text = "измененый пост", canDelete = false,
            canEdit = true, canPin = true, comments = comment, isPinned = false,
            attachements = arrayOf(videoAttach, audioAttach)
        )
        Wall.add(post1)
        val result = Wall.update(post2)
        assertEquals(true, result)
    }
    @Test
    fun updateNotExistPost() {
        val comment = Comments(
            canClose = false, canOpen = true, canPost = true, count = 10, groupsCanPost = false
        )
        val video = Video(
            id = 1, owner_id = 10, title = "test video"
        )
        val audio = Audio(
            id = 2, owner_id = 10, artist = "test artist", duration = 100
        )
        val videoAttach = VideoAttachement(
            type = "video", video = video
        )
        val audioAttach = AudioAttachement(
            type = "audio", audio = audio
        )
        val post1 = Post(
            id = 0, ownerId = 1, date = 1673186243, fromId = 2, text = "пост", canDelete = false,
            canEdit = true, canPin = true, comments = comment, isPinned = false,
            attachements = arrayOf(videoAttach, audioAttach)
        )
        val post2 = Post(
            id = 10, ownerId = 1, date = 1673186243, fromId = 2, text = "еще один измененный пост",
            canDelete = false, canEdit = true, canPin = true, comments = comment, isPinned = false,
            attachements = arrayOf(videoAttach, audioAttach)
        )
        Wall.add(post1)
        val result = Wall.update(post2)
        assertEquals(false, result)
    }
}