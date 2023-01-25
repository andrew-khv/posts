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
        val comment = Comment(
            id = 1, fromId = 10, date = 1674421150, text = "test"
        )
        val post = Post(
            id = 0, ownerId = 1, date = 1673186243, fromId = 2, text = "тест", canDelete = false,
            canEdit = true, canPin = true, comments = arrayOf(comment), isPinned = false
        )
        val result = Wall.add(post)
        assertEquals(1, result.id)
    }

    @Test
    fun updateExistPost() {
        val comment = Comment(
            id = 1, fromId = 10, date = 1674421150, text = "test"
        )
        val post1 = Post(
            id = 0, ownerId = 1, date = 1673186243, fromId = 2, text = "пост", canDelete = false,
            canEdit = true, canPin = true, comments = arrayOf(comment), isPinned = false
        )
        val post2 = Post(
            id = 1, ownerId = 1, date = 1673186243, fromId = 2, text = "измененый пост", canDelete = false,
            canEdit = true, canPin = true, comments = arrayOf(comment), isPinned = false
        )
        Wall.add(post1)
        val result = Wall.update(post2)
        assertEquals(true, result)
    }

    @Test
    fun updateNotExistPost() {
        val comment = Comment(
            id = 1, fromId = 10, date = 1674421150, text = "test"
        )
        val post1 = Post(
            id = 0, ownerId = 1, date = 1673186243, fromId = 2, text = "пост", canDelete = false,
            canEdit = true, canPin = true, comments = arrayOf(comment), isPinned = false
        )
        val post2 = Post(
            id = 10, ownerId = 1, date = 1673186243, fromId = 2, text = "еще один измененный пост",
            canDelete = false, canEdit = true, canPin = true, comments = arrayOf(comment), isPinned = false
        )
        Wall.add(post1)
        val result = Wall.update(post2)
        assertEquals(false, result)
    }

    @Test
    fun addCommentToPost() {
        val comment = Comment(
            id = 1, fromId = 10, date = 1674421150, text = "test"
        )
        val post = Post(
            id = 1, ownerId = 1, date = 1673186243, fromId = 2, text = "тест", canDelete = false,
            canEdit = true, canPin = true, comments = arrayOf(), isPinned = false
        )
        Wall.add(post)
        val result = Wall.addComment(1, comment)
        assertEquals(comment, result)
    }
    @Test(expected = NoPostException::class)
    fun addCommentNoExistPost() {
        val comment = Comment(
            id = 1, fromId = 10, date = 1674421150, text = "test"
        )
        val post = Post(
            id = 0, ownerId = 1, date = 1673186243, fromId = 2, text = "тест", canDelete = false,
            canEdit = true, canPin = true, comments = arrayOf(), isPinned = false
        )
        Wall.add(post)
        val result = Wall.addComment(0, comment)
    }
}