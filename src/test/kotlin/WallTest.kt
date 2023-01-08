import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import ru.netology.Comments
import ru.netology.Post
import ru.netology.Wall

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
        val post = Post(
            id = 0, ownerId = 1, date = 1673186243, fromId = 2, text = "тест", canDelete = false,
            canEdit = true, canPin = true, comments = comment, isPinned = false
        )
        val result = Wall.add(post)
        assertEquals(1, result.id)
    }

    @Test
    fun updateExistPost() {
        val comment = Comments(
            canClose = false, canOpen = true, canPost = true, count = 10, groupsCanPost = false
        )
        val post1 = Post(
            id = 0, ownerId = 1, date = 1673186243, fromId = 2, text = "пост", canDelete = false,
            canEdit = true, canPin = true, comments = comment, isPinned = false
        )
        val post2 = Post(
            id = 1, ownerId = 1, date = 1673186243, fromId = 2, text = "измененый пост", canDelete = false,
            canEdit = true, canPin = true, comments = comment, isPinned = false
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
        val post1 = Post(
            id = 0, ownerId = 1, date = 1673186243, fromId = 2, text = "пост", canDelete = false,
            canEdit = true, canPin = true, comments = comment, isPinned = false
        )
        val post2 = Post(
            id = 10, ownerId = 1, date = 1673186243, fromId = 2, text = "еще один измененный пост",
            canDelete = false, canEdit = true, canPin = true, comments = comment, isPinned = false
        )
        Wall.add(post1)
        val result = Wall.update(post2)
        assertEquals(false, result)
    }
}